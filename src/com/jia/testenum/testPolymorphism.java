package com.jia.testenum;

public class testPolymorphism {
	
	

	  public static void main (String[] args) 
	  {
	    Person p = new Person("Clarissa");
	    System.out.println(p);
	    
	    Person s = new Student("Jose",12345);
	    System.out.println(s);
	    
	  }
	
	

}


 class Person 
{
  private String name;

  public Person(String n) 
  {
    this.name = n;
  }

  public String toString() 
  {
    return name;
  }
}
 
 class Student extends Person
 {
   private int id;

   public Student(String n, int id) 
   {
     super(n);
     this.id = id;
   }

   public String toString() 
   {
     return super.toString()+", "+id;
   }
 }