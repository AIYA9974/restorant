package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.service.MenuService;

/**
 * Servlet implementation class CreateMenuFunction
 */
@WebServlet("/createmenufunction")
public class CreateMenuFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMenuFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===============CREATE MENU FUNCTION 진입");
		String resCode = request.getParameter("resCode");
		int result = new MenuService().create(resCode);
		if(result == 1 ) {
			System.out.println("===============CREATE MENU FUNCTION : 테이블 생성 성공");
			request.getSession().setAttribute("sssResCode", resCode);
			response.getWriter().append(String.valueOf(result));
		}else {
			System.out.println("===============CREATE MENU FUNCTION : 테이블 생성 실패");
		}
		System.out.println("===============CREATE MENU FUNCTION 종료");

	}

}
