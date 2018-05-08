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
import mumi.model.dto.ReviewDTO;

public class MumiService {
	private static MumiDAO mumiDAO = new MumiDAOImpl();
	private static UserDAO userDAO = new UserDAOImpl();
	
	/**장바구니 삭제
	 */
	public static int deleteCart(int oIndexNo) throws SQLException{
		if(userDAO.cartDelete(oIndexNo)==0)
			throw new SQLException("삭제 실패");
	}
	
	/**장바구니 삽입
	 */
	public static int insertCart(OrderDTO orderDTO) throws SQLException{
		if(userDAO.cartInsert(orderDTO)==0)
			throw new SQLException("장바구니 추가 실패");
	}
	
	/**장바구니 읽기
	 */
	public static List<CartDTO> readCart(String id) throws SQLException{
		return userDAO.cartShowAll(id);
		//널이어도 상관 없음. 아무것도 출력 안 할 거야.
	}
	
	//장바구니 업데이트
	public static int updateCart() throws SQLException{
		return 0;
	}
	
	//로그인
	public static UserDTO selectUserById() throws SQLException{
		return null;
	}
	
	//회원가입
	public static int insertUser() throws SQLException{
		return 0;
	}
	
	//회원탈퇴
	public static int deleteUserById() throws SQLException{
		return 0;
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
	
	//1:1 문의 게시글 삭제(로그인 한 유저의 글만)
	public static int deleteQA() throws SQLException{
		return 0;
	}
	
	//1:1 문의 게시글 수정(로그인 한 유저의 글만)
	public static int updateQA() throws SQLException{
		return 0;
	}
	*/
	//1:1 문의 게시글 보기(로그인 한 유저의 글만)
	public static List<QADTO> selectQAByQAIndex(String userid) throws SQLException{
		
		List<QADTO> list = null;
		
		list = userDAO.userQARead(userid);
		
		return list;
	}
	/*
	//1:1 문의 게시글 상세보기(로그인 한 유저의 글만)
	public static QADTO selectQADetailByQANO() throws SQLException{
		return null;
	}
	
	//1:1 문의 게시글 수정(로그인 한 유저의 글만)
	public static int updateQA() throws SQLException{
		return 0;
	}
	
	//리뷰 게시글 삭제(자기가 쓴 글만)
	public static int deleteUserReview() throws SQLException{
		return 0;
	}
	
	//리뷰 게시글 삽입(로그인 한 유저의 글만)
	public static int insertUserReview() throws SQLException{
		return 0;
	}
	
	//리뷰 게시글 수정(로그인 한 유저의 글만)
	public static int updateUserReview() throws SQLException{
		return 0;
	}
	
	//모든 리뷰 게시글 읽기(로그인 한 유저의 글만)
	public static List<ReviewDTO> selectUserReview() throws SQLException{
		return null;
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
	*/
	//모든 주문내역 보기
	public static List<OrderDTO> selectOrderAll() throws SQLException{
		return mumiDAO.adminOrderListRead();
		//널이어도 괜찮아! 그냥 출력 안 하면 그만?
	}
	/*
	//상품 추가
	public static int insertProduct() throws SQLException{
		return 0;
	}
	
	//상품 수정
	public static int updateProduct() throws SQLException{
		return 0;
	}
	
	//QA 게시글 삭제
	public static int deleteQA(QAindex) throws SQLException{
		return 0;
	}
	
	//QA 답글 삽입
	public static int insertAnswer() throws SQLException{
		return 0;
	}
	*/
	//QA 게시글 모두 조회
	public static List<QADTO> selectQAListAll() throws SQLException{
		List<QADTO> list = null;
		
		list = mumiDAO.adminQAReadAll();
		
		return list;
	}
	/*
	//QA 게시글 디테일 조회
	public static QADTO selectQADetail() throws SQLException{
		return null;
	}
	
	//QA 답글 수정
	public static int updateAnswer() throws SQLException{
		return 0;
	}
	
	//QA 답글 삭제
	public static int deleteAnswer() throws SQLException{
		return 0;
	}
	
	//회원정보 모두 보기
	public List<MemberDTO> selectAllUser() throws SQLException{
		return null;
	}
	
	//회원 강제 탈퇴
	public int dropUser() throws SQLException{
		return 0;
	
	}
}
