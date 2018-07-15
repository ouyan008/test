package com.jia.test;

import java.util.HashMap;
import java.util.Map;

public class TestStringHashcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "abc";
		String str2 = new String("abc");
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		Map map = new HashMap();
		map.put("abc", 1);
		map.put(new String("abc"), 2);
		
		System.out.println(map);
		
		
		
	}

}
