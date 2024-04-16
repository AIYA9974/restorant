package kh.mini.restorant.model.service;

import java.sql.Connection;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dao.MemberLoginDao;
import kh.mini.restorant.model.dto.MemberLoginDto;

public class MemberService {
	private MemberLoginDao dao = new MemberLoginDao();
	
	//member login - get memCode
	public String login(MemberLoginDto dto) {
		String result = null;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.login(conn, dto);
		JdbcTemplate.close(conn);
		return result;
	}
	
}
