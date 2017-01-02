package pojo;

public class Address {
	private int id;
	private String name;
	private int consumerId;
	private String staticAdd;

	public int getId() {
		return id;
	}
	public String getStaticAdd() {
		return staticAdd;
	}
	public void setStaticAdd(String staticAdd) {
		this.staticAdd = staticAdd;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

}
