package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.dto.RestorantUpdateDto;
import kh.mini.restorant.model.service.RestorantService;

/**
 * Servlet implementation class RestorantUpdateFunction
 */
@WebServlet("/restorantupdatefunction")
public class RestorantUpdateFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantUpdateFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=========RESTORANT UPDATE FUNCTION 진입");
		
		String resCode = request.getParameter("resCode");
		String resName = request.getParameter("resName");
		Long resPhone = Long.parseLong(request.getParameter("resPhone"));
		Long resSubPhone = Long.parseLong(request.getParameter("resSubPhone"));
		String resEmail = request.getParameter("resEmail");
		String resLoc = request.getParameter("resLoc");
		String resMsg = request.getParameter("resMsg");
		RestorantUpdateDto dto = new RestorantUpdateDto(resCode, resName, resPhone, resSubPhone, resEmail, resLoc, resMsg);
		System.out.println(dto);
		
		
		
		int result = new RestorantService().update(dto);
		System.out.println(result);
		
		if(result == 1) {
			System.out.println("UPDATE FUNCTION 성공");
			response.getWriter().append(String.valueOf(result));
		}else {
			System.out.println("UPDATE FUNCTION 실패");
		}
		
		System.out.println("=========RESTORANT UPDATE FUNCTION 탈출");
	}

}
