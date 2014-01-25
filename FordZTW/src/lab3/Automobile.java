package lab3;

import java.io.Serializable;

public class Automobile implements Serializable {
	private static final long serialVersionUID = 1L;
	private OptionSet optionSet; //each automobile should has an OptionSet
	private int price;
	private String name;
	private final int basePrice = 18445;
	/*
	 * constructors
	 */
	public Automobile(){}
	public Automobile(String name, String OptionSetName, OptionSet[] optionSets){
		setName(name);
		this.optionSet = new OptionSet(OptionSetName);
		for(int i=0; i<optionSets.length; i++) {
			if(optionSets[i].getName().equals(optionSet.getName())) {
				this.optionSet = optionSets[i];
				break;
			}
		}
	}
	//getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OptionSet getOptionSet() {
		return optionSet;
	}
	/**
	 * calculate the price of the automobile
	 * @return
	 */
	public int getPrice() {
		int additionalPrice = 0;
		//there are at most 5 different options in its optionset
		additionalPrice += optionSet.getOptionPrice("Color");
		additionalPrice += optionSet.getOptionPrice("Transmission");
		additionalPrice += optionSet.getOptionPrice("Brakes");
		additionalPrice += optionSet.getOptionPrice("SideAirBag");
		additionalPrice += optionSet.getOptionPrice("Moonroof");
		price = basePrice + additionalPrice;
		return price;
	}	
}
