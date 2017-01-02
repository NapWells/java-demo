package beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private long id;
	private Date createDatetime;
	private String memo;
	private OrderStatus orderStatus;
	private boolean isDelete;
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	private Client client;
	private List<OrderItem> orderItems;
	public Order(long id, Date createDatetime, String memo, OrderStatus orderStatus, Client client) {
		this.id = id;
		this.createDatetime = createDatetime;
		this.memo = memo;
		this.orderStatus = orderStatus;
		this.client = client;
		orderItems = new ArrayList<>();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", createDatetime=" + createDatetime + ", memo=" + memo + ", isDelete=" + isDelete
				+ "]";
	}
	
}
