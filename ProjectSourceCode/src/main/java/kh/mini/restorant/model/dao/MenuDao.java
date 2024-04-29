package kh.mini.restorant.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kh.mini.restorant.jdbc.common.JdbcTemplate;

public class MenuDao {
	
	public int create(Connection conn , String resCode) {
		
		System.out.println("=========CREATE MENU DAO진입");
		int result = 0;
		String sql="DECLARE\r\n"
				+ "    TABLE_NAME VARCHAR2(100);\r\n"
				+ "BEGIN\r\n"
				+ "    pro_create_table(?,TABLE_NAME);\r\n"
				+ "END;";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resCode);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(conn);
		
		System.out.println("MENU_"+resCode);
		System.out.println("=========CREATE MENU DAO종료");
		return result;
	}
	
	public int delete(Connection conn, String resCode) {
		System.out.println("=========DELETE MENU DAO진입");
		int result = 0;
		String sql ="DECLARE\r\n"
				+ "    TABLE_NAME VARCHAR2(100);\r\n"
				+ "BEGIN\r\n"
				+ "    pro_delete_table(?,TABLE_NAME);\r\n"
				+ "END;";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resCode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(pstmt);
		
		System.out.println("MENU_"+resCode);
		System.out.println("=========DELETE MENU DAO종료");
		return result;
	}
}




