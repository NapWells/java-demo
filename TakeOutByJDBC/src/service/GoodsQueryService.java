package service;

import java.util.List;
import java.util.Map;

import dao.GoodsQueryDao;
import pojo.Goods;

public class GoodsQueryService {
	public List<Goods> getListGoodsByMerchantId(int merchantId){
		GoodsQueryDao agd = new	GoodsQueryDao();
		return agd.getListGoodsByMerchantId(merchantId);
	}
	public Map<Goods,Integer> getMapGoodsByOrderId(long orderId){
		GoodsQueryDao gqd = new	GoodsQueryDao();
		return gqd.getListGoodsByOrderId(orderId);
	}
}
