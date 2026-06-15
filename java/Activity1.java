package fst;

public class Activity1 {
	public static void main(String args[]) {
		Car car = new Car();
		car.make = 2014;
		car.color = "black";
		car.transmission = "manual";
		car.displayCharacterstics();
		car.accelerate();
		car.brake();
	}
}
