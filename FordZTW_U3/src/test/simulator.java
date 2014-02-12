package test;

import adapter.BuildAuto;
import adapter.CreateAuto;
import adapter.EditAuto;

public class simulator {

	protected static final String SERIALIZED_FILE_NAME = "autos.ser";
	public static void main(String[] args) {
		try{
			CreateAuto auto1  = new BuildAuto();
			auto1.BuildAuto("OptionSet0.txt");
			auto1.printAuto("FordZTW");
			
			CreateAuto auto2  = new BuildAuto();
			auto2.BuildAuto("OptionSet1.txt");
			auto2.printAuto("ToyotaLexus");
			
			EditAuto autoEdit1 = new BuildAuto();	
			EditAuto autoEdit2 = new BuildAuto();
			
			autoEdit1.editOptionPrice("FordZTW", "Brakes", "Standard", 100);
			autoEdit2.editOptionPrice("FordZTW", "Brakes", "Standard", 200);
			System.out.println("Two threads which change the price start to run!");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
