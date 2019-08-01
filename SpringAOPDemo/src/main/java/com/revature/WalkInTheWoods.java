package com.revature;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bear;
import com.revature.beans.Human;
import com.revature.beans.Tiger;
import com.revature.exception.GotEatenException;
import com.revature.service.CircleOfLifeService;

public class WalkInTheWoods {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		CircleOfLifeService cls = (CircleOfLifeService) ac.getBean("circleOfLifeService");
		
		Human h = new Human();
		h.setSpeed(20.0);
		
		Bear b1 = new Bear(); 
		b1.setSpeed(10.0);
		b1.setHungry(true);
		
		Tiger t = new Tiger();
		t.setSpeed(30.0);
		t.setHungry(true);
		
		try {
			cls.chase(h, b1);
			cls.chase(t, h);
		} catch (GotEatenException e) {
			e.printStackTrace();
		}
		
		ac.close();
		
		
	}

}
