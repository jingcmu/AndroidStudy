package util;

import java.io.*;
import java.util.Properties;

import customerException.OptionException;
import model.Automobile;

public class Util {
	public Automobile buildAutoObject(String filename){
        //Reads the file and builds OptionSet array.
        String s;
        Automobile auto = new Automobile();
        int setNum = 0;
        
        //Open the file using FileReader Object.
        try {
        	if(!filename.contains(".txt")) {
        		throw new OptionException(0);
        	}
        	File optionFile = new File(filename);
    		//In a loop read a line using readLine method.
            FileReader fr = new FileReader(optionFile);
            @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
            br.readLine();
            s = br.readLine();
            auto.setMake(s);
            br.readLine();
            s = br.readLine();
            auto.setModel(s);
            br.readLine();
            s = br.readLine();
            auto.setBasePrice(Integer.parseInt(s));
            s = br.readLine(); //size of the optionSet
            auto.setOptionSetSize(Integer.parseInt(s)); //set optionSet size
            while ((s = br.readLine()) != null) {
            	String optionSetName = s;
            	auto.setOptionSet(optionSetName, setNum); //set the name of optionSet
            	s = br.readLine();
            	while(s != null && s.length() != 0) {
            		boolean hasPrice = s.contains("$");
            		if(!hasPrice) {
            			String optionName = s;
            			auto.setOption(optionSetName, optionName, 0);
            		} else {
            			int index = s.indexOf("$");            			
            			String optionName = s.substring(0, index);
            			String price = s.substring(index+1, s.length());
            			int priceInt = Integer.parseInt(price);
            			if(priceInt > auto.getBasePrice() || priceInt < 0-auto.getBasePrice()) {
            				throw new OptionException(3);
            			}
            			auto.setOption(optionSetName, optionName, priceInt);
            		}
            		s = br.readLine();
            	}
        		setNum++;	 
            }
            fr.close();
        }
        catch (OptionException e) {
        	e.printError();
        }
        catch(Exception e){
            e.printStackTrace();
        }        
        auto.setDefaultChoices();
        return auto;
	}
	
	public Automobile buildAutoObjectFromPropertiesFile(Properties props){
		Automobile auto = new Automobile();
		String CarMake = props.getProperty("CarMake"); //this is how you read a
		//property. It is like gettting a value from HashTable.
		Integer setNum = 0;
		boolean hasPrice = false;
		if(!CarMake.equals(null)) {
			auto.setMake(CarMake);
			String CarModel = props.getProperty("CarModel");
			auto.setModel(CarModel);
			String Baseprice = props.getProperty("Baseprice");
			auto.setBasePrice(Integer.parseInt(Baseprice));
			String OptionSize = props.getProperty("OptionSize");
			auto.setOptionSetSize(Integer.parseInt(OptionSize)); 
			String Option0 = props.getProperty("Option0");
			auto.setOptionSet(Option0, setNum++);
			String OptionValue0a = props.getProperty("OptionValue0a");
			hasPrice = OptionValue0a.contains("$");
			auto.setPrice(auto, Option0, OptionValue0a, hasPrice);
			String OptionValue0b = props.getProperty("OptionValue0b");
			hasPrice = OptionValue0b.contains("$");
			auto.setPrice(auto, Option0, OptionValue0b, hasPrice);
			String Option1 = props.getProperty("Option1");
			auto.setOptionSet(Option1, setNum++);
			String OptionValue1a = props.getProperty("OptionValue1a");
			hasPrice = OptionValue1a.contains("$");
			auto.setPrice(auto, Option1, OptionValue1a, hasPrice);
			String OptionValue1b = props.getProperty("OptionValue1b");
			hasPrice = OptionValue1b.contains("$");
			auto.setPrice(auto, Option1, OptionValue1b, hasPrice);
			String Option2 = props.getProperty("Option2");
			auto.setOptionSet(Option2, setNum++);
			String OptionValue2a = props.getProperty("OptionValue2a");
			hasPrice = OptionValue2a.contains("$");
			auto.setPrice(auto, Option2, OptionValue2a, hasPrice);
			String OptionValue2b = props.getProperty("OptionValue2b");
			hasPrice = OptionValue2b.contains("$");
			auto.setPrice(auto, Option2, OptionValue2b, hasPrice);
			String OptionValue2c = props.getProperty("OptionValue2c");
			hasPrice = OptionValue2c.contains("$");
			auto.setPrice(auto, Option2, OptionValue2c, hasPrice);
			String Option3 = props.getProperty("Option3");
			auto.setOptionSet(Option3, setNum++);
			String OptionValue3a = props.getProperty("OptionValue3a");
			hasPrice = OptionValue3a.contains("$");
			auto.setPrice(auto, Option3, OptionValue3a, hasPrice);
			String OptionValue3b = props.getProperty("OptionValue3b");
			hasPrice = OptionValue3b.contains("$");
			auto.setPrice(auto, Option3, OptionValue3b, hasPrice);
			String Option4 = props.getProperty("Option4");
			auto.setOptionSet(Option4, setNum++);
			String OptionValue4a = props.getProperty("OptionValue4a");
			hasPrice = OptionValue4a.contains("$");
			auto.setPrice(auto, Option4, OptionValue4a, hasPrice);
			String OptionValue4b = props.getProperty("OptionValue4b");
			hasPrice = OptionValue4b.contains("$");
			auto.setPrice(auto, Option4, OptionValue4b, hasPrice);
			//auto.setDefaultChoices();
		}
		return auto;
	}
	
}
