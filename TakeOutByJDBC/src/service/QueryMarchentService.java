package service;

import java.util.List;

import dao.MerchantsQueryDao;
import pojo.Clazz;
import pojo.Merchant;

public class QueryMarchentService {
	public List<Clazz> getAllMerchantsCLass(){
		MerchantsQueryDao dao = new MerchantsQueryDao();
		return dao.getAllMerchantsCLass();
	}
	public List<Merchant> getAllMerchant(){
		MerchantsQueryDao dao = new MerchantsQueryDao();
		return dao.getAllMerchant();
	}
	
	public Merchant getMerchantById(int merchantId) {
		MerchantsQueryDao mqd = new MerchantsQueryDao();
		return mqd.getMerchantById(merchantId);
	}
	
}
