package practise5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Manager {
	public static void main(String [] args){
		Set<Student> set = new TreeSet<Student>();
		Scanner in =new Scanner(System.in);
		for(int i = 0;i<5;i++){
			System.out.println("请输入第"+(i+1)+"位同学的姓名和三门课的成绩");
			String info = in.nextLine();
			String name = info.split(",")[0];
			int score1 = Integer.parseInt(info.split(",")[1]);
			int score2 = Integer.parseInt(info.split(",")[2]);
			int score3 = Integer.parseInt(info.split(",")[3]);
			Student stu = new Student(name,score1,score2,score3);
			set.add(stu);
		}
		in.close();
		File file = new File("stud.txt");
		FileWriter writer = null;
		BufferedWriter bWriter = null;
		try {
			file.createNewFile();
			writer = new FileWriter(file);
			bWriter = new BufferedWriter(writer);
			for(Student stu : set){
				bWriter.write(stu.getName()+"      "+stu.sumScore());
				bWriter.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
//钱七,70,30,80
//赵六,50,60,70
//王五,50,50,90
//张三,30,40,50
//李四,40,50,40