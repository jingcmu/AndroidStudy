package lab3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Automobile implements Serializable {
	private static final long serialVersionUID = 1L;
	private OptionSet optionSet;
	private int price;
	private String name;
	private final int basePrice = 18445;
	Automobile(){}
	Automobile(String name, String OptionSetName, OptionSet[] optionSets){
		setName(name);
		this.optionSet = new OptionSet(OptionSetName);
		for(int i=0; i<optionSets.length; i++) {
			if(optionSets[i].getName().equals(optionSet.getName())) {
				this.optionSet = optionSets[i];
				break;
			}
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OptionSet getOptionSet() {
		return optionSet;
	}
	
	public int getPrice() {
		int additionalPrice = 0;
		additionalPrice += optionSet.getOptionPrice("Color");
		additionalPrice += optionSet.getOptionPrice("Transmission");
		additionalPrice += optionSet.getOptionPrice("Brakes");
		additionalPrice += optionSet.getOptionPrice("SideAirBag");
		additionalPrice += optionSet.getOptionPrice("Moonroof");
		price = basePrice + additionalPrice;
		return price;
	}
	
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
			
			//Deserialize Autos
			ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
			@SuppressWarnings("unchecked")
			ArrayList<Automobile> Autos_recon  = (ArrayList<Automobile>)objectInputStream.readObject();
			Iterator<Automobile> iterator = Autos_recon.iterator();
			System.out.println("After deserialization, we get the info below:");
			while(iterator.hasNext()) {
				Automobile tmp = (Automobile)iterator.next();
				System.out.println("The price for " + tmp.getName() + " is $" + tmp.getPrice());
			}
			
			objectInputStream.close();
		}
		catch (IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
