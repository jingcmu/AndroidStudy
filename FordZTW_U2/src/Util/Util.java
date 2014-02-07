package Util;

import java.io.*;

import Model.Automobile;

public class Util {
	public Automobile buildAutoObject(String filename){
        //Reads the file and builds OptionSet array.
        String s;
        Automobile auto = new Automobile();
        int setNum = 0;
        //Open the file using FileReader Object.
        File optionFile = new File(filename);
        //In a loop read a line using readLine method.
        try {
                FileReader fr = new FileReader(optionFile);
                BufferedReader br = new BufferedReader(fr);
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
                			auto.setOption(optionSetName, optionName, Integer.parseInt(price));
                		}
                		s = br.readLine();
                	}
	        		setNum++;	 
                }
                fr.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }        
        return auto;
	}
}
