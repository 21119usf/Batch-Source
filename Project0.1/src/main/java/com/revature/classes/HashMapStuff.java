package com.revature.classes;

import java.util.HashMap;
import java.util.Map;

public class HashMapStuff {

	//<key,value>
	static HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	public static void main(String[] args) {
		
		map.put("GOD", true);
		map.put("Kenny", false);
		System.out.println(map.get("GOD"));
		//displays true
		
		if(map.containsKey("Jimbob")) 
			System.out.println("Jimbob exists");
		if(map.containsValue(false)) 
			System.out.println("theres definitly a false boolean");
		
		for(String String : map.keySet()) 
		{
			System.out.println("string");
		}
		
		for(Boolean b: map.values()) 
		{
			System.out.println("boolean");
		}
		
		for(Map.Entry kv: map.entrySet()) 
		{
			
		}
		//map.remove("Kenny");
		if(map.containsKey("Kenny")) 
			System.out.println("Kenny exists");
		else
			System.out.println("Kenny doesn't exist");
		
	}

}
