package com.liu.hibernate.beans;


public class Apartment {
	private int id;
	
	private int building;
	
	private int floor;
	
	private int room;
	
	private int bed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuilding() {
		return building;
	}
	public void setBuilding(int building) {
		this.building = building;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	@Override
	public String toString() {
		return "Apartment [id=" + id + ", building=" + building + ", floor=" + floor + ", room=" + room + ", bed=" + bed
				+ "]";
	}
	
	
}
