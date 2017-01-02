package pojo;

import java.sql.Date;


public class Merchant {
	private int id;
	private String name;
	private String telphone;
	private String address;
	private Date createDatetime;
	private int m_states_id;
	private int minSendPrice;
	private int sendPrice;
	private String picture;
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getId() {
		return id;
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
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	public int getM_states_id() {
		return m_states_id;
	}
	public void setM_states_id(int m_states_id) {
		this.m_states_id = m_states_id;
	}
	public int getMinSendPrice() {
		return minSendPrice;
	}
	public void setMinSendPrice(int minSendPrice) {
		this.minSendPrice = minSendPrice;
	}
	public int getSendPrice() {
		return sendPrice;
	}
	public void setSendPrice(int sendPrice) {
		this.sendPrice = sendPrice;
	}
}
