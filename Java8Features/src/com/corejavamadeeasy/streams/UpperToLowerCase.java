package com.corejavamadeeasy.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UpperToLowerCase {
	
	public static void main(String[] args) {
		
		List<String> l1 = new ArrayList<>();
		l1.add("JOHN");
		l1.add("BHARATH");
		l1.add("JIM");
		
		List<String> l2 = l1.stream().map(s->s.toLowerCase()).collect(Collectors.toList());
		
		System.out.println(l2);
		
		List<String> str = new ArrayList<>();
        str.add("ABC");
        str.add("DEF");
        str.add("GHI");
        str.add("JKL");
        str.add("MNOP");
        Predicate<String> p = s->s.length()>=4;
        Function<String, Integer> f = s->s.length();
        Consumer<String> c = s-> System.out.println("Length of string "+s+" is "+f.apply(s));
        
        List<Integer> sizes = str.stream().filter(p).peek(c).map(f).collect(Collectors.toList());
        System.out.println(sizes);
	        
	    
		
	}

}
