package com.liu.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.liu.beans.Message;
import com.liu.db.DBAccess;

public class MessageDao {
//	public List<Message> queryMessageList(String command,String description){
//		List<Message> messageList = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/micro_message";
//			Connection conn = DriverManager.getConnection(url,"qingke" ,"000000");
//			
//			StringBuilder sql = new StringBuilder("select * from message where 1 = 1");
//			List<String> paramList = new ArrayList<>();
//			if(command!=null&&!"".equals(command.trim())){
//				sql.append(" and `command` = ?");
//				paramList.add(command);
//			}
//			if(description!=null&&!"".equals(description.trim())){
//				sql.append(" and `description` like '%' ? '%'");
//				paramList.add(description);
//			}
//			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
//			for(int i = 0; i<paramList.size(); i++){
//				pstmt.setString(i+1,paramList.get(i) );
//			}
//			System.out.println(sql);
//			ResultSet rs = pstmt.executeQuery();
//			messageList = new ArrayList<>();
//			while(rs.next()){
//				Message message = new Message();
//				message.setId(rs.getInt("id"));
//				message.setCommand(rs.getString("command"));
//				message.setDescription(rs.getString("description"));
//				message.setContent(rs.getString("content"));
//				messageList.add(message);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		return messageList;
//	}
	
	/**
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> queryMessageList(String command,String description){
		List<Message> massageList = null;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			massageList = sqlSession.selectList("Message.queryMessageList",message);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)
				sqlSession.close();
		}
		return massageList;
	}
	
	public boolean deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		boolean result = false;
		try {
			sqlSession = dbAccess.getSqlSession();
			int effectRow = sqlSession.delete("Message.deleteOne", id);
			if(effectRow!=0)
				result = true;
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null)
				sqlSession.close();
		}
		return result;
	}
	
	public boolean deleteBatch(List<Integer> list){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		boolean result = false;
		try {
			sqlSession = dbAccess.getSqlSession();
			int effectRow = sqlSession.delete("Message.deleteBatch", list);
			sqlSession.commit();
			if(effectRow!=0)
				result =  true;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession != null)
				sqlSession.close();
		}
		return result;
	}
}
