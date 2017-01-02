package com.easyjava.jdbc.conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class JdbcBatch extends JdbcConn{

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("insert into besuper.player(name,username,password) value (?,?,?)");
			for(int i = 1; i < 20; i++){
				ps.setString(1, "qingke"+i);
				ps.setString(2, "qingke"+i);
				ps.setString(3, "123");
				
				ps.addBatch();
			}
			int [] result  =ps.executeBatch();
			
			System.out.println("result = " + Arrays.toString(result));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
