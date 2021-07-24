package data;

import java.sql.*;
import java.util.LinkedList;
import entities.*;
public class DbHandler {
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="locaclhost";
	private String port="3306";
	private String user="root";
	private String password="";
	private String db="java";
	Connection conn = null;
	
	public DbHandler() {
		// registrar el driver de conexion class.forName(...)
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
				
	}
	
	public LinkedList<Product> list() {
		Statement stmt=null;
		ResultSet rs =null;
		LinkedList<Product> prods = new LinkedList<Product>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javamarket","root","");
		} catch (SQLException e) {
			e.printStackTrace(); 
			return null;
		}		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from product");
			
			while(rs != null && rs.next()) {
				Product p = new Product();
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getDouble("price"));
				p.setStock(rs.getInt("stock"));
				p.setShippingIncluded(rs.getBoolean("shippingIncluded"));
				
				prods.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return prods;
	}
}
