package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
//	public  String getProperty(String key){
//		try {
//			Properties prop = new Properties();
//			prop.load(new FileInputStream("resources/jdbc.properties"));
//			return prop.getProperty(key);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
//	public void loadDriverClass() throws ClassNotFoundException{
//			Class.forName(getProperty("db.driver"));
//	}
	public Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/waimai?useSSL=false";
		String username = "root";
		String password = "000000";
		return DriverManager.getConnection(url,username,password);
	}
	public  void cleanup(Connection conn,PreparedStatement pstmt , ResultSet rs){
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		if(pstmt !=null)
			try {
				pstmt.close();
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
}
