package interview.drills.arrays.occurrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeastOccurrence {
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,1,3,4,5,3,6,6,8));
		
		Map<Integer, Long> mapResult = intList
		.stream()
		//.map(Object::toString)
		.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(mapResult.getClass());
		System.out.println(mapResult);
		
		Optional<Long> minLongValue = mapResult.values().stream().min(Comparator.comparing(Function.identity()));
		
		System.out.println(
				mapResult
				.entrySet()
				.stream()
				.filter(index -> mapResult.get(index.getKey()) == minLongValue.get())
				.findFirst().get().getKey()
				);
	}
}
