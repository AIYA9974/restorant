package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.dto.MemberLoginDto;
import kh.mini.restorant.model.service.MemberService;

/**
 * Servlet implementation class LoginFunction1
 */
@WebServlet("/loginfunction")
public class LoginFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MemberService memService = new MemberService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFunction() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberLoginDto dto = new MemberLoginDto(id, pwd);
		System.out.println(id);
		System.out.println(pwd);
		String result = memService.login(dto);
		System.out.println(result);
		System.out.println(String.valueOf(result));
		if(result != null && !result.equals("")) {
			request.getSession().setAttribute("sssMemberCode", result);
		} else {
			System.out.println("로그인실패");
		}
		response.getWriter().append(String.valueOf(result));
	}

}