package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnect;
import pojo.Address;
import pojo.User;

public class AddressManagerDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public List<Address> getAddressByUser(User user){
		List<Address> listAddress = null;
		DBConnect dbconn = new DBConnect();
		StringBuffer sql = new StringBuffer("select * from `cus_address`");
		if(user!=null){
			sql = sql.append("where consumer_id = "+user.getUserId());
		}else{
			return null;
		}
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			listAddress = new ArrayList<>();
			while(rs.next()){
				int id = rs.getInt("id");
				String address = rs.getString("address");
				int cid = rs.getInt("consumer_id");
				String staticAdd = rs.getString("static_add");
				Address addr = new Address();
				addr.setId(id);
				addr.setName(address);
				addr.setConsumerId(cid);
				addr.setStaticAdd(staticAdd);
				listAddress.add(addr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return listAddress;
	}
}
