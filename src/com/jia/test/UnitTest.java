package com.jia.test;

import java.util.Random;

public class UnitTest {
	
	public static void main (String [] args ) {
		
		String str = MyString.generateStr(9);
		System.out.println(str);
		System.out.println(reverseString(str));
		System.out.println(reverseString2(str));
	//tring str = "abababb";
		System.out.println(count(str, 'a'));
		
		
		
	}
	
	
	
	public static int count(String s, char a) {
			
		if (s.length() < 1) {
			
		  return  0;
		} else {
		String sub = s.substring(1);
		if (s.charAt(0) == 'a') {
			return 1+ count(sub, 'a');
		} else {
			return count(sub, 'a');
			
		}
		}
	}
	
    public static String reverseString2 (String str) {
    	
    	char [] arr = str.toCharArray();
    	reverseStr(arr, 0, arr.length-1);
    	return new String(arr);
    }
	
	public static void reverseStr(char [] arr, int start, int end) {
		
		if(end >start) {
			
		
        char tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
       // start++;
       // end--;
		reverseStr(arr, ++start, --end);
		System.out.println(new String("start: " + start + "end: " + end));
		}
	}
	
	
	
	
	public static String reverseString(String str) {
		char [] arr = str.toCharArray();
		int len = arr.length;
		int first = 0;
		int last = len - 1;
		while (first < last) {
			char tmp = arr[first];
			arr[first] = arr[last];
			arr[last] = tmp;
			first++;
			last--;
		}
		
		
		return new String(arr);
	}
	
	
}



class MyString {
	
	private static final String str = "abcdefghijklmnopqrstuwxyz";
	
	public static String generateStr (int n) {
		
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < n; i++ ) {
			sb.append(str.charAt(random.nextInt(26)));
		}
		
		return sb.toString();
	}
	
	
	
	
}