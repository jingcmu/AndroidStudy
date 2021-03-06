package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import customerException.OptionException;

public class Automobile implements Serializable {
	private static final long serialVersionUID = 1L;	
	private String make;
	private String model;
	private Integer basePrice;
	private ArrayList<OptionSet> optionSet; //this model has several OptionSets
	private Integer optionSetSize;
	private LinkedHashMap<String, String> Choices;
	
	/**
	 * constructors
	 */
	public Automobile(){}
	
	/**
	 * constructors
	 * @param Make : name of the maker
	 * @param Model : name of the model
	 * @param basePrice : base price of the model
	 * @param optionSetSize : the size of the optionset
	 */
	public Automobile(String Make, String Model, Integer basePrice, int optionSetSize){
		setMake(Make);
		setModel(Model); 				//model name like FordZTW
		setBasePrice(basePrice);
		setOptionSetSize(optionSetSize);
	}
		
	/**
	 * getters
	 * 
	 */
	public synchronized String getMake() {
		return this.make;
	}
	
	public synchronized String getModel() {
		return this.model;
	}
	
	public synchronized Integer getBasePrice(){
		return this.basePrice;
	}
	
	/**
	 * update optionSetSize and return
	 * @return optionSetSize
	 */
	public synchronized Integer getoptionSetSize(){
		this.optionSetSize = this.optionSet.size();
		return this.optionSetSize;
	}
	
	/**
	 * use customer exception to avoid index error
	 * @param index : index of optionset
	 * @return optionset with the index
	 */
	public synchronized OptionSet getOptionSet(int index) {
		try {
			if(index >= optionSetSize) {
				throw new OptionException(0);
			}
		} catch(OptionException e) {
			e.printError();
			index = this.optionSet.size() - 1;
		}
		return optionSet.get(index);
	}
	
	/**
	 * To get the option set with the name 
	 * @param optionSetName
	 * @return option set
	 */
	public synchronized OptionSet getOptionSet(String optionSetName) {
		int index = -1;
		for(int i=0; i<this.getoptionSetSize(); i++) {
			if(this.optionSet.get(i).getName().equals(optionSetName)) {
				index = i;
				break;
			}
		}
		return optionSet.get(index);
	}
	
	/**
	 * To find option set with the name
	 * @param OptionSetName
	 * @return option set
	 */
	public synchronized OptionSet findOptionSet(String OptionSetName) {
		for(int i=0; i<optionSetSize; i++) {
			if(this.optionSet.get(i).getName().equals(OptionSetName)) {
				return optionSet.get(i);
			}
		}
		return null;
	}
	
	/**
	 * To find option with the set name and option name
	 * @param OptionSetName : set name
	 * @param OptionName : option name
	 * @return Option
	 */
	public synchronized OptionSet.Option findOption(String OptionSetName, String OptionName) {
		OptionSet optionset = findOptionSet(OptionSetName);
		OptionSet.Option option = optionset.getOption(OptionName); //inner class
		return option;
	}
	
	/**
	 * setters
	 * 
	 */
	public synchronized void setMake(String make) { 
		this.make = make; // model name
	}
	
	public synchronized void setModel(String model) { 
		this.model = model; // model name
	}
	
	public synchronized void setBasePrice(Integer basePrice){
		this.basePrice = basePrice; // base price
	}
	
	public synchronized void setOptionSetSize(int optionSetSize) {
		this.optionSetSize = optionSetSize;
		this.optionSet = new ArrayList<OptionSet>(optionSetSize);
		for(int i=0; i<optionSetSize; i++) {
			OptionSet os = new OptionSet();
			this.optionSet.add(os);
		}
	}
	
	public synchronized void setOptionSet(String name, Integer index) {
		OptionSet optionset = this.getOptionSet(index);
		optionset.setName(name);
	}
	
	public synchronized void setOptionSet(String name, String newName) {
		int index = -1;
		for(int i=0; i<this.getoptionSetSize(); i++) {
			if(this.optionSet.get(i).getName().equals(name)) {
				index = i;
				break;
			}
		}
		if(index != -1)
			setOptionSet(newName, index);
	}
	
	public synchronized void setOption(String OptionSetName, String optionName, float price) {
		OptionSet optionset = findOptionSet(OptionSetName);
		optionset.setOption(optionName, price);
	}
	
	/**
	 * To delete the option set with the name
	 * @param OptionSetName
	 */
	public synchronized void deleteOptionSet(String OptionSetName) {
		int index = -1;
		for(int i=0; i<optionSetSize; i++) {
			if(this.optionSet.get(i).getName().equals(OptionSetName)) {
				index = i;
			}
		}
		if(index != -1) {
			for(int i=index; i<this.optionSet.size(); i++) {
				this.optionSet.set(i, this.optionSet.get(i+1));
			}
			optionSetSize = optionSetSize - 1;
		}
	}
	
