package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.service.OwnerService;

/**
 * Servlet implementation class OwnerCodeCreateFunction
 */
@WebServlet("/ownercodecreatefunction")
public class OwnerCodeCreateFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerCodeCreateFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memCode = request.getParameter("memCode");
		System.out.println(memCode);
		int result = new OwnerService().insert(memCode);
		if(result == 1) {
			System.out.println("성공");
		}
		response.getWriter().append(String.valueOf(result));
	}

}
