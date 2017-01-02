package beans;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private long id;
	private String code;
	private String name;
	private int price;
	private boolean idDelete;
	private ProductUnit pruductUnit;
	private Catalog catalog;
	private List<OrderItem> orderItems;
	public Product(){}
	public Product(long id, String code, String name, int price, ProductUnit pruductUnit, Catalog catalog) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.pruductUnit = pruductUnit;
		this.catalog = catalog;
		orderItems = new ArrayList<>();
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
	
	public boolean isIdDelete() {
		return idDelete;
	}
	public void setIdDelete(boolean idDelete) {
		this.idDelete = idDelete;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ProductUnit getPruductUnit() {
		return pruductUnit;
	}
	public void setPruductUnit(ProductUnit pruductUnit) {
		this.pruductUnit = pruductUnit;
	}
	public Catalog getCatalog() {
		return catalog;
	}
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", price=" + price + "]";
	}
}
