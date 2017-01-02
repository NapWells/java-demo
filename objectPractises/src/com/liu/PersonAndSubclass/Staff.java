package com.liu.PersonAndSubclass;

public class Staff extends Person{
	private String school;
	private int pay;
	public Staff(String name, String address, String school, int pay) {
		super(name, address);
		this.school = school;
		this.pay = pay;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	@Override
	public String toString() {
		return "Staff [name="+super.getName()+"address"+super.getAddress()+"school=" + school + ", pay=" + pay + "]";
	}
	
}
