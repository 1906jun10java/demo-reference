package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.funfactory.Car;

public class IOWithCollections {
private static final String carFile = "car.txt";
public static List<Car> carList =  new ArrayList<Car>();

	public static void writeCarFile() {
		try {
			ObjectOutputStream objectOut = 
					new ObjectOutputStream (new FileOutputStream (carFile));
			objectOut.writeObject(carList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readCarFile() {
		ObjectInputStream objectIn;
		try {
			objectIn= new ObjectInputStream( new FileInputStream(carFile));
			carList=(ArrayList<Car>)objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
