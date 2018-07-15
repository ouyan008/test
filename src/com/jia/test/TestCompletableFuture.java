package com.jia.test;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCompletableFuture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Future<String > future = runAsync();
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("run Async ...");
		

	}
	
	
	 static Future<String> runAsync() {
		 
		 Callable<String> call = () -> {

				Thread.sleep(5000);
				return new String("Jia");
				
			 
		 };
//		 
//		 System.out.println("xxxx");
//		 return Executors.newCachedThreadPool().submit(() -> {
//
//				Thread.sleep(5000);
//				return new String("Jia");
//				
//			 
//		 });
		 
		 return CompletableFuture.supplyAsync( () -> {

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return new String("Jia");
				
			 
		 });
	 }

}
