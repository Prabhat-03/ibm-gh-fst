package fst;

import java.util.HashSet;

public class Activity10 {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("Yshesh");
		hs.add("Vishesh");
		hs.add("Avshesh");
		hs.add("Sandesh");
		hs.add("Ganesh");
		hs.add("Vighnesh");
		hs.add("Vyomkesh");
		hs.add("Vishesh");
		
		System.out.println(hs);
		
		System.out.println(hs.size());
		System.out.println(hs.remove("Vighnesh"));
		System.out.println(hs.contains("Vishesh"));
		System.out.println(hs.remove("Khagendra Lal Chaturvedi"));
		System.out.println(hs);
	}
	
}
