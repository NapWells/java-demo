package beSuper1;

public class Question {
	private User user;
	private static int num = 0;
	private int id = num++;
	private String question;
	private boolean isSolved;
	
	public Question(User user, String question) {
		this.user = user;
		this.question = question;
		isSolved = false;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public boolean isSolved() {
		return isSolved;
	}
	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		if(isSolved == false)
			return "[UNSOLVED] " + id + " .[" + question + "] from "  + user.getUsername();
		else
			return "[SOLVED] " + id + " .[" + question + "] from "  + user.getUsername();
	}
	
}
