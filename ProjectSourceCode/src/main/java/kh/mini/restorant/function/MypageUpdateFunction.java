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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memCode = request.getParameter("memCode");
		String password = request.getParameter("password");
		Long phone = Long.parseLong(request.getParameter("phone"));
		String email = request.getParameter("email");
		System.out.println("memCode"+memCode);
		System.out.println("password"+password);
		System.out.println("phone"+phone);
		System.out.println("email"+email);
		MemberUpdateDto dto = new MemberUpdateDto(memCode, password, phone, email);
		System.out.println(dto);
		
		int result = new MemberService().update(dto);
		if(result == 1 ) {
			System.out.println("회원 정보 수정되었습니다");
			response.getWriter().append(String.valueOf(result));
		}
	}

}
