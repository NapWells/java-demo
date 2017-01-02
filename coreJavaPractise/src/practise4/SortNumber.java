package practise4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class SortNumber {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		System.out.println("please input number with arbitrarily：");
		String s = in.nextLine();
		System.out.println("input 1 if you want raise sort those number,or input 2 if you want decline sort those number");
		int n = in.nextInt();
		String []str = s.split(",");
		int [] num = new int[str.length];
		for(int i = 0; i<num.length; i++)
			num[i] = Integer.parseInt(str[i]);
		switch(n){
			case 1:
				Arrays.sort(num);
				System.out.print("operation result:");
				for(int i: num)
					System.out.print(i+" ");
				System.out.println();
				break;
			case 2:
				int temp = 0;
				for(int i = 0; i<num.length-1; i++){
					for(int j = i+1; j<num.length;j++)
						if(num[i]<num[j]){
							temp = num[i];
							num[i] = num[j];
							num[j] = temp;
						}
				}
				System.out.print("operation result:");
				for(int i: num)
					System.out.print(i+" ");
				System.out.println();
				break;
			default:
				System.out.println("input error, system will be exit");
				System.exit(0);
		}
		
		File file = new File("sort.txt");
		try {
			Writer writer = new FileWriter(file);
			BufferedWriter output = new BufferedWriter(writer);
			for(int i: num){
				output.write(i+" ");
			}
			output.flush();
			in.close();
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
