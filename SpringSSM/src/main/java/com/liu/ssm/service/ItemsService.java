package com.liu.ssm.service;

import java.util.List;

import com.liu.ssm.pojo.ItemsCustom;
import com.liu.ssm.pojo.ItemsQueryVo;


public interface ItemsService {
	
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception;
	
	public ItemsCustom findItemsById(int id) throws Exception;
	
	public void updateItems(Integer id,ItemsCustom itemsCustom)throws Exception;

}
