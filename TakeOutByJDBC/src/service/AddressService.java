package service;

import java.util.List;

import dao.AddressManagerDao;
import pojo.Address;
import pojo.User;

public class AddressService {
	public List<Address> getAddressByUser(User user){
		AddressManagerDao amd = new AddressManagerDao();
		return amd.getAddressByUser(user);
	}
	
}
