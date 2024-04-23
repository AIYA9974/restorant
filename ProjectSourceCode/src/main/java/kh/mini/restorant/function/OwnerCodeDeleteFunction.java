package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.service.OwnerService;

/**
 * Servlet implementation class OwnerCodeDeleteFunction
 */
@WebServlet("/ownercodedeletefunction")
public class OwnerCodeDeleteFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OwnerService service = new OwnerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerCodeDeleteFunction() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OwnerCodeDeleteFunction 연결 성공 ");
		
		String memCode = request.getParameter("memCode");
		System.out.println("OwnerCodeDeleteFunction memCode : " + memCode);
		
		int result = service.delete(memCode); 
		System.out.println("OwnerCodeDeleteFunction result : " + result);
		
		if(result == 1) {
			System.out.println("OwnerCodeDeleteFunction 성공 ");
		} else {
			System.out.println("OwnerCodeDeleteFunction 실패 ");
		}
		System.out.println("OwnerCodeDeleteFunction 탈출 ");
	}

}
