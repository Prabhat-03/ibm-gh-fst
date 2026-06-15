package fst;


interface BicycleParts{
	public int tyres = 2;
	public int maxSpeed = 40;
}

interface BicycleOperations{
	public void applyBrake(int decrement);
	public void speedUp(int increment);
}


class Bicycle implements BicycleParts, BicycleOperations{
	int gears;
	int currentSpeed;
	
	
	public Bicycle(int gears, int currentSpeed){
		this.gears = gears;
		this.currentSpeed = currentSpeed;
	}
	
	
	public void applyBrake(int decrement) {
		currentSpeed -= decrement;
		System.out.println("Speed after applying Brakes : " + currentSpeed);
	}
	
	
	public void speedUp(int increment) {
		currentSpeed += increment;
		System.out.println("Current Speed after SpeedUp: " + currentSpeed);
	}
	
	public String bicycleDesc() {
		return ("No. of gears are : " + gears +" Speed of the Bicycle is : " + currentSpeed);
	}
	
}


class MountainBike extends Bicycle{
	public int seatHeight;
	
	public MountainBike(int gears, int currentSpeed, int height) {
		super(gears, currentSpeed);
		seatHeight = height;
	}

	public void setHeight(int newHeight) {
		seatHeight = newHeight;
	}
	
	public String bicycleDesc() {
		return (super.bicycleDesc() + "\nSeat Height is : " + seatHeight);
	}


}

public class Activity7 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MountainBike mb = new MountainBike(3, 0, 25);
		System.out.println(mb.bicycleDesc());
		mb.speedUp(20);
		mb.applyBrake(5);
	}

}
