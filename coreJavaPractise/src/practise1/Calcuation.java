package practise1;

import java.util.Random;

public class Calcuation {
	public static void main(String [] args){
		Random rand = new Random();
		int[] n = new int[10];
		for(int i = 0; i<n.length; i++){
			n[i] = rand.nextInt(1000);
			System.out.print(n[i]+" ");
		}
		System.out.println();
		System.out.println("最大值为 ： " + getMaxNum(n));
		System.out.println("和值 ： " + getSum(n));
		System.out.println("平均值为 ： " + getSum(n)/(double)n.length);
	}
	public static int getMaxNum(int []n){
		int max = 0;
		for(int i = 0;i<n.length;i++){
			if(n[i]>max)
				max = n[i];
		}
		return max;
	}
	
	public static int getSum(int []n){
		int sum = 0;
		for(int i=0;i<n.length;i++){
			sum += n[i];
		}
		return sum;
	}
}
