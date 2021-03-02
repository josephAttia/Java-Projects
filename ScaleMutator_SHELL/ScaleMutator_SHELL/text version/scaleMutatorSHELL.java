//Rev. Dr. Douglas R Oberle - Washington, DC

import javax.sound.midi.*;
import java.util.Vector;
import java.io.*;
import java.util.*;

public class scaleMutatorSHELL
{          
   public static final int INSTRUMENT = 0;			//the melody instrument the user picks (piano is 0, 0<=INSTRUMENT<128)
   public static final int WHOLENOTE=192;				//resolution of a whole note for MIDI syncing
   public static final int OCTAVE = 12;				//add this to a note to go up an octave, subtract to go down
   public static final int VOLUME=80;				   //the VELOCITY of the note (how "hard" the note is struck) 0<=VELOCITY<128
     
   private static MidiChannel[] channels=null;		//MIDI channels
   private static Instrument[] instr;					//MIDI instrument bank
	
      	//intervals of scales						Major							minor						Blues				Harmonic minor
   private static int [][] intervals = {{0,2,4,5,7,9,11,12}, {0,2,3,5,7,9,11,12}, {0,3,5,6,7,10,12}, {0,2,3,5,7,8,11,12}};
   public static int [] scale = null;			      //the scale or mode the user picks
   public static int [] scaleOrig = null;          //original scale picked so user can restore it
   
   public static Scanner input = new Scanner(System.in);

//pre:  a and b are valid index #s of list, which is not null
//post: swaps list[a] with list[b]  - modifies the array that is sent
//i.e., given list:[1,2,3,4], a:1, b:3 -> changes list to [1,4,3,2]
   public static void swap(int[] list, int a, int b)
   {
     //*********WRITE THIS METHOD***************
     
     //*****************************************
   }

//pre:  list is not null
//post: nums is sorted in ascending order - modifies the array that is sent
//i.e., given list:[4,2,7,5] -> changes list to [2,4,5,7] 
//needs to work with an array of any size             
   public static void selSort(int[] list)
   {
     //*********WRITE THIS METHOD***************
     
     //*****************************************
   }

//pre:   list is not null
//post:  returns a new array with the same elements of list, but scrambled (put in random order)
//needs to work with an array of any size
   public static int[] scramble(int[]list)
   {
      int[]retVal = list.clone();
     //*********WRITE THIS METHOD***************
     
     //*****************************************
      return retVal;
   }

 //pre:  list is not null
 //post: returns a new array with elements in list, but in reverse order
 //i.e., given list:[1,2,3,4] -> returns [4,3,2,1]
 //needs to work with an array of any size
   public static int[] reverse(int[]list)
   {
     //*********WRITE THIS METHOD***************
     
      return list; 	//temporary statement to keep us compiling
     //*****************************************
   }
   
	//pre:  list is not null
   //post: returns a new array (almost double the size of list) with the elements of list as a palindrome.
	//i.e., given list:[1,2,3,4] -> returns [1,2,3,4,3,2,1]
	//needs to work with an array of any size
   public static int[] makePalindrome(int[]list)
   {
     //*********WRITE THIS METHOD***************
     
      return list; 	//temporary statement to keep us compiling
     //*****************************************
   }   
   
	//pre:  neither a nor b are null, assume a.length == b.length
   //post: returns a new array with elements shuffles in from two lists,
	//alternating between advancing elements of lists a and b
	//[a0, b0, a1, b1, a2, b2, a3, b3, a4, b4,...]
	//i.e., given a:[0,1,2,3], b:[9,8,7,6] -> returns [0,9,1,8,2,7,3,6]
	//needs to work with arrays of any size
   public static int[] shuffle(int[]a, int[]b)
   {
     //*********WRITE THIS METHOD***************
     
      return a; 		//temporary statement to keep us compiling
     //*****************************************
   }
	
	 //pre:  list is not null	
	 //post: returns a new array with elements of list, but shuffled- 
	 //alternating between elements from the beginning moving right and elements from the end moving left
	 //[1st elem, Last elem, 2nd elem, 2nd to last elem, 3rd elem, 3rd to last elem, 4th elem, 4th to last elem,...]
	 //i.e., given list:[0,1,2,3,4,5,6,7] -> returns [0,7,1,6,2,5,3,4]
	 //needs to work with an array of any size
   public static int[] shuffle(int[]list)
   {
     //*********WRITE THIS METHOD***************
     
      return list; 	//temporary statement to keep us compiling
     //*****************************************
   }
   
	//pre:  list is not null, note is between 22 and 108
	//post:  makes a new array containing each element of list, but where every other element is note
	//[list0, note, list1, note, list2, note, list3, note, list4, note,...]
	//if list:[2, 4, 6, 8] and note:1 -> returns [1,2,1,4,1,6,1,8]
	//needs to work with an array of any size
   public static int[] mixWithNote(int[] list, int note)
   {
     //*********WRITE THIS METHOD***************
     
      return list; 	//temporary statement to keep us compiling
     //*****************************************
   }
	
