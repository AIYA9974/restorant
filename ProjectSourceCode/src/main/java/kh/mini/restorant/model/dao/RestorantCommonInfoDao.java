package kh.mini.restorant.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dto.RestorantCommonInfoDto;
import kh.mini.restorant.model.dto.RestorantGetCommonInfoDto;

public class RestorantCommonInfoDao {
	
	public int insert(Connection conn , RestorantCommonInfoDto dto) {
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
	
	public RestorantGetCommonInfoDto selectOne (Connection conn , String resCode) {
		System.out.println("==========RESORANT COMMON INFO SELECT ONE  DAO  진입");
		RestorantGetCommonInfoDto result = null;
		String sql = "SELECT PLACE_ALONE, PLACE_GROUP, SIT_FLOOR, SIT_CHAIR, STANDING FROM RESTORANT_INFO WHERE RESTORANT_CODE = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result  = new RestorantGetCommonInfoDto(rs.getString("PLACE_ALONE"), rs.getString("PLACE_GROUP"), rs.getString("SIT_FLOOR"), rs.getString("SIT_CHAIR"), rs.getString("STANDING"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		
		System.out.println("==========RESORANT COMMON INFO SELECT ONE  DAO  종료");
		return result;
	}
}
