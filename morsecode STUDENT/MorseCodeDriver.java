import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.*;


public class MorseCodeDriver {

    // We are making these the result of encoding and decoding strings. This is necessary to achieve the sound playing feature  
    public static String finalEncode = new String();
    public static String finalDecode = new String();

    // Given a audio file name, this method uses the built in Java Audio Stream to play that audio clip
    //
    // @pram: soundFile => Type: String => The Name of the sound file 
    //
    // Pre: 
    // Audio file needs to be in the same directory as MorseCodeDriver.java. Name of the file need to mach the soundFile pram
    // Post:
    // Plays the given audio file
    public static void playSound(String soundFile) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        File f = new File("./" + soundFile);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner sc = new Scanner(System.in); // Initiates a scanner (this will be used for both console reading and file reading)

        System.out.println("      ,--.   ,--.                                 ,-----.          ,--.           ,--------.                              ,--.          ,--.                  ");
        System.out.println("      |   `.'   | ,---. ,--.--. ,---.  ,---.     '  .--./ ,---.  ,-|  | ,---.     '--.  .--',--.--. ,--,--.,--,--,  ,---. |  | ,--,--.,-'  '-. ,---. ,--.--.  ");
        System.out.println("      |  |'.'|  || .-. ||  .--'(  .-' | .-. :    |  |    | .-. |' .-. || .-. :       |  |   |  .--'' ,-.  ||      \\(  .-' |  |' ,-.  |'-.  .-'| .-. ||  .--' ");
        System.out.println("      |  |   |  |' '-' '|  |   .-'  `)\\   --.    '  '--'\\' '-' '\\ `-' |\\   --.       |  |   |  |   \\ '-'  ||  ||  |.-'  `)|  |\\ '-'  |  |  |  ' '-' '|  ");
        System.out.println("      `--'   `--' `---' `--'   `----'  `----'     `-----' `---'  `---'  `----'       `--'   `--'    `--`--'`--''--'`----' `--' `--`--'  `--'   `---' `--'     ");
        System.out.println("                                                       Name: Joseph Attia    ID: 1595187                                                                      ");

        // Makes HashMaps to store info and arrays seen in MorseCode.java
        // A Hashmap is nessesary for this because it is more efficient 
        Map < String, String > englishVersion = new HashMap < String, String > ();
        Map < String, String > morseCode = new HashMap < String, String > ();

        // Fills up the HashMap with the contents of that is seen in MorseCode.java 
        for (int i = 0; i < MorseCode.english.length; i++) {
            morseCode.put(MorseCode.english[i], MorseCode.code[i]); // Assigns each letter in the English Alpabet with a "morse code"
        }
        for (int i = 0; i < MorseCode.code.length; i++) {
            englishVersion.put(MorseCode.code[i], MorseCode.english[i]); // Assigns each "morse code" to a letter in the English Alpabet
        }

        // Prompts the user to pick the operation they want to use 
        System.out.println("Pick the operation: Encode (e) or Decode (d)");
        String operation = sc.nextLine();

        // Prompts the user to use a file for the translation
        System.out.println("Is there a file you would like to read from? (yes/y) (no/n) ");
        String fileChoice = sc.nextLine();

