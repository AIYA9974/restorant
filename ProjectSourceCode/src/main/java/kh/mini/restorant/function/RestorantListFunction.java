package kh.mini.restorant.function;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.mini.restorant.model.dto.RestorantPageListDto;
import kh.mini.restorant.model.service.RestorantService;

/**
 * Servlet implementation class RestorantListFunction
 */
@WebServlet("/restorantlistfunction")
public class RestorantListFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantListFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========RESTORANT SELECT ALL LIST FUNCTION 시작");
		String resKind = request.getParameter("resKind");
		List<RestorantPageListDto> list = new RestorantService().selectAllRestorantList(resKind);
		System.out.println("List<RestorantPageListDto> : "+list);
		String listJson = new Gson().toJson(list);
		System.out.println("json list : "+listJson);
		
		if(list == null) {
			System.out.println("등록된 정보가 없습니다");
		}else if(list.size() >= 1) {
			
			response.getWriter().append(listJson);
		}else {
			System.out.println("오류발생");
		}
		System.out.println("========RESTORANT SELECT ALL LIST FUNCTION 종료");
	}

}
