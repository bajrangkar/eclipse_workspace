package oreilly.lambdas;

import java.util.ArrayList;
import java.util.List;

public class StreamExample001 {
	
	public static void main(String[] args) {

		List<String> stringList = new ArrayList<>();
		
		stringList.add("Ram");
		stringList.add("Sandeep");
		stringList.add("Umesh");
		stringList.add("Sagar");
		stringList.add("Mahendar");
		stringList.add("Sampath");
		stringList.add("Bajrang");
		stringList.add("Vivek");
		stringList.add("Subba");
		stringList.add("Samba");
		stringList.add("Aman");
		stringList.add("Ashwini");
		stringList.add("Rajashree");
		stringList.add("Venu");
		
		Long count = stringList.stream().filter(s->s.length()>5).count();
		System.out.println("Number of people having more than 5 letters in their name :: " + count);
		
	}

}

// filter(Predicate
// map(Function

// Function - takes 1 argument and produces a result
// Consumer - takes 1 parameter and not returns any result
// Predicate - returns boolean true/false 