        try {
            if (fileChoice.equals("y") || fileChoice.equals("yes")) {

                System.out.print("Enter File Name (Case Sensitive): ");

                //instantiates a new file reader for future file reading
                File file = new File(sc.nextLine());
                sc = new Scanner(file);

                // This while loop will loop through each line and either, based on user choice/input, will encode or decode that line
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (operation.equals("d")) {
                        // Sends in the line and the set that goes with the operation 
                        decode(line, englishVersion);
                    } else if (operation.equals("e")) {
                        // Sends in the line and the set that goes with the operation 
                        encode(line, morseCode, true);
                    }
                }
            } 
            // If the user wants a manual input 
            else if (fileChoice.equals("n") || fileChoice.equals("no")) {

                System.out.print("Enter your text: ");
                String text = sc.nextLine();

                // if the user wants to encode, call the encode method
                if (operation.equals("e")) {
                    encode(text, morseCode, false);
                    //After the encoding has occured and stored in the pubic var then prompt the user to hear the audio or not
                    System.out.println("Do you want the hear the code?");
                    String hearAudio = sc.nextLine();

                    if (hearAudio.equals("y")) {
                       // For each char in the morse code (. or -) pay the correct sound 
                        for (String s: finalEncode.split("")) {
                            if (s.equals(".")) {
                                playSound("dot.wav");
                                TimeUnit.MILLISECONDS.sleep(500);
                            } else if (s.equals("-")) {
                                playSound("dash.wav");
                                TimeUnit.MILLISECONDS.sleep(500);
                            } else {
                                TimeUnit.MILLISECONDS.sleep(700);
                            }
                        }
                    }

                }
                // if the user wants to decode, call the decode method
                else if (operation.equals("d")) {
                    decode(text, englishVersion);
                }
            }
        }
        // Catches the FileNotFoundException to make sure the program runs smoothly
        catch (Exception e) {
            String error = e.getClass().toString();
            // FileNotFound Gets Caught
            if (error.equals("class java.io.FileNotFoundException")) {
                System.out.println("❗File Not Found ❗ \nCheck Spelling or File Extension");
            }
            // Any other errors
            else {
                System.out.println(e.getClass());
            }
        }
    }

    // Decodes a given text to morse code for every character in the text.
    //
    // @pram: text -> Type: String 
    // @pram: morseCode -> Type: Map
    //
    // Pre: 
    // A text, this can be either one letter or a whole essay 
    // To prevent any errors, if the text is either null or an empty string the user.
    //
    // Post:
    // Prints out the decoded message in normal english
    public static void decode(String text, Map < String, String > hashMap) {
        // Loops through each word (- . ...-) and gets the word assoiated with it (test) ex: - . ... -  ==> test 
        for (String morseWord: text.split(" ")) {
            String english = hashMap.get(morseWord);
            // Since spaces are not part of any set it returns null, without this check, the product of this code will be testNULLhelloNULLworld
            if (english == null) {
                finalDecode += " ";
            } else {
                finalDecode += english;
            }
        }
        System.out.println("Decoded message: \n" + finalDecode);
    }

    // Encodes a given text to morse code for every character in the text
    // @pram: text -> Type: String -> User test
    // @pram: morseCode -> Type: Map -> HashMap Associated with teh operation 
    // @pram: multiline -> Type: Bool -> Used to prevent over printing of a multiline file 
    // Pre: 
    // A text, this can be either one letter or a whole essay 
    // To prevent any errors, if the text is either null or an empty string the user.
    //
    // Post:
    // Prints out the encoded message in morse code
    public static void encode(String text, Map < String, String > hashMap, boolean multiLine) {
        text = text.toUpperCase();

        // Checks if any text has been provided to the method
        if (text == null || text.equals("")) {
            System.out.println("No Text Given");
        }

        // To prevent the string "Encoded message"  to be printed out for each line in the file, it is necessary to check if there are more than one line
        if (!multiLine) {
            // For each character in given string, this for loop will get the morse code for that letter/char
            for (char ch: text.toCharArray()) {

                String stringVersion = Character.toString(ch);
                String morseValue = hashMap.get(stringVersion);

                // if no value is given back then the char is a space thus put a space
                if (morseValue == null) {
                    finalEncode += "/";
                } else {
                    finalEncode += morseValue + " ";
                }
            }
            System.out.println("Encoded message: " + finalEncode);
        } 
        else {
            // For each character in given string, this for loop will get the morse code for that letter/char            
            for (char ch: text.toCharArray()) {

                String stringVersion = Character.toString(ch);
                String morseValue = hashMap.get(stringVersion);

                // if no value is given back then the char is a space thus put a space               
                if (morseValue == null) {
                    finalEncode += "/";
                } else {
                    finalEncode += morseValue + " ";
                }
            }
            System.out.println(finalEncode);
        }
    }
}