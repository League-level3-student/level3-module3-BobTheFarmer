package _00_Intro_To_String_Methods;

import java.util.ArrayList;
import java.util.Base64;



/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    		if(s1.length() > s2.length()) {
    			return s1;
    		} else if(s1.length() < s2.length()) {
    			return s2;
    		}
        return "equal";
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    		if(s.contains("underscores")) {
    			s = s.replace(' ', '_');
    		}
        return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    		ArrayList<String> names = new ArrayList<String>();
    		ArrayList<Character> lastNames = new ArrayList<Character>();
    		names.add(s1);
    		names.add(s2);
    		names.add(s3);
    		
    		int indexOfCurrentBest = 0;
    		for (int i = 0; i < 3; i++) {
    			names.set(i, names.get(i).trim());
    			lastNames.add(names.get(i).charAt(names.get(i).length()-1));
    			
    			if(lastNames.get(i).compareTo((lastNames.get(indexOfCurrentBest))) < 0) {
    				indexOfCurrentBest = i;
    				
    			}
		}
    		
    		return names.get(indexOfCurrentBest);
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	int sum = 0;
    		for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(Character.isDigit(c)) {
					sum+=Integer.parseInt(String.valueOf(c));
				}
			}
        return sum;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	int numberOfSubstrings = 0;
    		while(s.contains(substring)) {
    			s = s.substring(s.indexOf(substring)+substring.length());
    			numberOfSubstrings++;
    		}
    		
        return numberOfSubstrings;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    		return(Utilities.encrypt(s.getBytes(), (byte)key));
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    		return(Utilities.decrypt(s, (byte)key));
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    		int numberOfWordsEndWithSubstring = 0;
    		ArrayList<Integer> locationOfSpaces = new ArrayList<Integer>();
    		//ArrayList<Integer> locationOfSubstrings = new ArrayList<Integer>();
    		int sCompleted = 0;
    		String previousSSubstring = "suoidfoijsapokdopwqposk"; 
    		
    		//Save every spaces location
    			String sCopy = s;
    			while(sCopy.contains(" ")) {
    				sCopy = sCopy.substring(sCopy.indexOf(" ")+1);
    				locationOfSpaces.add(s.indexOf(sCopy));
    			}
    		//System.out.println(locationOfSpaces);
    			
    		//Save location of every substring
    		/*	String sCopy2 = s;
			while(sCopy2.contains(substring)) {
				sCopy2 = sCopy2.substring(sCopy.indexOf(substring)+substring.length());
				locationOfSubstrings.add(s.indexOf(sCopy));
			}
		System.out.println(locationOfSubstrings);
    		*/
    		
    		//Find every substring, check for an space before using locationOfSpaces
    			while(s.contains(substring)) {
    				sCompleted = s.indexOf(substring)+substring.length();
    				String sSubstring = s.substring(sCompleted);
        			if(s.charAt(s.indexOf(sSubstring)) == ' ') {
        				numberOfWordsEndWithSubstring++;
        			}
        			System.out.println("sSubstring: " + sSubstring + ", previous: " + previousSSubstring);
        			if(sSubstring.equals(previousSSubstring)) {
        				break;
        			}
        			previousSSubstring = sSubstring;
        		}
    			
        return numberOfWordsEndWithSubstring;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
        return 0;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    		//for
        return true;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
