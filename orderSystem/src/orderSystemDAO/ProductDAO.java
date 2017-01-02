package orderSystemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Catalog;
import beans.Product;
import beans.ProductUnit;

public class ProductDAO {
	public static List<Product> searchAllProduct(){
		List<Product> products = new ArrayList<>();
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from product";
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				long productUnitId = rs.getLong("product_unit_id");
				long catalogId = rs.getLong("catalog_id");
				Product product = new Product(id, code, name, price,getProductUnitById(productUnitId),getCatalogById(catalogId));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return products;
	}
	
	public static List<Product> searchProductByCatalog(Catalog catalog){
		List<Product> products = new ArrayList<>();
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from product where exists (select * from catalog where product.catalog_id = catalog.id and catalog.id = ?)";
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, catalog.getId());
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				long productUnitId = rs.getLong("product_unit_id");
				long catalogId = rs.getLong("catalog_id");
				Product product = new Product(id, code, name, price,getProductUnitById(productUnitId),getCatalogById(catalogId));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return products;
	}
	
	public static List<Product> searchProductByName(Product product){
		List<Product> products = new ArrayList<>();
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from product where name = ?";
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				long productUnitId = rs.getLong("product_unit_id");
				long catalogId = rs.getLong("catalog_id");
				Product product2 = new Product(id, code, name, price,getProductUnitById(productUnitId),getCatalogById(catalogId));
				products.add(product2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return products;
	}
	
	public static List<Product> searchProductByCode(Product product){
		List<Product> products = new ArrayList<>();
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from product where code = ?";
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getCode());
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				long productUnitId = rs.getLong("product_unit_id");
				long catalogId = rs.getLong("catalog_id");
				Product product2 = new Product(id, code, name, price,getProductUnitById(productUnitId),getCatalogById(catalogId));
				products.add(product2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return products;
	}
	public static ProductUnit getProductUnitById(long productUnitId){
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from product_unit where id = ?";
    	ProductUnit productUnit = null;
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, productUnitId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				String description = rs.getString("description");
				productUnit = new ProductUnit(id,code,name,description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return productUnit;
	}
	
	public static Catalog getCatalogById(long catalogId){
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from product_unit where id = ?";
    	Catalog catalog = null;
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, catalogId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				String description = rs.getString("description");
				catalog = new Catalog(id,code,name,description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return catalog;
	}
	
	public static Product getProductById(long productId){
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "select * from product where id = ?";
    	Product product = null;
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, productId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				long id = rs.getLong("id");
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				long product_nuit_id = rs.getLong("product_unit_id");
				long catalog_id = rs.getLong("catalog_id");
				product = new Product(id,code,name,price,getProductUnitById(product_nuit_id),getCatalogById(catalog_id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return product;
	}
	
	public static boolean deleteProduct(Product product){
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	String sql = "update product set is_delete = 1 where id = ?";
    	try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, product.getId());
			int rowEffect = pstmt.executeUpdate();
			if(rowEffect!=0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
        	DBConnection.cleanup(conn, pstmt, rs);
        }
    	return false;
    	
	}
}
