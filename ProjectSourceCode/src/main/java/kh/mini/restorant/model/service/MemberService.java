package kh.mini.restorant.model.service;

import java.sql.Connection;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dao.MemberDao;
import kh.mini.restorant.model.dto.MemberInsertDto;
import kh.mini.restorant.model.dto.MemberLoginDto;
import kh.mini.restorant.model.dto.MemberMypageDto;
import kh.mini.restorant.model.dto.MemberUpdateDto;

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

	public int insert(MemberInsertDto dto) {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.insert(conn, dto);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public MemberMypageDto mypage (String memCode) {
		System.out.println("service 진행");
		MemberMypageDto result = null;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.mypage(conn, memCode);
		JdbcTemplate.close(conn);
		System.out.println(result);
		System.out.println("service 진행 완료");
		return result;
	}
	
	public int update (MemberUpdateDto dto) {
		System.out.println("service 진행");
		int result = 0;
		Connection conn = JdbcTemplate.getConnection(true);
		result = dao.update(conn, dto);
		JdbcTemplate.close(conn);
		System.out.println("service 진행 완료");
		
		return result;
	}
}
