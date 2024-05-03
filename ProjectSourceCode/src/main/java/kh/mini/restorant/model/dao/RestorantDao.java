package kh.mini.restorant.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.mini.restorant.jdbc.common.JdbcTemplate.close;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dto.RestorantDto;
import kh.mini.restorant.model.dto.RestorantGetCodeDto;
import kh.mini.restorant.model.dto.RestorantGetInfoDto;
import kh.mini.restorant.model.dto.RestorantMainPageDto;
import kh.mini.restorant.model.dto.RestorantPageListDto;
import kh.mini.restorant.model.dto.RestorantUpdateDto;
import kh.mini.restorant.model.dto.RestorantUploadedListDto;

public class RestorantDao {
	
	public int insert(Connection conn , RestorantDto dto) {
		System.out.println("INSERT DAO 시작");
		int result = 0;
		String sql ="INSERT INTO RESTORANT (RESTORANT_CODE,OWNER_CODE,RESTORANT_NAME,RESTORANT_PHONE,RESTORANT_SUB_PHONE,RESTORANT_EMAIL,RESTORANT_LOCAL,RESTORANT_MESSAGE,RESTORANT_KIND) \r\n"
				+ "    VALUES ( TO_CHAR(SYSDATE,'YYMIDDMMSSHH24')||USER_CODE_SEQUENCE.nextval , ? , ? , ? , ? , ? , ? , ? , ? )";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getOwnerCode());
			pstmt.setString(2, dto.getResName());
			pstmt.setLong(3, dto.getResPhone());
			pstmt.setLong(4, dto.getResSubPhone());
			pstmt.setString(5, dto.getResEmail());
			pstmt.setString(6, dto.getResLoc());
			pstmt.setString(7, dto.getResMsg());
			pstmt.setString(8, dto.getResKind());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		
		System.out.println("1"+dto.getOwnerCode());
		System.out.println("2"+dto.getResName());
		System.out.println("3"+dto.getResPhone());
		System.out.println("4"+dto.getResSubPhone());
		System.out.println("5"+dto.getResEmail());
		System.out.println("6"+dto.getResLoc());
		System.out.println("7"+dto.getResMsg());
		System.out.println("8"+dto.getResKind());
		System.out.println("INSERT DAO 끝");
		return result;
	}
	
	public List<RestorantUploadedListDto>  selectAllList(Connection conn , String ownerCode) {
		System.out.println("LIST DAO 시작");
		
		List<RestorantUploadedListDto> result = null;
		String sql = "SELECT RESTORANT_CODE, RESTORANT_NAME , RESTORANT_LOCAL , RESTORANT_KIND FROM RESTORANT WHERE OWNER_CODE =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ownerCode);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new ArrayList<RestorantUploadedListDto>();
				do {
					RestorantUploadedListDto dto = new RestorantUploadedListDto(
							rs.getString("RESTORANT_CODE"), rs.getString("RESTORANT_NAME"), rs.getString("RESTORANT_LOCAL"), rs.getString("RESTORANT_KIND")
							);
					result.add(dto);
				}while (rs.next());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		
		System.out.println("DAO ownerCode :"+ownerCode);
		System.out.println("DAO result :"+result);
		
		System.out.println("LIST DAO 끝");
		return result;
	}
	
	public RestorantGetInfoDto getInfo(Connection conn, String resCode) {
		System.out.println("------getInfo dao 진행");
		
		RestorantGetInfoDto result = null;
		String sql = "SELECT RESTORANT_NAME, RESTORANT_PHONE, RESTORANT_SUB_PHONE, RESTORANT_EMAIL, RESTORANT_LOCAL, RESTORANT_MESSAGE \r\n"
				+ "    FROM RESTORANT WHERE RESTORANT_CODE = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new RestorantGetInfoDto(rs.getString("RESTORANT_NAME"), rs.getLong("RESTORANT_PHONE"),	rs.getLong("RESTORANT_SUB_PHONE"),rs.getString("RESTORANT_EMAIL"), rs.getString("RESTORANT_LOCAL"), rs.getString("RESTORANT_MESSAGE") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		
		System.out.println("getInfo dao resCode :"+resCode);
		System.out.println("------getInfo dao 종료");
		return result;
	}
	
	public int update(Connection conn , RestorantUpdateDto dto) {
		System.out.println("------getInfo dao 진행");
		int result = 0 ;
		String sql = "UPDATE RESTORANT SET RESTORANT_NAME = ? , RESTORANT_PHONE = ? , RESTORANT_SUB_PHONE = ?, RESTORANT_EMAIL = ? , RESTORANT_LOCAL = ? , RESTORANT_MESSAGE = ? \r\n"
				+ "    WHERE RESTORANT_CODE = ?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getResName());
			pstmt.setLong(2, dto.getResPhone());
			pstmt.setLong(3, dto.getResSubPhone());
			pstmt.setString(4, dto.getResEmail());
			pstmt.setString(5, dto.getResLoc());
			pstmt.setString(6, dto.getResMsg());
			pstmt.setString(7, dto.getResCode());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(pstmt);
		System.out.println("------getInfo dao 종료");
		return result;
	}
	
	public int delete(Connection conn,String resCode) {
		System.out.println("------getInfo dao 진행");
		int result = 0;
		String sql = "DELETE  FROM RESTORANT WHERE RESTORANT_CODE = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, resCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(pstmt);
		
		System.out.println("------getInfo dao 종료");
		return result;
	}
	
	
	public String getResCode (Connection conn, RestorantGetCodeDto dto) {
		System.out.println("------getResCode dao 진행");
		String result = null;
		String sql="SELECT RESTORANT_CODE FROM RESTORANT WHERE RESTORANT_NAME = ? AND RESTORANT_PHONE = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getResName());
			pstmt.setLong(2, dto.getResPhone());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("RESTORANT_CODE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		System.out.println("------getResCode dao 종료");
		return result;
	}
	
	public List<RestorantPageListDto> selectAllRestorantList(Connection conn , String resKind){
		System.out.println("-------------SELECT ALL RESTORANT LIST DAO 시작");
		List<RestorantPageListDto> result = null;
		String sql = "SELECT RESTORANT_CODE, RESTORANT_NAME , RESTORANT_PHONE , RESTORANT_LOCAL FROM RESTORANT WHERE RESTORANT_KIND = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, resKind);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new ArrayList<RestorantPageListDto>();
				do {
					RestorantPageListDto dto = new RestorantPageListDto(
							rs.getString("RESTORANT_CODE")
							, rs.getString("RESTORANT_NAME")
							, rs.getString("RESTORANT_PHONE")
							, rs.getString("RESTORANT_LOCAL")
							);
					result.add(dto);
				}while (rs.next());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		
		System.out.println("DAO resKind :"+resKind);
		System.out.println("DAO result :"+result);
		
		System.out.println("-------------SELECT ALL RESTORANT LIST DAO 종료");
		return result;
	}
	
	public RestorantMainPageDto mainPageGetInfo (Connection conn, String resCode) {
		System.out.println("------------- RESTORANT MAIN PAGE DAO 시작");
		RestorantMainPageDto result = null;
		String sql = "SELECT RESTORANT_NAME , RESTORANT_PHONE , RESTORANT_SUB_PHONE , RESTORANT_EMAIL , RESTORANT_LOCAL , RESTORANT_MESSAGE \n"
				+ "    FROM RESTORANT WHERE RESTORANT_CODE = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new RestorantMainPageDto(rs.getString("RESTORANT_NAME"), rs.getLong("RESTORANT_PHONE"), rs.getLong("RESTORANT_SUB_PHONE"), rs.getString("RESTORANT_EMAIL"), rs.getString("RESTORANT_LOCAL"), rs.getString("RESTORANT_MESSAGE") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		
		System.out.println("------------- RESTORANT MAIN PAGE DAO 종료");
		return result;
	}
	
}
