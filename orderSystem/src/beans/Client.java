package beans;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private long id;
	private String name;
	private String phone;
	private boolean isDelete;
	private List<User> users;
	private List<Order> orders;
	private ClientType clientType;
	private ClientStatus clientStatus;
	public Client(){};
	public Client(long id, String name, String phone,ClientType clientType,ClientStatus clientStatus) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.clientType = clientType;
		this.clientStatus = clientStatus;
		users = new ArrayList<>();
		orders = new ArrayList<>();
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ClientType getClientType() {
		return clientType;
	}
	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}
	public ClientStatus getClientStatus() {
		return clientStatus;
	}
	public void setClientStatus(ClientStatus clientStatus) {
		this.clientStatus = clientStatus;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

	
	
}
