package kh.mini.restorant.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dto.MemberInsertDto;
import kh.mini.restorant.model.dto.MemberLoginDto;
import kh.mini.restorant.model.dto.MemberMypageDto;
import kh.mini.restorant.model.dto.MemberUpdateDto;

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
				result= rs.getString("MEMBER_CODE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		System.out.println("dto.getMemId() : "+dto.getMemId());
		System.out.println("dto.getMemPassword() : "+dto.getMemPassword());
		System.out.println("MemberLoginDao login() return:"+ result);
		return result;
	}
	
	
	
	public int insert(Connection conn , MemberInsertDto dto) {
		int result = 0;
		//INSERT INTO MEMBER VALUES (TO_CHAR(SYSDATE,'YYMIDDMMSSHH24')||USER_CODE_SEQUENCE.nextval,'ID16','PWD',01012345690,'ID16@NAVER.COM');
		String sql = "INSERT INTO MEMBER VALUES (TO_CHAR(SYSDATE,'YYMIDDMMSSHH24')||USER_CODE_SEQUENCE.nextval,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPassword());
			pstmt.setLong(3, dto.getMemPhone() );
			pstmt.setString(4, dto.getMemEmail());
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(pstmt);
		return result;
	}
	
	public MemberMypageDto mypage(Connection conn , String memCode) {
		System.out.println("dao 진행");
		MemberMypageDto result = null;
		String sql = "SELECT ID , PASSWORD, PHONE , EMAIL FROM MEMBER WHERE MEMBER_CODE=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberMypageDto( rs.getString("ID"), rs.getString("PASSWORD"), rs.getLong("PHONE"), rs.getString("EMAIL") );
			}

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		
		System.out.println("TempDao selectOne() r: " +  result);
		System.out.println("dao 완료");
		return result;
	}
	
	public int update(Connection conn ,MemberUpdateDto dto) {
		System.out.println("dao 진행");
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET PASSWORD = ? , PHONE = ? , EMAIL = ?  WHERE MEMBER_CODE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemPassword());
			pstmt.setLong(2, dto.getMemPhone());
			pstmt.setString(3, dto.getMemEmail());
			pstmt.setString(4, dto.getMemCode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}JdbcTemplate.close(pstmt);
		
		System.out.println("dto.getMemPassword() :" +dto.getMemPassword());
		System.out.println("dto.dto.getMemPhone() :" +dto.getMemPhone());
		System.out.println("dto.getMemEmail() :" +dto.getMemEmail());
		System.out.println("dto.getMemCode() :" +dto.getMemCode());
		
		return result;
	}
}
