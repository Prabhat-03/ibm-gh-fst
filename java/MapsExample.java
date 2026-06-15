package fst;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class MapsExample {

    public static void main(String[] args) {
        // Creating a map using the HashMap
        Map<String, Integer> numbers = new HashMap<>();
        
        // Insert elements to the map
        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Dozen", 12);
        
        System.out.println("Map: " + numbers);

        // Access keys of the map
        System.out.println("Keys: " + numbers.keySet());

        // Access values of the map
        System.out.println("Values: " + numbers.values());

        // Access entries of the map
        System.out.println("Entries: " + numbers.entrySet());
        System.out.println("Value associated with Key:" + numbers.get("Dozen"));

        
        
        Iterator<Map.Entry<String, Integer>> iterator = numbers.entrySet().iterator();
        while(iterator.hasNext()) {
        	Map.Entry<String, Integer> e = iterator.next();
        	System.out.println("Key = " + e.getKey() + " Value = " + e.getValue());
        }
        
        
        // Remove Elements from the map
        int value = numbers.remove("Two");
        System.out.println("Removed Value: " + value);
    }
}
