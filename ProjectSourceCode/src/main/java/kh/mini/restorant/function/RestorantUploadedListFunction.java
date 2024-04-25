package kh.mini.restorant.function;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.mini.restorant.model.dto.RestorantUploadedListDto;
import kh.mini.restorant.model.service.RestorantService;

/**
 * Servlet implementation class RestorantUploadedListFunction
 */
@WebServlet("/restorantuploadedlistfunction")
public class RestorantUploadedListFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantUploadedListFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
   
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("리스트 펑션 시작");
		
		String ownerCode = request.getParameter("ownerCode");
		
		System.out.println("Function resList resCode :"+ownerCode);
		List<RestorantUploadedListDto> list = new RestorantService().selectAllList(ownerCode);
		System.out.println("Function resList result : "+list);
		
		String listJson = new Gson().toJson(list);
		System.out.println("json List : "+listJson);
		response.getWriter().append(listJson);
		
		System.out.println("리스트 펑션 끝");
	}

}

