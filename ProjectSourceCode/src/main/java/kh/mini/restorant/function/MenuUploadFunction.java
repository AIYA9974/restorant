package kh.mini.restorant.function;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.mini.restorant.model.dto.MenuInsertDto;
import kh.mini.restorant.model.service.MenuService;

/**
 * Servlet implementation class MenuUploadFunction
 */
@WebServlet("/menuuploadfunction")
public class MenuUploadFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuUploadFunction() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		// 방법 - gson 최신 버전용 완전 잘됨
		MenuInsertDto[] reqVoArray = gson.fromJson(request.getReader(), MenuInsertDto[].class);
		List<MenuInsertDto> reqVoList = Arrays.asList(reqVoArray);
		System.out.println(reqVoList);
		int result = 0; // TODO
		
		result = new MenuService().insert(reqVoList);
		response.getWriter().append(String.valueOf(result));
	}

}
