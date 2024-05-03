package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.dto.RestorantCommonInfoDto;
import kh.mini.restorant.model.service.RestorantCommonInfoService;

/**
 * Servlet implementation class RestorantInfoInsertFunction
 */
@WebServlet("/restorantcommoninfoinsertfunction")
public class RestorantInfoInsertFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantInfoInsertFunction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========SERVLET RES INFO 진입");
		
		String resCode = request.getParameter("resCode");
		String placeAlone = request.getParameter("placeAlone");
		String placeGroup = request.getParameter("placeGroup");
		String sitFloor = request.getParameter("sitFloor");
		String sitChair = request.getParameter("sitChair");
		String standing = request.getParameter("standing");
		System.out.println("resCode : "+resCode);
		System.out.println("placeAlone : "+placeAlone);
		System.out.println("placeGroup : "+placeGroup);
		System.out.println("sitFloor : "+sitFloor);
		System.out.println("sitChair : "+sitChair);
		System.out.println("standing : "+standing);
		
		
		int result = new RestorantCommonInfoService().insert(new RestorantCommonInfoDto(resCode, placeAlone, placeGroup, sitFloor, sitChair, standing));
		System.out.println(result);
		if(result == 1) {
			System.out.println("SERVLET RES INFO : 성공하였습니다");
			response.getWriter().append(String.valueOf(result));
		}else {
			System.out.println("SERVLET RES INFO : 실패하였습니다");
		}
		
		System.out.println("========SERVLET RES INFO 완료");

	}

}
