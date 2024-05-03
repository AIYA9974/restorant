package kh.mini.restorant.model.service;

import java.sql.Connection;
import java.util.List;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dao.RestorantDao;
import kh.mini.restorant.model.dto.RestorantDto;
import kh.mini.restorant.model.dto.RestorantGetCodeDto;
import kh.mini.restorant.model.dto.RestorantGetInfoDto;
import kh.mini.restorant.model.dto.RestorantMainPageDto;
import kh.mini.restorant.model.dto.RestorantPageListDto;
import kh.mini.restorant.model.dto.RestorantUpdateDto;
import kh.mini.restorant.model.dto.RestorantUploadedListDto;

public class RestorantService {
	RestorantDao dao = new RestorantDao();
	
	public int insert (RestorantDto dto) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.insert(conn, dto);
		JdbcTemplate.close(conn);
		
		return result;
	}

	public List<RestorantUploadedListDto> selectAllList(String ownerCode){
		List<RestorantUploadedListDto> result = null;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.selectAllList(conn, ownerCode);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public RestorantGetInfoDto getInfo(String resCode) {
		RestorantGetInfoDto result = null;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.getInfo(conn, resCode);
		JdbcTemplate.close(conn);
		return result;
		
	}
	
	public int update(RestorantUpdateDto dto) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.update(conn, dto);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public int delete(String resCode) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result =dao.delete(conn, resCode);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public String getResCode(RestorantGetCodeDto dto) {
		String result = null;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.getResCode(conn, dto);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public List<RestorantPageListDto> selectAllRestorantList(String resKind){
		List<RestorantPageListDto> result = null;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.selectAllRestorantList(conn, resKind);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public RestorantMainPageDto mainPageGetInfo(String resCode) {
		RestorantMainPageDto result = null;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.mainPageGetInfo(conn, resCode);
		JdbcTemplate.close(conn);
		return result;
	}
}
