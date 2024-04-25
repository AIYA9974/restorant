package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestorantUpdateFunction
 */
@WebServlet("/restorantcodecheckfunction")
public class RestorantcodeCheckFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantcodeCheckFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========RESCODE SESSION FUNCTION 시작");
		String resCode = request.getParameter("resCode");
		System.out.println(resCode);
		request.getSession().setAttribute("sssResCode", resCode);
		response.getWriter().append(String.valueOf(resCode));
		System.out.println("========RESCODE SESSION FUNCTION 끝");
	}

}
