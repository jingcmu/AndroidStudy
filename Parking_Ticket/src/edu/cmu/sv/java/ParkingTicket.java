package edu.cmu.sv.java;

import java.util.ArrayList;

/**
 * @brief simulate parking tickets
 * To report the make, model, color and license number of an illegally parked car
 * Report the fine - which is $25.00 for first hour plus $10.00 for each additional hour
 * Report the name and badge number of the police officer issuing the ticket.
 */
public class ParkingTicket {
	private ParkedCar carGetTicket;
	private PoliceOfficer officerGiveTicket;
	private double fine;
	
	public ParkingTicket(ParkedCar carGetTicket, PoliceOfficer officerGiveTicket, double fine) {
		this.carGetTicket = carGetTicket;
		this.officerGiveTicket = officerGiveTicket;
		this.fine = fine;
	}
	
	public ParkedCar getCarGetTicket() {
		return carGetTicket;
	}
	
	public void setCarGetTicket(ParkedCar carGetTicket) {
		this.carGetTicket = carGetTicket;
	}
	
	public PoliceOfficer getOfficerGiveTicket() {
		return officerGiveTicket;
	}
	
	public void setOfficerGiveTicket(PoliceOfficer officerGiveTicket) {
		this.officerGiveTicket = officerGiveTicket;
	}
	
	public void report() {
		System.out.println("Make:"+carGetTicket.getMake()+"\nModel:"+carGetTicket.getModel()
							+"\nColor:"+carGetTicket.getColor()+"\nLicenseNumber:"+carGetTicket.getLicenseNumber());
		System.out.println("Fine:"+this.fine);
		System.out.println("Police Name:"+this.officerGiveTicket.getName()+"\nBadge Number:"+officerGiveTicket.getBadgeNumber()+"\n");
	}
	
	public static void main(String[] argv) {
		ArrayList<ParkingTicket> List = new ArrayList<ParkingTicket>();
		ParkedCar[] car ;
		car = new ParkedCar[4];
		car[0] = new ParkedCar("Toyota", "Corolla", "Black", "XYZ1234", 160);
		car[1] = new ParkedCar("Honda", "Civic", "Red", "IJK4321", 180);
		car[2] = new ParkedCar("Audi", "Q7", "White", "ABCD123", 30);
		car[3] = new ParkedCar("Audi", "X5", "Purple", "518516QQ", 95);
		
		ParkingMeter[] meter;
		meter = new ParkingMeter[4];
		meter[0] = new ParkingMeter(50);
		meter[1] = new ParkingMeter(120);
		meter[2] = new ParkingMeter(0);
		meter[3] = new ParkingMeter(100);
		
		PoliceOfficer[] police;
		police = new PoliceOfficer[4];
		police[0] = new PoliceOfficer("Jacky", "XYZ911");
		police[1] = new PoliceOfficer("Tom", "XYZ008");
		police[2] = new PoliceOfficer("Jason", "XYZ119");
		police[3] = new PoliceOfficer("Joy", "XYZ333");
		
		for(int i=0; i<4; i++){
			ParkingTicket ticket = police[i].issueTicket(car[i], meter[i]);
			if(ticket != null){
				List.add(ticket);
			}
		}
		
		System.out.println("ticket number:" + List.size() + '\n');
		for(ParkingTicket t : List){
			t.report();
		}
	}
}