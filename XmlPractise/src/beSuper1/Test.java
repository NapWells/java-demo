package beSuper1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {
	public static List<Question> listQuestion = new ArrayList<Question>();
	public static List<Answer> listAnswer= new ArrayList<Answer>();
	public static void AskQuestion(Question question){
		listQuestion.add(question);
	}
	public static  void printQuestionList(){
		for(Question question: listQuestion)
			System.out.println(question);
	}
	public static void printAnswerList(){
		for(Answer answer: listAnswer)
			System.out.println(answer);
	}
	public static void printHelp(){
		System.out.println("list:" + "列出所有也问题");
		System.out.println("ask:" + "提问问题");
		System.out.println("answer:" + "回答问题");
		System.out.println("score:" + "当前得分");
		System.out.println("help:" + "查看所有命令及说明");
		System.out.println("exit:" + "退出程序");
		
	}
	public static User createUser(String username){
		return new User(username);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = in.nextLine();
		User user = createUser(username);
		while(true){
			System.out.println("请输入操作命令：");
			String order = in.nextLine();
			if(order.equals("list")){
				printQuestionList();
			}
			
			else if(order.equals("answer")){
				System.out.println("请输入问题的id：");
				int id = Integer.parseInt(in.nextLine());
				for(Question question : listQuestion){
					if(id == question.getId()&&question.isSolved()==true){
						System.out.println("问题已经被解答,请重新选择");
					}
					if(id == question.getId()&&question.isSolved()==false){
						System.out.println("请输入回答：");
						String answer = in.nextLine();
						System.out.println(answer);
						if(answer!=""){
							user.addScore();
							question.setSolved(true);
							listAnswer.add(new Answer(question,answer,user));
						}
						else{
							System.out.println("输入为空,请重新操作");
						}
					}
				}
			}
			
			else if(order.equals("score")){
				System.out.println("当前的得分：" + user.getScore());
			}
			
			else if(order.equals("ask")){
				System.out.println("请输入你的问题:");
				String question = in.nextLine();
				if(question != ""){
					listQuestion.add(new Question(user,question));
					System.out.println("提问成功");
				}
				else
					System.out.println("输入为空，请重新操作");
			}
			
			else if(order.equals("help")){
				printHelp();
			}
			
			else if(order.equals("exit")){
				in.close();
				System.exit(0);
			}
			else if(order.equals("result")){
				printAnswerList();
			}
			else
				System.out.println("输入无效，请重试！");
		}
		
	}

}
