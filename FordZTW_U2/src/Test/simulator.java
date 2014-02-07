package Test;

import Adapter.BuildAuto;
import Adapter.CreateAuto;
import Adapter.UpdateAuto;

public class simulator {

	protected static final String SERIALIZED_FILE_NAME = "autos.ser";
	public static void main(String[] args) {
		try{
			CreateAuto auto  = new BuildAuto();
			UpdateAuto autoUpdate = new BuildAuto();
			auto.BuildAuto("OptionSet.txt");
			auto.printAuto("FordZTW");
			
			//change the price of "Cloud 9 White Clearcoat" in Color optionSet to 100
			autoUpdate.updateOptionPrice("FordZTW", "Color", "Cloud 9 White Clearcoat", 100);
			auto.printAuto("FordZTW");
			
			//change the name of "Side Impact Air Bags" optionSet to "Air Bags"
			autoUpdate.updateOptionSetName("FordZTW", "Side Impact Air Bags", "Air Bags");
			auto.printAuto("FordZTW");
			
			//Change Choices, seems no interface to enable this test!
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
