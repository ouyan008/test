package com.tcs.codetest;


public class Test {

	public static void main(String[] args) {
		
	    int[] arr1 = {87, 45, 34, 9,  5, 8, 67, 5, 3, 2, 7, 7, 9};
		int arr2[] =  {12, 6, 2, 1, 3};
        print(SortedTwoArray(arr1, arr2));	   
	}
	
	
	public static void print(int[] a) {
    	for (int i = 0; i < a.length; i ++) {
    		System.out.print(a[i] + " ,");
    	}
    	System.out.println("");
    }  
	
	public static int [] SortedTwoArray(int [] arr1, int [] arr2) {
		
		// sort arr1 and arr2		
		int [] tmp1 = new int[arr1.length];		
		int [] tmp2 = new int[arr2.length];
		mergeSort(arr1, tmp1, 0, arr1.length-1);
		mergeSort(arr2, tmp2, 0, arr2.length-1);
		
		//combine sorted arr1 and arr2 into arr
        int len = arr1.length + arr2.length;
		int [] tmp = new int[len];
		int [] arr = new int[len];
		
		for (int i = 0; i <arr1.length; i++ ) {
			arr[i] = arr1[i];
		}
		for (int i = 0; i <arr2.length; i++ ) {
			arr[arr1.length+i] = arr2[i];
		}
		
		//sort arr
		merge(arr, tmp, 0, arr1.length-1, arr1.length + arr2.length-1  );
		return arr;
	}
	
	
	
    private static void mergeSort (int [] a, int[] tmp, int left, int right) {
    	
    	if (left >= right ) return;
    	int med = (left+right)/2;
        mergeSort(a, tmp, left, med);    	
        mergeSort(a, tmp, med+1, right);  
        merge(a, tmp,  left, med, right);
    	
    }

   
	 
		 
	private static void merge(int[] a, int[] tmp, int left, int med, int right) {

		for (int i = left; i <= right; i++) {
			tmp[i] = a[i];
		}

		int i = left;
		int j = med + 1;
		int k = i;
		while ((i <= med) && (j <= right)) {
			if (tmp[i] <= tmp[j]) {
				a[k] = tmp[i];
				i++;
			} else {
				a[k] = tmp[j];
				j++;
			}
			k++;
		}
		while (i <= med) {
			a[k] = tmp[i];
			k++;
			i++;
		}
		while (j <= med) {
			a[k] = tmp[j];
			k++;
			j++;
		}

	}
}
