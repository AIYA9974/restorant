package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.service.MenuService;
import kh.mini.restorant.model.service.RestorantCommonInfoService;
import kh.mini.restorant.model.service.RestorantService;

/**
 * Servlet implementation class RestorantDeleteFunction
 */
@WebServlet("/restorantdeletefuncion")
public class RestorantDeleteFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantDeleteFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=========RESTORANT DELETE FUNCTION 진입");
		
		String resCode = request.getParameter("resCode");
		System.out.println(resCode);
		
//		레스토랑 인포 딜리트 섹션
		int result = 0;
		result = new RestorantCommonInfoService().delete(resCode);
		System.out.println("레스토랑 인포 딜리트 : "+result);
		
		if(result == 1) {
			System.out.println("레스토랑 인포 딜리트 삭제 성공 하였습니다");
		}else {
			System.out.println("레스토랑 인포 딜리트 삭제 실패 하였습니다");
		}
		
//		레스토랑 딜리트 섹션
		result = 0;
		result = new RestorantService().delete(resCode);
		System.out.println("레스토랑 딜리트 : "+result);
		if(result == 1) {
			System.out.println("레스토랑 딜리트 삭제 성공 하였습니다");
		}else {
			System.out.println("레스토랑 딜리트 삭제 실패 하였습니다");
		}
		
		
//		레스토랑 메뉴 딜리트 섹션
		result = 0;
		result = new MenuService().delete(resCode);
		System.out.println("레스토랑 메뉴 딜리트 : "+result);
		if(result == 1) {
			System.out.println("레스토랑 딜리트 삭제 성공 하였습니다");
		}else {
			System.out.println("레스토랑 딜리트 삭제 실패 하였습니다");
			
		}
		
		request.getRequestDispatcher("/WEB-INF/views/mypage.jsp").forward(request, response);
		
		
		System.out.println("=========RESTORANT DELETE FUNCTION 탈출");
	}

}