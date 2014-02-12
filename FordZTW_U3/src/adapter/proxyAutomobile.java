package adapter;
import java.util.LinkedHashMap;

import model.*;
import util.Util;
public abstract class proxyAutomobile {
	private static LinkedHashMap<String, Automobile> models;
	
	/**
	 * To build Automobile object from input file
	 * @param filename
	 */
	public void BuildAuto(String filename) {
		Util util = new Util();
		Automobile a1 = util.buildAutoObject(filename);
		if(models == null) {
			models = new LinkedHashMap<String, Automobile>();
		}
		if(!models.containsKey(a1.getModel())) {
			models.put(a1.getModel(), a1);
		}
	}
	
	public void printAuto(String Modelname){
		if(models.containsKey(Modelname)) {
			models.get(Modelname).print();
		}
	}
	
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName){
		Automobile auto = models.get(Modelname);
		auto.setOptionSet(OptionSetname, newName);
		
	}
	
	public void updateOptionPrice(String Modelname, String OptionSetname, String Option, float newprice){
		Automobile auto = models.get(Modelname);
		auto.setOption(OptionSetname, Option, newprice);
	}
	
	public void editOptionPrice(String ModelName, String OptionsetName, String OptionName, float newprice) {
		EditOptionsSub editOptionsSub = new EditOptionsSub(models.get(ModelName), OptionsetName, OptionName, newprice);
		editOptionsSub.start();
	}
	
	public void editOptionSetName(String ModelName, String OptionsetName, String newName) {
		EditOptionsSub editOptionsSub = new EditOptionsSub(models.get(ModelName), OptionsetName, newName);
		editOptionsSub.start();
	}
}
