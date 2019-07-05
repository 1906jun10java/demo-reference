package com.revature.pcproblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCMain {

	public static void main(String[] args) {
		BlockingQueue<Message> queue=
				new ArrayBlockingQueue<Message>(10);
		Producer producer=new Producer(queue);
		Consumer con1= new Consumer(queue,"Consumer1");
		Consumer con2= new Consumer(queue,"Consumer2");
		Consumer con3= new Consumer(queue,"Consumer3");
		Consumer con4= new Consumer(queue,"Consumer4");
		Thread t= new Thread(con4);
		t.setPriority(10);
		t.start();
		new Thread(producer).start();
		new Thread(con1).start();
		new Thread(con2).start();
		new Thread(con3).start();
		
		System.out.println("Producers and Consumers have been started");
	

	}

}
