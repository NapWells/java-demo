package com.liu.ballAndContainer;

public class Container {
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	public Container(int x, int y, int width, int height) {
		x1 = x;
		y1 = height;
		x2 = x+width;
		y2 = y1 - height;
	}
	public int getX() {
		return x1;
	}
	public int getY() {
		return y1;
	}
	public int getWidth(){
		return Math.abs(x2-x1);
	}

	public int getHeight(){
		return Math.abs(y2-y1);
	}
	public boolean collides(Ball ball){
		if (ball.getX() - ball.getRadius() <= this.x1 ||
			       ball.getX() - ball.getRadius() >= this.x2) {
			      ball.reflectHorizontal();
			      return true;
			   }
		else if (ball.getY() - ball.getRadius() <= this.y1 ||
			       ball.getY() - ball.getRadius() >= this.y2) {
			      ball.reflectVertical();
			      return true;
			   }
		return false;
	}
}
