package com.easyjava.jdbc.conn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Properties;
import java.util.Scanner;

public class JdbcConn {
	public static void main(String [] args){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/student";
//			conn = DriverManager.getConnection(url,"root" ,"000000");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.getResultSet();
	
			rs = stmt.executeQuery("select * from player");
			
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				int score =rs.getInt("score");
				System.out.println("player : id = " + id + ", name = " + name + ", score = " + score);

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			cleanup(conn, stmt, rs);
		}
		System.out.println("-----------------------------------------------------------");
		
		PreparedStatement  ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement("select * from player where id = ?");
			ps.setInt(1, 2);
			
			rs = ps.executeQuery();
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				int score =rs.getInt("score");
				System.out.println("player : id = " + id + ", name = " + name + ", score = " + score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cleanup(conn, stmt, rs);
		}
		System.out.println("-----------------------------------------------------------");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("username: ");
		String username = scanner.nextLine();
		System.out.println("password: ");
		String password =  scanner.nextLine();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "select * from player where username = '"+username+"' and password = '"+password+"'";
			rs = stmt.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				int score =rs.getInt("score");
				System.out.println("player : id = " + id + ", name = " + name + ", score = " + score);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			cleanup(conn, stmt, rs);
			scanner.close();
		}
	
		
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Enter username pattern: ");
		String pattern = scanner1.nextLine();
		
		CallableStatement cs = null;
		try {
			conn = getConnection();
			cs = conn.prepareCall("call besuper.get_player(?,?)");
			cs.setString(1, pattern);
			cs.registerOutParameter(2,Types.INTEGER);
			cs.execute();
			
			int resultCount = cs.getInt(2);
			System.out.println("count: " + resultCount);
			
			rs = cs.getResultSet();
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				int score =rs.getInt("score");
				System.out.println("player : id = " + id + ", name = " + name + ", score = " + score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cleanup(conn, cs, rs);
			scanner1.close();
		}
		
		
	}
	
	public static void loadDriverClass(){
		try {
			Class.forName(getProperty("db.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			String url = getProperty("db.url");
			String username = getProperty("db.username");
			String password = getProperty("db.password");
			return DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static void cleanup(Connection conn,Statement stmt , ResultSet rs){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		if(stmt !=null)
			try {
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getProperty(String key){
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("jdbc.properties"));
			return props.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
