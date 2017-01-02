package practise3;

import java.util.Random;

public class MangerSocre {
	public static void main(String [] args){
		String [] courses = {"Java","C++","Ruby","OC","C#"};
		int [][] scores = new int[10][5];
		Random rand = new Random();
		//(1)循环给二维数组的每个元素赋0～100的随机数值
		for(int i = 0; i< scores.length; i++)
			for(int j = 0; j<scores[i].length; j++)
				scores[i][j] = rand.nextInt(100);
		
		//(2)按照列表方式输出这些学员的每门课成绩。
		for(String s : courses)
			System.out.print(s + "\t");
		System.out.println();
		for(int i = 0; i< scores.length; i++){
			for(int j = 0; j<scores[i].length; j++){
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		//(3)算出每个学员的总分，保留在一个数组中。
		int [] eachTotal = new int[10];		
		for(int i = 0; i< scores.length; i++){
			int sum = 0;
			for(int j = 0; j<scores[i].length; j++){
				sum += scores[i][j];
			}
			eachTotal[i] = sum;
		}
		System.out.println("total score of each student:");
		for(int n: eachTotal)
			System.out.print(n + "\t");
		System.out.println();
		
		//(4)求所有学员每门课的平均分。
		int [] eachScore = new int[5];
		for(int i = 0; i< 5; i++){
			int sum = 0;
			for(int j = 0; j<10; j++){
				sum += scores[j][i];
			}
			eachScore[i] =  sum;
		}
		System.out.println();
		System.out.println("average score of each course:");
		for(int n: eachScore)
			System.out.print(n/10.0 + "\t");
		System.out.println();
	}
}
