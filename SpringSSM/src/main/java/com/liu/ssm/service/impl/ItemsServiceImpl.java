package com.liu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.liu.ssm.dao.ItemsMapper;
import com.liu.ssm.dao.ItemsMapperCustom;
import com.liu.ssm.pojo.Items;
import com.liu.ssm.pojo.ItemsCustom;
import com.liu.ssm.pojo.ItemsQueryVo;
import com.liu.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {

	// 注入mapper
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Autowired
	private ItemsMapper itemsMapper;

	// 商品的查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	public ItemsCustom findItemsById(int id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//写业务代码
		
				//对于关键业务数据的非空校验
				if(id == null){
					//抛出异常，提示调用接口的用户，id不能为空
					//...
				}
				//itemsMapper.updateByPrimaryKey(itemsCustom);
				itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
				
	}

}
