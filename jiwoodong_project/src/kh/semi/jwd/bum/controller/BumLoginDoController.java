package kh.semi.jwd.bum.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kh.semi.jwd.bum.model.dao.BumDao;
import kh.semi.jwd.bum.model.service.BumService;
import kh.semi.jwd.bum.model.service.BusinessReservationService;
import kh.semi.jwd.bum.model.vo.BumLoginVo;
import kh.semi.jwd.bum.model.vo.BumVo;

/**
 * Servlet implementation class BumLoginController
 */
@WebServlet("/bumLogin.lo")
public class BumLoginDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BumLoginDoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		out.println("<h1>잘못된 요청 방법입니다.</h>");
//		out.println("<a href='WEB-INF/login/bumLogin.jsp'>다시 로그인</a>");
   	//request.getRequestDispatcher("WEB-INF/login/loginProcess.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bu_id = request.getParameter("bu_id");
		String password = request.getParameter("password");
		String buNo = request.getParameter("buNo");
		
		System.out.println("bu_id : " + bu_id);
		System.out.println("password : " + password);
		
		BumLoginVo vo = new BumLoginVo();
		vo.setBuId(bu_id);
		vo.setBuPwd(password);
		vo.setBuName(vo.getBuName());
		vo.setBuNo(vo.getBuNo());
		
		BumLoginVo result = new BumService().loginBuMember(vo);
		System.out.println("controller BumLoginVo : " + result);
		// 사업자번호 뽑아서 세션에넣기
		int cpno = new BusinessReservationService().getCpno(result.getBuId());
		if(result != null && result.getBuId() !=null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("bu_id", result.getBuId());
			session.setAttribute("password", result.getBuPwd());
			session.setAttribute("buName", result.getBuName());
			session.setAttribute("cpNo", cpno);
			session.setAttribute("buNo", result.getBuNo());
			System.out.println("bu_id:"+bu_id);
			System.out.println("password:"+password);
			System.out.println("name:"+result.getBuName());
			
			System.out.println(request.getSession().getAttribute("cpNo"));
			System.out.println("로그인 성공한거지 여기가?네네 - 오늘의 명언... 언니 최고...");
			response.sendRedirect("BumMainPage");
		}else {
			 // 로그인 실패
			System.out.println("로그인 해주세요");
			//response.sendRedirect("bumLogin");
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('아이디/비밀번호를 확인해주세요.'); location.href='bumLogin';</script>");
		   // request.setAttribute("LoginErrMsg", "로그인 오류입니다."); 
		   // request.getRequestDispatcher("bumLogin").forward(request, response);
			
		}
		

	}

}