	//pre:  list is at least of length 3
	//post:  makes a new array containing triads (groups of 3 consecutive notes in the scale), each starting with successive elements of list
	//[1st elem, 2nd elem, 3rd elem, 2nd elem, 3rd elem, 4th elem, 3rd elem, 4th elem, 5th elem,...]
	//if list:[1,2,3,4,5,6] -> returns [1,2,3,  2,3,4,  3,4,5, 4,5,6]
   public static int[] triads(int[] list)
   {
     //*********WRITE THIS METHOD***************
     
      return list; 	//temporary statement to keep us compiling
     //*****************************************
   }
   	
     //post:  student invents their own mutation to the scale
   public static int[] extraCredit(int[] list)
   {
     //*********WRITE THIS METHOD***************
     
      return list; 	//temporary statement to keep us compiling
     //*****************************************
   }    
        
	//given a String, returns true if it is comprised of only digits
   public static boolean isNumber(String word)
   {
      for(int i=0; i<word.length(); i++)
         if(!Character.isDigit(word.charAt(i)))
            return false;
      return true;
   }
  	  
	//Post: sets specific key, scale
   private static void userInput() throws IOException
   {  
      int key = 60;							//this will be the root value for the key chosen
      System.out.println("What key: C,C#, D,D#, E, F,F#, G,G#, A,A#, B or (R)andom");
      String temp = input.next().toUpperCase();
      if(temp.charAt(0)=='R')
         key = (int)(Math.random()*12) + 60;	//so song can be in any key
      else
         key = keyToInt(temp);							//C is 36,48,60
      
      System.out.println("What scale: (1)Major, (2)Minor, (3)Blues, (4)Harmonic Minor or (R)andom");
      temp = input.next().toUpperCase();
      int scaleChoice = 0;
      if(!isNumber(temp))
         scaleChoice = (int)(Math.random()*intervals.length);
      else
         scaleChoice = Integer.parseInt(temp) - 1;
      if(scaleChoice < 0 || scaleChoice >= intervals.length)
         scaleChoice = (int)(Math.random()*intervals.length);
      scale = intervals[scaleChoice]; 
      for(int i=0; i<scale.length; i++)									//adjust scale to random key
         scale[i] += key;
      scaleOrig = scale.clone();
   }
	  
//shows list contents in {42, 58, 46} format given list, false
//shows list contents in {B, -, D#} format given list, true
   public static String printArray(int[]list, boolean noteFormat)
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
	
//given the key of the song, return its corresponding MIDI note value
//(returns 60->71 given C->B)
   public static int keyToInt(String key)
   {
      if(key.equals("C"))
         return 60;
      if(key.equals("C#"))
         return 61;
      if(key.equals("D"))
         return 62;
      if(key.equals("D#"))
         return 63;
      if(key.equals("E"))
         return 64;
      if(key.equals("F"))
         return 65;
      if(key.equals("F#"))
         return 66;
      if(key.equals("G"))
         return 67;
      if(key.equals("G#"))
         return 68;
      if(key.equals("A"))
         return 69;
      if(key.equals("A#"))
         return 70;
      if(key.equals("B"))
         return 71;
      return 60;				//if key is not recognized, make it a C
   }

   //given a MIDI note value, return its corresponding key (multiples of 12 are C)
	//returns "?" if it is not found
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
   	     
   //plays the scale while program is being executed
   public static void playNow(int[]scale)
   {
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
	  	
   public static void main(String [] args)throws IOException
   {
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
      
      userInput();         //user picks key and scale
   
      int option = 1;
      while(option != -1)  //option Q to quit
      {  
         playNow(scale);
         System.out.println(printArray(scale, true));   
         System.out.println("(Q) quit                (0) extra credit mutation  (R) random");
         System.out.println("(1) sort,               (2) reverse,               (3) palindrome");
         System.out.println("(4) shuffle within self,(5) shuffle with reverse,  (6) scramble");  
         System.out.println("(7) mix with the root,  (8) sequence as triads,    (9) restore original scale");
         String temp = input.next().toUpperCase();
         option = 1;
         if(!isNumber(temp))
         {
            if(temp.equals("Q"))
               option = -1;
            else
               option = (int)(Math.random()*8)+1;
         }
         else
            option = Integer.parseInt(temp);
      
         switch(option)
         {
            case 0: scale = extraCredit(scale);
               break;
            case 1:  selSort(scale);  
               break;
            case 2: scale = reverse(scale); 
               break;
            case 3: scale = makePalindrome(scale); 
               break;
            case 4: scale = shuffle(scale); 
               break;
            case 5: scale = shuffle(scale, reverse(scale)); 
               break;
            case 6: scale = scramble(scale); 
               break;
            case 7: scale = mixWithNote(scale, scale[0]); 
               break;
            case 8: scale = triads(scale); 
               break;
            case 9: scale = scaleOrig.clone(); 
               break;
            default: 
               break;
         }   
      }
          
   }
} 	
