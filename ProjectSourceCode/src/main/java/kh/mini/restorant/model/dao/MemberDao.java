package kh.mini.restorant.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dto.MemberDto;
import kh.mini.restorant.model.dto.MemberLoginDto;

public class MemberDao {
	
	
	public String login(Connection conn , MemberLoginDto dto) {
		String result = null;
		
		String sql ="SELECT MEMBER_CODE FROM MEMBER WHERE ID=? AND PASSWORD=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result= new String(rs.getString("MEMBER_CODE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		System.out.println("MemberLoginDao login() return:"+ result);
		return result;
	}
	
	
	
	public int insert(Connection conn , MemberDto dto) {
		int result = 0;
		//INSERT INTO MEMBER VALUES (TO_CHAR(SYSDATE,'YYMIDDMMSSHH24')||USER_CODE_SEQUENCE.nextval,'ID16','PWD',01012345690,'ID16@NAVER.COM');
		String sql = "INSERT INTO MEMBER VALUES (TO_CHAR(SYSDATE,'YYMIDDMMSSHH24')||USER_CODE_SEQUENCE.nextval,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPassword());
			pstmt.setInt(3, dto.getMemPhone() );
			pstmt.setString(4, dto.getMemEmail());
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(pstmt);
		return result;
	}
	
}
