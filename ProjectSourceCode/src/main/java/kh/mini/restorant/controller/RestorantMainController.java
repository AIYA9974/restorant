package kh.mini.restorant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestorantMainController
 */
@WebServlet("/restorantmaincontroller")
public class RestorantMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantMainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resCode = request.getParameter("resCode");
		request.getSession().setAttribute("sssResCode" , resCode);
		request.getRequestDispatcher("WEB-INF/views/restorant_main.jsp").forward(request, response);
	}

}
