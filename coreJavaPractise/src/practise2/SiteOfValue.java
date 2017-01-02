package practise2;

import java.util.Scanner;

public class SiteOfValue {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		System.out.println("input a number that lenth must be less than 5:  ");
		int n = in.nextInt();
		String str[] = {"个位","十位","百位","千位","万位","十万","百万","千万"};
		int i= 0;
		while(n!=0){
			System.out.println(str[i] + ":" + n%10);
			n = n/10;
			i++;
		}
	}
}
