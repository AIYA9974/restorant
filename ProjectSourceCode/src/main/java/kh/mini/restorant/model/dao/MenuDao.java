package kh.mini.restorant.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.mini.restorant.jdbc.common.JdbcTemplate;
import kh.mini.restorant.model.dto.MenuInsertDto;
import kh.mini.restorant.model.dto.MenuSelectAllDto;

public class MenuDao {
	
	public int create(Connection conn , String resCode) {
		
		System.out.println("=========CREATE MENU DAO진입");
		int result = 0;
		String sql="DECLARE\r\n"
				+ "    TABLE_NAME VARCHAR2(100);\r\n"
				+ "BEGIN\r\n"
				+ "    pro_create_table(?,TABLE_NAME);\r\n"
				+ "END;";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "MU_"+resCode);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(conn);
		
		System.out.println(resCode);
		System.out.println("=========CREATE MENU DAO종료");
		return result;
	}
	
	public int delete(Connection conn, String resCode) {
		System.out.println("=========DELETE MENU DAO진입");
		int result = 0;
		String sql ="DECLARE\r\n"
				+ "    TABLE_NAME VARCHAR2(100);\r\n"
				+ "BEGIN\r\n"
				+ "    pro_delete_table(?,TABLE_NAME);\r\n"
				+ "END;";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "MU_"+resCode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(pstmt);
		
		System.out.println(resCode);
		System.out.println("=========DELETE MENU DAO종료");
		return result;
	}
	
	public int insert(Connection conn,List<MenuInsertDto> list) {
		System.out.println("=========INSERT MENU DAO진입");
		int result = 0;
		
		for(int i = 0; i <list.size(); i++) {
			MenuInsertDto dto = list.get(i);
			System.out.println(dto);
			System.out.println("MU_"+dto.getResCode());
			
			String sql = "INSERT INTO MU_?  VALUES   ( TO_CHAR(SYSDATE,'YYMIDDMMSSHH24---')||USER_CODE_SEQUENCE.nextval , ? , ? )";
			PreparedStatement pstmt = null;
			System.out.println("1발생?");
			
				try {
					pstmt = conn.prepareStatement(sql);
					
					System.out.println("2발생?");
					pstmt.setString(1, dto.getResCode());
					pstmt.setString(2, dto.getMenuName() );
					pstmt.setString(3, dto.getMenuInfo() );
					System.out.println("3발생?");
					pstmt.executeUpdate();
					System.out.println("4발생?");
					if(result != 1) {
						System.out.println(1+result);
						System.out.println("5발생?");
					}
						System.out.println(2+result);
					} catch (SQLException e) {
						e.printStackTrace();
				}
				JdbcTemplate.close(pstmt);
			}
		
		System.out.println(3+result);
		System.out.println("=========INSERT MENU DAO종료");
		return result;
	}
	
	public List<MenuSelectAllDto> selectAll(Connection conn , String resCode) {
		System.out.println("=========SELECTALL MENU DAO진입");
		List<MenuSelectAllDto> result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, "'MU_'"+resCode);
			rs = pstmt.executeQuery();
				if(rs.next()) {
					result = new ArrayList<MenuSelectAllDto>();
					do {
						MenuSelectAllDto dto = new MenuSelectAllDto(
								rs.getString("MENU_CODE"),
								rs.getString("MENU_NAME"),
								rs.getString("MENU_COMMENT")
								);
						result.add(dto);
					}while(rs.next());
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcTemplate.close(rs);
		JdbcTemplate.close(pstmt);
		
		System.out.println("=========SELECTALL MENU DAO종료");
		return result;
	}
}




