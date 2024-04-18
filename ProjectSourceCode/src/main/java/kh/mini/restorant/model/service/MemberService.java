package kh.mini.restorant.model.service;

import java.sql.Connection;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dao.MemberDao;
import kh.mini.restorant.model.dto.MemberDto;
import kh.mini.restorant.model.dto.MemberLoginDto;

public class MemberService {
	private MemberDao dao = new MemberDao();

	// member login - get memCode
	public String login(MemberLoginDto dto) {
		String result = null;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.login(conn, dto);
		JdbcTemplate.close(conn);
		return result;
	}

	public int insert(MemberDto dto) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.insert(conn, dto);
		JdbcTemplate.close(conn);
		return result;
	}
	
}
