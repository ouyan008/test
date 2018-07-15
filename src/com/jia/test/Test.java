package com.jia.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;







class Emp {
	   
	private float comm;
	private Date  date;
	private String dept;
	private String email;
	private String firstName;
	private int Id;
	private String job;
	private String lastName;
	private String manager;
	private String number;
	private int salary;

	public Emp(int id, String firstName, String lastName, String email, String number, Date date, String job,
			int salary, float comm, String manager, String dept) {

		this.Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.number = number;
		this.date = date;
		this.job = job;
		this.salary = salary;
		this.comm = comm;
		this.manager = manager;
		this.dept = dept;
	}

	public float getComm() {
		return comm;
	}

	public Date getDate() {
		return date;
	}

	public String getDept() {
		return dept;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return Id;
	}

	public String getJob() {
		return job;
	}

	public String getLastName() {
		return lastName;
	}

	public String getManager() {
		return manager;
	}

	public String getNumber() {
		return number;
	}

	public int getSalary() {
		return salary;
	}

	public void setComm(float comm) {
		this.comm = comm;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(int id) {
		Id = id;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	   
	   @Override
	public String toString() {
		   return Id + " " + firstName + " " + lastName + " " + email + " " + number + " " + date + " " + job + "  "+  salary + " " + comm + " "  + manager + " " + dept + "\n"; 
	   }
	   
//	   @Override
//	   public boolean equals(Object o) {
//		   
//		   if ( this == o) return true;
//		   if (o instanceof Emp) {
//			   Emp e = (Emp) o;
//			   return this.getDept() == e.getDept();
//		   } 
//		   
//		   return false;
//		   
//	   }
	   
	   
	   
   }
   
   
   
   public class Test
{
    static void doPermute( char[] in, StringBuffer out,
                    boolean[] used, int length, int level ){
    	
    	if (level == 4) {
    		System.out.println(out.toString());
    		System.out.println("");
    		return ;
    	}
    	
    	for (int i = 0; i < length; i++) {
    		if (used[i]) continue;
    		
    			out.append(in[i]); 
    			print(used);
    			used[i] = true;
    		//	level++;
    			System.out.println(in[i] + "**level:" + level);
    			System.out.println(out);
    			doPermute(in, out, used, length, level+1);
    			used[i] = false;
    			out.setLength(out.length()-1);
    			
    		
    	}
               
            
    					  

    }
    
    
public static int fib (int n) {
	
	if ((n == 1) || (n ==2)) 
		return 1; 
	else {
		return fib(n-1) + fib(n-2);
	}
	
}


public static void findMostFreqChar (String str) {
	
	char [] arr = str.toCharArray();
	int max = 0;
	char maxC = arr[0];
	char c;
	for (int i = 0; i < arr.length; i++) {
		int tmp = 0;
		c = arr[i];
		for (int j = i; j < arr.length; j++) {
			if ( c == arr[j]) tmp++;
		}
		if (max < tmp) {
			max = tmp;
			maxC = c;
		}
	}
	System.out.println("most repeat char: " + maxC + " " + max + " times");
}
    
    
    
    
    
    private static Collector groupingBy(Object object) {
			// TODO Auto-generated method stub
			return null;
		}
    
    
    
   
    
    /**
     * @param args
     */
    public static void main(String[] args){
   
    //    permute("abcd");
           
   // 	findMostFreqChar("abbcfffd");

//    	printOpenDoor( 5);
    	
    	
  //  	List <Emp> emps = new ArrayList<>();
//    	emps.sort(Comparator.comparing(Emp::getFirstName).thenComparing(emp -> emp.getSalary()));	
    	 			
    String testStr = "aaabbbeegghggg";

    LinkedHashMap<Character, Integer> lhm  = new LinkedHashMap<>();
    char x = 'A';
    
    
//    testStr.chars().map(s -> Character.valueOf((char) s)).collect((Supplier<R>) Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
   // testStr.chars().map(s -> Character.valueOf((char) s)).collect( Collectors.groupingBy(Function.identity())).stream().foreach(s -> System.out.print(s));
      List<Emp> emps = new ArrayList<>();
      Path path = Paths.get("C:/Users/ouyan/Desktop/xx.txt");
      Stream<String> lineStreamsx;
      
      try (Stream<String> lineStreams = Files.lines(path);){
    	  
//       Map<String, Long> lineMap =	  lineStreams.filter(line -> !line.matches("(.*)--+(.*)")).filter(line -> ! line.matches("^\\s*$")).filter(s -> {
//    		  //String [] words = s.split("\\s+");
//    		  //return words[11].equals("100");
//    	      return true;
//    	  }).collect(Collectors.groupingBy(s -> { 
//    		  String [] words = s.split("\\s+");
//    		  return words[11];
//    	  }, Collectors.counting()
//    	  ));
    
//    	  
//        Map<String, TreeSet> lineMap =	  lineStreams.filter(line -> !line.matches("(.*)--+(.*)")).filter(line -> ! line.matches("^\\s*$")).collect(Collectors.groupingBy(s -> { 
//		  String [] words = s.split("\\s+");
//		  return words[11];
//	  }, Collectors.mapping(s -> {
//		  String [] words = s.split("\\s+");
//		  return words[1];
//		  }, Collectors.toCollection(() -> new TreeSet() ))));   
//        
//        System.out.println(lineMap);
    	  
//    DoubleSummaryStatistics max = lineStreams.filter(line -> !line.matches("(.*)--+(.*)")).filter(line -> ! line.matches("^\\s*$")).mapToDouble(s -> {
//    	 String [] words = s.split("\\s+");
//    	 return Double.valueOf(words[8]); 	 
//    }).summaryStatistics();
	 
//    DoubleSummaryStatistics max = lineStreams.filter(line -> !line.matches("(.*)--+(.*)")).filter(line -> ! line.matches("^\\s*$")).map(s -> {
//   	 String [] words = s.split("\\s+");
//   	 return Double.valueOf(words[8]); 	 
//   }).collect(Collectors.summarizingDouble(Double::doubleValue));
//    
    

    	  DateFormat df = new SimpleDateFormat("DD-MMM-YY");
    	  lineStreams.forEach(line-> { 
          String [] words;
//    	  if (!line.matches("(.*)--+(.*)") || (! line.matches("^\\s*$")) )	{  
    		  if  (line.matches("(.*)--+(.*)")) {
    			  
    		  } else if (line.matches("^\\s*$")) 
    		  {  
    			  
    		  } else {
    	  words =  line.split("\\s+");
    //       System.out.println(line + " || " + words[8] +"  " +   words[10] + "  " +  words[11]);
    	  Date date = null;
    	  try {
			 date = df.parse(words[6]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	  emps.add(new Emp (Integer.parseInt(words[1]), words[2], words[3], words[4], words[5], date, words[7], Integer.parseInt(words[8]), Float.parseFloat(words[9]), words[10], words[11]));
    	  
    	  } 
    	  }
    			  );
    	  
    	  
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    //emps.stream().forEach(s -> System.out.println(s.getId()));
//    Map <String, List<Emp>> xx  = emps.stream().filter(s -> s.getDept().equals("100")).collect(Collectors.groupingBy( s -> s.getDept()));
//      System.out.println(emps.stream().map( s -> s.getDept()).collect(Collectors.toList()));
//      Map<String, List<Emp>> xxx = emps.stream().collect(Collectors.groupingBy(Emp::getDept));
      Map<String, List<Emp>> x2 = emps.stream().collect(Collectors.groupingBy(Emp::getDept));
      Map<String, Map<String, List<Emp>>> x3 = emps.stream().collect(Collectors.groupingBy(Emp::getDept, Collectors.groupingBy(Emp::getManager)));
//      System.out.println(x2);
      System.out.println(x3);
      List<String> empsSorted = emps.stream().sorted(Comparator.comparingInt(Emp::getSalary).thenComparing(Emp::getComm)).map(s -> s.getSalary() + "  " + s.getComm()).collect(Collectors.toList());
      System.out.println(empsSorted);
      
      
//      System.out.println(emps.stream().filter( s -> s.getDept().equals("100")).collect(Collectors.toList()));
//     emps.stream().forEach(s -> System.out.println(s));
    //	System.out.println(xx);
    	
//      emps.stream ().sorted ((s1, s2) -> {
//    	 
//    	  return (int) (s1.getDept().compareTo(s2.getDept()) > 0 ?  s1.getDept().compareTo(s2.getDept()) : 
//    		  s1.getDept().compareTo(s2.getDept()) < 0 ?   s1.getDept().compareTo(s2.getDept()) : s1.getId().compareTo(s2.getId()));
//    	  
//      }).forEach( s -> System.out.println(s.getDept() + " " + s.getId()));;
      
      
      
      
    	
   }
    




    static void permute( String str ){
        int          length = str.length();
        boolean[]    used = new boolean[ length ];
     //   for (int i = 0; i < length; i++) System.out.println(used[i]);
        StringBuffer out = new StringBuffer();
        char[]       in = str.toCharArray();

        doPermute( in, out, used, length, 0 );
    }

    public static void print(boolean [] a) {
    	for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
    	System.out.println();
    }
    
    
    public static void printOpenDoor (int students) {
    	
    		char [] doors = new char[5];
    		
    	for (int i = 0; i < doors.length; i++) {
    		doors[i] = 'C';
    	}
    	
    	for (int i = 1; i <= students; i++) {
    		for (int j = 0; j < doors.length; j++) {
    			if ((j+1) % i == 0) doors[j] = ( doors[j] == 'O') ?  'C' :  'O';
    		}
    		System.out.println(new String(doors));
    	}
    	
    	System.out.println("========");
    	for (int i = 0 ; i < doors.length; i++) {
    		 System.out.print(doors[i]);
    	}
    	
    	
    }
    
   public void travel(Node root) {
	   
	   
   }

//   public void weakReferenceStackManipulation() {
//	    final WeakReference<ValueContainer> stack = new WeakReference<>();
//
//	    final ValueContainer expected = new ValueContainer("Value for the stack");
//	    stack.push(new ValueContainer("Value for the stack"));
//
//	    ValueContainer peekedValue = stack.peek();
//	    assertEquals(expected, peekedValue);
//	    assertEquals(expected, stack.peek());
//	    peekedValue = null;
//	    System.gc();
//	    assertNull(stack.peek());
//	}
//   
//}



 	   
   }
   
   
   
   
   
   

	
	

	
	
	


    
	

