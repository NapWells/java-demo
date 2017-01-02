package com.liu.PersonAndSubclass;

public class Student extends Person{
	private String program;
	private int year;
	private int see;
	public Student(String name, String address, String program, int year, int see) {
		super(name, address);
		this.program = program;
		this.year = year;
		this.see = see;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSee() {
		return see;
	}
	public void setSee(int see) {
		this.see = see;
	}
	@Override
	public String toString() {
		return "Student [name="+super.getName()+
				",address"+super.getAddress()+",program=" + program + ", year=" + year + ", see=" + see + "]";
	}
	
	
}
