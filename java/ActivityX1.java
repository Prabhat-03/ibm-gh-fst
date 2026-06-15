package fst;

/*
Create the following Java Classes:
Human, Boy, Girl, Robot

All the classes should have methods:
 walking(), talking()

Create a class to instantiate: 3 boys, 3 girls, 3 robots
Print out population of Humans and Robots without using loops or counters in this class.
*/


class Human{
	static int HumanPopulation = 0;
	Human(){
		HumanPopulation++;
	}
	
	void walking() {
		System.out.println("Human is walking...");
	}
	
	void talking() {
		System.out.println("Human is talking...");
	}
	
	int getHumanPopulation() {
		return HumanPopulation;
	}
}

class Boy extends Human{
	static int BoyPopulation = 0;
	
	Boy(){
		super();
		BoyPopulation++;
	}
	
	void walking() {
		System.out.println("Boy is walking...");
	}
	
	void talking() {
		System.out.println("Boy is talking...");
	}
	
	int getBoyPopulation() {
		return BoyPopulation;
	}
}


class Girl extends Human{
	static int GirlPopulation = 0;
	
	Girl(){
		super();
		GirlPopulation++;
	}
	
	void walking() {
		System.out.println("Girl is walking...");
	}
	
	void talking() {
		System.out.println("Girl is talking...");
	}
	
	int getGirlPopulation() {
		return GirlPopulation;
	}
}

class Robot{
	static int RobotPopulation = 0;
	String name;
	
	Robot(String name){
		this.name = name;
		RobotPopulation++;
	}

	void walking() {
		System.out.println(name + " is walking.");
	}
	
	void talking() {
		System.out.println("Oyii Oyii, " + name + " is Talking!!");
	}
	
	int getRobotPopulation() {
		return RobotPopulation;
	}
}


public class ActivityX1 {
	public static void main(String[] args) {
		Boy b1 = new Boy();
		Boy b2 = new Boy();
		
		Girl g1 = new Girl();
		Girl g2 = new Girl();
		Girl g3 = new Girl();
		
		Robot r1 = new Robot("Yshesh");
		Robot r2 = new Robot("WhizRobo");
		
		
		System.out.println("Human Population : " + Human.HumanPopulation);
		System.out.println("Robo Population : " + Robot.RobotPopulation);
		System.out.println("Population of Boys : " + Boy.BoyPopulation);
		System.out.println("Population of Gils : " + Girl.GirlPopulation);
		
		r1.walking();
		b1.talking();
		r2.talking();
	}
}
