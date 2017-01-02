package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBConnect;
import pojo.User;

public class UserQueryDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public User queryUser(int id,String phone,String emaill,String username){
		User user = null;
		DBConnect dbconn = new DBConnect();
		String sql = "select * from `user` where id = ? or telphone = ? or email = ? or username = ?";
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, phone);
			pstmt.setString(3, emaill);
			pstmt.setString(4, username);
			rs = pstmt.executeQuery();
			while(rs.next()){
				user = new User();
				int userId = rs.getInt("id");
				String name = rs.getString("name");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				String address = rs.getString("address");
				Date createTime = rs.getDate("create_time");
				String email = rs.getString("email");
				int userTypeId = rs.getInt("user_type_id");
				String telphone = rs.getString("telphone");
				user.setUserId(userId);
				user.setName(name);
				user.setUsername(userName);
				user.setPassword(password);
				user.setAddress(address);
				user.setCreateTime(createTime);
				user.setEmail(email);
				user.setUserType(userTypeId);
				user.setTelphone(telphone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return user;
	}
	
	public boolean isUserExist(String condition){
		boolean result = false;
		DBConnect dbconn = new DBConnect();
		String sql = "select * from `user` where telphone = ? or username = ? or email = ?";
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, condition);
			pstmt.setString(2, condition);
			pstmt.setString(3, condition);
			rs = pstmt.executeQuery();
			if(rs.next())
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return result;
	}
	
	public User login(String telphone,String username,String email,String password){
		User user = null;
		DBConnect dbconn = new DBConnect();
		String sql = "select * from `user` where telphone = ? or username = ? or email = ?  and password = ?";
		if(isUserExist(telphone)||isUserExist(username)||isUserExist(email)){
			try {
				conn = dbconn.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, telphone);
				pstmt.setString(2, username);
				pstmt.setString(3, email);
				pstmt.setString(4, password);
				rs = pstmt.executeQuery();
				if(rs.next())
					user = queryUser(-1,telphone,email,username );
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				dbconn.cleanup(conn, pstmt, rs);
			}
		}
		return user;
	}
}
