package pojo;


public class Order {
	private long id;
	private String create_Time;
	private int o_status_id;
	private int knight_id;
	private double totalprice;
	private int consumer_id;
	private int merchantId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getCreate_Time() {
		return create_Time;
	}
	public void setCreate_Time(String create_Time) {
		this.create_Time = create_Time;
	}
	public int getO_status_id() {
		return o_status_id;
	}
	public void setO_status_id(int o_status_id) {
		this.o_status_id = o_status_id;
	}
	public int getKnight_id() {
		return knight_id;
	}
	public void setKnight_id(int knight_id) {
		this.knight_id = knight_id;
	}
	public int getConsumer_id() {
		return consumer_id;
	}
	public void setConsumer_id(int consumer_id) {
		this.consumer_id = consumer_id;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", create_Time=" + create_Time + ", o_status_id=" + o_status_id + ", knight_id="
				+ knight_id + ", totalprice=" + totalprice + ", consumer_id=" + consumer_id + ", merchantId="
				+ merchantId + "]";
	}
}
