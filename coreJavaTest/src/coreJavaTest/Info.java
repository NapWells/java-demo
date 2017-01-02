package coreJavaTest;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class Info implements Comparable<Info>{
	private String ID;
	private String name;
	private int averageSalory;
	private String subID;
	private String boss;
	public Info(String iD, String name, int averageSalory, String subID, String boss) {
		ID = iD;
		this.name = name;
		this.averageSalory = averageSalory;
		this.subID = subID;
		this.boss = boss;
	}
	public String getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public int getAverageSalory() {
		return averageSalory;
	}
	public String getSubID() {
		return subID;
	}
	public String getBoss() {
		return boss;
	}
	@Override
	public String toString() {
		return ID +"，"+ name +"，"+ averageSalory + "，"+ subID
				+ "，" + boss;
	}

	@Override
	public int compareTo(Info o) {
		return this.getID().compareTo(o.getID());
	}
	
}
class SortInfoByName implements Comparator<Info>{

	@Override
	public int compare(Info o1, Info o2) {
		Collator instance  = Collator.getInstance(Locale.CHINA);
		return instance.compare(o1.getName(),o2.getName());
	}
}
class SortInfoBySalary implements Comparator<Info>{

	@Override
	public int compare(Info o1, Info o2) {
		if(o1.getAverageSalory()>=o2.getAverageSalory())
			return 1;
		else 
			return -1;
	}
}
