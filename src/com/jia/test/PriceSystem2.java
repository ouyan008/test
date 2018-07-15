package com.jia.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PriceSystem2 {
	
	private Map<String, String[]> products = new HashMap<>(); 
	private Map<String, String[]> competetive = new HashMap<>(); 

    public PriceSystem2(String fileName) {
    	init(fileName);
    }
	public Map<String, String[]> getCompetetive () {
		return competetive;
	}
       
    public Map<String, String[]> getProduct() {
    	return products;
    }
    
	private void init(String fileName) {
		String line;
		try (BufferedReader bfr = new BufferedReader(new FileReader(fileName));) {
			
			while ((line = bfr.readLine()) != null) {
				String[] words = line.split(" ");
				if (words.length < 3)
					continue;
				if (words[2].equalsIgnoreCase("H") || words[2].equalsIgnoreCase("L")) {
					products.put(words[0], words);
				} else {
					String item = words[0];
					competetive.put(words[0] + " " + words[1], words);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static Map<String, Double> getAvgPrice(Map<String, String[]> original) {
		
		 return original.entrySet().stream().collect(Collectors.groupingBy(entry -> entry.getKey().split(" ")[0],
				Collectors.averagingDouble(entry -> Float.parseFloat(entry.getValue()[2]))));
		 
	}
	
	public Map<String, String[]> filter(Map<String, String[]> competetive2) {
		
		Map<String, Double> avePricebyProduct = PriceSystem2.getAvgPrice(competetive2);
		return competetive2.entrySet().stream().filter(entry -> {
			float price = Float.parseFloat(entry.getValue()[2]);
			String product = entry.getKey().split(" ")[0];
			return ((price > 0.5 * avePricebyProduct.get(product)) && (price < 1.5 * avePricebyProduct.get(product)));
		}).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
	}
	
//	public Map<String, Long> priceTreeMap(Map<String, String[]> competetive) {
//
//		Map<String, String[]> goodComp = filter(competetive);
//		Map<String, Long> maxbyProduct = getPricebyFrequency(goodComp);
//
//		return maxbyProduct.entrySet().stream().sorted(
//				 (o1,  o2) -> {
//					if (maxbyProduct.get(o1.getKey()) - maxbyProduct.get(o2.getKey()) == 0) {
//						return o1.getKey().compareTo(o2.getKey());
//					} else {
//						return  (int) (maxbyProduct.get(o2.getKey()) - maxbyProduct.get(o1.getKey()));
//					}
//				}
//				
//				
//				).peek(s -> System.out.println(s)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap:: new));
//		
//	}
	
	
//	public Set<Map.Entry> priceTreeMap(Map<String, String[]> competetive) {
		public List<Map.Entry> priceTreeMap(Map<String, String[]> competetive) {

		Map<String, String[]> goodComp = filter(competetive);
	//	Map<String, Long> maxbyProduct = getPricebyFrequency(goodComp);
	//	Map<String, Long> maxbyProduct = getPricebyFrequency(competetive);
		Map<String, Long> maxbyProduct = getPricebyFrequency(competetive);
		return maxbyProduct.entrySet().stream().sorted(
//				 (o1,  o2) -> {
//					if (o1.getValue() - o2.getValue() == 0) {
//						return o1.getKey().compareTo(o2.getKey());
//					} else {
//						return  (int) (o2.getValue() - o1.getValue());
//					}
//				}
				
				Comparator.comparing(Map.Entry<String, Long>::getValue).reversed().thenComparing(Map.Entry::getKey))
			//	).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap:: new));
				.peek(s -> System.out.println(s)).collect(Collectors.toList());
		
	}
	
	private static Map<String, Long> getPricebyFrequency(Map<String, String[]> comp) {
		
		return comp.entrySet().stream().collect(Collectors.groupingBy(entry -> {
			String product = entry.getKey().split(" ")[0];
			float price = Float.parseFloat(entry.getValue()[2]);
			return product + "_" + entry.getValue()[2];
		}, Collectors.counting()));

	}
	
	public void recommendPrice() {

		Map<String, String[]> validedCompInfo = filter(competetive);
//		Map<String, Long> orderedPriceMap = priceTreeMap(validedCompInfo);
//		Set<Map.Entry> orderedPriceMap = priceTreeMap(validedCompInfo);
		List<Map.Entry> orderedPriceMap = priceTreeMap(validedCompInfo);
		Map<String, Float> finalPriceMap = new HashMap<>();
		
		
//		for (Entry<String, Long> entry : orderedPriceMap.entrySet()) {
			for (Entry<String, Long> entry : orderedPriceMap) {
			String prod = entry.getKey().split("_")[0];
			Float price = Float.parseFloat(entry.getKey().split("_")[1]);
			if (!finalPriceMap.containsKey(prod)) {
				finalPriceMap.put(prod, price);
			}
		}

		for (Entry<String, Float> entry : finalPriceMap.entrySet()) {
			String product = entry.getKey();
			float price = entry.getValue();
			String supply = getProduct().get(product)[1];
			String demand = getProduct().get(product)[2];
			// System.out.println("product: " + product + " price " + price + "
			// supply " + supply + " demand " + demand);

			if (((supply.equals("H")) && (demand.equals("H"))))
				System.out.println(price);
			else if ((supply.equals("L")) && (demand.equals("L")))
				System.out.println(1.1 * price);
			else if ((supply.equals("L")) && (demand.equals("H")))
				System.out.println(1.05 * price);
			else if ((supply.equals("H")) && (demand.equals("L")))
				System.out.println(0.95 * price);
		}
	}
	
	public static void main(String[] args) {
		
		PriceSystem2 ps = new PriceSystem2("C:\\tmp\\testDate\\p2.txt");
		ps.recommendPrice();
		
	}

}
