package com.liu.ssm.dao;

import java.util.List;

import com.liu.ssm.pojo.ItemsCustom;
import com.liu.ssm.pojo.ItemsQueryVo;

public interface ItemsMapperCustom {
	//��Ʒ�Ĳ�ѯ�б�
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception;

}
