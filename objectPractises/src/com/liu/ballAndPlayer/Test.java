package com.liu.ballAndPlayer;

public class Test {
	public static void main(String [] args){
		Ball ball = new Ball(1,2,3);
		Player player = new Player(11,4,8);
		System.out.println(player.near(ball));
	}
}
