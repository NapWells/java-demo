package practise11;

public class Address {
	private String addressName;
	private String zipCode;
	public Address(String addressName, String zipCode) {
		this.addressName = addressName;
		this.zipCode = zipCode;
	}
	public String getAddressName() {
		return addressName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public int hashCode() {
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Address))
			return false;
		Address address = (Address) obj;
		if(this.getAddressName().equals(address.getAddressName())&&this.getZipCode().equals(address.getZipCode()))
			return true;
		else
			return false;
	}
	
}
