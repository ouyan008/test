package com.jia.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Lock lock1  = new ReentrantLock();
		Lock lock2  = new ReentrantLock();
		
		ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
		
		new Thread(()-> {
			
			    try {
					if (! lock1.tryLock(2000, TimeUnit.MILLISECONDS)) {
						System.out.println("not get the lock, return");
						return;
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				System.out.println("enter lock1" + Thread.currentThread().getId());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				try {
					if (! lock2.tryLock(3000, TimeUnit.MILLISECONDS)) {
						System.out.println("not get the lock, return");
						return;
					};
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					System.out.println("enter lock2" + Thread.currentThread().getId());
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    finally {
				     lock2.unlock();
				     lock1.unlock();
				    }
				
			
			
			
		}).start();
		new Thread(
				() -> {
				      
					try {
						if (lock2.tryLock(3000, TimeUnit.MILLISECONDS)) return;
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					System.out.println("enter lock1" + Thread.currentThread().getId());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						lock1.tryLock(2000, TimeUnit.MILLISECONDS);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
						System.out.println("enter lock2" + Thread.currentThread().getId());
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					finally {
						lock2.unlock();
						lock1.unlock();
				}
				
				}		
				
				).start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long[] ids = tmx.findDeadlockedThreads();
		if (ids != null) {
		for (long id : ids) {
			System.out.println(id);
		}
		}
	}
	
	
	

	
	

}
