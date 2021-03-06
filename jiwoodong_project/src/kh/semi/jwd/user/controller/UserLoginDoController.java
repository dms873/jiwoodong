package kh.semi.jwd.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kh.semi.jwd.user.model.service.UserService;
import kh.semi.jwd.user.model.vo.UserLoginVo;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/userLogin.lo")
public class UserLoginDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginDoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("WEB-INF/login/umLogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String um_id = request.getParameter("um_id");
		String password = request.getParameter("password");
		
		System.out.println("um_id : " + um_id);
		System.out.println("password : " + password);
		
		UserLoginVo vo = new UserLoginVo();
		vo.setUmId(um_id);
		vo.setUmPwd(password);
		vo.setUmName(vo.getUmName());
		vo.setUmUseYn(vo.getUmUseYn());
		
		UserLoginVo result = new UserService().loginUserMember(vo);
		System.out.println("controller UserLoginVo : " + result);
		System.out.println("umUseYn:"+result.getUmUseYn());
		String umUseYn = result.getUmUseYn();
		
		
		
		
//		if((umUseYn == "N") && (result != null && result.getUmId() != null) ) {
//		if( result != null && result.getUmId() != null) {
//			HttpSession session = request.getSession();
//			
//			session.setAttribute("um_id", result.getUmId());
//			session.setAttribute("password", result.getUmPwd());
//			session.setAttribute("umName", result.getUmName());
//			// ?????? ??? ????????? ??? ????????? ?????? ???????????? ?????? : ?????????
//			session.setAttribute("umTel", result.getUmTel());
//			session.setAttribute("umPostcode", result.getUmPostcode());
//			session.setAttribute("umAddress", result.getUmAddress());
//			
//			System.out.println("um_id:"+um_id);
//			System.out.println("password:"+password);
//			System.out.println("name:"+result.getUmName());
//			
//			System.out.println("umTel : " + result.getUmTel());
//			System.out.println("umPostcode : " + result.getUmPostcode());
//			System.out.println("umAddress : " + result.getUmAddress());
//			
//			System.out.println("????????? ??????????????? ???????????????? - ????????? ??????... ?????? ??????...");
//			response.sendRedirect("/jwd");
//		}
////		else if( result != null && result.getUmId() != null ) {
////			PrintWriter out = response.getWriter();
////			out.println("<script>alert('????????? ???????????????. ?????? ???????????? ????????????????????????'); location.href='enrollMain';</script>");
////			out.flush();
////			System.out.println("?????? umUseYn:"+umUseYn);
////			System.out.println("?????? result.getUmId():"+result.getUmId());
////			System.out.println("?????? result:"+result);
////		}
//		else {
//			// ????????? ??????
//			System.out.println("????????? ????????????");
//			//response.sendRedirect("userLogin");
//			System.out.println("else umUseYn:"+umUseYn);
//			System.out.println("else result.getUmId():"+result.getUmId());
//			System.out.println("else result:"+result);
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('?????????/??????????????? ??????????????????.'); location.href='userLogin';</script>");
//			out.flush();
//		}
		
	 if(result != null && result.getUmId() != null){
				if(umUseYn.equals("Y")) {
					
					HttpSession session = request.getSession();
					
					session.setAttribute("um_id", result.getUmId());
					session.setAttribute("password", result.getUmPwd());
					session.setAttribute("umName", result.getUmName());
					// ?????? ??? ????????? ??? ????????? ?????? ???????????? ?????? : ?????????
					session.setAttribute("umTel", result.getUmTel());
					session.setAttribute("umPostcode", result.getUmPostcode());
					session.setAttribute("umAddress", result.getUmAddress());
					
					System.out.println("um_id:"+um_id);
					System.out.println("password:"+password);
					System.out.println("name:"+result.getUmName());
					
					System.out.println("umTel : " + result.getUmTel());
					System.out.println("umPostcode : " + result.getUmPostcode());
					System.out.println("umAddress : " + result.getUmAddress());
					
					System.out.println("????????? ??????????????? ???????????????? - ????????? ??????... ?????? ??????...");
					response.sendRedirect("/jwd");
				}else if(umUseYn.equals("N")){
				PrintWriter out = response.getWriter();
				out.println("<script>alert('????????? ???????????????. ?????? ???????????? ????????????????????????'); location.href='enrollMain';</script>");
				out.flush();
				System.out.println("?????? umUseYn:"+umUseYn);
				System.out.println("?????? result.getUmId():"+result.getUmId());
				System.out.println("?????? result:"+result);
				}
			
			}else {
				// ????????? ??????
				System.out.println("????????? ????????????");
				//response.sendRedirect("userLogin");
				System.out.println("else umUseYn:"+umUseYn);
				System.out.println("else result.getUmId():"+result.getUmId());
				System.out.println("else result:"+result);
				PrintWriter out = response.getWriter();
				out.println("<script>alert('?????????/??????????????? ??????????????????.'); location.href='userLogin';</script>");
				out.flush();
			}
		
	}

}
