package com.liu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.beans.Message;
import com.liu.service.QueryService;
import com.liu.util.Iconst;

public class AutoReplyServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out  = resp.getWriter();
		QueryService queryService = new QueryService();
		String content = req.getParameter("content");
		if(Iconst.HELP_COMMAND.equals(content)){
			List<Message> listMessage = queryService.queryMessageList(null, null);
			for(int i = 0;i<listMessage.size();i++){
				out.write("回复["+listMessage.get(i).getCommand()+"]:"+listMessage.get(i).getDescription()+"<br>");
			}
		}else
			out.write(queryService.queryByCommand(content));
		out.flush();
		out.close();
	}
	

}
