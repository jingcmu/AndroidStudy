package edu.cmu.sv.java;

import java.lang.Math;

public class Coin {
	private String SideUp; //indicating the side of the coin that is facing up
	
	//randomly determine the side of the coin that is facing up
	private void setCoin() {
		int randomNum = (int)(Math.random()*10);
		if(randomNum%2 == 0) {
			SideUp = "heads";
		} else {
			SideUp = "tails";
		}
	}
	 
	public Coin(){
		setCoin();
	}
	
	public void toss(){
		setCoin();
	}
	
	public String getSideUp(){
		return SideUp;
	}
	
	public static void main(String argv[]){
		Coin coinX = new Coin();
		int headsUpNum = 0, tailsUpNum = 0; 
		System.out.println("Initially facing up:" + coinX.getSideUp());
		//toss 20 times
		for(int index = 0; index < 20; index++){
			coinX.toss();
			System.out.println("Currently facing up:" + coinX.getSideUp());
			if(coinX.getSideUp() == "heads") {
				headsUpNum++;
			} else {
				tailsUpNum++;
			}	
		}
		//display
		System.out.println("heads up:"+headsUpNum+"times and "+"tails up:"+tailsUpNum+"times");
	}
}
