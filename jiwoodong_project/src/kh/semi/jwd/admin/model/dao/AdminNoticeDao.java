package kh.semi.jwd.admin.model.dao;

import static kh.semi.jwd.common.jdbc.JdbcDBCP.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kh.semi.jwd.admin.model.vo.AdminNoticeVo;

public class AdminNoticeDao {
	private static PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 글쓰기
	public int insertNotice(Connection conn, AdminNoticeVo adnvo) {
		int result = 0;

		//		NT_NO         NOT NULL NUMBER         
		//		NT_TITLE      NOT NULL VARCHAR2(300)  
		//		NT_CONTENT    NOT NULL VARCHAR2(4000) 
		//		NT_WRITE_DATE NOT NULL TIMESTAMP(6)   
		//		NT_COUNT      NOT NULL NUMBER         

		String sql = "INSERT INTO NOTICE VALUES (NOTICE_SEQ.NEXTVAL, ?, ?, DEFAULT, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adnvo.getNtTitle());
			pstmt.setString(2, adnvo.getNtContent());
			pstmt.setString(3, adnvo.getFlGno());
			result = pstmt.executeUpdate();
			return result; // 성공 시 result 반환
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return -1; // 오류면 -1 반환
	}

	// 글조회(메인)
	public ArrayList<AdminNoticeVo> noticeList(Connection conn) {

		ArrayList<AdminNoticeVo> voList = null;

		//		String sql = "SELECT * FROM NOTICE ORDER BY NT_WRITE_DATE DESC";
		//		String sql = "SELECT * FROM(SELECT A.*, ROWNUM RNUM FROM (SELECT NT_NO, NT_TITLE, NT_CONTENT, TO_CHAR(NT_WRITE_DATE, 'YYYY/MM/DD') FROM NOTICE ORDER BY NT_WRITE_DATE DESC) A) WHERE RNUM BETWEEN 1 AND 10";
		String sql = "SELECT B.NT_NO, B.NT_TITLE, B.NT_CONTENT, B.NT_WRITE_DATE FROM(SELECT ROWNUM RNUM, A.* FROM (SELECT NT_NO, NT_TITLE, NT_CONTENT, TO_CHAR(NT_WRITE_DATE, 'YYYY/MM/DD') AS NT_WRITE_DATE FROM NOTICE ORDER BY NT_NO DESC) A) B WHERE RNUM BETWEEN 1 AND 9";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				voList = new ArrayList<AdminNoticeVo>();
				//				NT_NO         NOT NULL NUMBER         
				//				NT_TITLE      NOT NULL VARCHAR2(300)  
				//				NT_CONTENT    NOT NULL VARCHAR2(4000) 
				//				NT_WRITE_DATE NOT NULL TIMESTAMP(6)   
				//				NT_COUNT      NOT NULL NUMBER 
				do {
					AdminNoticeVo adnvo = new AdminNoticeVo();
					adnvo.setNtNo(rs.getInt(1));
					adnvo.setNtTitle(rs.getString(2));
					adnvo.setNtContent(rs.getString(3));
					adnvo.setNtDate(rs.getString(4));

					voList.add(adnvo);
					// System.out.println("dao다. 값 담겼니?" + voList);

				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return voList;
	}

	// 글조회(공지사항조회) - 페이징
	public ArrayList<AdminNoticeVo> noticeListDetailPaging(Connection conn, int startRnum, int endRnum) {

		ArrayList<AdminNoticeVo> voList = null;

		//		String sql = "SELECT * FROM NOTICE ORDER BY NT_WRITE_DATE DESC";
		//		String sql = "SELECT * FROM(SELECT A.*, ROWNUM RNUM FROM (SELECT NT_NO, NT_TITLE, NT_CONTENT, TO_CHAR(NT_WRITE_DATE, 'YYYY/MM/DD') FROM NOTICE ORDER BY NT_WRITE_DATE DESC) A) WHERE RNUM BETWEEN 1 AND 10";
		String sql = "SELECT B.NT_NO, B.NT_TITLE, B.NT_CONTENT, B.NT_WRITE_DATE "
				+ " FROM(SELECT ROWNUM RNUM, A.* FROM (SELECT NT_NO, NT_TITLE, NT_CONTENT, "
				+ " TO_CHAR(NT_WRITE_DATE, 'YYYY/MM/DD') AS NT_WRITE_DATE FROM NOTICE ORDER BY NT_NO DESC) A) B "
				+ " WHERE RNUM BETWEEN ? AND ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				voList = new ArrayList<AdminNoticeVo>();
				//				NT_NO         NOT NULL NUMBER         
				//				NT_TITLE      NOT NULL VARCHAR2(300)  
				//				NT_CONTENT    NOT NULL VARCHAR2(4000) 
				//				NT_WRITE_DATE NOT NULL TIMESTAMP(6)   
				//				NT_COUNT      NOT NULL NUMBER 
				do {
					AdminNoticeVo adnvo = new AdminNoticeVo();
					adnvo.setNtNo(rs.getInt(1));
					adnvo.setNtTitle(rs.getString(2));
					adnvo.setNtContent(rs.getString(3));
					adnvo.setNtDate(rs.getString(4));

					voList.add(adnvo);
					// System.out.println("dao다. 값 담겼니?" + voList);

				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return voList;
	}
	
	// 글조회(공지사항조회) - 페이징 & 검색
		public ArrayList<AdminNoticeVo> noticeListDetailSearchPaging(Connection conn, String field, String query, int startRnum, int endRnum) {

			String ntContent = '%' + query + '%';
			
			// System.out.println("title값 잘 왔니?" + ntTitle + "content값 잘 왔니?" + ntContent);
			
			ArrayList<AdminNoticeVo> voList = null;

			//		String sql = "SELECT * FROM NOTICE ORDER BY NT_WRITE_DATE DESC";
			//		String sql = "SELECT * FROM(SELECT A.*, ROWNUM RNUM FROM (SELECT NT_NO, NT_TITLE, NT_CONTENT, TO_CHAR(NT_WRITE_DATE, 'YYYY/MM/DD') FROM NOTICE ORDER BY NT_WRITE_DATE DESC) A) WHERE RNUM BETWEEN 1 AND 10";
			String sql = "SELECT NT_NO, NT_TITLE, NT_CONTENT, NT_WRITE_DATE FROM"
					+ "	(SELECT ROWNUM RNUM, A.* FROM (SELECT NT_NO, NT_TITLE, NT_CONTENT, "
					+ "	TO_CHAR(NT_WRITE_DATE, 'YYYY/MM/DD') AS NT_WRITE_DATE FROM NOTICE WHERE "+ field +" LIKE ? ORDER BY NT_NO DESC) A ) WHERE RNUM BETWEEN ? AND ?";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ntContent);
				pstmt.setInt(2, startRnum);
				pstmt.setInt(3, endRnum);
				rs = pstmt.executeQuery();

				if(rs.next()) {
					voList = new ArrayList<AdminNoticeVo>();
					//				NT_NO         NOT NULL NUMBER         
					//				NT_TITLE      NOT NULL VARCHAR2(300)  
					//				NT_CONTENT    NOT NULL VARCHAR2(4000) 
					//				NT_WRITE_DATE NOT NULL TIMESTAMP(6)   
					//				NT_COUNT      NOT NULL NUMBER 
					do {
						AdminNoticeVo adnvo = new AdminNoticeVo();
						adnvo.setNtNo(rs.getInt(1));
						adnvo.setNtTitle(rs.getString(2));
						adnvo.setNtContent(rs.getString(3));
						adnvo.setNtDate(rs.getString(4));

						voList.add(adnvo);
						// System.out.println("dao다. 값 담겼니?" + voList);

					} while (rs.next());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return voList;
		}

	// 글 수정
	public int updateNotice(Connection conn, AdminNoticeVo adnvo) {
		int result = 0;

		//			NT_NO         NOT NULL NUMBER         
		//			NT_TITLE      NOT NULL VARCHAR2(300)  
		//			NT_CONTENT    NOT NULL VARCHAR2(4000) 
		//			NT_WRITE_DATE NOT NULL TIMESTAMP(6)   
		//			NT_COUNT      NOT NULL NUMBER         

		String sql = "UPDATE NOTICE SET NT_TITLE = ?, NT_CONTENT = ?, FL_GNO = ? WHERE NT_NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adnvo.getNtTitle());
			pstmt.setString(2, adnvo.getNtContent());
			pstmt.setString(3, adnvo.getFlGno());
			pstmt.setInt(4, adnvo.getNtNo());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 글 수정(파일 없을 때)
	public int updateNoticeNtNc(Connection conn, AdminNoticeVo adnvo) {
		int result = 0;

		//			NT_NO         NOT NULL NUMBER         
		//			NT_TITLE      NOT NULL VARCHAR2(300)  
		//			NT_CONTENT    NOT NULL VARCHAR2(4000) 
		//			NT_WRITE_DATE NOT NULL TIMESTAMP(6)   
		//			NT_COUNT      NOT NULL NUMBER         

		String sql = "UPDATE NOTICE SET NT_TITLE = ?, NT_CONTENT = ? WHERE NT_NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adnvo.getNtTitle());
			pstmt.setString(2, adnvo.getNtContent());
			pstmt.setInt(3, adnvo.getNtNo());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 글 삭제
	public int deleteNotice(Connection conn, AdminNoticeVo adnvo) {
		int result = 0;

		String sql = "DELETE FROM NOTICE WHERE NT_NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adnvo.getNtNo());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 특정 게시글 번호의 모든 정보
	public AdminNoticeVo readNotice(Connection conn, int ntNo) {

		AdminNoticeVo adnvo = null;

		String sql = "SELECT NT_NO, NT_TITLE, NT_CONTENT, TO_CHAR(NT_WRITE_DATE, 'YYYY/MM/DD'), FL_GNO "
				+ " FROM NOTICE WHERE NT_NO = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ntNo);
			rs = pstmt.executeQuery();

			adnvo = new AdminNoticeVo();
			if(rs.next()) {
				adnvo.setNtNo(rs.getInt(1));
				adnvo.setNtTitle(rs.getString(2));
				adnvo.setNtContent(rs.getString(3));
				adnvo.setNtDate(rs.getString(4));
				adnvo.setFlGno(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return adnvo;
	}

	// 공지사항 글 개수
	public int countNoticeList(Connection conn) {

		int result = 0;

		String sql = "SELECT COUNT(*) FROM NOTICE";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;

	}
	
	// 공지사항 검색된 것 개수 확인
	public int countNoticeSearchList(Connection conn, String field, String query) {

		String ntContent = '%' + query + '%';

		int result = 0;

		String sql = "SELECT COUNT(*) FROM NOTICE WHERE " + field + " LIKE '" + ntContent + "'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		// System.out.println("dao에서 개수맞게 들어갔을까 ? : " + result);
		return result;

	}

}
