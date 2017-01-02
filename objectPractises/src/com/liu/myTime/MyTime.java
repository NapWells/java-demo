package com.liu.myTime;

public class MyTime {
	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	public MyTime() {}
	public MyTime(int hour, int minute, int second) {
		if(hour>=0&&hour<=24&&minute>=0&&minute<60&second>=0&&second<=60){
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour>=0&&hour<=24){
			this.hour = hour;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute>=0&&minute<60){
			this.minute = minute;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second>=0&&second<60){
			this.second = second;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	@Override
	public String toString() {
		String h = "";
		String m = "";
		String s = "";
		if(hour<10)
			h = "0"+String.valueOf(hour);
		else 
			h = String.valueOf(hour);
		if(minute<10)
			m = "0"+String.valueOf(minute);
		else 
			m = String.valueOf(minute);
		if(second<10)
			s = "0"+String.valueOf(second);
		else 
			s = String.valueOf(second);
		return h+":"+m+":"+s;
	}
	public void setTime(int hour, int minute, int second){
		if(hour>=0&&hour<=24&&minute>=0&&minute<60&second>=0&&second<60){
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public MyTime nextSecond(){
		second+=1;
		if(second==60){
			second = 0;
			minute +=1;
			if(minute == 60){
				minute = 0;
				hour+=1;
				if(hour==24)
					hour=0;
			}
		}
		return new MyTime(hour,minute,second);
	}
	public MyTime nextMinute(){
		minute+=1;
		if(minute == 60){
			minute = 0;
			hour+=1;
			if(hour==24)
				hour=0;
		}
		return new MyTime(hour,minute,second);
	}
	public MyTime nextHour(){
		hour+=1;
		if(hour==24)
			hour=0;
		return new MyTime(hour,minute,second);
	}

}
