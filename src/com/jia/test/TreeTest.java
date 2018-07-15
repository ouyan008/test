package com.jia.test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeTest<E extends Comparable> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
//	System.out.println(reverse(-34285));
		
		
		HashMap<String, Integer> treeMap = new HashMap<>();
		treeMap.put("C" + " " + 10.5, 1 );
		treeMap.put("A" + " " + 10.8, 2 );
		treeMap.put("B" + " " + 10.7, 2 );
		treeMap.put("A" + " " + 10.6, 2 );
		System.out.println(treeMap);
		

		TreeMap<String, Integer> treeMapbyValue  = new TreeMap<>(new Comparator<String>  () {

			@Override
			public int compare(String o1, String o2) {
				
				if (treeMap.get(o1)-treeMap.get(o2) == 0) {
					return o1.compareTo(o2);
				} else {
				return treeMap.get(o1)-treeMap.get(o2);
				}
			}			
		}
					);		
		treeMapbyValue.putAll(treeMap);
		
		System.out.println(treeMapbyValue);
	}
	

	
	
class com implements Comparator<Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		
		return o1.getValue()-o2.getValue();
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int reverse(int x) {
		if ( x == 0) return 0;
		while (x % 10 == 0) {
			x = x /10;
		}		
		char[] arr = String.valueOf(x).toCharArray();
		int front = 0;
		int end = arr.length-1;
		if (arr[0] == '-') front = 1;
		while(front < end) {
			char tmp = arr[end];
			arr[end] = arr[front];
			arr[front] = tmp;
			front++;
			end--;
		}
		int value = Integer.parseInt(new String(arr));
		return (value > Math.pow(2,  31) -1) || (value < -Math.pow(2, 31)) ? 0: value;	
	}

	
}



class TreeNode <E extends Comparable> {
   private E value;
	TreeNode<E> left;
	TreeNode<E> right;
	
	public boolean find(TreeNode<E> root, E data ) {
		if (root == null) {
			return false;
		}
		if (data.compareTo(root.value) == 0 ) {
			return true;
		} else if (data.compareTo(root.value) <0 ) {
			return find(root.left, data);
		} else {
			return find(root.right, data);
		}
		
	
		
	}
	
}

