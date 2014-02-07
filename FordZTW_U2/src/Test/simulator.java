package Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.Automobile;
import Util.Util;

public class simulator {

	protected static final String SERIALIZED_FILE_NAME = "autos.ser";
	public static void main(String[] args) {
		Util util = new Util();
		Automobile auto = new Automobile();
		auto = util.buildAutoObject("OptionSet.txt");
		try{
			//serialize Autos
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
			objectOutputStream.writeObject(auto);
			objectOutputStream.close();
			
			//De-serialize Autos
			ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));

			Automobile Auto_recon  = (Automobile)objectInputStream.readObject();
			System.out.println("After deserialization, we get the info below:");
			Auto_recon.print();
			System.out.println();		
			objectInputStream.close();
		}
		catch (IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
