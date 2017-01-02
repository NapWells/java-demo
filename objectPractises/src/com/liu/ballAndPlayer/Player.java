package com.liu.ballAndPlayer;

public class Player {
	private int number;
	private float x;
	private float y;
	private float z  =0.0f;
	public Player(int number, float x, float y) {
		this.number = number;
		this.x = x;
		this.y = y;
	}
	public void move(float xDisp,float yDisp,float zDisp){
		x = xDisp;
		y = yDisp;
		z = zDisp;
	}
	
	public void jump(float zDisp){
		z = zDisp;
	}
	public boolean near(Ball ball){
		if(Math.sqrt((ball.getX()-this.x)*(ball.getX()-this.x)+
				(ball.getY()-this.y)*(ball.getY()-this.y)+
				(ball.getZ()-this.z)*(ball.getZ()-this.z))<8)
			return true;
		return false;
				
	}
	public void kick(Ball ball){
		
	}
	
}
