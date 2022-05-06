package kh.semi.jwd.bum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.jwd.bum.model.service.BumService;
import kh.semi.jwd.bum.model.vo.CompanyVo;

/**
 * Servlet implementation class BusinessCompanyWriteDoServlet
 */
@WebServlet("/bucompanydo")
public class BusinessCompanyWriteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BusinessCompanyWriteDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		int result = 0;
		int buNo = 29;

//		PrintWriter out = response.getWriter();
//		// 파일 저장 경로
//		String fileSavePath = "upload";
//		// 파일 크기 10M 제한
//		int uploadSizeLimit = 10 * 1024 * 1024;
//		String encType = "UTF-8";
//		ServletContext context = getServletContext();
//		String uploadPath = context.getRealPath(fileSavePath);
//
//		MultipartRequest multi = new MultipartRequest(request, // request 객체
//				uploadPath, // 서버 상 업로드 될 디렉토리
//				uploadSizeLimit, // 업로드 파일 크기 제한
//				encType, // 인코딩 방법
//				new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
//		);
//		Enumeration files = multi.getFileNames();
//		out.println("<h2>멀티 파일 업로드 구현하기</h2>");
//		while (files.hasMoreElements()) {
//			// 업로드 된 파일 이름 얻어오기
//			String file = (String) files.nextElement();
//			String fileName = multi.getFilesystemName(file);
//			out.println("<br> 첨부파일명 : " + fileName);
//		}

		String cpName = request.getParameter("cpName");
		String cpCategory = request.getParameter("cpCategory");
		String cpExplain = request.getParameter("cpExplain");
		// String flGno
		String cpClassify = request.getParameter("cpClassify");
//		System.out.println(cpClassify);
		String cpOpenDate = request.getParameter("cpOpenDate");
//		System.out.println(cpOpenDate);
		String cpCloseDate = request.getParameter("cpCloseDate");
//		System.out.println(cpCloseDate);
		String cpOpenTime = request.getParameter("cpOpenTime");
//		System.out.println(cpOpenTime);
		String cpCloseTime = request.getParameter("cpCloseTime");
		String cpPostcode = request.getParameter("cpPostcode");
//		System.out.println("cpPostcode:" + cpPostcode);
		String cpAddress = request.getParameter("cpAddress");
		String cpDtaddress = request.getParameter("cpDtaddress");

		CompanyVo cvo = new CompanyVo();
		cvo.setBuNo(buNo);
		cvo.setCpName(cpName);
		cvo.setCpCategory(cpCategory);
		cvo.setCpExplain(cpExplain);
		cvo.setCpClassify(cpClassify);
		cvo.setCpOpenDate(cpOpenDate);
		cvo.setCpCloseDate(cpCloseDate);
		cvo.setCpOpenTime(cpOpenTime);
		cvo.setCpCloseTime(cpCloseTime);
		cvo.setCpPostcode(cpPostcode);
		cvo.setCpAddress(cpAddress);
		cvo.setCpDtaddress(cpDtaddress);
		System.out.println("cvo:" + cvo);

		result = new BumService().companyWrite(cvo);

		System.out.println("Controller result" + result);

		if(result < 1) {
			System.out.println("업체 등록실패============");
			PrintWriter out1 = response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			out1.println("<script language='javascript'>");
			out1.println("alert('업체등록에 실패하였습니다.'); location.href='BumMainPage'");
			out1.println("</script>");
			out1.flush();
		} else {
			System.out.println("업체 등록 *성공*");
			PrintWriter out1 = response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			out1.println("<script language='javascript'>");
			out1.println("alert('업체등록 요청이 완료되었습니다. 관리자에게 문의해주시기 바랍니다.'); location.href='BumMainPage'");
			out1.println("</script>");
			out1.flush();
		}
	}
}