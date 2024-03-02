package com.telusko.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 


public class AlienRepository {
	
	List<Alien> aliens;
	
	Connection con = null;
	
	public AlienRepository() {
		String url = "jdbc:mysql://localhost:3306/fonsi?verifyServerCertificate=false&useSSL=false";
		String username = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Alien> getAliens() {
		
		List<Alien> aliens = new ArrayList<>();
		String sql = "select * from alien";
		try { 
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			
			while(result.next()) {
				Alien a = new Alien();
				a.setId(result.getInt(1));
				a.setName(result.getString(2));
				a.setPoints(result.getInt(3));
				
				aliens.add(a);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return aliens;
	}
	
	public Alien getAlien(int id) {
		String sql = "select * from alien where id="+id;
		Alien a = new Alien();
		try { 
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			
			if(result.next()) {
				a.setId(result.getInt(1));
				a.setName(result.getString(2));
				a.setPoints(result.getInt(3));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public Alien createAlien(Alien a1) {
		String sql = "insert into alien values (?,?,?)";
		
		try { 
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3, a1.getPoints());
			st.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		return a1;
	}
	
	
	
}
