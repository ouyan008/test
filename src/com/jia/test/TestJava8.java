package com.jia.test;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Function;

class Member {
	
	private String firstName;

	public Member(int id, String firstName, String lastName, MemberShipLevel level, Member parnent) {
		super();
		this.firstName = firstName;
		Id = id;
		this.lastName = lastName;
		this.level = level;
		this.parnent = parnent;
	}
	private int Id;

	private String lastName;

	private MemberShipLevel level;

	private Member parnent;

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return Id;
	}

	public String getLastName() {
		return lastName;
	}

	public MemberShipLevel getLevel() {
		return level;
	}

	public Member getParnent() {
		return parnent;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(int id) {
		Id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setLevel(MemberShipLevel level) {
		this.level = level;
	}
	public void setParnent(Member parnent) {
		this.parnent = parnent;
	}
	
	
}


enum MemberShipLevel {COMMUNITY, ENTERPRISE, PREMIUM}

public class TestJava8 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		 int [] letterScores = {
	                // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y,  z 
	                   1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10
	            };
		 
	//	 String str = "abcde";
	//	 Function <String, Integer> a  = ( word)->  word.chars().map (s -> letterScores[s-'a']).sum();
		 
	CompletableFuture	x = CompletableFuture.runAsync(() -> {
	//	 CompletableFuture.runAsync(() -> {
			
		//	for (int i = 0; i < 100; i++) {
			
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
				System.out.println("xx");
		//	}
			
		
		});
	
	Executors.newSingleThreadExecutor().submit(() -> System.out.println("heell"));
//	System.out.println(x.get());

System.out.println(x.get());
x.cancel(true);
//	System.out.println(Thread.currentThread().getName());
//	Thread.sleep(100000);
	System.out.println("end");
	
//				 
				 
	}		 
				 
				 
}				 
		 

	

