package kh.semi.jwd.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.jwd.user.model.service.UserService;
import kh.semi.jwd.user.model.vo.UserVo;

/**
 * Servlet implementation class UserDeleteInfoDoController
 */
@WebServlet("/UserInfoDelete")
public class UserInfoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// String umId = "apple";
		String umId = (String) request.getSession().getAttribute("um_id");
		
		UserVo usMemberListInfo = new UserService().usMemberListInfo(umId);
		request.setAttribute("usMemberListInfo", usMemberListInfo);
		
		request.getRequestDispatcher("WEB-INF/user/userInfoDelete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		request.getRequestDispatcher("WEB-INF/user/userDeleteInfo.jsp").forward(request, response);
//		
//		
//	}

}
