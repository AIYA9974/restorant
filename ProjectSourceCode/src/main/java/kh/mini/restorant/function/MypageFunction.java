package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.dto.MemberMypageDto;
import kh.mini.restorant.model.service.MemberService;

/**
 * Servlet implementation class MypageFunction
 */
@WebServlet("/mypagefunction")
public class MypageFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService memService = new MemberService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memCode = request.getParameter("memCode");
		System.out.println(memCode);
		MemberMypageDto result = new MemberService().mypage(memCode);
		
		System.out.println("controller  ::" + result);
		System.out.println("controller  email ::" +result.getMemEmail());
		if(result != null && !result.equals("")) {
			request.getSession().setAttribute("memEmail", result.getMemEmail());
			request.getSession().setAttribute("memId", result.getMemId());
			request.getSession().setAttribute("memPassword", result.getMemPassword());
			request.getSession().setAttribute("memPhone", result.getMemPhone());
		} else {
			System.out.println("로그인실패");
		}
	}

}
