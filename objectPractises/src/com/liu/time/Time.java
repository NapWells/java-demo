package com.liu.time;

public class Time {
	private int hour;
	private int minute;
	private int second;
	public Time(int hour, int minute, int second) {
		if(hour>=1&&hour<=24)
			this.hour = hour;
		else
			System.out.println("no imput invalidation needed");
		if(minute>=1&&minute<60)
			this.minute = minute;
		else
			System.out.println("no imput invalidation needed");
		if(second>=1&&second<60)
			this.second = second;
		else
			System.out.println("no imput invalidation needed");
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		hour = hour%24;
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute/60>0)
			this.setHour(this.getHour()+minute%60);
		else if(minute<60&&minute>0)
			this.minute = minute;
		else
			System.out.println("no input validation need");
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second/60>0)
			this.second = second%60;
		else if(second<60&&second>0)
			this.second = second;
		else
			System.out.println("no input validation need");
	}
	public void setTime(int hour, int minute, int second){
		this.setHour(hour);
		this.setMinute(minute);
		this.setHour(second);
	}
	public Time nextSecond(){
		return new Time(this.getHour(),this.getMinute(),this.getSecond()+1);
	}
	public Time previousSecond(){
		return new Time(this.getHour(),this.getMinute(),this.getSecond()-1);
	}
	public String toString() {
		return hour+":"+minute+":"+second+" with leading zero";	
	}
}
