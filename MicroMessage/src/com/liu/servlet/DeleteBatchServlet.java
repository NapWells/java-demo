package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.service.MaintainService;

public class DeleteBatchServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String [] selectDeletes = req.getParameterValues("selectDelete");
		MaintainService maintainService = new MaintainService();
		boolean isDelete = maintainService.deleteBatch(selectDeletes);
		System.out.println(isDelete);
		if(isDelete){
			req.setAttribute("deleteResult", "删除成功");
			req.getRequestDispatcher("/ListServlet.action").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("/ListServlet.action").forward(req, resp);
		}
		
	}
	

}
