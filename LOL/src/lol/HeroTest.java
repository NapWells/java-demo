package lol;

import java.util.Random;

public class HeroTest {
	//移除已经死亡的英雄
	public static Hero [] removeHero(Hero [] heros,Hero hero){
		Hero []result = new Hero[heros.length-1];
		int id = 0;
		for(int i=0;i<heros.length;i++){
			if(heros[i] == hero){
				continue;
			}
			result[id++]=heros[i];
				
		}
		return result;
	}
	public static void main(String [] args){
//		//两人对战
//		Hero h1 = new Hero("赵信",Camp.RED);
//		h1.print();
//		Hero h2 = new Hero("剑圣",Camp.RED);
//		h2.print();
//		System.out.println("---------------");
//		do{
//			h1.hit(h2);
//			h2.hit(h1);
//			h1.print();
//			h2.print();
//			System.out.println("---------------");
//			if(h1.getBlood()==0){
//				System.out.println(h1.getName()+"已经阵亡");
//				break;
//			}
//			if(h2.getBlood()==0){
//				System.out.println(h2.getName()+"已经阵亡");
//				break;
//			}
//		}while(true);
//	
		
//5V5对战		
		Hero []herosRed = {new Hero("金克司",Camp.RED),
						   new Hero("凯特林",Camp.RED),
						   new Hero("薇恩",Camp.RED),
						   new Hero("盖伦",Camp.RED),
						   new Hero("拉克丝",Camp.RED)};
		
		Hero []herosBlue = {new Hero("皇子",Camp.BLUE),
						    new Hero("蚂蚱",Camp.BLUE),
				            new Hero("大树",Camp.BLUE),
				            new Hero("雪人",Camp.BLUE),
				            new Hero("船长",Camp.BLUE)};
		for(int i=0;i<5;i++){
			herosRed[i].print();
		}
		System.out.println("---------------------------------------");
		for(int i=0;i<5;i++){
			herosBlue[i].print();
		}
		System.out.println("---------------------------------------");
		Random rand = new Random();
		do{
			do{
				Hero hRed = herosRed[rand.nextInt(herosRed.length)];
				Hero hBlue = herosBlue[rand.nextInt(herosBlue.length)];
				hRed.hit(hBlue);
				hBlue.hit(hRed);
				hRed.print();
				hBlue.print();
				if(hRed.getBlood()==0){
					System.out.println(hRed.getName()+"已经阵亡");
					System.out.println("---------------");
					herosRed = removeHero(herosRed,hRed);
					break;
				}
				if(hBlue.getBlood()==0){
					System.out.println(hBlue.getName()+"已经阵亡");
					System.out.println("---------------");
					herosBlue = removeHero(herosBlue,hBlue);
					break;	
				}
				System.out.println("---------------");
			}while(true);
			if(herosRed.length==0){
				System.out.println("---------------");
				System.out.println("红色方全部阵亡，输掉比赛");
				break;
			}
			if(herosBlue.length==0){
				System.out.println("---------------");
				System.out.println("蓝色方全部阵亡，输掉比赛");
				break;
			}
		}while(true);
	}
}
