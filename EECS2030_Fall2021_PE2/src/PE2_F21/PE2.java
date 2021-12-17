package PE2_F21;


import java.io.*;
import java.util.*; 

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Hoshner Tavadia
Student Number: 217828567
Course Section: EECS2030 A
*/



public class PE2 {

	public static void main(String[] args) {
		
		// Remember to remove any code that you may write in the main method, before you submit.

	} // end of main
} // end of PE2

/**
 * A Simple Interface to implement all classes in performingArt class and its extensions with the function play.
 * @author Hoshner Tavadia
 *
 */
interface Art extends Comparable{
	public void play();
}

/**
 * Class Performing arts
 * @author Hoshner Tavadia
 *
 */
abstract class PerformingArt implements Art{
	public static int exceptionCode;
	/**
	 * Reads String Line by line from a text file
	 * @param file is the name/path to the file
	 * @return a list of strings for each line of text in the file provided.
	 *
	 */
	public static List<String> readFile(String file){
		exceptionCode = 0;
		try {
			Scanner sc = new Scanner(new File(file));
			List<String> x = new ArrayList<String>();
			while(sc.hasNextLine()) {
				x.add(sc.nextLine());
			}
			return x;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			exceptionCode = -1;
			return null;
		}
	}
	/**
	 * This method should be able to play any type of performing arts
	 */
	public void play() {
		this.play();
	}
}

/**
 * NOTE Class
 * @author Hoshner Tavadia
 * Gets Extended from Performing Arts
 */
class Note extends PerformingArt{
	private int note;
	private int duration;
	private int exceptionCode = 0;
	private int octave;
	/**
	 * Default constructor for Note
	 */
	public Note() {
		note = 0;
		duration = 0;
		octave = 0;
	}
	
	/**
	 * Getter for Note
	 * @return note
	 */
	public int getNote() {
		return this.note;
	}
	
	/**
	 * getter for Duration
	 * @return duration
	 */			
	public int getDuration() {
		return this.duration;
	}	
	
	/**
	 * Getter For Exception Code
	 * @return exception code
	 */
	public int getExceptionCode() {
		return this.exceptionCode;
	}
	
	/**
	 * Getter For Octave
	 * @return octave
	 */
	public int getOctave() {
		return this.octave;
	}
	
	/**
	 * Setter for Octave
	 * @param value sets octave
	 */
	public void setOctave(int value) {
		this.octave = value;
	}
	
	/**
	 * Setter for Note
	 * @param value sets note
	 */
	public void setNote(int value) {
		this.note = value;
	}
	
	/**
	 * Setter for Duration
	 * @param value sets duration
	 */
	public void setDuration(int value) {
		this.duration = value;
	}	
	
	/**
	 * Overloaded constructor for Note
	 * @param n is the note value
	 * @param d is the duration value
	 * @param o is the octave value
	 */
	public Note(int n,int d, int o) {
		note = n;
		duration = d;
		octave = o;
	}
	
	/**
	 * Checks if the Note and Octave are in sync, or the Note-Octave pair is valid as per the given table.
	 * @throws MismatchException
	 */
	private void validate() throws MismatchException{
		if((note>=0 && note<=127 && octave>=-1 && octave<=9)) {
		if (this.octave!=((this.note-1)/12)-1) {
			throw new MismatchException("Octave/Note Mismatch");
		}
		}
		else throw new MismatchException("Octave/Note Mismatch");
	}
	
	@Override
	/**
	 * Compares 2 notes for equality
	 * @param o is the objects that it going to be compared with.
	 * @exception NullPointerException is thrown if Object o is null
	 * @exception ClassCastException is thrown if Object O is not a Note Class
	 */
	public int compareTo(Object o){
		// TODO Auto-generated method stub
		try {
			if(this==o) return 0;
			if(o==null) {
				
				throw new NullPointerException();
			}
			if(this.getClass()!=o.getClass()) {
				
				throw new ClassCastException();
			}
			else {
				Note x = (Note)o;
				if(this.note== x.note && this.octave==x.octave) return 0;
				else return this.note-x.note;
			}
		}
		catch(NullPointerException e) {
			this.exceptionCode=-1;
		}
		catch(ClassCastException e) {
			this.exceptionCode=-2;
		}
		return 0;
	}
	
