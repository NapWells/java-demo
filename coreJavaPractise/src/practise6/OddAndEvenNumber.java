package practise6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddAndEvenNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("input a number");
		int n = in.nextInt();
		int odd = 0;
		int even = 0;
		List<Integer> listOdd = new ArrayList<Integer>();
		List<Integer> listEven = new ArrayList<Integer>();
		if(n%2!=0)
			while(n!=0){
				odd += n%10;
				listOdd.add(n%10);
				n = n/10;
				even += n%10;
				listEven.add(n%10);
				n = n/10;
			}
		else
			while(n!=0){
				even += n%10;
				listEven.add(n%10);
				n = n/10;
				odd += n%10;
				listOdd.add(n%10);
				n = n/10;
			}
		int b [] = {odd,even};
		System.out.print("奇数位b[0]=");
		for(int i = listOdd.size()-1; i>=0;i--){
			if(i==0)
				System.out.print(listOdd.get(i)+"=");
			else
				System.out.print(listOdd.get(i)+"+");
		}
		System.out.println(odd);
		System.out.println();
		
		System.out.print("偶数位b[1]=");
		for(int i =listEven.size()-1;i>=0;i--){
			if(i == 0)
				System.out.print(listEven.get(i)+"=");
			else
				System.out.print(listEven.get(i)+"+");
		}
		System.out.println(even);
	}

}
