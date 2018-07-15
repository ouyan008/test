package com.jia.testenum;

public class enumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             System.out.println(Grade2.values()[0].toString());
             System.out.println(Grade2.B);
	}

}



class Grade {
	
   public static final Grade A = new Grade() ; 	
   public static final Grade B = new Grade(); 	
   
   private Grade() {
	   
   }
	
   public Grade Grade (int grade) {
	   if ((grade >= 90 ) && (grade <= 100)) {
		   
		   return A;
	   } else {
		   return B;
	   }
   }
	
}



 enum Grade2 {
  
	  
	 A, B ;
	 
	
}
 
  class MySingleton {
	    private volatile static MySingleton instance = null; //volatile modifier is used
	 
	    // private constructor
	    private MySingleton() {
	    }
	 
	    public static MySingleton getInstance() {
	        if (instance == null) {
	            synchronized (MySingleton.class) {
	                // Double check
	                if (instance == null) {
	                    instance = new MySingleton();
	                }
	            }
	        }
	        return instance;
	    }
	} 

  
  class Node {
	  
	 private Node left;
	 private Node right;
	 
	 public Node getLeft() {
		 return left;
	 }
	 
	 public Node getRright() {
		 return right;
	 }
	 
  }
  
  
  class Tree {
	 
	  Node root;
	  
	  public int size(Node node) {
		  
	
		  if (node == null) {
			  return 0; 
		  } else {
			  return size(node.getLeft()) + size(node.getRright()) +1;
		  }
			 
		 
		  
		 
	  };
	  
  }
  
  
  
  