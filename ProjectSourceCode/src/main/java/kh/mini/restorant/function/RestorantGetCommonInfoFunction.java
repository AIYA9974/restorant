package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kh.mini.restorant.model.dto.RestorantGetCommonInfoDto;
import kh.mini.restorant.model.service.RestorantCommonInfoService;

/**
 * Servlet implementation class RestorantGetCommonInfoFunction
 */
@WebServlet("/restorantgetcommoninfofunction")
public class RestorantGetCommonInfoFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantGetCommonInfoFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=============RES GET COMMON INFO FUNCTION 시작");
		String resCode = request.getParameter("resCode");
		RestorantGetCommonInfoDto result = new RestorantCommonInfoService().selectOne(resCode);
		System.out.println(result);
		
		request.getSession().setAttribute("sssPlaceAlone", result.getPlaceAlone());
		request.getSession().setAttribute("sssPlaceGroup", result.getPlaceGroup());
		request.getSession().setAttribute("sssSitFloor", result.getSitFloor());
		request.getSession().setAttribute("sssSitChair", result.getSitChair());
		request.getSession().setAttribute("sssStanding", result.getStanding());
		
		
		System.out.println("=============RES GET COMMON INFO FUNCTION 종료");
	}

}
