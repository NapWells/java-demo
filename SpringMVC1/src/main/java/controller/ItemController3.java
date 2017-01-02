package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Items;

@Controller
public class ItemController3{

	@RequestMapping("/quertyItemsList.action")
	public ModelAndView quertyItemsList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Items> itemsList = new ArrayList<Items>();
	
			Items items_1 = new Items();
			items_1.setName("����ʼǱ�");
			items_1.setPrice(6000f);
			items_1.setCreatetime(new Date());
			items_1.setDetail("ThinkPad T430 ����ʼǱ����ԣ�");
	
			Items items_2 = new Items();
			items_2.setName("ƻ���ֻ�");
			items_2.setPrice(5000f);
			items_2.setDetail("iphone6ƻ���ֻ���");
	
			itemsList.add(items_1);
			itemsList.add(items_2);
			
//			//��������䵽request
//			request.setAttribute("itemsList", itemsList);
//			
//			//ת����jspҳ��
//			request.getRequestDispatcher("/WEB-INF/jsp/itemsList.jsp").forward(request,response);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("itemsList", itemsList);
			modelAndView.setViewName("/WEB-INF/jsp/itemsList.jsp");
			return modelAndView;
	}


}
