package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import DBConnection.DBConnect;
import pojo.Goods;

public class GoodsQueryDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public List<Goods> getListGoodsByMerchantId(int merchantId){
		List<Goods> listGoods = null;
		DBConnect dbconn = new DBConnect();
		String sql ="select * from `goods` where merchants_id = ?";
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, merchantId);
			rs = pstmt.executeQuery();
			listGoods = new ArrayList<>();
			while(rs.next()){
				int 	id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String description = rs.getString("describe");
				String imgUrl = rs.getString("img_url");
				Goods good = new Goods();
				good.setId(id);
				good.setName(name);
				good.setDescription(description);
				good.setPrice(price);
				good.setImgUrl(imgUrl);
				good.setMerchantId(merchantId);
				listGoods.add(good);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return listGoods; 
	}
	
	public Map<Goods,Integer> getListGoodsByOrderId(long orderId){
		Map<Goods,Integer> mapGoods = null;
		DBConnect dbconn = new DBConnect();
		String sql ="select `goods`.*,num from `goods`,`goods_has_order` where "
				+ "`goods`.id = `goods_has_order`.goods_id and order_id = ?";
		try {
			conn = dbconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, orderId);
			rs = pstmt.executeQuery();
			mapGoods = new LinkedHashMap<>();
			while(rs.next()){
				int 	id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String description = rs.getString("describe");
				String imgUrl = rs.getString("img_url");
				int merchantId = rs.getInt("merchants_id");
				int num = rs.getInt("num");
				Goods good = new Goods();
				good.setId(id);
				good.setName(name);
				good.setDescription(description);
				good.setPrice(price);
				good.setImgUrl(imgUrl);
				good.setMerchantId(merchantId);
				mapGoods.put(good, num);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbconn.cleanup(conn, pstmt, rs);
		}
		return mapGoods; 
	}
	
}
