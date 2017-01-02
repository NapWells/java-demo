package beSuper1;

public class Answer {
	private Question question;
	private String answer;
	private User user;
	public Answer(Question question, String answer,	User user) {
		this.question = question;
		this.answer = answer;
		this.user = user;
	}
	public Question getQuestion() {
		return question;
	}
	public String getAnswer() {
		return answer;
	}
	public User getUser(){
		return user;
	}
	@Override
	public String toString() {
		return "Answer [question=" + question + ", answer=" + answer + ", user=" + user + "]";
	}
	
}
