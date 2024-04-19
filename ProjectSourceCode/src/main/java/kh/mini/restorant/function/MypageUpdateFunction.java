package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.dto.MemberUpdateDto;
import kh.mini.restorant.model.service.MemberService;

/**
 * Servlet implementation class MypageUpdateFunction
 */
@WebServlet("/mypageupdatefunction")
public class MypageUpdateFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageUpdateFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memCode = request.getParameter("memCode");
		String memPassword = request.getParameter("password");
		Long memPhone = Long.parseLong(request.getParameter("phone"));
		String memEmail = request.getParameter("email");
		
		System.out.println("function쪽 sysout");
		System.out.println(memCode);
		System.out.println(memPassword);
		System.out.println(memPhone);
		System.out.println(memEmail);
		System.out.println("/function쪽 sysout");
		
		MemberUpdateDto dto = new MemberUpdateDto(memCode,memPassword, memPhone, memEmail);
		int result = new MemberService().update(dto);
		if(result == 1) {
			System.out.println("성공");
		}else{
			System.out.println("실패");
		}response.getWriter().append(String.valueOf(result));
		
	}

}
