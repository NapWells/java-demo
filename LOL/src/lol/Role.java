package lol;

import java.util.Random;

public abstract class Role {
	private String name;
	private int blood;
	private int attactPower;
	private Camp camp;
	private Random rand  = new Random();
	
	public Role(String name,Camp camp){
		this.name = name;
		blood = rand.nextInt(100)+500;
		attactPower = rand.nextInt(50)+50;
		this.camp = camp;
	}
	
	public Camp getCamp(){
		return camp;
	}
	public String getName(){
		return name;
	}
	
	public int getBlood(){
		return blood;
	}
	public void setBlood(int blood){
		this.blood = blood;
	}
	
	public int getAttackPower(){
		return attactPower;
	}
	public void print(){
		System.out.println("初始血量为："+blood+"，初始攻击力为："+attactPower);
	}
	
	public abstract void hit(Role role);
	public abstract void beHit(int attack);
}
