package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.mini.restorant.model.dto.RestorantMainPageDto;
import kh.mini.restorant.model.service.RestorantService;

/**
 * Servlet implementation class RestorantMainPageGetInfoFunction
 */
@WebServlet("/restorantmainpagegetinfofunction")
public class RestorantMainPageGetInfoFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantMainPageGetInfoFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("============RESTORANT MAIN PAGE GET INFO  Function 시작");
		String resCode = request.getParameter("resCode");
		RestorantMainPageDto result = new RestorantService().mainPageGetInfo(resCode);
		System.out.println(result);
		if(result != null) {
			String rsjson = new Gson().toJson(result);
			response.getWriter().append(String.valueOf(rsjson));
			System.out.println(rsjson);

		}
		System.out.println("============RESTORANT MAIN PAGE GET INFO  Function 종료");
	}

}
