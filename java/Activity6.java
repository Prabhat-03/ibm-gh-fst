package fst;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane{
	private List<String> passengers;
	private int maxPassengers;
	private Date lastTimeTookOff;
	private Date lastTimeLanded;
	
	Plane(int maxPassesngers){
		this.maxPassengers = maxPassengers;
		this.passengers = new ArrayList<>();
	}
	
	public void onboard(String passenger) {
		if (passengers.size() <= maxPassengers) {
			this.passengers.add(passenger);
		}
	}
	
	public Date takeOff() {
		this.lastTimeTookOff = new Date();
		return lastTimeTookOff;
	}
	
	public void land() {
		this.lastTimeLanded = new Date();
		this.passengers.clear();
	}
	
	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}
	
	public List<String> getPassengers() {
		return passengers;
	}
	
}



public class Activity6 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Plane plane = new Plane(10);
		plane.onboard("Yshesh");
		plane.onboard("Will");
		plane.onboard("Steve");
		plane.onboard("");
		System.out.println("Plane took off at: " + plane.takeOff());
		System.out.println("Passengers List: " + plane.getPassengers());
		
		Thread.sleep(5000);
		plane.land();
		
		System.out.println("Plane landed at: " + plane.getLastTimeLanded());
 		System.out.println("People on the plane after landing: " + plane.getPassengers());
	}

}
