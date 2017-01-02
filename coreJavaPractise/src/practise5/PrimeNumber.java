package practise5;

import java.util.Random;
import java.util.Scanner;

public class PrimeNumber {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("输入一个整数：");
		int  n = in.nextInt();
		int [] num = new int [n];
		System.out.println("所有的随机数为:");
		for(int i =0 ; i<n ;i++){
			num[i] = rand.nextInt(n);
			System.out.print(num[i]+" ");
		}
		System.out.println();
		System.out.println("不是素数的有:");
		for(int i =0 ; i<n ;i++){
			if(!isPrimeNum(num[i]))
				System.out.print(num[i]+" ");
		}

			
	}
	public static boolean isPrimeNum(int n){
		if(n<2)
			return false;
		boolean mark = true;
		for(int i = 2;i<=Math.sqrt(n); i++){
			if(n%i == 0)
				mark = false;
		}
		return mark;
		
				
	}

}
