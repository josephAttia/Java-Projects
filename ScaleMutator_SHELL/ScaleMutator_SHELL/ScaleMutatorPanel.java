import javax.sound.midi.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class ScaleMutatorPanel extends JPanel
{
  
   private static final int SIZE=40;	            //size of untis being drawn
  
   public static int INSTRUMENT = 0;			      //the melody instrument the user picks (piano is 0, 0<=INSTRUMENT<128)
   public static int WHOLENOTE=190;				      //resolution of a whole note for MIDI syncing
   public static final int OCTAVE = 12;				//add this to a note to go up an octave, subtract to go down
   public static final int VOLUME=80;				   //the VELOCITY of the note (how "hard" the note is struck) 0<=VELOCITY<128

   private static MidiChannel[] channels=null;		//MIDI channels
   private static Instrument[] instr;					//MIDI instrument bank

   	                                             //intervals of scales						   
   private static final int [][] intervals = {{0,2,4,5,7,9,11,12}, {0,2,3,5,7,9,11,12}, {0,3,5,6,7,10,12}, {0,2,3,5,7,8,11,12}};
   private static final String[] scaleName = {"Major",             "Minor",             "Blues",           "Harm Minor"};
   private static int scaleIndex;                  //index of user's scale choice
   public static int key;                          //the key the user picks
   public static int [] scale;			            //the scale or mode the user picks
   public static int [] scaleOrig;                 //original scale picked so user can restore it
    
   public ScaleMutatorPanel()                     //constructor
   {
      key = -1;
      scaleIndex = -1;
      scale = null;
      scaleOrig = null;
      try 
      {
         Synthesizer synth = MidiSystem.getSynthesizer();
         synth.open();
         channels = synth.getChannels();
         instr = synth.getDefaultSoundbank().getInstruments();
      }
      catch (Exception ignored) 
      {}
      channels[0].programChange(instr[INSTRUMENT].getPatch().getProgram());
   }

	//THIS METHOD IS ONLY CALLED THE MOMENT A KEY IS HIT - NOT AT ANY OTHER TIME
	//pre:   k is a valid keyCode
	//post:  processes user input - select key/scale/mutation (sent from the driver)
   public void processUserInput(int k, boolean shiftIsPressed)
   {
      if(k==KeyEvent.VK_Q || k==KeyEvent.VK_ESCAPE)					//End the program	
         System.exit(1);
      if(key == -1 && ((k>=KeyEvent.VK_A && k<=KeyEvent.VK_G) || k==KeyEvent.VK_R))                            
      {                                         //key has not been picked yet
         if(k==KeyEvent.VK_R)
            key = (int)(Math.random()*12) + 60;	//user picks random key
         else if(k==KeyEvent.VK_C)
            key = 60;
         else if(k==KeyEvent.VK_D)
            key = 62;
         else if(k==KeyEvent.VK_E)
            key = 64;
         else if(k==KeyEvent.VK_F)
            key = 65;
         else if(k==KeyEvent.VK_G)
            key = 67;
         else if(k==KeyEvent.VK_A)
            key = 69;
         else if(k==KeyEvent.VK_B)
            key = 71;
         if(shiftIsPressed)                     //make the key sharp
            key++;   
      }
      else if(scaleIndex == -1)                 //scale has not been picked yet
      {
         if(k==KeyEvent.VK_R)                   //user picks random scale
            scaleIndex = (int)(Math.random()*intervals.length);
         else if(k==KeyEvent.VK_1)
            scaleIndex = 0;
         else if(k==KeyEvent.VK_2)
            scaleIndex = 1;
         else if(k==KeyEvent.VK_3)
            scaleIndex = 2;
         else if(k==KeyEvent.VK_4)
            scaleIndex = 3;
         if(scaleIndex>=0 && scaleIndex<intervals.length)
         {
            scale = intervals[scaleIndex].clone();
            for(int i=0; i<scale.length; i++)	//adjust scale to key
               scale[i] += key;
            scaleOrig = scale.clone();
            playNow(scale);
         }
      }                          //END: scale has not been picked yet
      else
      {  
         if(k==KeyEvent.VK_UP)   //increase note length
         {
            if(WHOLENOTE < 1000)
               WHOLENOTE+=10;
            repaint();			
            return;
         }
         if(k==KeyEvent.VK_DOWN) //decrease note length
         {
            if(WHOLENOTE > 40)
               WHOLENOTE-=10;
            repaint();			
            return;
         }
         if(k==KeyEvent.VK_RIGHT) //increase instrument bank
         {
            if(INSTRUMENT < 127)
            {
               INSTRUMENT++;
               channels[0].programChange(instr[INSTRUMENT].getPatch().getProgram());
            }
            repaint();			
            return;
         }
         if(k==KeyEvent.VK_LEFT) //decrease instrument bank
         {
            if(INSTRUMENT > 0)
            {
               INSTRUMENT--;
               channels[0].programChange(instr[INSTRUMENT].getPatch().getProgram());
            }
            repaint();			
            return;
         }
         if(k==KeyEvent.VK_S)        //start over
         {
            key = -1;
            scaleIndex = -1;
            scale = null;
            scaleOrig = null;
            repaint();			
            return;
         }
         if(k==KeyEvent.VK_W)        //write to MIDI file
         {
            writeToMidiFile(scale);
            repaint();			
            return;
         }
         int opt = -1;
         if(k==KeyEvent.VK_R)             //user picks random option
            opt = (int)(Math.random()*9) + 1;
         else if(k==KeyEvent.VK_1)        //sort
            opt=1;
         else if(k==KeyEvent.VK_2)        //reverse
            opt=2;
         else if(k==KeyEvent.VK_3)        //palindrome
            opt=3; 
         else if(k==KeyEvent.VK_4)        //shuffle with self
            opt=4;
         else if(k==KeyEvent.VK_5)        //shuffle with reverse
            opt=5;
         else if(k==KeyEvent.VK_6)        //scramble
            opt=6;
         else if(k==KeyEvent.VK_7)        //mix with root
            opt=7; 
         else if(k==KeyEvent.VK_8)        //triads
            opt=8;
         else if(k==KeyEvent.VK_9)        //restore original
            opt=9;
         else if(k==KeyEvent.VK_0)        //extra credit mutation
            opt=0;
      
         if(opt>=0 && opt<=9)
         {   
            if(opt==1)                    //sort
               scaleMutator.selSort(scale);
            else if(opt==2)               //reverse
               scale = scaleMutator.reverse(scale);
            else if(opt==3)               //palindrome
               scale = scaleMutator.makePalindrome(scale); 
            else if(opt==4)               //shuffle with self
               scale = scaleMutator.shuffle(scale);
            else if(opt==5)               //shuffle with reverse
               scale = scaleMutator.shuffle(scale, scaleMutator.reverse(scale));
            else if(opt==6)               //scramble
               scale = scaleMutator.scramble(scale);
            else if(opt==7)               //mix with root
               scale = scaleMutator.mixWithNote(scale, scale[0]); 
            else if(opt==8)               //triads
               scale = scaleMutator.triads(scale);
            else if(opt==9)               //restore original
               scale = scaleOrig.clone();
            else if(opt==0)               //extra credit mutation
               scale = scaleMutator.extraCredit(scale);
            playNow(scale);                //play the scale!
         }
      }
      repaint();			//refresh the screen
   }

   //post: draws contents to the panel
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      g.setColor(Color.blue.darker().darker());		//draw a blue boarder around the board
      g.fillRect(0, 0, (20*SIZE), (15*SIZE));
      
      int x = 0, y=0;
      g.setFont(new Font("Monospaced", Font.PLAIN,(int)(SIZE*.5)));
      g.setColor(Color.yellow);
      if(key == -1)              //key has not yet been selected
      {
         g.drawString("What key: C,D,E,F,G,A,B or (R)andom, (SHIFT) to sharp", x, y+=(SIZE));
      }
      else if(scaleIndex == -1)  //scale has not yet been selected
      {
         g.drawString("key: " + intToKey(key), x, y+=(SIZE));
         g.drawString("What scale: (1)Major,(2)Minor,(3)Blues,(4)Harm Minor or (R)andom", x, y+=(SIZE));
      }
      else
      {
         String instrumentName = instr[INSTRUMENT].toString().substring(11,24);
         g.drawString("key: " + intToKey(key) + " note length(UP/DOWN): " + WHOLENOTE + " instr(LEFT/RIGHT)"+ instrumentName, x, y+=(SIZE));
         g.drawString("scale: " + scaleName[scaleIndex] + ":"+ scaleString(scaleOrig, true), x, y+=(SIZE));
         g.drawString("(Q)uit    (S)tart over  (W)rite to MIDI file       (R)andom", x, y+=(SIZE));
         g.drawString("(0) ex.cr.(1) sort      (2) reverse                (3) palindrome", x, y+=(SIZE));
         g.drawString("(4) shuffle within self (5) shuffle with reverse   (6) scramble", x, y+=(SIZE));
         g.drawString("(7) mix with the root   (8) sequence as triads     (9) restore", x, y+=(SIZE));
         g.drawString("" + scaleString(scale, false), x, y+=(SIZE));
         y+=(SIZE*6);
         int [] leveled = levelScale(scale);
         for(int note: leveled)  //draw the notes as scaled ovals on the screen
         {
            int radius = SIZE - (scale.length - scaleOrig.length)/2;
            if(radius < 10)
               radius = 10;
            int red = ((note+1)*15)%256;
            int blue = (256-((note+1)*15))%256;
            int green = (scaleIndex+1) * 63;
            g.setColor(new Color(red, green, blue));
            g.fillOval(x, y-(note*19), radius, SIZE);
            g.setColor(Color.black);
            g.drawOval(x, y-(note*19), radius, SIZE);
            x+=(radius);
         }
      }
   }
   
   //pre:  scale != null and is non-empty
   //post: returns a version of the scale where all notes are lowered so that the lowest note is 0
   //      used to draw notes as ovals on the screen in paintComponent
   public static int[] levelScale(int [] scale)
   {
      int min = scale[0];
      for(int note: scale)    //find the lowest note
         if(note < min)
            min = note;
      int [] ans = scale.clone();
      for(int i=0; i < ans.length; i++)
         ans[i] -= min;
      return ans;      
   }
   
    //pre:  num >= 0 and is a MIDI note value
    //post: return its corresponding key (multiples of 12 are C)
    //      returns "?" if it is not found
    //      used in paintComponent to show the scale as musical notes
   public static String intToKey(int num)
   {
      while(num>=12)			//strip out any octaves
         num-=OCTAVE;    	
      switch(num)
      {
         case 0: 
            return "C";
         case 1: 
            return "C#";
         case 2: 
            return "D";
         case 3: 
            return "D#";
         case 4: 
            return "E";
         case 5: 
            return "F";
         case 6: 
            return "F#";
         case 7: 
            return "G";
         case 8: 
            return "G#";
         case 9: 
            return "A";
         case 10: 
            return "A#";
         case 11: 
            return "B";
      }
      return "?";			//unknown note value sent
   }

