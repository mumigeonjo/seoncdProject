package mumi.model.service;

import java.sql.SQLException;
import java.util.List;


import mumi.model.dao.MumiDAO;
import mumi.model.dao.MumiDAOImpl;
import mumi.model.dao.UserDAO;
import mumi.model.dao.UserDAOImpl;
import mumi.model.dto.CartDTO;
import mumi.model.dto.MemberDTO;
import mumi.model.dto.NoticeDTO;
import mumi.model.dto.OrderDTO;
import mumi.model.dto.ProductDTO;
import mumi.model.dto.QADTO;
import mumi.model.dto.QAReplyDTO;
import mumi.model.dto.ReviewDTO;

public class MumiService {
	private static MumiDAO mumiDAO = new MumiDAOImpl();
	private static UserDAO userDAO = new UserDAOImpl();
	
	/**장바구니 삭제
	 */
	public static int deleteCart(int oIndexNo) throws SQLException{
		int result=userDAO.cartDelete(oIndexNo);
		if(result==0)
			throw new SQLException("삭제 실패");
		return result;
	}

	// 회원가입
	public static int insertUser(MemberDTO memberDTO) throws SQLException {
		int result = userDAO.insertMember(memberDTO);
		if(result==0) {throw new SQLException();}
		return result;
	}
	
	/**장바구니 삽입
	 */
	public static int insertCart(OrderDTO orderDTO) throws SQLException{
		int result = userDAO.cartInsert(orderDTO);
		if(result==0)
			throw new SQLException("장바구니 추가 실패");
		return result;
	}

	// 로그인
	public static MemberDTO selectUserById(String id, String pwd) throws SQLException {
		MemberDTO memberDTO = userDAO.loginFunction(id, pwd);
		return memberDTO;
	}
	
	/**장바구니 읽기
	 */
	public static List<CartDTO> readCart(String id) throws SQLException{
		return userDAO.cartShowAll(id);
		//널이어도 상관 없음. 아무것도 출력 안 할 거야.
	}

	// 회원탈퇴
	public static int deleteUserById(String id) throws SQLException {
		int result = userDAO.userLeave(id);
		return result;
	}

	// 회원정보수정
	public static int updateUser(MemberDTO memberDTO) throws SQLException {
		int result = userDAO.userInfoUpdate(memberDTO);
		return result;
	}
	
	//로그인
	public static MemberDTO selectUserById() throws SQLException{
		return null;
	}

	// 리뷰 게시글 삽입(로그인 한 유저의 글만)
	public static int userReviewInsert(ReviewDTO reviewDTO) throws SQLException {
		int re = userDAO.userReviewInsert(reviewDTO);
		if (re == 0)
			throw new SQLException("등록되지 않았습니다.");
		return re;

	}

	// 리뷰 게시글 수정(로그인 한 유저의 글만)
	public static int userReviewUpdate(ReviewDTO reviewDTO) throws SQLException {
		int re = userDAO.userReviewUpdate(reviewDTO);
		if (re == 0)
			throw new SQLException("수정되지 않았습니다.");
		return re;

	}
	
	//공지사항 조회
	public static List<NoticeDTO> selectNoticeAll() throws SQLException{
		return null;
	}
	
	//주문하기(UserOrderInsertAction)
	public static int insertOrder(OrderDTO orderDTO) throws SQLException{
		int result = userDAO.userOrderComplete(orderDTO);
		if(result==0)
			throw new SQLException("결제 실패하였습니다.");
		return result;
	}
	
	//모든 결제내역 확인(로그인 한 유저의 글만)
	public static List<CartDTO> selectOrderAllById(String id) throws SQLException{
		return userDAO.orderListRead(id);
		//널이어도 상관 없음. 출력 안 하면 그만.
	}
	
	/**결제 폼 뿌리기(UserOrderReadAction)
	 */
	public static CartDTO selectOrderByProductNum(int oIndexNo) throws SQLException{
		CartDTO cartDTO = userDAO.cartDetailForUpdate(oIndexNo);
		if(cartDTO==null)
			throw new SQLException("장바구니 정보를 불러올 수 없습니다.");
		return cartDTO;
	}
	
	//상품 목록 보기(UserProductAllReadAction)
	public static List<ProductDTO> selectProductAll() throws SQLException{
		return null;
	}
	
	//상품 디테일보기(UserProductReadAction)
	public static ProductDTO selectProductByProductCode() throws SQLException{
		return null;
	}
	//////////////////////////////qa//////////////////////
	
	//1:1 문의 게시글 삭제(로그인 한 유저의 글만)
	public static int deleteQA(int bIndexNo) throws SQLException{
		int result = 0;
		
		result = userDAO.userQADelete(bIndexNo);
		if(result==0)throw new SQLException("업데이트되지 않았습니다.");
		return result;
	}
	
	//1:1 문의 게시글 수정(로그인 한 유저의 글만)
	public static int updateQA(QADTO qaDTO) throws SQLException{
		int result = 0;
		
		result = userDAO.userQAUpdate(qaDTO);
		if(result==0)throw new SQLException("업데이트되지 않았습니다.");
		return result;
	}
	
	//1:1 문의 게시글 보기(로그인 한 유저의 글만)
	public static List<QADTO> selectQAByQAIndex(String userid) throws SQLException{
		
		List<QADTO> list = null;
		
		list = userDAO.userQARead(userid);
		
		return list;
	}
	
