package kh.semi.jwd.user.model.service;


import static kh.semi.jwd.common.jdbc.JdbcDBCP.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Map;

import kh.semi.jwd.bum.model.vo.CompanyVo;
import kh.semi.jwd.bum.model.vo.ReviewVo;
import kh.semi.jwd.user.model.dao.UserDao;
import kh.semi.jwd.user.model.dao.UserReviewDao;
import kh.semi.jwd.user.model.vo.UserBookingListVo;
import kh.semi.jwd.user.model.vo.UserLoginVo;
import kh.semi.jwd.user.model.vo.UserVo;

public class UserService {

	//승희 - 사용자 회원가입 
	public int insertUserMember(UserVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = new UserDao().insertUserMember(conn, vo);
			close(conn);
			return result;			
	}
	//승희 - 아이디 중복 체크
	public int checkUmId(String umId) {
		int result;
		Connection conn = getConnection();
		result = new UserDao().checkUmId(conn, umId);
		close(conn);
		System.out.println("checkUmId result:" + result);
		return result;
		
	}
	//승희 - 사용자 로그인
	public UserLoginVo loginUserMember(UserLoginVo vo) {
		UserLoginVo uvo = new UserLoginVo();
		Connection conn = getConnection();
		uvo = new UserDao().loginUserMember(conn, vo);
		close(conn);
		// System.out.println("loginBuMember bvo:" + bvo);
		return uvo;
		
	}
	
	// 내 정보 수정 : 손은진
	public int updateUmInfo(UserVo uvo) {
		int result = 0;
		
		Connection conn = getConnection();
		result = new UserDao().updateUmInfo(conn, uvo);
		close(conn);
		
		return result;
	}
	
	// 내 정보 조회 : 손은진
	public UserVo usMemberListInfo(String umId) {
		UserVo result = null;

		Connection conn = getConnection();
		result = new UserDao().usMemberListInfo(conn, umId);
		close(conn);

		return result;
	}
	
	// 회원 탈퇴 : 손은진
	public int deleteUmInfo(UserVo uvo) {
		int result = 0;

		Connection conn = getConnection();
		result = new UserDao().deleteUmInfo(conn, uvo);
		close(conn);

		return result;
	}
	
	// 사용자 마이페이지 - 업체 조회 : 최규식
		public ArrayList<CompanyVo> usCpList() {
			
			 ArrayList<CompanyVo> volist = null;
			 
			 Connection conn = getConnection();
			 volist = new UserDao().usCpList(conn);
			 close(conn);
			 
			 return volist;
			
		}
		
	// 사용자 마이페이지 - 예약 현황 조회 : 최규식
	public ArrayList<Map<String, Object>> usBkList(String umId) {
		
		ArrayList<Map<String, Object>> volist = null;
		Connection conn = getConnection();
		volist = new UserDao().usBkList(conn, umId);
		close(conn);
		
		return volist;
	}
	
	// 사용자 마이페이지 - 리뷰 내역 조회 : 최규식
	public ArrayList<Map<String, Object>> usRvList(String umId) {
		Connection conn = getConnection();
		ArrayList<Map<String, Object>> usRvList = new UserDao().usRvList(conn, umId);
		close(conn);
		System.out.println("usRvList:" + usRvList);
		return usRvList;
	}
	
	// 사용자 마이페이지 - 예약 현황(취소/c) 조회 : 최규식
	public ArrayList<Map<String, Object>> usBkList_c(String umId) {
		
		ArrayList<Map<String, Object>> volist = null;
		
		Connection conn = getConnection();
		
		volist = new UserDao().usBkList_c(conn, umId);
		
		close(conn);
		
		return volist;
	}
	
	// 사용자 마이페이지 - 예약 현황(완료/r) 조회 : 최규식
	public ArrayList<Map<String, Object>> usBkList_r(String umId) {
		
		ArrayList<Map<String, Object>> volist = null;
		
		Connection conn = getConnection();
		
		volist = new UserDao().usBkList_r(conn, umId);
		
		close(conn);
		
		return volist;
	}
	
	
		// 승희 -사용자 리뷰 페이지
		public ArrayList<Map<String, Object>> userRvlist(String umId){
			Connection conn = getConnection();
			ArrayList<Map<String, Object>> volist = new UserReviewDao().userRvlist(conn, umId);
			close(conn);
			System.out.println("userRvlist volist:"+volist);
			return volist;
		}
		//승희 - 사용자 리뷰 상세 조회
		public ArrayList<Map<String, Object>> userRvDetailList(int rvNo) {
			
			ArrayList<Map<String, Object>> volist = null;
			
			Connection conn = getConnection();
			volist = new UserReviewDao().userRvDetailList(conn, rvNo);
			close(conn);
			System.out.println("userRvDetailList volist:"+volist);
			return volist;
		
		}
		//승희 - 사용자 리뷰 작성
		public int insertReview(ReviewVo vo) {
			Connection conn = getConnection();
			int result = new UserReviewDao().insertReview(conn, vo);
			System.out.println("user서비스의 result: "+result);
			close(conn);
			return result;
		}
		//승희 - 사용자 리뷰 수정
		public int updateUserReview(String rvContent,String fileUrl,int rvScore,int rvNo) {
			Connection conn = getConnection();
			int result = new UserReviewDao().updateUserReview(conn, rvContent, fileUrl, rvScore, rvNo);
			close(conn);
			System.out.println("updateUserReview result: "+result);
			return result;
		}
		//승희 - 사용자 리뷰 삭제
		public int deleteReview(int rvNo) {
			Connection conn = getConnection();
			int result = new UserReviewDao().deleteReview(conn, rvNo);
			close(conn);
			System.out.println("deleteReview result : "+result);
			return result;
		}
	
}
