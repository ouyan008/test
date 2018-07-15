package com.jia.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;



public class Java8Test1 {

	public static void main(String[] args) {

		List<String> strs = Arrays.asList("aa", "bb", "cc", "aa", "cc",  "bb", "aa", "bbb", "aa");
		List<String> strs1 = Arrays.asList("aa", "bb", "cc");
		System.exit(0);
		
		ListIterator its = strs.listIterator(strs.size());
		System.out.println(strs.lastIndexOf("bb"));
		System.out.println(its.previous());
		int index = strs.size() -1;
		while (its.hasPrevious()) {
			if (its.previous() == "bb") {
				System.out.println("size: " + index );				
				break;
			} else {
				index--;
			}
		}
	
	//	IntSummaryStatistics hist1 = strs.stream().collect(Collectors.summarizingInt(s -> s.length()));
		System.out.println("*****");
	//	System.out.println(strs1.stream().collect(Collectors.toMap(s -> s, s -> s.length())) + "*****");
		
	//	System.out.println(hist1);
		
		Map <String, Long> hist = strs.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		
	    System.out.println(hist.entrySet().stream().filter(s -> s.getValue() > 1 ).map(s -> s.getKey()).collect(Collectors.toList()));
		
		List <Map.Entry<String, Long>> sortedHist1 = hist.entrySet().stream().sorted(( s1, s2 )-> s1.getValue().compareTo(s2.getValue())).collect(Collectors.toList());
		List <Map.Entry<String, Long>> sortedHist2 = hist.entrySet().stream().sorted(Comparator.comparing(s -> -s.getValue())).collect(Collectors.toList());
		List <Map.Entry<String, Long>> sortedHist3 = hist.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
		List <Map.Entry<String, Long>> sortedHist4 = hist.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

		System.out.println(sortedHist1);
		System.out.println(sortedHist2);
		System.out.println(sortedHist3);
		System.out.println(sortedHist4);
		
	// Old way
		
		Map<String, Integer> map = new HashMap<>();
		strs.forEach( s -> {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) +1);
			} else {
				map.put(s, 1);
			}
		});
		
		
		TreeMap sortedMap = new TreeMap( (s1, s2) -> {
			return map.get(s1).compareTo(map.get(s2));
		}); 
		
		sortedMap.putAll(map);
		
		System.out.println(map);
				
	}

}
