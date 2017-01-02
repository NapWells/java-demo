package fuShanEscape;

public class GoFusanGame {
	public static void main(String [] args){
		City fuShan = new City("釜山",1500);
		City shouEr = new City("首尔",1600);
		City renChuan = new City("仁川",1300);
		
		Human h1 = new Human("小明");
		Human h2 = new Human("小李");
		Human h3 = new Human("小张");
		
		DeadWalker d1 = new DeadWalker("丧尸1");
		DeadWalker d2 = new DeadWalker("丧尸2");
		DeadWalker d3 = new DeadWalker("丧尸3");
			
		int count = 0;
		
		if(h1.go(fuShan)<d1.go(fuShan)){
			System.out.println(h1.getName()+"取得胜利");
			count++;
		}
		else{
			System.out.println(d1.getName()+"取得胜利");
		}
		
		if(h2.go(shouEr)<d2.go(shouEr)){
			System.out.println(h2.getName()+"取得胜利");
			count++;
		}
		else{
			System.out.println(d2.getName()+"取得胜利");
		}
		
		if(h3.go(renChuan)<d3.go(renChuan)){
			System.out.println(h3.getName()+"取得胜利");
			count++;
		}
		else{
			System.out.println(d3.getName()+"取得胜利");
		}
		
		System.out.println("---------------------------");
		if(count>1){
			System.out.println("人类取得胜利");
		}
		else
			System.out.println("丧尸取得胜利");
	}
}