	//1:1 문의 게시글 상세보기(로그인 한 유저의 글만)
	public static QADTO selectQADetailByQANO(int bIndexNo) throws SQLException{
		QADTO qaDTO = null;
		qaDTO = userDAO.userQAReadForUpdate(bIndexNo);
		
		return qaDTO;
	}
	
	//1:1문의 게시글 삽입하기 
	public static int insertQA(QADTO qaDTO) throws SQLException{
		int result = 0;
		
		result = userDAO.userQAInsert(qaDTO);
		if(result==0)throw new SQLException("업데이트되지 않았습니다.");
		return result;
	}
	
	// 상품 추가 -다영
	public static int adminProductInsert(ProductDTO productDTO) throws SQLException {
		int re = mumiDAO.adminProductInsert(productDTO);
		if (re == 0)
			throw new SQLException("추가되지 않았습니다.");
		return re;
	}

	// 상품 수정 -다영
	public static int adminProductUpdate(ProductDTO productDTO) throws SQLException {
		int re = mumiDAO.adminProductUpdate(productDTO);
		if (re == 0)
			throw new SQLException("수정되지 않았습니다.");
		return re;
	}
	
	
	///////////////////////////////review//////////////
	
	//리뷰 게시글 삭제(자기가 쓴 글만)
	public static int userReviewDelete(int rIndexNo) throws SQLException{
		 int re = userDAO.userReviewDelete(rIndexNo);
		 if(re==0)throw new SQLException("삭제되지 않았습니다.");
		 return re;
	}

	// 상품 삭제 -다영
	public static int adminProductDelete(String pCode) throws SQLException {
		int re = mumiDAO.adminProductDelete(pCode);
		if (re == 0)
			throw new SQLException("삭제되지 않았습니다.");
		return re;
	}
	/*
	//리뷰 게시글 삽입(로그인 한 유저의 글만)
	public static int userReviewInsert(ReviewDTO reviewDTO) throws SQLException{
		 int re = userDAO.userReviewInsert(reviewDTO);
		 if(re==0)throw new SQLException("등록되지 않았습니다.");
		 return re;
		
	}
	
	//리뷰 게시글 수정(로그인 한 유저의 글만)
	public static int userReviewUpdate(ReviewDTO reviewDTO) throws SQLException{
		  int re = userDAO.userReviewUpdate(reviewDTO);
		  if(re==0)throw new SQLException("수정되지 않았습니다.");
		  return re;
		
	}*/
	
	//모든 리뷰 게시글 읽기(로그인 한 유저의 글만)
	public static List<ReviewDTO> userReviewRead(String pCode) throws SQLException{
		List<ReviewDTO> list = userDAO.userReviewRead(pCode);
		 
		return list;
		
	}
	
	
	
	////////////////////////관리자 ////////////////////////////
	//공지사항 삭제
	public static int deleteNotice() throws SQLException{
		return 0;
	}
	
	//공지사항 삽입
	public static int insertNotice() throws SQLException{
		return 0;
	}
	
	//공지사항 수정
	public static int updateNotice() throws SQLException{
		return 0;
	}
	
	//모든 주문내역 보기
	public static List<OrderDTO> selectOrderAll() throws SQLException{
		return mumiDAO.adminOrderListRead();
		//널이어도 괜찮아! 그냥 출력 안 하면 그만?
	}
	
	//상품 추가
	public static int insertProduct() throws SQLException{
		return 0;
	}
	
	//상품 수정
	public static int updateProduct() throws SQLException{
		return 0;
	}
	
	//QA답글조회
	public static QAReplyDTO readAnswer(int bIndexNo) throws SQLException{
		QAReplyDTO qaReplyDTO = null;
		
		qaReplyDTO = mumiDAO.adminQAReplyReadDetail(bIndexNo);
		
		return qaReplyDTO;
	}
	
	
	
	//QA 답글 삽입
	public static int insertAnswer(QAReplyDTO qaReplyDTO) throws SQLException{
		int result = 0;
		
		result = mumiDAO.adminQAReplyInsert(qaReplyDTO);
		if(result==0)throw new SQLException("업데이트되지 않았습니다.");
		return result;
	}
	
	//QA 게시글 모두 조회
	public static List<QADTO> selectQAListAll() throws SQLException{
		List<QADTO> list = null;
		
		list = mumiDAO.adminQAReadAll();
		
		return list;
	}
	
	//QA 답글 수정
	public static int updateAnswer(QAReplyDTO qaReplyDTO) throws SQLException{
		int result = 0;
		
		result = mumiDAO.adminQAReplyUpdate(qaReplyDTO);
		if(result==0)throw new SQLException("업데이트되지 않았습니다.");
		return result;
	}

	public static ProductDTO userProductRead(String pCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//QA 답글 삭제
	public static int deleteAnswer(int qIndexNo) throws SQLException{
		int result = 0;
		
		result = mumiDAO.adminQAReplyDelete(qIndexNo);
		if(result==0)throw new SQLException("삭제되지 않았습니다.");
		return result;
	}

	
	
	/*
	//회원정보 모두 보기
	public List<MemberDTO> selectAllUser() throws SQLException{



	public static QADTO selectQADetailByQANO(int bIndexNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int updateQA(QADTO qadto) {
		// TODO Auto-generated method stub
		return 0;
	}
	*/
	public static List<MemberDTO> adminSelectAllMember() throws SQLException {
		List<MemberDTO> list = mumiDAO.adminSelectAllMember();
		return list;
	}

	public static int adminUserDelete(String memberID) throws SQLException {
		int result=mumiDAO.adminUserDelete(memberID);
		return result;
	}

}
