package Model;

import java.io.Serializable;
import java.util.ArrayList;

import CustomerException.OptionSetIndexException;

public class Automobile implements Serializable {
	private static final long serialVersionUID = 1L;	
	private String name;
	private Integer basePrice;
	private ArrayList<OptionSet> optionSet; //this model has several OptionSets
	private Integer optionSetSize;
	/*
	 * constructors
	 */
	public Automobile(){}
	public Automobile(String name, Integer basePrice, int optionSetSize){
		setName(name); 				//model name like FordZTW
		setBasePrice(basePrice);
		setOptionSetSize(optionSetSize);
	}
	//getters
	public String getName() {
		return name;
	}
	
	public Integer getBasePrice(){
		return this.basePrice;
	}
	
	public Integer getoptionSetSize(){
		return this.optionSetSize;
	}
	
	//use customer exception to avoid index error
	public OptionSet getOptionSet(int index) {
		try {
			if(index >= optionSetSize) {
				throw new OptionSetIndexException();
			}
		} catch(OptionSetIndexException e) {
			e.printProblems();
			index = this.optionSet.size() - 1;
		}
		return optionSet.get(index);
	}
	
	//finders
	public OptionSet findOptionSet(String OptionSetName) {
		for(int i=0; i<optionSetSize; i++) {
			if(this.optionSet.get(i).getName().equals(OptionSetName)) {
				return optionSet.get(i);
			}
		}
		return null;
	}
	
	public OptionSet.Option findOption(String OptionSetName, String OptionName) {
		OptionSet optionset = findOptionSet(OptionSetName);
		OptionSet.Option option = optionset.getOptions(OptionName); //inner class
		return option;
	}
	
	//setters
	public void setName(String name) { 
		this.name = name; // model name
	}
	
	public void setBasePrice(Integer basePrice){
		this.basePrice = basePrice; // base price
	}
	
	public void setOptionSetSize(int optionSetSize) {
		this.optionSetSize = optionSetSize;
		this.optionSet = new ArrayList<OptionSet>(optionSetSize);
		for(int i=0; i<optionSetSize; i++) {
			OptionSet os = new OptionSet();
			this.optionSet.add(os);
		}
	}
	
	public void setOptionSet(String name, Integer index) {
		OptionSet optionset = this.getOptionSet(index);
		optionset.setName(name);
	}
	
	public void setOption(String OptionSetName, String optionName, Integer price) {
		OptionSet optionset = findOptionSet(OptionSetName);
		optionset.setOption(optionName, price);
	}
	
	//delete
	public void deleteOptionSet(String OptionSetName) {
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
	
	public void deleteOption(String OptionSetName, String OptionName) {
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
	
	//update
	public void updateOptionSet(OptionSet optionset, int index) {
		try {
			if(index >= optionSetSize) {
				throw new OptionSetIndexException();
			}
			else {
				this.optionSet.set(index, optionset);
			}
		} catch(OptionSetIndexException e) {
			e.printProblems();
		}
	}
		
	public void updateOption(OptionSet.Option option, int optionSetIndex) {
		OptionSet optionset;
		OptionSet.Option optionT;
		try {
			if(optionSetIndex >= optionSetSize) {
				throw new OptionSetIndexException();
			}
			else {
				optionset = this.optionSet.get(optionSetIndex);
				optionT = optionset.getOption(option.getName());
				optionset.setOption(optionT.getName(), optionT.getPrice());
			}
		} catch(OptionSetIndexException e) {
			e.printProblems();
		}
	}
	
	
	//print method
	public void print() {
		StringBuffer str = new StringBuffer();
		str.append("The model ");
		str.append(this.getName());
		str.append(" includes ");
		str.append(this.getoptionSetSize());
		str.append(" optionSets!");
		System.out.println(str);
	}
		
}
