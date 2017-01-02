package coreJavaTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	public static List<Info> infoList = new ArrayList<Info>();
	
	public static void readInfo(){
		try {
			File file = new File("info.txt");
			FileReader reader = new FileReader(file);
			BufferedReader in = new BufferedReader(reader);
			String line = in.readLine();
			while(line!=null){
				if(line.charAt(0)!='#'){
					String [] str = line.split("，");
					infoList.add(new Info(str[0],str[1],Integer.parseInt(str[2]),str[3],str[4]));
					line = in.readLine();
				}
				else{
					line = in.readLine();
				}
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//3------------------------------
	public static void ls(String ... arg){
		if(arg.length==2)
			for(Info info : infoList)
				if(info.getID().equals(arg[1]))
					System.out.println(info);
		if(arg.length==3&&"-all".equals(arg[1])){
			String id = arg[2];
			for(int i=0;i<infoList.size();i++){
				if(infoList.get(i).getID().equals(id)){
					System.out.println(infoList.get(i));
				}
				if(infoList.get(i).getSubID().equals(id)){
					System.out.println(infoList.get(i));
					id = infoList.get(i).getSubID();
				}
			}
		}
		if(arg.length==2&&"-all".equals(arg[1]))
			for(Info info: infoList)
				System.out.println(info);
	}
	
	//4
	public static void find(String ...arg){
		if(arg.length==3&&arg[1].equals("-name")){
			for(int i = 0; i<infoList.size();i++){
				if(infoList.get(i).getName().indexOf(arg[2])!=-1){
					System.out.println(infoList.get(i));
				}
			}
		}
		if(arg.length==3&&arg[1].equals("-salary")&&arg[2].matches("\\d+")){
			for(int i = 0; i<infoList.size();i++){
				if(infoList.get(i).getAverageSalory()>Integer.parseInt(arg[2]))
					System.out.println(infoList.get(i));
			}
		}
		if(arg.length==3&&arg[1].equals("-salary")&&arg[2].matches("\\d+~\\d+")){
			for(int i = 0; i<infoList.size();i++){
				if(infoList.get(i).getAverageSalory()>=Integer.parseInt(arg[2].split("~")[0])&&
						infoList.get(i).getAverageSalory()<=Integer.parseInt(arg[2].split("~")[1]))
					System.out.println(infoList.get(i));
			}
		}
	}
	
	
	public static void sort(String ...arg){
		if(arg.length==2&&arg[1].equals("-name")){
			Set<Info> infoSet = new TreeSet<Info>(new SortInfoByName());
			for(int i = 0;i<infoList.size();i++)
				infoSet.add(infoList.get(i));
			for(Info info : infoSet)
				System.out.println(info);
		}
		if(arg.length==2&&arg[1].equals("-salary")){
			Set<Info> infoSet = new TreeSet<Info>(new SortInfoBySalary());
			for(int i = 0;i<infoList.size();i++)
				infoSet.add(infoList.get(i));
			for(Info info : infoSet)
				System.out.println(info);
		}
	}
	
	public static  void printHelp(){
		System.out.println("exit: 输入exit可以推出程序");
		System.out.println("help: 可以输出所有的可用命令，以及命令的 使用规则");
		System.out.println("ls:   输入ls[-all][ID]可以输出[对应ID]记录的基本[详细]信息。-all，ID参数为可选项。");
		System.out.println("find: 输入find[-name|salary][value]可以搜索并答应按[名字|平均收入]为条件的记录。"
				+ "-name或-salary,以及value不能为空。find -salary搜索条件的取值必须符合\"全数字\"或者\"数组~数组\"");
		System.out.println("sort: 输入sort[-name|salary]可以输出按[名字|平均收入]排序后的基本信息，-name和-salary为可选项");
	}
	
	
	public static void main(String [] args){
		readInfo();
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("请输入命令：");			
			String s = in.nextLine();
			if(s.equals("exit")){
				System.out.println("程序 结束");
				in.close();
				System.exit(0);
			}
			else if(s.equals("help")){
					printHelp();
			}
			else if(s.matches("ls\\s(-all){0,1}\\s{0,1}\\d{0,2}")){
				ls(s.split(" "));
			}
			else if(s.matches("find\\s(-name|-salary)\\s([\u4e00-\u9fa5]+|\\d+|\\d+~\\d+)")){
				find(s.split(" "));
			}
			else if(s.matches("sort\\s(-name|-salary)")){
				sort(s.split(" "));
			}
			else{
				System.out.println("输入错误："+s+",请重试！");
			}
		System.out.println();	
		}
				
	}
}
