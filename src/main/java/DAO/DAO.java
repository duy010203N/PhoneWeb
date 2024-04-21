package DAO;

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
	public static void main(String[] args) {
		DAO dao = new DAO();
		List<Product> list = dao.getAllProduct();
		for (Product o : list) {
			System.out.println(o);
		}
	}
}
