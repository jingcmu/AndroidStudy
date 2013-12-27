package lab3;

import java.io.Serializable;

public class OptionSet implements Serializable {
	private static final long serialVersionUID = 1L;
	class Option implements Serializable {
		private static final long serialVersionUID = 1L;
		private String name;
		private int price;
		Option() {}
		Option(String name, int price) {
			this.name = name;
			this.price = price;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}		
	}
	private String name;
	private Option[] options;
	OptionSet() {}
	OptionSet(String name) {
		this.name = name;
		options = null;
	}
	OptionSet(String name, int count) {
		this.name = name;
		options = new Option[count];
		for(int i=0; i<options.length; i++) {
			options[i] = new Option();
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Option[] getOptions() {
		return options;
	}
	public void setOptions(Option[] options) {
		this.options = options;
	}
	public void setOption(int i, String name, int price) {
		options[i].setName(name);
		options[i].setPrice(price);
	}
	public Option getOption(String name) {
		int index = findOption(name);
		if(index != -1) {
			return options[index];
		}
		return null;
	}
	public int getOptionPrice(String name) {
		int index = findOption(name);
		if(index != -1) {
			return options[index].getPrice();
		}
		return -1;
	}
	private int findOption(String name) {
		for(int i=0; i<options.length; i++) {
			if(options[i].getName().equals(name))
				return i;
		}
		return -1;
	}
}
