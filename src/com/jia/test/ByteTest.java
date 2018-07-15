package com.jia.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ByteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] =  {3, 7, 5, 10, 2};
		int arr2[] =  {12, 6, 2, 1, 3};
	    sort(arr1);
	    sort(arr2);
     //   p(arr2);
        int [] res = test(arr1, arr2);
        p(res);
        
	}
	
	




	
	public static int [] test (int [] arr1, int [] arr2) {
		    int len = arr1.length + arr2.length;
		    int [] results = new int [len];
		    sort(arr1);
		    sort(arr2);
		    int i = 0;
		    int j = 0;
		    int k = 0;
		while ( i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				results[k] = arr1[i];
				i++;
			} else {
				results[k] = arr2[j];
				j++;
			}
			k++;
			
		}
		if (i < arr1.length) {
		for (int m = k; m < len; m++) {
			results[m] = arr1[i];
		} 
		}
		
		if ( j < arr2.length) {
		for (int m = k; m < len; m++)	{
			results[m] = arr2[j];
		}
		
		}
		
		return results;
	}
	
	public static void sort (int [] arr) {
		
		for (int i = 0; i < arr.length; i ++) {
			for (int j = i+1; j <arr.length; j++) {
				int tmp = arr[i];
				if (arr[i] > arr[j]) {
				    arr[i] = arr[j];
				    arr[j] = tmp;
				}
 			}
		}
		
	}
	
    public static void p (int[] arr) {
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i] + " ,");
    	}
    }
}
