package com.jia.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public  class  TestUnit {
	
	public static void main(String [] args) throws InterruptedException {
		
		DelayElement de1 = new DelayElement(10000);
		DelayElement de2 = new DelayElement(5000);
		
		DelayQueue<DelayElement> delayQueue = new DelayQueue();
		
		ForkJoinTask
	    delayQueue.put(de1);
	    Thread.sleep(2000);
	    delayQueue.put(de2);
	    
	    System.out.println(delayQueue.take().delay);
	    System.out.println(delayQueue.take().delay);
		
	
	}
	
	
}

class DelayElement implements Delayed  {
	
	public Calendar cal = Calendar.getInstance();
	
	long expiredTime; 
	public long delay;
	public DelayElement(long delay) {
		this.delay = delay;
		this.expiredTime = System.currentTimeMillis() + delay ;
	}

	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		return (int) - (this.getDelay(TimeUnit.SECONDS) - o.getDelay(TimeUnit.SECONDS));
	}

	@Override
	public long getDelay(TimeUnit unit) {
		
	//	System.out.println(expiredTime);
	//	System.out.println(System.currentTimeMillis());
	
		return unit.convert((expiredTime - System.currentTimeMillis()), unit );
	}
	
	
	
	
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

