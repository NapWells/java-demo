package practise5;

public class Student implements Comparable<Student>{
	private String name;
	private int score1;
	private int score2;
	private int score3;
	public Student(String name, int score1, int score2, int score3) {
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
	}
	public String getName() {
		return name;
	}
	public int getScore1() {
		return score1;
	}
	public int getScore2() {
		return score2;
	}
	public int getScore3() {
		return score3;
	}
	public int sumScore(){
		return score1 + score2 + score3; 
	}
	@Override
	public int compareTo(Student s) {
		if(this.sumScore()<=s.sumScore())
			return 1;
		else
			return -1;
	}
}


