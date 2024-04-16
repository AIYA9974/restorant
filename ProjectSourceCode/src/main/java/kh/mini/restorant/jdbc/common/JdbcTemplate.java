package kh.mini.restorant.jdbc.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcTemplate {
	
	
	public static Connection getConnection(boolean isLocalhost) {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			String currentPath = JdbcTemplate.class.getResource("./").getPath();
			prop.load(new FileReader(currentPath+"driver.properties"));
			Class.forName(prop.getProperty("jdbc.driver"));
			conn = DriverManager.getConnection(prop.getProperty("jdbc.url")
										,prop.getProperty("jdbc.username")
										,prop.getProperty("jdbc.password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	//auto commit
	public static void autoCommit(Connection con, boolean autocommit) {
		try {
			if(con != null) con.setAutoCommit(autocommit);
		} catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	//commit
	public static void commit(Connection con , boolean commit) {
		try {
			if(con != null) con.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback (Connection con) {
		try {
			if(con != null)con.rollback();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close (Connection con) {
		try {
			if(con != null) con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close (Statement stmt) {
		try {
			if(stmt != null) stmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close (ResultSet rs) {
		try {	
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
