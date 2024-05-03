package kh.mini.restorant.function;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.mini.restorant.model.dto.MenuSelectAllDto;
import kh.mini.restorant.model.service.MenuService;

/**
 * Servlet implementation class RestorantMenuFunction
 */
@WebServlet("/restorantmenulistfunction")
public class RestorantMenuListFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantMenuListFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========RES MENU SELECT ALL FUNCTION 진입");
		String resCode = request.getParameter("resCode");
		List<MenuSelectAllDto> list = new MenuService().selectAll(resCode);
		System.out.println("List<MenuSelectAllDto> : "+list);
		if(list == null) {
			request.getSession().setAttribute("menuList", 2);
			response.getWriter().append(String.valueOf(2));
		}else if(list.size() >= 1) {
			request.getSession().setAttribute("menuList", 1);
			String listJson = new Gson().toJson(list);
			System.out.println("json list : "+listJson);
			response.getWriter().append(listJson);
		}else {
			System.out.println("오류발생");
			request.getSession().setAttribute("menuList", 3);
			response.getWriter().append(String.valueOf(3));
		}
		

		System.out.println("========RES MENU SELECT ALL FUNCTION 종료");

	}

}
