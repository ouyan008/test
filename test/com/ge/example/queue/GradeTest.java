package com.ge.example.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class GradeTest {

	@Test
	public void test() {
		System.out.println(Grade.values().length);
		System.out.println(Grade.A);
		Grade mygrade = Grade.A;
		System.out.println(mygrade.name());
        
	}

}
