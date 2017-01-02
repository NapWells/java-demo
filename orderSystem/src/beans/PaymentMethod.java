package beans;

public class PaymentMethod {
	private long id;
	private String code;
	private String name;
	private String description;
	private Payment payment;
	public PaymentMethod(long id, String code, String name, String description, Payment payment) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.payment = payment;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}
