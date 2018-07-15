package com.ge.example.queue;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PriorityQueueImpl4Test {

	private PriorityQueueImpl5 <String> queue = null;
	String inValueHigh = "High";
	String inValueHigh_med = "High_Med";
	String inValueMed_low = "Med_Low";
	String inValueMed = "Med";
	String inValueLow = "Low";

	@Before
	public void init() {

		queue = new PriorityQueueImpl5();
		queue.add(inValueMed_low, 8);
		System.out.println("total size: " + queue.toString());
		queue.add(inValueMed, 5);
		System.out.println("total size: " + queue.toString());
		// System.out.println("yy");
		queue.add(inValueHigh, 1);
		System.out.println("total size: " + queue.toString());
		queue.add(inValueHigh_med, 3);
		System.out.println("total size: " + queue.toString());
		// System.out.println("yy");
		queue.add(inValueLow, 10);
		System.out.println("total size: " + queue.toString());
	}

	@Test
	public void testIsEmpty() {

	}

	

	@Test
	public void testAdd() {

	}

	@Test
	public void testReorder() {

		Assert.assertFalse("Queue should not be empty.", queue.isEmpty());

		String s = queue.getNext();
		System.out.println("xx" + s);
		Assert.assertSame("Expected High priority value first.", inValueHigh, s);
		s = queue.getNext();
		System.out.println(s);
		Assert.assertSame("Expected High priority value first.",
				inValueHigh_med, s);
		s = queue.getNext();
		System.out.println(s);
		Assert.assertSame("Expected Med priority value second.", inValueMed, s);
		s = queue.getNext();
		System.out.println("yy" +s);
		Assert.assertSame("Expected High priority value first.",
				inValueMed_low, s);
		s = queue.getNext();
		Assert.assertSame("Expected Low priority value third.", inValueLow, s);
		System.out.println("xx" +s);

	//	Assert.assertTrue("Expected is empty", queue.isEmpty());

	}
	
	@Test(expected = NoSuchElementException.class)
	public void testGetNext() {
		queue.getNext();

	}

}
