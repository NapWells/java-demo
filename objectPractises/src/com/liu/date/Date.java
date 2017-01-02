package com.liu.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) {
		if(day>=1&&day<31)
			this.day = day;
		else
			System.out.println("no imput invalidation needed");
		if(month>=1&&month<12)
			this.month = month;
		else
			System.out.println("no imput invalidation needed");
		if(year>=1990&&year<9999)
			this.year = year;
		else
			System.out.println("no imput invalidation needed");
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(day>=1&&day<31)
			this.day = day;
		else
			System.out.println("no imput invalidation needed");
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month>=1&&month<12)
			this.month = month;
		else
			System.out.println("no imput invalidation needed");
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year>=1990&&year<9999)
			this.year = year;
		else
			System.out.println("no imput invalidation needed");
	}
	public void setDate(int day,int month,int year){
		if(day>=1&&day<31)
			this.day = day;
		else
			System.out.println("no imput invalidation needed");
		if(month>=1&&month<12)
			this.month = month;
		else
			System.out.println("no imput invalidation needed");
		if(year>=1990&&year<9999)
			this.year = year;
		else
			System.out.println("no imput invalidation needed");
	}

	public String toString() {
		return day+"/"+month+"/"+year+" with leading zero";	
	}

}
