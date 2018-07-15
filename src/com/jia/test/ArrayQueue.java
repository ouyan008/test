package com.jia.test;

import com.jia.test.StackTest;


public class ArrayQueue<T> {
	
	
	private Node [] array;
	private int front, back;
	private int item;
	public ArrayQueue(int size) {
		array = new Node[size];
		back = -1;
		front = 0;
		item = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue queue = new ArrayQueue(8);
		for (int i = 0; i < 4; i++) {
			queue.enqueue(i);
			System.out.println(queue);
		}
		for (int i = 0; i < 12; i++) {
			System.out.println("dequeue ....");
			
			System.out.println(queue.dequeue());
			System.out.println(queue);	
			System.out.println("enequeue .... " + (i+4));
			queue.enqueue(i+4);
			System.out.println(queue);	
			
		}
//		
		System.out.println("peek:" + queue.peek());
//		System.out.println(queue.getTail());

	}
		
		

	

	public boolean enqueue(T data) {
	
		if (item < array.length) { 
		    back = (back+1)%array.length;
		    array[back] = new Node<T>(data);
		    item++;
		    System.out.println("Item:" + item);
		    return true;
		} else {
			return false;
		}
	}
	
	public T dequeue() {
		
		if (item == 0) {
			throw new RuntimeException("Empty Queue"); 
		}
		Node <T> delete =  array[front];
		front = (front + 1)%array.length;
		item--;
		return delete.getData() ;
	}
	
	public T peek() {  
        if (item == 0) return null;		
		return (T) array[front].getData();
	}
	
	public String  toString() {
		String str = "";
		if ( item == 0) {
			return "";
		} else {
		for (int i = front; i <=back; i++) {
			str = str + array[i].getData();
		}
		return "===" + str + "===";
	}
	
	
}
	
}
