package interview.drills.strings.repeatedCharacter;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
 
public class FirstRepeatedCharacter {
 
  public static void main(String[] args) {
 
    System.out.println("  Please  enter  the  input  string  :");
    Scanner in = new Scanner(System.in);    // read from System input
    String input = in.nextLine();
    Character firstNonRepeatedChar = firstNonRepeatedCharLogic(input);
    System.out.println("The  first  non repeated  character  is  :    " + firstNonRepeatedChar);
    Character firstRepeatedChar = firstRepeatedCharLogic(input);
    System.out.println("The  first  repeated  character  is  :    " + firstRepeatedChar);
    in.close();
  }
	 
  private static Character firstNonRepeatedCharLogic(String input) {  
    Character result =  input.chars()           // IntStream
     .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))  // convert to lowercase & then to Character object Stream
     .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
     .entrySet().stream()                       // EntrySet stream
     .filter(entry -> entry.getValue() == 1L)   // extracts characters with a count of 1
     .map(entry -> entry.getKey())              // get the keys of EntrySet
     .findFirst().get();                        // get the first entry from the keys
    
     return result;    
  }
  
  private static Character firstRepeatedCharLogic(String input) {  
	    Character result =  input.chars()           // IntStream
	     .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))  // convert to lowercase & then to Character object Stream
	     .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
	     .entrySet().stream()                       // EntrySet stream
	     .filter(entry -> entry.getValue() > 1L)   // extracts characters with a count of 1
	     .map(entry -> entry.getKey())              // get the keys of EntrySet
	     .findFirst().get();                        // get the first entry from the keys
	    
	     return result;    
	  }
}
