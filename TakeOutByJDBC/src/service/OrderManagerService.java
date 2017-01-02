package service;

import java.util.ArrayList;
import java.util.List;

import dao.OrderManagerDao;
import pojo.Order;
import pojo.User;

public class OrderManagerService {
	public boolean createOrder(String dishList,String totalPrice,String merchantId,User user ){
		OrderManagerDao omd = new OrderManagerDao();
		List<Integer> goodsIds = new ArrayList<>();
		for(String i : dishList.split(" "))
			goodsIds.add(Integer.parseInt(i));
		long orderId = omd.createOrder(Double.parseDouble(totalPrice), user.getUserId(),Integer.parseInt(merchantId));
		if(goodsIds.size()>0){
			for(int i = 0; i < goodsIds.size(); i=i+2)
				omd.createGoodsHasOrder(goodsIds.get(i), orderId,goodsIds.get(i+1));
			return true;
		}
		return false;
	}
	
	public List<Order> getOrder(long orderId,int merchantId,int userId,int knightId,int oStatusId){
		OrderManagerDao omd = new OrderManagerDao();
		return omd.getOrder(orderId, merchantId, userId, knightId, oStatusId);
	}
	

}
