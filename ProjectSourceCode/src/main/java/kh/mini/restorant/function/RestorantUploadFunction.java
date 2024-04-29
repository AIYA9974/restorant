package kh.mini.restorant.function;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mini.restorant.model.dto.RestorantDto;
import kh.mini.restorant.model.service.RestorantService;

/**
 * Servlet implementation class UploadRestorantFunction
 */
@WebServlet("/restorantuploadfunction")
public class RestorantUploadFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorantUploadFunction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Upload Restorant Function 시작");
		
		String ownerCode = request.getParameter("OwnerCode");
		String resName = request.getParameter("resName");
		Long resPhone = Long.parseLong(request.getParameter("resPhone"));
		Long resSubPhone = Long.parseLong(request.getParameter("resSubPhone"));
		String resEmail = request.getParameter("resEmail");
		String resLoc = request.getParameter("resLoc");
		String resMsg = request.getParameter("resMsg");
		String resKind = request.getParameter("resKind");
		
		System.out.println("FUNCTION :"+ownerCode);
		System.out.println("FUNCTION :"+resName);
		System.out.println("FUNCTION :"+resPhone);
		System.out.println("FUNCTION :"+resSubPhone);
		System.out.println("FUNCTION :"+resEmail);
		System.out.println("FUNCTION :"+resLoc);
		System.out.println("FUNCTION :"+resMsg);
		System.out.println("FUNCTION :"+resKind);
		
		RestorantDto dto = new RestorantDto(ownerCode, resName, resPhone, resSubPhone, resEmail, resLoc, resMsg, resKind);
		int result = new RestorantService().insert(dto);
		System.out.println("FUNCTION :"+result);
		if(result == 1) {
			System.out.println("등록 성공");
		}else {
			System.out.println("등록 실패");
		}
		response.getWriter().append(String.valueOf(result));
		System.out.println("Upload Restorant Function 끝");
	}

}
