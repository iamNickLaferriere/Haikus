/*
 * Imports
 */
import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Nick Laferriere
 *
 */

/*
 * Purpose: Read in a text file. Process the file and print out any Haiku you find (5 syllables, 7 syllables 5 syllables). 
 */
public class HaikuDriver {
	//Array list to store words
	//String[] wordsArray;
	//Array List to store haikus
    //String[] haikusArray;
    String word = "";
	String haikus = "";
	String fileName = "sample.txt";
	int lineSylNum = 0;
	int sylNum = 5;
	int count;
	Scanner scan;
		
	
    /*
     * 
     */
    public HaikuDriver()throws IOException{
    findHaiku();
    }
    
	/* 
	 * NEEDS IMPROVEMENT: Only prints out consecutive words with syllable count of 5,7,5 regardless of the sentence
	 * TODO add sentence recognization
	 * Processes file searching for consecutive sentences with the syllable count of 5,7,5.  Adds total syllables to each other.
	 */
    public void findHaiku(){
    	     	
    	try{			
    	String sCurrentWord;	
    	scan = new Scanner(new FileReader(new File(fileName)));
  
    		while(scan.hasNext() != false){
    	 	sCurrentWord = scan.next().trim();
    	 	
    	 	lineSylNum += countSyllables(sCurrentWord);
    	 	word += sCurrentWord + " ";
    	 	//System.out.println(line);				
    	 		if(lineSylNum == sylNum){
    	 		//total syllable count equals 5
    	 		if(sylNum == 5){
    	 		sylNum += 7;
    	 		}
    	 		//total syllable count equals 12 (5+7=12)
    	 		else if(sylNum == 12){
    	 		sylNum += 5;
    	 		}
    	 		//total syllable count equals 17 (12+5=17)
    	 		else if(sylNum == 17){
    	 		sylNum =5;
    	 		haikus += word + "\n";
    	 		word = " ";
    	 		lineSylNum = 0;
    		 	count++;
    	 		}
    	 	}
    	 		//clear haiku count
    	 	 	else if(lineSylNum > sylNum){
	    	 	clear();
	    	 	}
    	 		//System.out.println(sylNum);
    	 		//System.out.println(scan.hasNext());
    	 }
    	 System.out.println("Haikus:"+ "\n" + "\n" + haikus);
    	 System.out.println("Total Haikus: " + count);
    	 } 
    	 catch (FileNotFoundException e) {
    	 System.out.println("File Could Not Be Found. Check File Destination.");
    	 e.printStackTrace();
    	 }
    	scan.close();
    }
    
    /*
 	* NEEDS IMPROVEMENT
 	* counts syllables in a word just by counting the number of vowels
 	*/
    public static int countSyllables(String word) {
    	int syl = 0;
    	boolean vowel = false;
    	int length = word.length();

    	//check each word for vowels
    	for(int i=0; i<length; i++) {
    		if (isVowel(word.charAt(i)) && (vowel==false)) {
    			vowel = true;
    			syl++;
    		} else if (isVowel(word.charAt(i)) && (vowel==true)) {
    			vowel = true;
    		} else {
    			vowel = false;
    		}
    	}
    	char tempChar = word.charAt(word.length()-1);
    	//check for e at the end, as long as not a word with one syllable
    	if(((tempChar == 'e') || (tempChar == 'E')) && (syl != 1)) {
    		syl--;
    	}
    	return syl;
    }

    /*
 	* check if a char is a vowel including y
 	*/
    public static boolean isVowel(char c) {
    	if      ((c == 'a') || (c == 'A')) { 
    		return true;  
    		}
    	else if ((c == 'e') || (c == 'E')) { 
    		return true; 
    		}
    	else if ((c == 'i') || (c == 'I')) { 
    		return true; 
    		}
    	else if ((c == 'o') || (c == 'O')) {
    		return true; 
    		}
    	else if ((c == 'u') || (c == 'U')) { 
    		return true; 
    		}
    	else if ((c == 'y') || (c == 'Y')) { 
    		return true;  
    		}
    	else { 
    		return false; 
    		}
  	}
    
	/*
	 * Clears any contents left over in line and word variables
	 */
	public void clear(){
		lineSylNum = 0;
		word = " ";
	}
	
	/*
	 * Driver
	 */
	public static void main(String[] args) throws IOException {
		new HaikuDriver();	
	}
}