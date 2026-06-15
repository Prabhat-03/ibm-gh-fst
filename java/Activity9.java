package fst;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Abc");
		myList.add("Def");
		myList.add("Ghi");
		myList.add(2, "Yshesh");
		myList.add("Xyz");
		
		System.out.println(myList.get(2));
		System.out.println(myList.contains("Yshesh"));
		System.out.println(myList.size());
		
		System.out.println(myList.remove("Ghi"));
		System.out.println(myList.size());
		System.out.println(myList);
	}

}
