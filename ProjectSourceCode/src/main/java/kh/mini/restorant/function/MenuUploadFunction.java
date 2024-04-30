package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuUploadFunction
 */
@WebServlet("/menuuploadfunction")
public class MenuUploadFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuUploadFunction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuNum = request.getParameter("menuNum");
		String menuName = request.getParameter("menuName");
		String menuInfo = request.getParameter("menuInfo");
	
		System.out.println(menuNum);
		System.out.println(menuName);
		System.out.println(menuInfo);
	}

}
