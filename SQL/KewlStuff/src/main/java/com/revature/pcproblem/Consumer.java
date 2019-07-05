package com.revature.pcproblem;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private BlockingQueue<Message> queue;
	private String name;
	public Consumer(BlockingQueue<Message> queue, String name) {
		super();
		this.queue = queue;
		this.name = name;
	}
	@Override
	public void run() {
		Message msg=null;
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(!(msg=queue.take()).getMsg().equals("exit")) {
				System.out.println("Consumed "+ msg.getMsg()+ " by "+ name);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
