package orderSystemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.Client;
import beans.IdentifierClient;

public class ClientDAO {
	public static boolean isUsernameExists(String username){
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement("select * from client where username = ?");
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
    public static Client login(IdentifierClient identifierClient) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
        String sql = "SELECT * FROM client WHERE username = ? AND password = ?";
        Client client = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, identifierClient.getUsername());
            pstmt.setString(2, identifierClient.getPassword());
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                long clientTypeId = rs.getLong("client_type_id");
                long clientStatusId = rs.getLong("client_status_id");
                client = new Client(id,name,phone,UserDAO.getClientTypeForId(clientTypeId),UserDAO.getClientStatusForId(clientStatusId));
            }
          
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
        return client;
    }
	public static List<Client> searchAllClients(){
		List<Client> clients = new ArrayList<>();
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from client";
	    try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				Client client = UserDAO.getClientForId(id);
				clients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn,pstmt, null);
        }
		return clients;
	}
	
	public static Client searchClientByName(String name){
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from client where name = ?";
    	Client client = null;
	    try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				client = UserDAO.getClientForId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn,pstmt, null);
        }
		return client;
	}
	
	public static List<Client> searchClientByCode(String code){
		List<Client> clients = new ArrayList<>();
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		String sql = "select c.* from client c,client_status cs  where c.client_status_id = cs.id and cs.code = ? ";
		Client client = null;
		 try {
				conn = DBConnection.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
				while(rs.next()){
					long id = rs.getLong("id");
					client = UserDAO.getClientForId(id);
					clients.add(client);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
	        	DBConnection.cleanup(conn,pstmt, null);
	        }
			return clients;
	}
		
	public static boolean upsertCient(Client client){
		Connection conn = null;
    	PreparedStatement pstmt = null;
		String sqlAdd = "insert into client(name,phone,client_type_id,client_status_id) value(?,?,?,?)";
		String sqlUpdateDelete = "update client set name = ?,phone = ?,client_type_id = ?,client_status_id = ?, is_delate = ? where id = ?";
		try {
			String sql = sqlUpdateDelete;
			if(client.getId()==-1)
				sql = sqlAdd;
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, client.getName());
			pstmt.setString(2, client.getPhone());
			pstmt.setLong(3, client.getClientType().getId());
			pstmt.setLong(4,client.getClientStatus().getId());
			if(client.getId()!=-1){
				if(client.isDelete()){
					pstmt.setInt(5, 1);
				}else{
					pstmt.setInt(5,0);
				}
				pstmt.setLong(6, client.getId());
			}
			int efffectRow = pstmt.executeUpdate();
			if(efffectRow==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn,pstmt, null);
        }
		return false;
	}
	
	public static Client getClientById(long clientId){
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		String sql = "select * from client where id = ? ";
		Client client = null;
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,clientId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				long clientTypeId = rs.getLong("client_type_id");
				long clientStatusId = rs.getLong("client_status_id");
				client = new Client(id,name,phone,UserDAO.getClientTypeForId(clientTypeId),UserDAO.getClientStatusForId(clientStatusId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.cleanup(conn, pstmt, rs);
		}
		return client;
	}
}
