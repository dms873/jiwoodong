package kh.semi.jwd.bum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.semi.jwd.bum.model.service.BusinessReservationService;
import kh.semi.jwd.bum.model.vo.BumReservationVo;

/**
 * Servlet implementation class BusinessReservationSelectStatus
 */
@WebServlet("/selectStatusDayCafe")
public class BusinessReservationSelectStatusDayCafeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessReservationSelectStatusDayCafeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
        PrintWriter out = response.getWriter();
		String date = request.getParameter("day");
		String status = request.getParameter("status");
		int cpNo = (int) request.getSession().getAttribute("cpNo");
		ArrayList<BumReservationVo> list = new BusinessReservationService().selectStatusCafe(date, cpNo, status);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String list1 = gson.toJson(list);
//		JSONArray jsonArray = new JSONArray ();
//
//		JSONObject json = null;
//
//		for(int i=0; i<list.size();i++){
//
//		  json = new JSONObject();
//
//		  BumReservationVo vo = (BumReservationVo) list.get(i);
//		   json.put("bkTotalPrice", vo.getBkTotalPrice());
//		   json.put("bkNo",vo.getBkNo());
//		   json.put("umId",vo.getUmId());
//		   json.put("bkName",vo.getBkName());
//		   json.put("bkPhone",vo.getBkPhone());
//		   json.put("bkDate",vo.getBkDate());
//		   json.put("bkTime",vo.getBkTime());
//		   json.put("menuName",vo.getMenuName());
//		   json.put("menuNo",vo.getMenuNo());
//		   json.put("menuCount", vo.getMenuCount());
//		   json.put("menuPrice",vo.getMenuPrice());
//		   json.put("bkRequire",vo.getBkRequire());
//		   json.put("bkStatus",vo.getBkStatus());
//		   json.put("bkmCount", vo.getBkmCount());
//		  jsonArray.add(json);
//
//		}
		out.println(list1);
		out.flush();
		out.close();
	}

}
