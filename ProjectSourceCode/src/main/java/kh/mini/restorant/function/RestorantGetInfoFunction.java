package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.mini.restorant.model.dto.RestorantGetInfoDto;
import kh.mini.restorant.model.service.RestorantService;

/**
 * Servlet implementation class RestorantUpdateGetInfoFunction
 */
@WebServlet("/restorantgetinfofunction")
public class RestorantGetInfoFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantGetInfoFunction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=========GET INFO FUNCTION 진입");
		RestorantGetInfoDto result = null;
		
		String resCode = request.getParameter("resCode");
		System.out.println("GET INFO FUNCTION resCode : " +resCode);
		
		result = new RestorantService().getInfo(resCode);
		System.out.println("GET INFO FUNCTION result : " +result);
		
		String rsJson = new Gson().toJson(result); 
		System.out.println("GET INFO FUNCTION rsJson : " +rsJson);
		if(rsJson != null) {
			response.getWriter().append(rsJson);
			
			
		System.out.println("=========GET INFO FUNCTION 종료");
		}
		
	}

}
