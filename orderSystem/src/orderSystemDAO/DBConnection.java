package orderSystemDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	static PropertyManager manager = PropertyManager.getInstance("jdbc.properties");
	public static void loadDriverClass() throws ClassNotFoundException{
			Class.forName(manager.getProperty("db.driver"));
	}
	public static Connection getConnection() throws SQLException{
		String url =manager.getProperty("db.url");
		String username = manager.getProperty("db.username");
		String password = manager.getProperty("db.password");
		return DriverManager.getConnection(url,username,password);
	}
	public static void cleanup(Connection conn,PreparedStatement pstmt , ResultSet rs){
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
