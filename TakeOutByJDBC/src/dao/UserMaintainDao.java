package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBConnection.DBConnect;
import pojo.User;
import util.FormatDatetime;

public class UserMaintainDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	
	public boolean register(String telphone,String email,String username,String passwrod){
		DBConnect dbconn = new DBConnect();
		try {
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into `user` (telphone,create_time,email,username,password) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, telphone);
			pstmt.setString(2,FormatDatetime.getStringDatetime());
			pstmt.setString(3, email);
			pstmt.setString(4, username);
			pstmt.setString(5, passwrod);
			pstmt.executeUpdate();
			conn.commit();
			return true;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbconn.cleanup(conn, pstmt, null);
		}
		return false;
	}
	
	public boolean updateUser(User user){
		boolean result = false;
		DBConnect dbconn = new DBConnect();
		String sql = "update `user` set name = ?,telphone = ?,address = ?,user_type_id = ?,email = ?,username = ?,password = ? where id = ?";
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getTelphone());
			pstmt.setString(3, user.getAddress());
			pstmt.setInt(4, user.getUserType());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getUsername());
			pstmt.setString(7, user.getPassword());
			pstmt.setInt(8, user.getUserId());
			int affecRow = pstmt.executeUpdate();
			if(affecRow == 1)
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, null);
		}
		return result;
	}
}