	/**
	 * To delete the option with set name and option name
	 * @param OptionSetName
	 * @param OptionName
	 */
	public synchronized void deleteOption(String OptionSetName, String OptionName) {
		OptionSet optionSet = null;
		OptionSet.Option option = null;
		for(int i=0; i<this.getoptionSetSize(); i++) {
			if(this.optionSet.get(i).getName().equals(OptionSetName)) {
				optionSet = this.optionSet.get(i);
			}
		}
		if(optionSet != null) {
			for(int i=0; i<optionSet.getOptionSize(); i++) {
				option = optionSet.getOption(OptionName);
				this.optionSet.remove(option);
			}
		}
	}
	
	/**
	 * To update optionset with an index
	 * @param optionset : new option set
	 * @param index : the option set with this index will be updated
	 */
	public synchronized void updateOptionSet(OptionSet optionset, int index) {
		try {
			if(index >= optionSetSize) {
				throw new OptionException(4);
			}
			else {
				this.optionSet.set(index, optionset);
			}
		} catch(OptionException e) {
			e.printError();
		}
	}
		
	/**
	 * To update option with an optionset index
	 * @param option : new option
	 * @param optionSetIndex : optionset with this index will be updated
	 */
	public synchronized void updateOption(OptionSet.Option option, int optionSetIndex) {
		OptionSet optionset;
		OptionSet.Option optionT;
		try {
			if(optionSetIndex >= optionSetSize) {
				throw new OptionException(4);
			}
			else {
				optionset = this.optionSet.get(optionSetIndex);
				optionT = optionset.getOption(option.getName());
				optionset.setOption(optionT.getName(), optionT.getPrice());
			}
		} catch(OptionException e) {
			e.printError();
		}
	}
	
	
	/**
	 * to print all the OptionSets and Options with their price in the model
	 */
	public synchronized void print() {
		StringBuffer str = new StringBuffer();
		str.append("Make ");
		str.append(this.getMake());
		str.append(" Model ");		
		str.append(this.getModel());
		str.append("'s base price is ");
		str.append(this.getBasePrice());
		System.out.println(str);
		str.setLength(0);
		str.append("Total price is: ");
		str.append(this.getTotalPrice());
		System.out.println(str);
		System.out.println("end of print----------\n\n");
	}
	
	public String listOptionSet() {
		StringBuffer str = new StringBuffer();
		for(int i = 0; i<this.optionSetSize; i++) {
			str.append(optionSet.get(i).getName() + " | ");
		}
		return str.toString();
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Make ");
		str.append(this.getMake());
		str.append(" Model ");		
		str.append(this.getModel());
		str.append("'s base price is ");
		str.append(this.getBasePrice());
		str.append(" Total price is: ");
		str.append(this.getTotalPrice());
		return str.toString();
	}
	
	/**
	 * set default choice to each optionSet
	 */
	public synchronized void setDefaultChoices() {
		this.Choices = new LinkedHashMap<String, String>();
		//set default choices to the first option of each optionSet
		for(int i=0; i<this.getoptionSetSize(); i++) {
			this.Choices.put(this.optionSet.get(i).getName(), this.optionSet.get(i).getOption(0).getName());
		}
	}
	
	/**
	 * set choice to an optionSet
	 * @param setName : name of the option set
	 * @param optionName : name of the option
	 */

	public synchronized void setOptionChoice(String setName, String optionName) {
		if(this.Choices.containsKey(setName)) {
			this.Choices.put(setName, optionName);
		}
		else {
			try{
				throw new OptionException(1);
			} catch(OptionException e) {
				e.printError();
			}
		}
	}
	
	/**
	 * To get the name of the chosen option for an option set
	 * @param setName : name of option set
	 * @return option name
	 */
	public synchronized String getOptionChoice(String setName) {
		String optionName = null;
		if(this.Choices.containsKey(setName)) {
			optionName = this.Choices.get(setName);
		}
		else {
			try {
				throw new OptionException(2);
			} catch(OptionException e) {
				e.printError();
			}
		}
		return optionName;
	}
	
	/**
	 * To get the price of a chosen option for an option set
	 * @param setName : name of the option set
	 * @param optionName : name of the option
	 * @return price of the option
	 */
	public synchronized Float getOptionChoicePrice(String setName, String optionName) {
		OptionSet.Option option = null;
		
		if(optionName != null)
			option = this.findOptionSet(setName).getOption(optionName);
		
		if(option != null)
			return option.getPrice();
		else
			return 0f;
	}
	
	/**
	 * To get the total price of the chosen options
	 * @return total price
	 */
	public synchronized Float getTotalPrice() {
		Float price = (Float)(float)this.basePrice;
		for(int i=0; i<this.getoptionSetSize(); i++) {
			price += getOptionChoicePrice(this.getOptionSet(i).getName(), getOptionChoice(this.getOptionSet(i).getName()));
		}
		return price;
	}
	
	public synchronized void setPrice(Automobile auto, String OptionSetName, 
			String OptionName, boolean hasPrice) {
		if(!hasPrice) {
			auto.setOption(OptionSetName, OptionName, 0);
		} else {
			int index = OptionName.indexOf("$");            			
			String optionName = OptionName.substring(0, index-1);
			String price = OptionName.substring(index+1, OptionName.length());
			int priceInt = Integer.parseInt(price);
			auto.setOption(OptionSetName, optionName, priceInt);
		}
	}
}
