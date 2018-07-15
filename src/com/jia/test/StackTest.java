package com.jia.test;

import com.jia.test.LinkedListTest;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyStack<Integer> stack = new MyStack<Integer>();
		ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
		for (int i = 0; i < 6; i++) {
			stack.push(i);
		}
		System.out.println(stack);
        for (int i = 0; i < 6; i++) {
        	System.out.println(stack);
        System.out.println(stack.peek());
        	System.out.println(stack);
        	stack.pop();
        }
		
	}

}


class MyStack <T> {

	Node<T> head;
	
	
	void push(T data) {
		
		if (data != null) {
			    Node <T> oldhead = head;
			    head  = new Node<T>(data);
		//	    System.out.print("T: " + data );
			    head.setNext(oldhead);
			}
		}
	
	
	T pop () {
		
		if (head == null) {
			throw new RuntimeException("Empty Stack");
		}
		
			Node<T> oldHead = head;
			head = head.getNext();
			return oldHead.getData();
		
	
	}
	
	T peek() {
		if (head == null) throw new RuntimeException("Empty Stack");
		return head.getData();
	}
	
	
	public String toString() {
		
		String str = "";
		Node<T> current = head; 
		while (current != null) {
			str = current.getData() + "|" +str;
			current = current.getNext();
			
		}
		return str;
	}
	
}


class ArrayStack <T> {
	
	private  Node[] array;
	private int index;
	
	public ArrayStack (int size) {
		array = new Node[size];
		index = -1;
	}
	
	boolean push(T data) {
		if (index < array.length-1) {
	//		index++;
		    array[++index] = new Node<T>(data);
//		    System.out.println("T: " + data );
		    return true;
		} else {
		    return false;
		}
	}
	
	T pop () {
		if (index < 0) throw new RuntimeException("Empty Stack");
		T data = (T) array[index--].getData();
//		index--;
		return data;
		
	}
	
	T peek() {
		if (index < 0) throw new RuntimeException("Empty Stack");
		return (T) array[index].getData();
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i <= index; i++) {
			str = str + "|" + array[i].getData();
		}
		return str;
	}
	
}


