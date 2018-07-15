package com.jia.test;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TheadTest implements Runnable {
	
	 int count;
	 AtomicInteger ai = new AtomicInteger();
	 static FF ff = new FF();
	 static Runinc runinc = new Runinc(ff);
	 static Rundec rundec = new Rundec(ff);
	
	public static void main(String [] args) {
		
		ExecutorService  es = Executors.newCachedThreadPool();
		TheadTest test = new TheadTest();
		for (int i = 0; i < 10; i++) {
			es.execute(runinc);
			es.execute(rundec);
			
		}
		es.shutdown();;
		System.out.println("---end----");
	
}

	@Override
	public void run() {
		
		for (int i = 0 ; i < 20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//		synchronized(this) {
				//count++;
				ai.getAndIncrement();
	//		}
		}
//		System.out.println("Count: " + count);
		System.out.println("Count: " + ai.get());
	}


}

class FF  {
	
	int count;
	


	public void incre() throws InterruptedException {
		
		synchronized (this) {
//		if ( count == 0) {
	    while (count != 0) {
	    	wait();
	    }
			count ++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notify();
			System.out.print(count);
		};
		
	}
	
   public void decre() throws InterruptedException {
			
//			if ( count == 1) {
	   synchronized(this) {
		    while ( count != 1) {
		    	wait();
		    }
				count --;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(count);
			};
			
		}
		
	}
	
	class Runinc implements Runnable {
		
		FF ff;
        public Runinc(FF ff) {
        	this.ff=ff;
        }
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 20; i++) {
				try {
					ff.incre();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
		
	class Rundec implements Runnable {
		
		FF ff = new FF();
		public Rundec(FF ff) {
			this.ff = ff;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 20; i++) {
				try {
					ff.decre();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
		