package com.jia.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class PriceSystem {
	
	private Map<String, String[]> products = new HashMap<>(); 
	private Map<String, String[]> competetive = new HashMap<>(); 

    public PriceSystem(String fileName) {
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
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(fileName));
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

	public static Map<String, Float> getAvgPrice(Map<String, String[]> original) {

		Map<String, Float> avePricebyProduct = new HashMap<>();
		Map<String, Integer> totCompbyProduct = new HashMap<>();
		Map<String, Float> totPricebyProduct = new HashMap<>();
		
		for (Entry<String, String[]> entry : original.entrySet()) {
			String product = entry.getKey().split(" ")[0];
			if (totCompbyProduct.containsKey(product)) {
				totCompbyProduct.put(product, totCompbyProduct.get(product) + 1);
			} else {
				totCompbyProduct.put(product, 1);
			}
			if (totPricebyProduct.containsKey(product)) {
				totPricebyProduct.put(product, totPricebyProduct.get(product) + Float.parseFloat(entry.getValue()[2]));
			} else {
				totPricebyProduct.put(product, Float.parseFloat(entry.getValue()[2]));
			}
		}
		for (String product : totCompbyProduct.keySet()) {
			// System.out.println( totPricebyProduct.get(product) + " " +
			// totCompbyProduct.get(product));
			avePricebyProduct.put(product, totPricebyProduct.get(product) / totCompbyProduct.get(product));
		}

		return avePricebyProduct;
	}
	
	public Map<String, String[]> filter(Map<String, String[]> competetive2) {
		
		Map<String, String[]> filteredComp = new HashMap<String, String[]>();
		Map<String, Float> avePricebyProduct = PriceSystem.getAvgPrice(competetive2);
		
		for (Entry<String, String[]> entry : competetive2.entrySet()) {
			float price = Float.parseFloat(entry.getValue()[2]);
			String product = entry.getKey().split(" ")[0];
			if ((price > 0.5 * avePricebyProduct.get(product)) && (price < 1.5 * avePricebyProduct.get(product))) {
				filteredComp.put(entry.getKey(), entry.getValue());
			}
		}
		return filteredComp;
	}
	
	public TreeMap<String, Integer> priceTreeMap(Map<String, String[]> competetive) {

		Map<String, String[]> goodComp = filter(competetive);
		Map<String, Integer> maxbyProduct = getPricebyFrequency(goodComp);
		Map<String, Integer> priceProduct = new HashMap<>();

		TreeMap<String, Integer> lowPricebyProduct = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (maxbyProduct.get(o1) - maxbyProduct.get(o2) == 0) {
					return o1.compareTo(o2);
				} else {
					return maxbyProduct.get(o2) - maxbyProduct.get(o1);
				}
			}
		});
		
		lowPricebyProduct.putAll(maxbyProduct);		
		return lowPricebyProduct;
	}
	
	private static Map<String, Integer> getPricebyFrequency(Map<String, String[]> comp) {
		
		Map<String, Integer> numberOfPricebyProduct = new HashMap<>();

		for (Entry<String, String[]> entry : comp.entrySet()) {
			String product = entry.getKey().split(" ")[0];
			float price = Float.parseFloat(entry.getValue()[2]);
			String compositeKey = product + "_" + entry.getValue()[2];
			if (numberOfPricebyProduct.containsKey(compositeKey)) {
				numberOfPricebyProduct.put(compositeKey, numberOfPricebyProduct.get(compositeKey) + 1);
				// System.out.println("+++" + compositeKey);
			} else {
				numberOfPricebyProduct.put(compositeKey, 1);
			}
		}
		return numberOfPricebyProduct;
	}
	
	public void recommendPrice() {

		Map<String, String[]> validedCompInfo = filter(competetive);
		TreeMap<String, Integer> orderedPriceMap = priceTreeMap(validedCompInfo);
		Map<String, Float> finalPriceMap = new HashMap<>();

		for (Entry<String, Integer> entry : orderedPriceMap.entrySet()) {
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
		
		PriceSystem ps = new PriceSystem("C:\\tmp\\testDate\\p2.txt");
		ps.recommendPrice();
		
	}

}
