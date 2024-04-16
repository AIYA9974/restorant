package kh.mini.restorant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.dto.MemberLoginDto;
import kh.mini.restorant.model.service.MemberService;

/**
 * Servlet implementation class LoginSe
 */
@WebServlet("/loginse")
public class LoginSe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MemberService memService = new MemberService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id);
		System.out.println(pwd);
		MemberLoginDto dto = new MemberLoginDto(id, pwd);
		System.out.println(id);
		System.out.println(pwd);
		String result = memService.login(dto);
		System.out.println(result);
		if(!result.equals(null)) {
			request.getSession().setAttribute("sssMemberCode", result);
			response.sendRedirect(request.getContextPath()+"/home");	
		} else {
			System.out.println("오류발생");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
