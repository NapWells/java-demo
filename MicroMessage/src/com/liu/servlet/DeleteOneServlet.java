package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.service.MaintainService;

public class DeleteOneServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("deleteOne");
		MaintainService maintainService = new MaintainService();
		boolean isDelete = maintainService.deleteOne(id);
		if(isDelete){
			req.setAttribute("deleteResult", "删除成功");
			req.getRequestDispatcher("/ListServlet.action").forward(req, resp);
		}
		else{
//			req.setAttribute("deleteResult", "删除失败,数据已经被删除了");
			req.getRequestDispatcher("/ListServlet.action").forward(req, resp);
		}
	}

}
