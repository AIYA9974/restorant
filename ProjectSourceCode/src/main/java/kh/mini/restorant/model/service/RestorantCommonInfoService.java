package kh.mini.restorant.model.service;

import java.sql.Connection;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dao.RestorantCommonInfoDao;
import kh.mini.restorant.model.dto.RestorantCommonInfoDto;
import kh.mini.restorant.model.dto.RestorantGetCommonInfoDto;

public class RestorantCommonInfoService {
	private RestorantCommonInfoDao dao = new RestorantCommonInfoDao();
	
	public int insert(RestorantCommonInfoDto dto) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.insert(conn, dto);
		JdbcTemplate.close(conn);
		return result;
	}
	public int delete(String resCode) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.delete(conn, resCode);
		JdbcTemplate.close(conn);
		return result;
	}
	public RestorantGetCommonInfoDto selectOne(String resCode) {
		RestorantGetCommonInfoDto result = null;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.selectOne(conn, resCode);
		JdbcTemplate.close(conn);
		return result;
	}
}
