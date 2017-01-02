package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DBConnection.DBConnect;
import pojo.ClassHasMerchants;
import pojo.Clazz;
import pojo.Merchant;

public class MerchantsQueryDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public List<Clazz> getAllMerchantsCLass(){
		DBConnect dbconn = new DBConnect();
		List<Clazz> result = null;
		String sql = "select * from `class`";
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<>();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Clazz clazz = new Clazz();
				clazz.setId(id);
				clazz.setName(name);
				result.add(clazz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return result;
		
	}
	
	public List<Merchant> getAllMerchant(){
		List<Merchant> listMerchant = null;
		DBConnect dbconn = new DBConnect();
		String sql = "select * from merchants";
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			listMerchant = new ArrayList<>();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String telphone = rs.getString("telphone");
				String address = rs.getString("address");
				Date createDatetime = rs.getDate("create_time");
				int m_states_id = rs.getInt("m_status_id");
				int minSendPrice = rs.getInt("min_send_price");
				int sendPrice = rs.getInt("send_price");
				String picture = rs.getString("picture");
				Merchant m = new Merchant();
				m.setId(id);
				m.setName(name);
				m.setTelphone(telphone);
				m.setAddress(address);
				m.setCreateDatetime(createDatetime);
				m.setM_states_id(m_states_id);
				m.setMinSendPrice(minSendPrice);
				m.setSendPrice(sendPrice);
				m.setPicture(picture);
				listMerchant.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return listMerchant;
	}

	public List<ClassHasMerchants> getListMerchantByClassId(int id) {
		DBConnect dbconn = new DBConnect();
		List<ClassHasMerchants> result = null;
		String sql = "select * from `class_has_merchants` where class_id = ?";
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<>();
			while(rs.next()){
				int classId = rs.getInt("class_id");
				int merchantId = rs.getInt("merchants_id");
				ClassHasMerchants chm = new ClassHasMerchants();
				chm.setClassId(classId);
				chm.setMerchantId(merchantId);
				result.add(chm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return result;
	}

	public Merchant getMerchantById(int merchantId) {
		DBConnect dbconn = new DBConnect();
		Merchant merchant = null;
		String sql = "select * from merchants where id = ?";
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, merchantId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String telphone = rs.getString("telphone");
				String address = rs.getString("address");
				Date creatTime = rs.getDate("create_time");
				int mstatusId = rs.getInt("m_status_id");
				int minSendPrice = rs.getInt("min_send_price");
				int sendPrice = rs.getInt("send_price");
				String picture = rs.getString("picture");	
				merchant = new Merchant();
				merchant.setId(id);
				merchant.setName(name);
				merchant.setTelphone(telphone);
				merchant.setAddress(address);
				merchant.setCreateDatetime(creatTime);
				merchant.setM_states_id(mstatusId);
				merchant.setMinSendPrice(minSendPrice);
				merchant.setSendPrice(sendPrice);
				merchant.setPicture(picture);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return merchant;
	}

	public Clazz getClassById(int classId) {
		DBConnect dbconn = new DBConnect();
		Clazz clazz = null;
		String sql = "select * from `class` where id = ?";
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				clazz = new Clazz();
				clazz.setId(id);
				clazz.setName(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return clazz;
	}
}
