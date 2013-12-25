package lab3;

public class Automobile {
	private OptionSet optionSet;
	private int price;
	private String name;
	private final int basePrice = 18445;
	Automobile(){}
	Automobile(String name, String OptionSetName){
		setName(name);
		setOptionSet(OptionSetName);
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
	
	public void setOptionSet(String OptionSetName) {
		optionSet = new OptionSet(OptionSetName);
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(OptionSet[] optionSets) {
		int additionalPrice = 0;
		for(int i=0; i<optionSets.length; i++) {
			if(optionSets[i].getName().equals(optionSet.getName())) {
				additionalPrice += optionSets[i].getOptionPrice("Color");
				additionalPrice += optionSets[i].getOptionPrice("Transmission");
				additionalPrice += optionSets[i].getOptionPrice("Brakes");
				additionalPrice += optionSets[i].getOptionPrice("SideAirBag");
				additionalPrice += optionSets[i].getOptionPrice("Moonroof");
				break;
			}
		}
		price = basePrice + additionalPrice;
	}
	
	public static void main(String[] args) {
		Automobile A1 = new Automobile("Jacky's car", "OptionSet4");
		OptionSet[] optionSets = Util.readFile("OptionSet.txt");
		A1.setPrice(optionSets);
		System.out.println("The price for " + A1.getName() + " is $" + A1.getPrice());
	}
}
