package com.jia.test;

import java.util.Random;

public class LinkedListTest {

	public static void main(String[] args) {
		Random random = new Random();
		// TODO Auto-generated method stub
//		MyList<Integer> list = new MyList<>();
//		SortedList<Integer> list = new SortedList<>();
//		SortedList2<Integer> list = new SortedList2<>();
		RecursiveLinkedList<Integer> list = new RecursiveLinkedList();
		for (int i = 0; i < 20; i++) {
			int data = random.nextInt(100);
	//		System.out.println("insert:  " + data);
			list.insert(data);
		}
      list.printList();
      System.out.println();
      list.printList2(list);
      System.out.println();
      list.printList3();
      
      for (int i = 0; i < 20; i++) {
    	  int data =   random.nextInt(100);
         // if (list.delete(data)) System.out.println("delete data: " + data + "-----");
           System.out.println("delete data: " + data + "-----" + list.delete(data)); 
      }
        list.printList();
//      System.out.println("finally:" + list);
//      
//        
//        list.delete(4);
//        System.out.println(list);
//        list.delete(0);
//        System.out.println(list);
//        list.delete(3);
//        System.out.println(list);
//        list.delete(1);
//        System.out.println(list);
//        list.delete(2);
//        System.out.println(list);
	}

}


class MyList<T> {
	
	protected  Node<T> head = null;

	protected int size = 0;

	public boolean delete (T data) {
		Node <T> preNode = null; 
		for (Node<T> current = head; current != null; current=current.getNext()) {
			
			if (current.getData() == data) {
				if (preNode == null) {
					head = current.getNext();
				} else {
					preNode.setNext(current.getNext());
				}
				size--;
				return true;
			}
			preNode = current;
		}		
		return false;
	}

	public Node<T> getHead() {
		return head;
	}

	public int getSize() {
		return size;
	}

	public void insert(T data) {
		Node <T> current = head;
		if (current == null) {
			head = new Node<T>(data);
			size++;
		} else {
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new Node<T>(data));	
			size++;
		}
		
	}

	public void insertAtHead(T data) {
		 Node<T> oldHead = head; 
		 head = new Node<T>(data);
		 head.setNext(oldHead);
		 size++;
	}
	
	
	public void setHead(Node<T> head) {
		this.head = head;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
	public String toString() {
		
		String str = "";
		Node<T> current = head; 
		while (current != null) {
			str = str + ", " + current.getData();
			System.out.println(current);
			current = current.getNext();
			
		}
		return str + "size:" + size;
	}
	
	
}


class Node <T>  {
	private T data;
	private Node<T> next;
	
	public Node (T data)  {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}

}


class Node2 <T> {
	
	private T data;

	private Node2<T> next;

	private Node2<T> previous;

	public Node2(T data) {
		this.data = data;
		next = null;
		previous = null;
	}

	public T getData() {
		return data;
	}

	public Node2<T> getNext() {
		return next;
	}

	public Node2<T> getPrevious() {
		return previous;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setNext(Node2<T> next) {
		this.next = next;
	}

	public void setPrevious(Node2<T> previous) {
		this.previous = previous;
	}
	
	
	
}



class SortedList<T extends Comparable> extends MyList<T> {

	public boolean delete (T data) {
		
		Node<T> previous = null;
		for (Node<T> current = head; current != null; current=current.getNext()) {
			if (current.getData().compareTo(data) > 0) break;
			if ((current.getData() == data) && (current == head)) {
				head = current.getNext();
				size--;
				return true;
			} else if (current.getData() == data) {
				previous.setNext(current.getNext());
				size--;
				return true;
			}
			previous = current;
		}
          return false;
}

	@Override
	public void insert(T data) {
		
		Node <T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;		
		}else {
			Node <T> current  = head;
			Node <T> previous = head;
			while((current != null)) {
				if ( current.getData().compareTo(data) > 0) {
					if (current == head) {
						head = newNode;
						head.setNext(current);
					} else {
						previous.setNext(newNode);
						newNode.setNext(current);
					}
					System.out.println(data);
					size++;
					return;
				}
				previous = current;
				current = current.getNext();
			}
			previous.setNext(newNode);
			
		}
		size++;
	
}

}

