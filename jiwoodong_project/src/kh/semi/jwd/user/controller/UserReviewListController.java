package kh.semi.jwd.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.jwd.user.model.service.UserService;

/**
 * Servlet implementation class UserReviewListController
 */
@WebServlet("/userreviewlist")
public class UserReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReviewListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("안녕!");
		String umId = (String)request.getSession().getAttribute("um_id");
		
		System.out.println("umId"+umId);
		ArrayList<Map<String, Object>> userrvlist = new UserService().userRvlist(umId);
		System.out.println("userrvlist:"+userrvlist);
		request.setAttribute("userrvlist", userrvlist);
		
		
		
		request.getRequestDispatcher("WEB-INF/review/reviewlist.jsp").forward(request, response);
		//request.getRequestDispatcher("WEB-INF/review/review.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