	@Override
	/**
	 * Plays the individual note
	 */
	public void play(){
		try {
			validate();
			Synthesizer midiSynthesizer = MidiSystem.getSynthesizer();
			midiSynthesizer.open();
			Instrument[] instrument = midiSynthesizer.getDefaultSoundbank().getInstruments();
			midiSynthesizer.loadInstrument(instrument[0]);
			MidiChannel[] midiChannels = midiSynthesizer.getChannels();
			midiChannels[0].noteOn(this.note, 100);
			try {
				Thread. sleep(duration);
			}
			catch( InterruptedException e ) {
				e.printStackTrace();
			}
			midiChannels[0].noteOff(this.note);
		}
		catch (MismatchException e) {
			this.exceptionCode=-3;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Factory method For node
	 * @param d is the Note that needs to be cloned
	 * @return the clone of the Note d
	 */
	public static Note getInstance(Note d) {
		Note temp = new Note(d.note,d.duration,d.octave);
		return temp;
	}
}

/**
 * MUSIC Class
 * @author Hoshner Tavadia
 * Gets extended by the PerformingArts Class
 */
class Music extends PerformingArt{

	private String Composer;
	private String name;
	private ArrayList<Note> score;
	private int exceptionCode;
	
	/**
	 * Getter for Composer
	 * @return composer
	 */
	public String getComposer() {
		return this.Composer;
	}
	
	/**
	 * Getter for Name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Getter for Exception Code
	 * @return exceptionCode
	 */
	public int getExceptionCode() {
		return this.exceptionCode;
	}
	
	/**
	 * GEtter For ArrayList<Note> Score
	 * @return score
	 */
	public ArrayList<Note> getScore(){
		ArrayList<Note> temp = new ArrayList<Note>();
		for(int i=0;i<score.size();i++) {
			Note old = score.get(0);
			temp.add(Note.getInstance(old));
		}
		return temp;
	}
	
	/**
	 * Setter For Composer
	 * @param value to be set for composer
	 */
	public void setComposer(String value) {
		Composer = new String(value);
	}
	
	/**
	 * Setter For Name
	 * @param value to be set for name
	 */
	public void setName(String value) {
		name = new String(value);
	}
	
	/**
	 * Setter For ArrayList<Note> score
	 * @param temp is the Array List that needs to be cloned to score
	 */
	public void setScore(ArrayList<Note> temp) {
		score = new ArrayList<Note>();
		for(int i=0;i<temp.size();i++) {
			Note old = temp.get(0);
			score.add(Note.getInstance(old));
		}
	}
	
	/**
	 * Default constructor for Music
	 */
	public Music() {
		Composer = null;
		name = null;
		exceptionCode = 0;
		score = new ArrayList<Note>();
	}
	
	/**
	 * Overloaded constructor for Music
	 * @param c is the composer
	 * @param n is the name
	 * @param temp is the ArrayList of notes
	 */
	public Music(String c, String n, ArrayList<Note> temp) {
		Composer = c;
		name = n;
		score = new ArrayList<Note>();
		for(int i=0;i<temp.size();i++) {
			Note old = temp.get(0);
			score.add(new Note(old.getNote(),old.getDuration(),old.getOctave()));
		}
	}
	
	/**
	 * Overloaded constructor for Music
	 * @param c is the composer
	 * @param n n is the name
	 * @param temp is the List of String that contain the data for each note in the format "note, duration, octave"
	 */
	public Music(String c, String n, List<String> temp) {
		Composer = c;
		name = n;
		score = new ArrayList<Note>();
		for(String x : temp) {
			Scanner sc = new Scanner(x);
			score.add(new Note(sc.nextInt(),sc.nextInt(),sc.nextInt()));
			sc.close();
		}
	}
	
	/**
	 * Compares the value of 2 music objects
	 * @param o is the objects that gets com0pared with
	 * @exception NullPointerException is thrown if Object o is null
	 * @exception ClassCastException is thrown if Object O is not a Music Class
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		try {
			if(this==o) return 0;
			if(o==null) {				
				throw new NullPointerException();
			}
			if(this.getClass()!=o.getClass()) {
				throw new ClassCastException();
			}
			else {
				Music x = (Music)o;
				boolean equalNote = true;
				for(int i=0;i<score.size();i++) {
					if(score.get(i).compareTo(x.score.get(i))!=0) {
						equalNote = false;
						break;
					}
				}
				if(this.Composer.equals(x.Composer) && this.name.equals(x.name) && equalNote) return 0;
				else return -1;
			}
		}
		catch(NullPointerException e) {
			this.exceptionCode=-1;
		}
		catch(ClassCastException e) {
			this.exceptionCode=-2;
		}
		return 1;
	}

	/**
	 * Plays all the notes in the 
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		for(Note x : score) {
			x.play();
		}
	}
}

/**
 * A Custome Made Exception FOr this particular class
 * It Is thrown when the note does not match the octave value as given in the table.
 * @author Hoshner Tavadia
 */
class MismatchException extends Exception{
	public MismatchException() {
		super();
	}
	public MismatchException(String message) {
		super(message);
	}
}

