package com.jia.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFunctInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> stooges = Arrays.asList("Larry", "Moe", "Curly", "Larry", "Moe", "Curly", "Jia", "Jia", "Curly", "Larry");
		
		Map<Object, Long> map = stooges.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		List<Entry<Object, Long>> sortMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
		System.out.print(sortMap);

	}
	

}



@FunctionalInterface
interface Summable {

	public int sum (int input1, int input2 ); 
	
}