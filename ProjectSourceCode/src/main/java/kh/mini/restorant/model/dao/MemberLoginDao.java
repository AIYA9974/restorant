package kh.mini.restorant.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dto.MemberLoginDto;

public class MemberLoginDao {
	
	
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
		return result;
	}
}
