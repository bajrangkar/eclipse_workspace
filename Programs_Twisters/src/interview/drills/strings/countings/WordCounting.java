package interview.drills.strings.countings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounting {
	public static void main(String[] args) {
		String str = "bull dog acts as bull not as dog";
		
		List<String> stringList = Arrays.asList(str.split(" "));
		System.out.println(stringList);
		Map<String, Long> mapResult = stringList.stream()
										.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(mapResult);
	}
}
