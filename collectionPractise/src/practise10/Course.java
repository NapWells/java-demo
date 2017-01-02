package practise10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Course {
	public static void main(String []args){
		Map<String,String> map = new HashMap<String,String>();
		map.put("Tom", "CoreJava");
		map.put("John", "Oracle");
		map.put("Susan", "Oracle");
		map.put("Jerry", "JDBC");
		map.put("Jim", "Unix");
		map.put("Kevin", "Jsp");
		map.put("Lucy", "Jsp");
		
		map.put("Allen", "JDBC");
		map.put("Lucy","CoreJava");
		for(Map.Entry<String,String> entry:map.entrySet()){
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"\t"+value);
		}
		System.out.println("=============================");
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String,String> entry = (Entry<String, String>) it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			if(value.equals("Jsp"))
				System.out.println(key+"\t"+value);
		}
		System.out.println(map.keySet());
		System.out.println(map.values());
	}
}
