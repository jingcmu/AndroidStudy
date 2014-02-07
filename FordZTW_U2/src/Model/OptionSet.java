package Model;

import java.io.Serializable;
import java.util.ArrayList;

/*implement Serializable interface*/
public class OptionSet implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * Option is an inner class of OptionSet
	 * It is used to represent an option for the car
	 * @author Jacky
	 *
	 */
	class Option implements Serializable {
		private static final long serialVersionUID = 1L;
		private String name;
		private int price;
		
		protected Option() {}
		
		protected Option(String name) {
			this.name = name;
		}
		
		protected Option(String name, int price) {
			this.name = name;
			this.price = price;
		}
		
		protected String getName() {
			return name;
		}
		protected void setName(String name) {
			this.name = name;
		}
		protected int getPrice() {
			return price;
		}
		protected void setPrice(int price) {
			this.price = price;
		}		
	}  //end of option
	
	//properties of OptionSet
	private String name;
	private ArrayList<Option> options;
	private Integer optionSize;
	
	/**
	 * constructors
	 */
	protected OptionSet() {
		options = new ArrayList<Option>();
	}
	protected OptionSet(String name) {
		this.name = name;
		options = new ArrayList<Option>();
	}
	
	/**
	 * getter and setter of OptionSet
	 * @return
	 */
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected Integer getOptionSize() {
		return this.optionSize;
	}
	protected void setOptionSize(Integer optionSize) {
		this.optionSize = optionSize;
	}
	protected Option getOptions(String optionName) {
		int index = -1;
		for(int i=0; i<this.options.size(); i++) {
			if(this.options.get(i).getName().equals(name)) {
				index = i;
				break;
			}
		}
		return index == -1? null:options.get(index);
	}
	protected void setOptions(Integer index, Option options) {
		this.options.set(index, options);
	}
	/**
	 * sets the ith Option to the specified name and price
	 * @param i - the ith option
	 * @param name - the name of the option
	 * @param price - the price of the option
	 */
	protected void setOption(String name, int price) {
		boolean found = false;
		int index = -1;
	
		for(int i=0; i<this.options.size(); i++) {
			if(this.options.get(i).getName().equals(name)) {
				found = true;
				index = i;
				break;
			}
		}
		//if found, just change the price;
		//if not found, add the node into the ArrayList
		if(found) {
			Option o = this.options.get(index);
			o.setPrice(price);
		} else {
			Option o = new Option(name, price);
			this.options.add(o);
		}
	}
	
	protected Option getOption(String name) {
		int index = findOption(name);
		if(index != -1) {
			return options.get(index);
		}
		return null;
	}
	/**
	 * eturns the price of the Option based on the name
	 * @param name
	 * @return
	 */
	protected int getOptionPrice(String name) {
		int index = findOption(name);
		if(index != -1) {
			return options.get(index).getPrice();
		}
		return -1;
	}
	/**
	 * eturns the index of the Option based on the name
	 * @param name
	 * @return
	 */
	protected int findOption(String name) {
		for(int i=0; i<options.size(); i++) {
			if(options.get(i).getName().equals(name))
				return i;
		}
		return -1;
	}
}
