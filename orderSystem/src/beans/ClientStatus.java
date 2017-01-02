package beans;

import java.util.ArrayList;
import java.util.List;

public class ClientStatus {
	private long id;
	private String code;
	private String name;
	private String description;

	private List<Client> clients;
	public ClientStatus(long id, String code, String name, String description) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		clients = new ArrayList<>();
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
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	@Override
	public String toString() {
		return "ClientStatus [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
