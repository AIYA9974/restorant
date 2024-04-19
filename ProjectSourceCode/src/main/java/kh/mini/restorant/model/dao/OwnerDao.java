package kh.mini.restorant.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



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
}
