package com.ge.example.queue;
//
//public enum Grade {
//	
//	A, B, C, D, F
//	
//
//	
//
//}


class Grade {
	
	private String grade;
	
	
	public Grade(String grade) {
		this.grade = grade;
	}
	public static final Grade A = new Grade("100~90"); ;   
	public static final Grade B = new Grade("89~80");   
	public static final Grade C = new Grade("70~70");   
	public static final Grade D = new Grade("69~60");   
	public static final Grade F = new Grade("59~0");   
	
	
	
}

