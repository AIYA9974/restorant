package kh.mini.restorant.model.service;

import java.sql.Connection;
import java.util.List;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dao.RestorantDao;
import kh.mini.restorant.model.dto.RestorantDto;
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
}
