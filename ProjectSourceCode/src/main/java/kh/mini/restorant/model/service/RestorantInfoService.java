package kh.mini.restorant.model.service;

import java.sql.Connection;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dao.RestorantInfoDao;
import kh.mini.restorant.model.dto.RestorantInfoDto;

public class RestorantInfoService {
	private RestorantInfoDao dao = new RestorantInfoDao();
	
	public int insert(RestorantInfoDto dto) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.insert(conn, dto);
		JdbcTemplate.close(conn);
		return result;
	}
}
