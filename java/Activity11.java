package fst;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> colors = new HashMap<>();
		colors.put(1, "Blue");
		colors.put(2, "Green");
		colors.put(3, "Yellow");
		colors.put(4, "Aqua");
		colors.put(5, "Vishesh");
		
		System.out.println(colors.remove(2));
		System.out.println("Checking whether Vishesh exists: " + colors.containsValue("Vishesh"));
		System.out.println("Size : "+ colors.size());
		System.out.println(colors);
	}

}
