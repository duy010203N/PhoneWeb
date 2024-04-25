package DAO;

import Entity.Account;
import Entity.Product;
import java.util.ArrayList;
import java.util.List;
import Context.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	Connection conn = null ;
	PreparedStatement ps = null;
	ResultSet rs = null ;
	
	public List<Product> getAllProduct(){
		List<Product> list = new ArrayList<>();
		String query = "select * from Product";
		try {
			new DBConnect();
			conn = DBConnect.getConn();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
			list.add(new Product(rs.getInt(1),
					rs.getString(2),
					rs.getString(3), 
					rs.getDouble(4), 
					rs.getString(5),
					rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
}
	
	public Account login(String user, String pass) {
	    String query = "SELECT * FROM account WHERE user = ? AND pass = ?";
	    try {
	        new DBConnect();
	        conn = DBConnect.getConn();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, user);
	        ps.setString(2, pass);
	        rs = ps.executeQuery();
	        while(rs.next()) {
	            return new Account(rs.getInt(1),
	                                rs.getString(2),
	                                rs.getString(3),
	                                rs.getInt(4),
	                                rs.getInt(5));
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // In lỗi để kiểm tra và xử lý sau
	    } 
	    return null;
	}
	
	public void signup(String user ,String pass) {
		String query = "INSERT INTO Account (user, pass, isSell,isAdmin) VALUES (?,?,?,?)";
		 try {
		        new DBConnect();
		        conn = DBConnect.getConn();
		        ps = conn.prepareStatement(query);
		        ps.setString(1, user);
		        ps.setString(2, pass);
		        ps.executeUpdate();
		        } catch(Exception e) {
		        }
	}
	
	public Account checkAccountExist(String user) {
	    String query = "select * from account where user = ?";
	    try {
	        new DBConnect();
	        conn = DBConnect.getConn();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, user);
	        rs = ps.executeQuery();
	        while(rs.next()) {
	            return new Account(rs.getInt(1),
	                                rs.getString(2),
	                                rs.getString(3),
	                                rs.getInt(4),
	                                rs.getInt(5));
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // In lỗi để kiểm tra và xử lý sau
	    } 
	    return null;
	}
	

}
