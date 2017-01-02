package orderSystemDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Client;
import beans.Order;
import beans.OrderItem;
import beans.OrderStatus;

public class OrderDAO {
	public static List<Order> searchAllOrder(){
		List<Order> orders = new ArrayList<>();
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from `order`";
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				Date createDatetime = rs.getDate("create_datetime");
				String demo = rs.getString("memo");
				long clientId = rs.getLong("client_id");
				long orderStatusId = rs.getLong("order_status_id");
				boolean isDelete = (rs.getInt("isDelete")==1)?true:false;
				Order order = new Order(id, createDatetime, demo, getOrderStatusById(orderStatusId), UserDAO.getClientForId(clientId));
				order.setDelete(isDelete);
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return orders;
	}
	
	public static List<Order> searchOrderByClient(Client client){
		List<Order> orders = new ArrayList<>();
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from `order` where exists (select * from client where `order`.client_id = client.id and client.id = ?)";
	
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,client.getId());
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				Date createDatetime = rs.getDate("create_datetime");
				String demo = rs.getString("memo");
				long clientId = rs.getLong("client_id");
				long orderStatusId = rs.getLong("order_status_id");
				Order order = new Order(id, createDatetime, demo, getOrderStatusById(orderStatusId), UserDAO.getClientForId(clientId));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return orders;
    }
	
	public static Order searchOrderByItem(OrderItem item){
		Order order = null;
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from order where exists (select * from client where item.client_id = client.id and item.id = ?)";
	
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,item.getId());
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				Date createDatetime = rs.getDate("create_datetime");
				String demo = rs.getString("demo");
				long clientId = rs.getLong("client_id");
				long orderStatusId = rs.getLong("order_status_id");
				order = new Order(id, createDatetime, demo, getOrderStatusById(orderStatusId), UserDAO.getClientForId(clientId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return order;
    }
	
	public static OrderStatus getOrderStatusById(long id){
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from order_status where id = ?";
    	OrderStatus  orderStatus = null;
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String code = rs.getString("code");
				String name = rs.getString("name");
				String description = rs.getString("description");
				orderStatus = new OrderStatus(id, code, name, description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return orderStatus;
	}
	
	public static boolean upsertOrder(Order order){
		Connection conn = null;
    	PreparedStatement pstmt = null;
		String sqlAdd = "insert into `order`(create_datetime,memo,client_id,order_status_id) value(?,?,?,?)";
		String sqlUpdateDelete = "update `order` set create_datetime = ?,memo = ?,client_id = ?,"
				+ "order_status_id = ? ,isDelete = ? where id = ?";
		try {
			String sql = sqlUpdateDelete;
			if(order.getId()==-1)
				sql = sqlAdd;
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, order.getCreateDatetime());
			pstmt.setString(2, order.getMemo());
			pstmt.setLong(3, order.getClient().getId());
			pstmt.setLong(4,order.getOrderStatus().getId());
			pstmt.setInt(5, order.isDelete()?1:0);
			if(order.getId()!=-1){
				pstmt.setLong(6, order.getId());
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
	
	public static List<OrderItem> getOrderItemByProduct(long productId){
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from order_item where exists (select * from product where order_item.product_id = product.id and product.id = ?)";
    	List<OrderItem> orderItems = new ArrayList<>();
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, productId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				int amount = rs.getInt("amount");
				String memo = rs.getString("memo");
				long order_id = rs.getShort("order_id");
				long product_id = rs.getLong("product_id");
				OrderItem oi = new OrderItem(id,amount,memo,OrderDAO.getOrderByID(order_id),ProductDAO.getProductById(product_id));
				orderItems.add(oi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.cleanup(conn, pstmt, rs);
		}
    	return orderItems;
	}
	
	public static Order getOrderByID(long orderId){
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from `order` where id = ?";
    	Order order = null;
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, orderId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				Date create_datetime = rs.getDate("create_datetime");
				String memo = rs.getString("memo");
				long client_id = rs.getLong("client_id");
				long order_status_id = rs.getLong("order_status_id");
				order = new Order(id,create_datetime,memo,getOrderStatusById(order_status_id),ClientDAO.getClientById(client_id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.cleanup(conn, pstmt, rs);
		}
    	return order;
	}
	
	public static List<Order> getOrdersByStatus(OrderStatus orderStatus){
		List<Order> orders = new ArrayList<>();
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from `order` where order_status_id = ?";
    	Order order = null;
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, orderStatus.getId());
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				Date create_datetime = rs.getDate("create_datetime");
				String memo = rs.getString("memo");
				long client_id = rs.getLong("client_id");
				long order_status_id = rs.getLong("order_status_id");
				order = new Order(id,create_datetime,memo,getOrderStatusById(order_status_id),ClientDAO.getClientById(client_id));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.cleanup(conn, pstmt, rs);
		}
    	return orders;
		
		
	}
}
