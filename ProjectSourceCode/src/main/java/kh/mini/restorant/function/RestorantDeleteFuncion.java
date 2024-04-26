package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.service.RestorantService;

/**
 * Servlet implementation class RestorantDeleteFuncion
 */
@WebServlet("/restorantdeletefuncion")
public class RestorantDeleteFuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantDeleteFuncion() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========= UPDATE FUNCTION 진입");
		
		String resCode = request.getParameter("resCode");
		
		int result = new RestorantService().delete(resCode);
		System.out.println(result);
		if(result == 1) {
			System.out.println("삭제 성공 하였습니다");
		}else {
			System.out.println("삭제 실패 하였습니다");
		}
		
		request.getRequestDispatcher("/WEB-INF/views/mypage.jsp").forward(request, response);
		
		
		System.out.println("========= UPDATE FUNCTION 탈출");
	}

}
