package beans;

import java.util.ArrayList;
import java.util.List;

public class Payment {
	private long id;
	private PaymentStatus paymentStatus;
	private Order order;
	private List<PaymentMethod> paymentMthods;
	public Payment(long id, PaymentStatus paymentStatus, Order order) {
		this.id = id;
		this.paymentStatus = paymentStatus;
		this.order = order;
		paymentMthods = new ArrayList<>();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<PaymentMethod> getPaymentMthods() {
		return paymentMthods;
	}
	public void setPaymentMthods(List<PaymentMethod> paymentMthods) {
		this.paymentMthods = paymentMthods;
	}
	
	
	
}
	