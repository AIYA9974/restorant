package kh.mini.restorant.model.service;

import java.sql.Connection;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dao.MenuDao;
	

public class MenuService {
	private MenuDao dao = new MenuDao();
	
	public int create (String resCode) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.create(conn, resCode);
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
	
}