//pre:  list != null and is non-empty, all values >= 0      
//post: returns a String of list contents in {42, 58, 46} format given list, false
//      returns a String of list contents in {B, -, D#} format given list, true
//      used in paintComponent to show the mutated scale as musical notes or pitch values
   public static String scaleString(int[]list, boolean noteFormat)
   {
      String ret = "{";
      for(int i=0; i<list.length; i++)
      {
         if(noteFormat==true)
         {
            if(list[i]==0)
               ret += "-";							//denotes a rest
            else
               ret += ""+intToKey(list[i]);
         }
         else
            ret += ""+list[i];
         if(i < list.length-1)
            ret += ", ";
      }
      return ret + "}";
   }

//pre:  scale != null and is non-empty, comprised of values >= 0
//post: plays the scale while program is being executed
   public static void playNow(int[]scale)
   {
      if(scale == null)
         return;
      try {
         int noteLength = WHOLENOTE;
         for(int i=0; i<scale.length; i++)
         {
            channels[0].noteOn(scale[i], VOLUME);
            if(i==scale.length-1)
               Thread.sleep( noteLength * 2);	//make the last note longer
            else
               Thread.sleep( noteLength );
            channels[0].allNotesOff(); 				//turn sounds off
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      channels[0].allNotesOff(); 				//turn sounds off
   }
   
   //pre:  scale != null, non-empty, comprised of values >= 0
   //post: writes the scale to a MIDI file
   public static void writeToMidiFile(int[]scale)
   {
      String filename = "BLANK";
      Sequencer sequencer = null;
      Sequence song = null;
      try
      {
         sequencer = MidiSystem.getSequencer(); 
         sequencer.open();
      }
      catch (MidiUnavailableException e) 
      {
         e.printStackTrace();
      }
   
      try 
      {
         song = new Sequence(javax.sound.midi.Sequence.PPQ,24);
      }
      catch (InvalidMidiDataException e) 
      {
         e.printStackTrace();
      }
   
      int tracking = 0;						   //where the current event will be placed in the song, constantly updated
      Track music = song.createTrack();	//the MIDI track we write our notes into
      setTempo(WHOLENOTE, 0, music);
      music.add(new MidiEvent(ChangeInstrument(INSTRUMENT, 0), 0));	      //melody track on channel 0
      final int TEXT = 0x01;
      addEvent(music, TEXT, scaleName[scaleIndex].getBytes(), tracking);   //add the name of the track to the MIDI file
      tracking = playScale(scale, tracking, 0, music);
      String songInfo = "";     
      String TrackName = scaleName[scaleIndex] + key;
      songInfo+=("You have chosen to compose a sequence in the "+scaleName[scaleIndex]+" scale\n");
      songInfo+=("Please open and run '"+TrackName+".mid' in this folder"+"\n");      
      System.out.println(songInfo);
    //****  set track name (meta event)  ****
      MetaMessage mmessage = new MetaMessage();
      try 
      {
         mmessage.setMessage(0x03 ,TrackName.getBytes(), TrackName.length());
      }
      catch (InvalidMidiDataException e) 
      {
         e.printStackTrace();
      }
   
      music.add(new MidiEvent(mmessage,(long)0));
   
      filename = TrackName+".mid";
    
      int[] allowedTypes = MidiSystem.getMidiFileTypes(song); 
   	
      if (allowedTypes.length == 0) 
      { 
         System.err.println("No supported MIDI file types.");
      } 
      else 
      { 
         try
         {
            try
            {
               MidiSystem.write(song, allowedTypes[0], new java.io.File(filename));//write to the file
            }
            catch (java.io.FileNotFoundException e) 
            {
               e.printStackTrace();
            }
         
         }
         catch(java.io.IOException ex) 
         {
            System.out.println("\n\n\nERROR:\nPlease close the media player and run again");
         }
      }
   
   }
   
   //pre:  newTempo > 0, where >=0, music!=null
   //post: adds a TEMPO meta event to set the speed of the song
   private static void setTempo(int newTempo, int where, Track music)
   {
      MetaMessage mmessage = new MetaMessage();
      int l = 60*1000000/newTempo;
      try 
      {
         mmessage.setMessage(0x51,new byte[]{(byte)(l/65536), (byte)(l%65536/256), (byte)(l%256)}, 3);
      }
      catch (InvalidMidiDataException e) 
      {
         e.printStackTrace();
      }
      music.add(new MidiEvent(mmessage, where));
   }

   //pre:  inst>=0 && inst<=127, channel>=0
   //post: returns a message to set instrument for a MIDI file
   private static ShortMessage ChangeInstrument(int inst, int channel)
   {
      ShortMessage temp=new ShortMessage();
      try 
      {
         temp.setMessage(ShortMessage.PROGRAM_CHANGE, channel, inst, 100);
      }
      catch (InvalidMidiDataException e) 
      {
         e.printStackTrace();
      }
      return temp;
   }
   
   private static void addEvent(Track track, int type, byte[] data, long where)
   {
      MetaMessage message = new MetaMessage();
      try
      {
         message.setMessage(type, data, data.length);
         MidiEvent event = new MidiEvent( message, where );
         track.add(event);
      }
      catch (InvalidMidiDataException e)
      {
         e.printStackTrace();
      }
   }
   
   //plays the melody sent with sent durations at tracking position 'where'
	//melodyNotes and melodyDurations should have the same length
	//returns current tracking position
   public static int playScale(int[]scale, int where, int chnl,  Track music)
   {
      int noteLength = WHOLENOTE/12;
      for(int i=0; i<scale.length; i++)
      {
         try
         {
            try
            {
               if(i == scale.length - 1)		//make the last note longer
                  noteLength *= 2;
               where = playNote(scale[i], noteLength, VOLUME, where, chnl,  music);
            }
            catch (InvalidMidiDataException e)
            {
               e.printStackTrace();
            }
         
         }
         catch (MidiUnavailableException e)
         {
            e.printStackTrace();
         }
      
      }
      return where;
   }

//writes a sound of pitch 'note', durartion 'noteLength', volume 'VELOCITY' at location 'where' in chanel 'chnl' in the Track 'music'
	//returns the updated tracking position - doesn't add a sound if 'note' is <= 0 but places a rest
   private static int playNote(int note, int noteLength, int myVelocity, int where, int chnl, Track music) throws InvalidMidiDataException, MidiUnavailableException
   {	
      if(noteLength < 0)
         noteLength = Math.abs(noteLength);
      if(note>0)
      {
         ShortMessage on = new ShortMessage();
         ShortMessage off = new ShortMessage();
         on.setMessage(ShortMessage.NOTE_ON, chnl, note, myVelocity);
         off.setMessage(ShortMessage.NOTE_OFF,chnl, note, myVelocity);   
         music.add(new MidiEvent(on, where));
         music.add(new MidiEvent(off, where+noteLength));
      }  
      return where+noteLength;
   }

}
