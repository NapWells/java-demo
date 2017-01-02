package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnect;
import pojo.GoodHasOrder;
import pojo.Order;
import util.FormatDatetime;

public class OrderManagerDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	public long createOrder(double totalPrice,int userId,int merchantId){
		long orderId = 0;
		String sql = "insert into `order` (id,creat_time,totalprice,consumer_id,merchants_id) values(?,?,?,?,?)";
		DBConnect dbconn = new DBConnect();
		try {
			long nowtime = System.currentTimeMillis();
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, nowtime);
			pstmt.setString(2, FormatDatetime.getStringDatetime());
			pstmt.setDouble(3, totalPrice);
			pstmt.setInt(4, userId);
			pstmt.setInt(5, merchantId);
			int affectRow = pstmt.executeUpdate();
			if(affectRow == 1)
				orderId = nowtime;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, null);
		}
		return orderId;
	}
	public boolean createGoodsHasOrder(int goods_id,long order_id,int n){
		DBConnect dbconn = new DBConnect();
		String sql = "insert into `goods_has_order`(goods_id,order_id,num) values (?,?,?)";
		boolean result = false;
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods_id);
			pstmt.setLong(2, order_id);
			pstmt.setInt(3, n);
			int affectRow = pstmt.executeUpdate();
			if(affectRow == 1)
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, null);
		}
		return result;
	}
	public GoodHasOrder getGoodsHasOrder(int goods_id,int oreder_id){
		DBConnect dbconn = new DBConnect();
		String sql = "select * from `goods_has_order` where goods_id=? and oreder_id";
		GoodHasOrder result = null;
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods_id);
			pstmt.setInt(2, oreder_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int goodsId = rs.getInt("goods_id");
				int orderId = rs.getInt("oreder_id");
				result = new GoodHasOrder();
				result.setGoods_id(goodsId);
				result.setOreder_id(orderId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return result;
	}
	
	public List<Order> getOrder(long orderId,int merchantId,int userId,int knightId,int oStatusId){
		List<Order> listOrder = null;
		String sql = "select * from `order` where id = ? or merchants_id = ? or consumer_id=? or knight_id=? or o_status_id = ?";
		DBConnect dbconn = new DBConnect();
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, orderId);
			pstmt.setInt(2, merchantId);
			pstmt.setInt(3, userId);
			pstmt.setInt(4, knightId);
			pstmt.setInt(5,oStatusId);
			rs = pstmt.executeQuery();
			listOrder = new ArrayList<>();
			while(rs.next()){
				long id = rs.getLong("id");
				String creatTime = rs.getString("creat_time");
				double totalPrice = rs.getDouble("totalprice");
				int ostatusId = rs.getInt("o_status_id");
				int knightid = rs.getInt("knight_id");
				int userid = rs.getInt("consumer_id");
				int merchantid = rs.getInt("merchants_id");
				Order order = new Order();
				order.setId(id);
				order.setCreate_Time(creatTime);
				order.setTotalprice(totalPrice);
				order.setO_status_id(ostatusId);
				order.setKnight_id(knightid);
				order.setConsumer_id(userid);
				order.setMerchantId(merchantid);
				listOrder.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return listOrder;
	}

	
}
