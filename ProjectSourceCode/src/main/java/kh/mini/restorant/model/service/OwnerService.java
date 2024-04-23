package kh.mini.restorant.model.service;

import java.sql.Connection;

import kh.mini.restorant.jdbc.common.JdbcTemplate;

import kh.mini.restorant.model.dao.OwnerDao;

public class OwnerService {
	private OwnerDao dao = new OwnerDao();
	
	public int insert(String memCode) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.insert(conn, memCode);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public String check(String memCode) {
		String result = null;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.check(conn, memCode);
		JdbcTemplate.close(conn);
		return result;
	}

	public int delete (String memCode) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.delete(conn, memCode);
		JdbcTemplate.close(conn);
		return result;
	}
}