class SortedList2<T extends Comparable> extends MyList<T> {
	
	private Node2<T> head;
	
	@Override
	public void insert(T data) {
		System.out.println("insert  " + data );
		Node2<T> newNode = new Node2<T>(data);
		Node2<T> current;
		if (head == null) {
			head = newNode;
		} else {
			 int count = 0;
			for (current = head; current != null; current=current.getNext()) {
					if (current == head) {
						if ((current.getData().compareTo(data)) > 0) {
						newNode.setNext(head);
						head.setPrevious(newNode);
						head = newNode;
						System.out.println("xxx");
						break;
					} else if (current.getNext() == null) {
						System.out.println("zzz: " + current.getData());
						current.setNext(newNode);
						newNode.setPrevious(current);
					    break;
					} 
					} else {
						if ((current.getData().compareTo(data)) > 0) {
						current.getPrevious().setNext(newNode);
						newNode.setNext(current);
						newNode.setPrevious(current.getPrevious());
						current.setPrevious(newNode);
						break;
					} else if (current.getNext() == null) {
						System.out.println("www: " + current.getData());
						current.setNext(newNode);
						newNode.setPrevious(current);
					    break;	
					}
				} 
				}
			}						
		size++;
		
	}
	
	public boolean delete (T data) {
		
		for (Node2<T> current = head; current != null; current=current.getNext()){
			if (current.getData().compareTo(data) > 0) {
				return false;
			} else if (current.getData().compareTo(data) == 0) {
				current.getPrevious().setNext(current.getNext());
				current.getNext().setPrevious(current.getPrevious());
				size--;
				return true;
			}			
		}
		return false;
	}
@Override	
public String toString() {
		
		String str = "";
		Node2<T> current = head; 
		while (current != null) {
			str = str + ", " + current.getData();
			current = current.getNext();
		}
		return str + "size:" + size;
	}
}

class RecursiveLinkedList<T> {
	
	private T first;
	public void setFirst(T first) {
		this.first = first;
	}


	private int size;
	public T getFirst() {
		return first;
	}


	private RecursiveLinkedList<T> rest;
	
	public void setRest(RecursiveLinkedList<T> rest) {
		this.rest = rest;
	}

	public RecursiveLinkedList<T> getRest() {
		return rest;
	}

	public RecursiveLinkedList(T first, RecursiveLinkedList<T> rest) {
		this.first = first;
		this.rest = rest;
	}

	public RecursiveLinkedList() {
		this.first = null;
		this.rest = null;
	}

	
	public void insert (T data) {
		
		if (first == null) {			
			first = data;
		} else {		
			RecursiveLinkedList<T> tmp = new RecursiveLinkedList (first, rest);
			first = data;
			rest = tmp;		
		}
		size++;
	}
	
	
	public boolean delete (T data) {
		
		
			if (first == data) {
				if (rest != null) {
					first = rest.getFirst();
					System.out.println("first: " + first + "size: " +size);
					rest = rest.getRest();
				} else {
					first = null;
					rest = null;
				}
				size--;
				return true;
			} else if ( rest != null) {
				return rest.delete(data);	
			} else {
				return false;
			}		
	}
	
	public void printList() {
		
		System.out.print(first + ", ");
		RecursiveLinkedList<T> tmp = rest;
		while (tmp != null) {
			System.out.print(tmp.getFirst() + ", ");
			tmp = tmp.getRest();
		}
		System.out.print(" | " + "--" +  size + "---");
		
	}
       
public void printList2(RecursiveLinkedList<T> rest) {
	   
		if (rest != null) {
			System.out.print(rest.getFirst() + ", ");
			printList2(rest.getRest());
		}
		
	}

public void printList3() {
	   
	System.out.print(first + ", ");
	if (rest != null) {
	   rest.printList();
	   rest=rest.getRest();
	}
}
}
	
//	@Override	
//	public String toString() {
//			
//			String str = "";
//			T current = first; 
//			System.out.println("rest: " + rest);
//			while (rest != null) {
//				str = str + ", " + rest.getFirst();
//				rest = rest.getRest();
//			}
//			return current+ str + "size:" + size;
//		  
//		}
//	}
	

