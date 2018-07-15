package com.jia.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee1 {
  private String name;
  private Integer age;
  private Double salary;
  public Employee1(String name, Integer age, Double salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }
  public String toString(){
    DecimalFormat dformat = new DecimalFormat(".##");
    return "Employee Name:"+this.name
        +"  Age:"+this.age
        +"  Salary:"+dformat.format(this.salary);
  }
//getters and setters for name, age and salary go here
//standard equals() and hashcode() code go here
public String getName() {
	// TODO Auto-generated method stub
	return name;
}
public void setName(String name) {
	// TODO Auto-generated method stub
	this.name = name;
	
}
}
//MultiValueMapsExample.java


public class MultiValueMapsExample {
  static Map<Integer, List<Employee1>> employeeDOJMap = new HashMap<>();
   
  public static void main(String args[]) {
 
    List<Employee1> list2014 = Arrays.asList(
        new Employee1("Deborah Sprightly", 29, 9000.00));
    employeeDOJMap.put(2014, list2014);
    List<Employee1> list2015 = Arrays.asList(
        new Employee1("Tom Jones", 45, 7000.00),
        new Employee1("Harry Major", 25, 10000.00));
    employeeDOJMap.put(2015, list2015);
    List<Employee1> list2016 = Arrays.asList(
        new Employee1("Ethan Hardy", 65, 8000.00),
        new Employee1("Nancy Smith", 22, 12000.00));
    employeeDOJMap.put(2016, list2016);
    
    employeeDOJMap.replaceAll((k, v) -> {
     
    	v.replaceAll(emp -> {
    		emp.setName(emp.getName().toUpperCase());
    		return emp;
    	});
       return v;
    }  
    );
    
    employeeDOJMap.computeIfAbsent(2018, (e) -> new ArrayList<>()).add(new Employee1("Dick Newman", 35, 10000.00));
    
    System.out.println(employeeDOJMap);
    
    
  }
}