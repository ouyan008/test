package com.jia.test;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class Outer 
{ 
    public void someOuterMethod() 
    {
        //Line 5 
    } 
    public class Inner { }  
    
    public static void main(String[] argv) 
    {
        Outer ot = new Outer(); 
        //Line 10
    } 
} 