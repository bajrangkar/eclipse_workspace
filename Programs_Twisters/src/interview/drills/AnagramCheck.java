package interview.drills;

import java.util.Arrays;

public class AnagramCheck {
	public static void main(String[] args) {
		String str1 = "race";
		String str2 = "care";
		
		boolean anagram = isAnagramSort(str1, str2);
		System.out.println(anagram);
		
	}
	public static boolean isAnagramSort(String string1, String string2) {
	    if (string1.length() != string2.length()) {
	        return false;
	    }
	    char[] a1 = string1.toCharArray();
	    char[] a2 = string2.toCharArray();
	    Arrays.sort(a1);
	    Arrays.sort(a2);
	    return Arrays.equals(a1, a2);
	}
}
