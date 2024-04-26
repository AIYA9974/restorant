package kh.mini.restorant.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dto.RestorantInfoDto;

public class RestorantInfoDao {
	
	public int insert(Connection conn , RestorantInfoDto dto) {
		System.out.println("==========DAO insert 진입");
		int result = 0;
		
		String sql = "INSERT INTO RESTORANT_INFO VALUES (?,?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getResCode());
			pstmt.setString(2, dto.getPlaceAlone());
			pstmt.setString(3, dto.getPlaceGroup());
			pstmt.setString(4, dto.getSitFloor());
			pstmt.setString(5, dto.getSitChair());
			pstmt.setString(6, dto.getStanding());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(pstmt);
		
		System.out.println("==========DAO insert 진입");
		return result;
	}
		
	public int delete(Connection conn , String resCode) {
		System.out.println("==========RESORANT INFO DELETE DAO insert 진입");
		int result = 0;
		String sql = "DELETE RESTORANT_INFO WHERE RESTORANT_CODE=?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(pstmt);
		
		System.out.println("==========RESORANT INFO DELETE DAO insert 종료");
		return result;
	}
	
}
