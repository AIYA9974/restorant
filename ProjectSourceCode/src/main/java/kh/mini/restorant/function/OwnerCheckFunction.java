package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.service.OwnerService;

/**
 * Servlet implementation class OwnerCheckFunction
 */
@WebServlet("/ownercheckfunction")
public class OwnerCheckFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OwnerService service = new OwnerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerCheckFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("오너 체크 펑션 시작");
		
		String memCode = request.getParameter("memCode");
		System.out.println("오너 체크 펑션 memCode : "+memCode);
		
		String result = service.check(memCode);
		System.out.println("오너 체크 펑션 result : "+result);
		
		if(result != null && !result.equals("")) {
			request.getSession().setAttribute("sssOwnerCode", result);
		} else {
			System.out.println("오류 발생으로 인하여 sssOwnerCode 가져오기 실패");
		}
		
		
		System.out.println("오너 체크 펑션 끝");
	
	}

}
