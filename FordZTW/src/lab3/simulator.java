package lab3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class simulator {

	protected static final String SERIALIZED_FILE_NAME = "autos.ser";
	//protected static final String SERIALIZED_FILE_NAME2 = "auto2.ser";
	//protected static final String SERIALIZED_FILE_NAME3 = "auto3.ser";
	//protected static final String SERIALIZED_FILE_NAME4 = "auto4.ser";
	public static void main(String[] args) {
		OptionSet[] optionSets = Util.readFile("OptionSet.txt");
		ArrayList<Automobile> Autos = new ArrayList<Automobile>();
		Automobile A1 = new Automobile("Jacky's car", "OptionSet4", optionSets);
		Automobile A2 = new Automobile("Amy's car", "OptionSet7", optionSets);
		Automobile A3 = new Automobile("Kam's car", "OptionSet13", optionSets);
		Automobile A4 = new Automobile("Oliviar's car", "OptionSet23", optionSets);
		Autos.add(A1); 
		Autos.add(A2); 
		Autos.add(A3); 
		Autos.add(A4); 
		try{
			//serialize Autos
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
			objectOutputStream.writeObject(Autos);
			objectOutputStream.close();
			
			//De-serialize Autos
			ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
			@SuppressWarnings("unchecked")
			ArrayList<Automobile> Autos_recon  = (ArrayList<Automobile>)objectInputStream.readObject();
			Iterator<Automobile> iterator = Autos_recon.iterator();
			System.out.println("After deserialization, we get the info below:");
			while(iterator.hasNext()) {
				Automobile auto = (Automobile)iterator.next();
				System.out.println("The options of " + auto.getName() + " are:");
				for(int i=0; i<auto.getOptionSet().getOptions().length; i++) {
					System.out.println(auto.getOptionSet().getOptions()[i].getName());
				}
				System.out.println("The price is $" + auto.getPrice() + "\n");
			}
			
			objectInputStream.close();
		}
		catch (IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
