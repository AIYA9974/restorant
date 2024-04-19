package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.dto.MemberInsertDto;
import kh.mini.restorant.model.service.MemberService;

/**
 * Servlet implementation class CreateAccountFunction
 */
@WebServlet("/createaccountfunction")
public class CreateAccountFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountFunction() {
        super();
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Create Account Function 연결 성공");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Long phone = Long.parseLong(request.getParameter("phone"));
		String email = request.getParameter("email");
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(phone);
		System.err.println(email);
		
		MemberInsertDto dto = new MemberInsertDto(id, pwd, phone, email);
		
		int result = new MemberService().insert(dto);
		if(result == 1) {
			System.out.println("성공");
			
		}
		response.getWriter().append(String.valueOf(result));
		
	}

}
