package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.dto.RestorantGetCodeDto;
import kh.mini.restorant.model.service.RestorantService;

/**
 * Servlet implementation class RestorantGetCodeFunction
 */
@WebServlet("/restorantgetcodefunction")
public class RestorantGetCodeFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantGetCodeFunction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("================ SERVLET GET RESCODE 진입");
		String resName = request.getParameter("resName");
		Long resPhone = Long.parseLong(request.getParameter("resPhone"));
		System.out.println(resName);
		System.out.println(resPhone);
		
		RestorantGetCodeDto dto = new RestorantGetCodeDto(resName, resPhone);
		String result = new RestorantService().getResCode(dto);
		System.out.println(result);
		
		if(result != null && result != "") {
			System.out.println("GET RESCODE 성공");
			response.getWriter().append(String.valueOf(result));
		}
		System.out.println("================ SERVLET GET RESCODE 종료");
	}

}
