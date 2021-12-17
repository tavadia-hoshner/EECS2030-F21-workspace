package PE2_F21;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.*;

class PE2_tester {
	@Test 
	void testNoteConstructor0() {
		Note note1 = new Note(); 
		boolean actual = ((note1.getExceptionCode() ==  0 && note1.getNote() == 0 && note1.getOctave() == 0 && note1.getDuration() == 0) ? true : false);
		assertEquals(true, actual, "Note's default constructors or getter methods are not properly implemented!");
	}


	@Test 
	void testNoteCompareTo1() {
		Note note1 = new Note(60, 100, 4); 
		Note note2 = new Note(60, 100, 4); 
		int ret = note1.compareTo(note2); 
		boolean actual = (ret == 0? true : false) && note1.getExceptionCode() == 0; 
		assertEquals(true, actual, "Note's compareTo does not work as expected and/or getExceptionCode is not set properly");
	}

	
	@Test 
	void testNoteCompareTo4() {
		Note note1 = new Note(60, 100, 4); 
		Music note2 = new Music(); 
		int ret = note1.compareTo(note2); 
		int actual = note1.getExceptionCode();
		assertEquals(-2, actual, "getExceptionCode is not set properly for incompatible objects");
	}
	
	
	@Test
	void testValidate_1() {
		Note note1 = new Note(-3, 100, -1); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave -1");
	}

	// This tester checks if validateNote throws an exception. However, it does not check the  type of exception.
	 @Test
     public void testValidateNote1() {
		 Note note = new Note(70, 1000, 9);
		 try {
			 Method method = Note.class.getDeclaredMethod("validateNote", null);
			 method.setAccessible(true);
			 assertThrows(InvocationTargetException.class, ()-> method.invoke(note));
		 }
		 catch (Exception e) {		
			 System.out.println("error");
		 }
     }	

	
		@Test 
		void testMusicConstructor0() {
			Music music = new Music();
			boolean actual = ((music.getName() == null && music.getComposer() == null && music.getScore().size() == 0) ? true : false);
			assertEquals(true, actual, "Music's default constructors or getter methods are not properly implemented!");
		}

		
		@Test 
		void testMusicCompareTo3() {
			Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
			Note [] note2 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)};
			ArrayList<Note> score1 = new ArrayList<Note>();
			ArrayList<Note> score2 = new ArrayList<Note>();
			for (int i = 0; i < note1.length; i++) {
				score1.add(note1[i]);
				score2.add(note2[i]);
			}
			Music music1 = new Music("composer", "name1", score1);
			Music music2 = new Music("composer", "name2", score2);
			boolean actual = music1.compareTo(music2) == 0;
			assertEquals(false, actual, "Music's compareTo() is not properly implemented!");
		}
		
		@Test 
		void testCompositionInScoreByGetter() {
			Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
			ArrayList<Note> score1 = new ArrayList<Note>();
			for (int i = 0; i < note1.length; i++) 
				score1.add(note1[i]);
			Music music1 = new Music("composer", "name1", score1);
			boolean actual = music1.getScore() != score1 && music1.getScore().get(0) != score1.get(0);
			assertEquals(true, actual, "Composition was not implemented correctly in the getter method");
			
		}
	
		@Test
		void testReadFile1() {
			PerformingArt.readFile("AFileThatDoesnotExist");
			assertEquals(-1, PerformingArt.exceptionCode, "readFile does not handle the exception correctly");
		}
		
		@Test
		void testReadFile3() {
			//For this tester to works properly, create a file called music1 and store the content of list2 (below) in the file.
			List<String> list = (ArrayList<String>) PerformingArt.readFile("music1"); 
			String[] list2 = {"48 1000 3", "68 1000 4", "2 1000 -1", "108 1000 8", "51 1000 3", "59 1000 3", "33 1000 1", "48 1000 3", "93 1000 6", "102 1000 7"};
			boolean equal = list2.length == list.size(); 
			if (equal)
				for (int i = 0; i < list2.length; i++)
					if((list2[i].trim()).compareTo((list.get(i).trim())) != 0){
						equal = false; 
						break;
					}
			assertEquals(true, equal, "readFile does not read the file correctly");
		}
		
		@Test
	    void testValidate_101() {
	        Note note1 = new Note(72, 200, 10); 
	        note1.play();
	        boolean actual1 = note1.getExceptionCode() == -3;
	        
	        Note note2 = new Note(72, 200, -2); 
	        note2.play();
	        boolean actual2 = note2.getExceptionCode() == -3;
	        
	        boolean actual = actual1 && actual2;
	        assertEquals(true, actual, "validate does not handle the note properly");
	    }
		
		@Test
        void testReadFile101() {
            Music music = new Music("Marzieh", "idk", PerformingArt.readFile("music"));
            music.play();
            boolean actual1 = PerformingArt.exceptionCode == 0;
            
            PerformingArt.readFile("AFileThatDoesnotExist");
            
            boolean actual2 = PerformingArt.exceptionCode == -1;
            boolean actual3 = actual1 && actual2;
            assertEquals(true, actual3, "readFile does not handle the exception correctly");
        }
		
        @Test void setScore2(){
            ArrayList<Note> score1 = new ArrayList<Note>();
            Music music1 = new Music("composer", "name", score1);
            Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
            Note [] note2 = {new Note(5, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)};
            score1 = new ArrayList<Note>();
            ArrayList<Note> score2 = new ArrayList<Note>();
            for (int i = 0; i < note1.length; i++) {
                score1.add(note1[i]);
                score2.add(note2[i]);
            }
            music1.setScore(score2);
            assertNotEquals(music1.getScore(),score2, "setScore is not properly implemented, needs deep copy");
        }
		
		


}
