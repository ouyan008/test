package com.jia.test;

import java.util.concurrent.CopyOnWriteArrayList;

public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int[] a = {87, 45, 34, 9,  5, 8, 67, 5, 3, 2, 7, 7, 9};
           int [] tmp = new int[a.length];
		   //bubble(a);
           //select(a);
         //  bsort(a);
		 //  print(a);
		  // System.out.println(find(34, a));
     //      print(a);
    //       mergeSort(a, tmp, 0, 10);	
           print(a);
        //   quickSort(a, 0, a.length-1);
           split(a, 0, a.length-1);
           print(a);
	}

	
	public static void split(int [] a, int head, int tail) {
		
		if ((tail - head) == 0) {
	//		System.out.println("tail: " + tail + "head:" + head);
			p(a, head, tail);
			return;
		}
		int midIndex = (head + tail)/2;
		p(a, head, tail);
		split(a, head, midIndex);
		split(a, midIndex+1, tail);
		System.out.println("combine ---" + "head= " + head + " midIndex= " + midIndex + " tail= " + tail);
		mg(a, head, midIndex, tail);
		p(a, head, tail);
	}
	
	public static void mg (int [] a, int head, int midIndex, int tail) {
		int [] tmp = new int [tail-head+1];
		int i = 0;
		int leftIndex = head;
		int rightIndex = midIndex+1;
		while ((leftIndex <= midIndex) && (rightIndex <= tail)) {
		if (a[leftIndex] < a[rightIndex]) {
			tmp[i] = a[leftIndex];
			leftIndex++;
		} else {
			tmp[i] = a[rightIndex];
			rightIndex++;
		}
		i++;
		}
		System.out.println("leftIndex = " + leftIndex + "rightIndex = " + rightIndex);
	    if (leftIndex > midIndex) {
	    	while (rightIndex <= tail) {
			 tmp[i] = a[rightIndex];
			 i++;
			 rightIndex++;
		}
	    } else {
	    	while (leftIndex <= midIndex) {
	    		tmp[i] = a[leftIndex];
	    		i++;
	    		leftIndex++;
	    	}
	    }
	    print(tmp);
	    for (int k = head; k <= tail; k++) {
	    	a[k] = tmp[k-head];
	    	System.out.println("K =" +  k + "tmp" + tmp[k-head] + "tail =" + tail);
	    }
	    print(a);
	}
	
	public static int find(int v, int [] a) {
		
		int start = 0;
		int end = a.length-1;
		
		while(start <= end) {
		if (v > a[(start+end)/2]) {
			start = (start + end)/2 + 1;
			System.out.println("start:" + start );
		} else if ( v <a[(start+end)/2]) {
			end = (start+end)/2;
			System.out.println("end" + end);
		} else {
			
			return (start+end)/2;
		}
		
		}
		return -1;
	}
	
	
	
	public static void bubble (int [] a) {
		
		int len = a.length;
		for (int i = 0; i < len -1; i++) {
			for (int j = 0; j < len-i-1; j++) {
				if (a[j+1] < a[j]) {
				swap(j+1, j, a);
//					int tmp = a[j];
//					a[j] = a[j+1];
//					a[j+1] = tmp;
				}
			}
		
		}
		
		
	}
	
	
	public static void select (int[] a) {
		
		for (int i = 1; i < a.length; i++) {
		    int k = i;
			while (k > 0) {
				if (a[k] < a[k-1]) {
					swap(k, k-1, a); 
				} else {
					break;
				}
				k--;
			}
			
		}
		
		
		
	}
	
	
	public static void bsort(int[] a) {
		
		int length = a.length;
		for (int i = 0; i < length-1; i++) {
			for(int j = 0; j <length-i-1; j++) {
				if (a[j] > a[j+1]) {
					swap(j, j+1, a);
				}
			}
		}
		
		
	}
	
	
	public static void swap(int i, int j, int [] a) {
		
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		
	}
		
    public static void print(int[] a) {
    	for (int i = 0; i < a.length; i ++) {
    		System.out.print(a[i] + " ,");
    	}
    	System.out.println("");
    }
	
    
    public static void p (int[] a, int s, int d) {
    	for (int i = s; i <= d; i++) System.out.print(" | " + a[i] );
    	System.out.println("");
    }
    public static void pp (int[] a, int s, int d) {
    	for (int i = s; i <= d; i++) System.out.print(" || " + a[i] );
    	System.out.println("");
    }
    
    
    public static  void quickSort(int [] a, int head, int tail) {
    	
    	System.out.println("tail: " + tail + "head: " + head);
    	if ((tail - head)  < 2 ) {
    		return; 
    	}
    	int [] b = new int[tail-head+1];
    	int pivot = a[tail];
        int headIndex = head;
        int tailIndex = tail;
        int pivotIndex = 0;
    	System.out.println("pivot: " + pivot);
    	
    	for (int i = head; i <= tail; i++) {
    		if (a[i] > pivot) {
    			b[tailIndex-head] = a[i]; 
    			System.out.println(b[tailIndex-head] + "^^" + (tailIndex-head));
    			tailIndex--;
    		} else if (a[i] <= pivot){
    			b[headIndex-head]=a[i];
    			System.out.println(b[headIndex-head] + "%" + (headIndex-head));
    			headIndex++;
    		}
            if (headIndex == tailIndex) pivotIndex = headIndex;
    	}    	
    	System.out.println("headIndex:" + headIndex);
    	System.out.println("tailIndex:" + tailIndex);
    	System.out.println("pivotIndex:" + pivotIndex);
    	print(b);
    	for (int i = head; i <= tail; i++) {
    		a[i] = b[i-head];
    		System.out.println("**");
    	}
    	print(a);
    //	System.exit(1);
        quickSort(a, 0, pivotIndex-1 );
    	quickSort(a, pivotIndex+1, tail);
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void mergeSort (int [] a, int[] tmp, int left, int right) {
    	
    	if (left >= right ) return;
    	int med = (left+right)/2;
    //	 p(a, left, med);
    // 	p(a, med+1, right);
        mergeSort(a, tmp, left, med);    	
        mergeSort(a, tmp, med+1, right);  
   //     System.out.println("--");
        merge(a, tmp,  left, med, right);
    	
    }
	
    private static void  merge(int[] a, int [] tmp, int left, int med, int right) {
    	
    	for (int i = left; i <= right; i++){
    		tmp[i]=a[i];
    	}
    	
    	int i = left;
    	int j = med+1;
    	int k = i;
    	while((i <= med) && (j <= right)) {
    		if (tmp[i] <= tmp[j]) {
    			a[k]=tmp[i];
    			i++;
    		} else {
    			a[k]=tmp[j];
    			j++;
    		}
    		k++;
    	}
    	while (i <=med) {
    		a[k] = tmp[i];
    		k++;
    		i++;
    	}
    	while (j <=med) {
    		a[k] = tmp[j];
    		k++;
    		j++;
    	}
    	
    	
    }
	
}


