package kh.mini.restorant.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static kh.mini.restorant.jdbc.common.JdbcTemplate.close;



public class OwnerDao {
	
	public int insert(Connection conn , String memCode) {
		System.out.println("dao 진입");
		int result = 0;
		String sql = "INSERT INTO RESTORANT_OWNER VALUES (TO_CHAR(SYSDATE,'YYMIDDMMSSHH24')||USER_CODE_SEQUENCE.nextval , ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memCode);
			result = pstmt.executeUpdate();
			
			System.out.println("memCode :" +memCode);
			System.out.println("result :" +result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("dao 탈출");
		return result;
	}
	
	
	public String check(Connection conn , String memCode) {
		System.out.println("dao 진입");
		String result = null;
		
		String sql = "SELECT OWNER_CODE FROM RESTORANT_OWNER WHERE MEMBER_CODE = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("OWNER_CODE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		
		System.out.println("result : "+result);
		System.out.println("dao 탈출");
		return result;
	}
	
	public int delete (Connection conn, String memCode) {
		System.out.println("DELETE dao 진입");
		
		int result = 0;
		String sql = "DELETE FROM RESTORANT_OWNER WHERE MEMBER_CODE = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memCode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		
		System.out.println("DELETE dao memCode : " + memCode);
		System.out.println("DELETE dao result : " + result);
		System.out.println("DELETE dao 탈출");
		return result;
	}
	
}



