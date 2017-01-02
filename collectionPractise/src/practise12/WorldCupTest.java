package practise12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import practise9.WorldCup;

public class WorldCupTest {
	public static void main(String []args){
		WorldCup w1 = new WorldCup(1,"1930","乌拉圭");
		WorldCup w2 = new WorldCup(2,"1934","意大利");
		WorldCup w3 = new WorldCup(3,"1938","意大利");
		WorldCup w4 = new WorldCup(4,"1950","乌拉圭");
		WorldCup w5 = new WorldCup(5,"1954","德国");
		WorldCup w6 = new WorldCup(6,"1958","巴西");
		WorldCup w7 = new WorldCup(7,"1962","巴西");
		WorldCup w8 = new WorldCup(8,"1966","英格兰");
		WorldCup w9 = new WorldCup(9,"1970","巴西");
		WorldCup w10 = new WorldCup(10,"1974","德国");
		WorldCup w11 = new WorldCup(11,"1978","阿根廷");
		WorldCup w12 = new WorldCup(12,"1982","意大利");
		WorldCup w13 = new WorldCup(13,"1986","阿根廷");
		WorldCup w14 = new WorldCup(14,"1990","德国");
		WorldCup w15 = new WorldCup(15,"1994","巴西");
		WorldCup w16 = new WorldCup(16,"1998","法国");
		WorldCup w17 = new WorldCup(17,"2002","巴西");
		WorldCup w18 = new WorldCup(18,"2006","意大利");
		Map<String,WorldCup> map = new HashMap<String,WorldCup>();
		map.put(w1.getYear(), w1);
		map.put(w2.getYear(), w2);
		map.put(w3.getYear(), w3);
		map.put(w4.getYear(), w4);
		map.put(w5.getYear(), w5);
		map.put(w6.getYear(), w6);
		map.put(w7.getYear(), w7);
		map.put(w8.getYear(), w8);
		map.put(w9.getYear(), w9);
		map.put(w10.getYear(), w10);
		map.put(w11.getYear(), w11);
		map.put(w12.getYear(), w12);
		map.put(w13.getYear(), w13);
		map.put(w14.getYear(), w14);
		map.put(w15.getYear(), w15);
		map.put(w16.getYear(), w16);
		map.put(w17.getYear(), w17);
		map.put(w18.getYear(), w18);
		Scanner in = new Scanner(System.in);
		System.out.println("请输入球队名字：");
		String teamName = in.nextLine();
		String years ="";
		for(Map.Entry<String, WorldCup> entry:map.entrySet()){
			String key = entry.getKey();
			WorldCup value = entry.getValue();
			if(value.getChampion().equals(teamName))
				years+=key+"、";
		}
		if(years.length()==0)
			System.out.println(teamName+"没有获得过世界杯");
		else
			System.out.println(teamName+"获得冠军的年份是"+years);
	}
}

