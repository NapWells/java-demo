package beans;

public class OrderItem {
	private long id;
	private int amount;
	private String memo;
	private Order order;
	private Product product;
	public OrderItem(long id, int amount, String memo, Order order, Product product) {
		this.id = id;
		this.amount = amount;
		this.memo = memo;
		this.order = order;
		this.product = product;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
