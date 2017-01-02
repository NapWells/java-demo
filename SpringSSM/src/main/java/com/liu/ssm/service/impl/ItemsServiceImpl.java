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

	// ע��mapper
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Autowired
	private ItemsMapper itemsMapper;

	// ��Ʒ�Ĳ�ѯ�б�
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
		//дҵ�����
		
				//���ڹؼ�ҵ�����ݵķǿ�У��
				if(id == null){
					//�׳��쳣����ʾ���ýӿڵ��û���id����Ϊ��
					//...
				}
				//itemsMapper.updateByPrimaryKey(itemsCustom);
				itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
				
	}

}
