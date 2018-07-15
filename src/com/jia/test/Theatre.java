/**
 * 
 */
package com.jia.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author ouyan
 *
 */
public class Theatre {
	
	private int totTicket;
	private String request;
	private List<List<Integer>> tickets = new ArrayList<>() ;

	public List<List<Integer>> getTickets () {
		return tickets;
	}
	
	public int getTotTicket() {
		return totTicket;
	}
	public Theatre(String request) {
		this.request = request;
		initial();
	}
	
	private void initial()  {
		String line = null;
		BufferedReader bfr = null; 
		try {
			bfr = new BufferedReader(new FileReader(request));
			
			while((line = bfr.readLine()) != null) {
			String[] strings = line.split(" ");
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < strings.length; i++ ) {
				list.add(new Integer(strings[i]));
				totTicket++;
			}
			tickets.add(list);
		} 
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			System.exit(1);
		}
				
	}
	
	public void sell(Map<String,Integer> request) {
		for (Entry<String,Integer> customer: request.entrySet()) {
			boolean gotTicket = false;
		//	System.out.println("serving..." + customer.getKey());
			if (customer.getValue() > totTicket) {
				System.out.println("Wilson Sorry, we can't handle your party");
				break;
			} 
			for (int i = 0; i < tickets.size() && !gotTicket; i++) {
				for(int j = 0; j <tickets.get(i).size(); j++) {
					if (customer.getValue().compareTo((Integer) tickets.get(i).get(j)) <= 0 )     {
						System.out.println(customer.getKey() + " Row " + (i+1) + " Section " + (j+1) );
						tickets.get(i).set(j, tickets.get(i).get(j)-customer.getValue());
						gotTicket = true;
						break;
					}
				}
			}
			if (!gotTicket) {
				System.out.println(customer.getKey() + " Call to split party");
			}
		}
		
	}

	public static void main(String[] args) {
         Theatre theatre = new Theatre("C:/Users/ouyan/Desktop/xxx.txt");
         List<List<Integer>> tickets = theatre.getTickets();
//         System.out.println(theatre.getTotTicket());
//         for (int i = 0; i <tickets.size(); i++) {
//        	 for (int j = 0; j <tickets.get(i).size(); j++) {
//        		 System.out.print("  ("+ tickets.get(i).get(j) + ")  ");
//        	 }
//        	 System.out.println();
//         }
         Map<String, Integer> map = getRequest("C:/Users/ouyan/Desktop/y.txt");
//         for (Entry<String, Integer> set : map.entrySet()) {
//        	 System.out.println(set.getKey() + " " + set.getValue());
//         }
         
         theatre.sell(map);
         
	}

	
	public static Map<String, Integer> getRequest(String request) {
		Map<String, Integer> custRequest = new HashMap<>();
		String line = null;
		try {
			BufferedReader bfd = new BufferedReader(new FileReader(request));
				while((line = bfd.readLine()) != null) {
				String[] strings = line.split(" ");	
				System.out.println("add: " + strings[0] + "  " + strings[1]);
				custRequest.put(strings[0], new Integer(strings[1]));
				}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return custRequest;
	}
	
}
