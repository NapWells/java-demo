package orderSystemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import beans.Client;
import beans.ClientStatus;
import beans.ClientType;
import beans.User;

public class UserDAO {
	
	public static User signup(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
        String sql = "INSERT INTO `user` (`username`, `password`,`email`,`phone`) VALUES (?,?,?,?)";

        try {
        	conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3,user.getEmail());
            pstmt.setString(4,user.getPhone());
            int affectRows = pstmt.executeUpdate();
            
            if (affectRows > 0) {
                return login(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnection.cleanup(conn,pstmt, null);
        }

        return null;
    }
    public static boolean isUsernameExists(String username){
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement("select * from user where username = ?");
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
		return false;
	}
    public static User login(User user) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        User newUser = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                long id = rs.getLong("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                long clientId = rs.getLong("client_id");
                newUser = new User(id,username,password,email,phone,getClientForId(clientId));
            }
          
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
        return newUser;
    }
    
    public static Client getClientForId(long clientId){
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	Client client = null;
    	try {
    		String sql = "select * from client where id = ?";
   
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,clientId);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				long id = rs.getLong("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				long  clientTypeId = rs.getLong("client_type_id");
				long  clientStatusId = rs.getLong("client_status_id");
				client = new Client(id,name,phone,getClientTypeForId(clientTypeId),getClientStatusForId(clientStatusId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return client;
    }
    public static ClientType getClientTypeForId(long client_type_id){
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	ClientType clientType = null;
    	try {
    		String sql = "select * from client_type where id = ?";
   
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,client_type_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				long id = rs.getLong("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				String description = rs.getString("description");
				clientType = new ClientType(id,code,name,description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return clientType;
    }
    
    public static ClientStatus getClientStatusForId(long clientStatusId){
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	ClientStatus clientStatus = null;
    	try {
    		String sql = "select * from client_status where id = ?";
   
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,clientStatusId);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				long id = rs.getLong("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				String description = rs.getString("description");
				clientStatus = new ClientStatus(id,code,name,description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return clientStatus;
    }
    
    public static User updateUser(User user){
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "update user set username = ?,password = ?,email = ?,phone = ?,client_id = ? where id = ?";
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPhone());
			pstmt.setLong(5, user.getClient().getId());
			pstmt.setLong(6, user.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, null);
        }
    	return user;
    }
    
    public static User searchByUsername(String username){
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	User user = null;
    	String sql = "select * from user where username = ?";
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username );
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				username = rs.getString("username");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				long clientId = rs.getLong("client_id");
				user = new User(id,username,email,phone,getClientForId(clientId));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, null);
        }
    	return user;
    }
}
