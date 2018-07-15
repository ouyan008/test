package com.jia.test;

import java.util.concurrent.locks.*;
class Bus {
    Lock lock = new ReentrantLock();

    public void boardBus(String name) {
        System.out.println(name + ": boarded");
    }
}
public class Employee extends Thread {
    Bus bus; String name;
    Employee(String name, Bus bus) {
        this.bus = bus;
        this.name = name;
    }
    public void run() {
        try {
            bus.lock.lockInterruptibly();
            bus.boardBus(name);
        }
        catch (InterruptedException e) {
            System.out.println(name + ": Interrupted!!");
            Thread.currentThread().interrupt();
        }
        finally {
            bus.lock.unlock();
        }
    }
    public static void main(String args[]) {
        Employee e1 = new Employee("Paul", new Bus());
        e1.start();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        e1.interrupt();
    }
}