package com.liu.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.liu.ssm.pojo.ItemsCustom;
import com.liu.ssm.service.impl.ItemsServiceImpl;

@Controller
public class ItemsController {
	
	@Autowired
	@Qualifier("itemsService")
	private ItemsServiceImpl itemsService;
	@RequestMapping("/quertyItems")
	public ModelAndView quertyItemsList()
			throws Exception {
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("itemsList", itemsList);
			modelAndView.setViewName("/WEB-INF/jsp/itemsList.jsp");
			return modelAndView;
	}
}
