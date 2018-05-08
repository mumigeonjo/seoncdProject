package mumi.model.dao;

import java.sql.SQLException;
import java.util.List;

import mumi.model.dto.MemberDTO;
import mumi.model.dto.NoticeDTO;
import mumi.model.dto.OrderDTO;
import mumi.model.dto.ProductDTO;
import mumi.model.dto.QADTO;
import mumi.model.dto.QAReplyDTO;

public interface MumiDAO {
	
	/**
	 * 주문 내역 관리 - 모든 사용자의 주문 내역을 DB로부터 가져온다.
	 * 단, O_STATUS가 true(1?)인 경우만 가져온다. O_STATUS가 false(0?)이면 장바구니에만 있다는 뜻.
	 * SELECT MEMBER_ID, P_CODE, O_EA, O_DATE FROM ORDER WHERE O_STATUS=1;
	 */
	public List<OrderDTO> adminOrderListRead() throws SQLException;
	
	/**
	 * 공지 사항 추가하기
	 * 관리자용 공지 페이지에서 '추가'버튼을 눌러 실행된다.
	 * 공지 작성 페이지에서 값을 읽어서 DB의 NOTICE 테이블에 저장한다.
	 * insert into notice (n_indexno, n_title, n_content, n_date) values (notice_seq, ?, ?, sysdate);
	 */
	public int adminNoticeInsert(NoticeDTO notice) throws SQLException;
	
	/**
	 * 공지 사항 삭제하기
	 * 공지를 선택해서 들어가면, 수정 폼이 뜬다. 그 곳에서 삭제 가능..? 
	 * NOTICE 테이블로부터 해당 공지를 삭제한다.
	 */
	public int adminNoticeDelete(int nIndexNo) throws SQLException;
	
	/**
	 * 공지 사항 업데이트하기
	 * 공지를 선택해서 들어가면, 수정 폼이 뜬다. 그 곳에서 수정 가능.
	 * 공지의 제목, 내용을 수정할 수 있다. 
	 * 공지가 수정된 시간으로 N_DATE의 값이 변경된다.
	 */
	public int adminNoticeUpdate(NoticeDTO notice) throws SQLException;
	
	/**
	 * 고객이 작성한 Q&A 읽기
	 * QA게시판에 올라온 모든 게시글을 출력한다. (답글 달렸나 표시도?) - SQL문 수정
	 */
	public List<QADTO> adminQAReadAll() throws SQLException;
	
	/**
	 * 고객 질문글에 답변 달기
	 * 각 고객의 질문글에 리플 형식으로 답변을 달 수 있다.
	 */
	public int adminQAReplyInsert(QAReplyDTO reply) throws SQLException;
	/**
	 * 답변 수정하기
	 */ 
	public int adminQAReplyUpdate(QAReplyDTO reply) throws SQLException;
	
	/**
	 * 답변 삭제하기
	 */
	public int adminQAReplyDelete(int qIndexNo) throws SQLException;
	
	/**
	 * QA 자세히 읽기. QA 클릭하면 내용 띄워주기?
	 * 리플은 어떻게 가져올까. 별개 메소드로?
	 
	public QADTO adminQAReadDetail() throws SQLException;
	*/
	/**
	 * QA 자세히 읽기- 리뷰 부분만 가져오는 메소드(추가)
	 */
	public QAReplyDTO adminQAReplyReadDetail(int bIndexNo) throws SQLException;
	
	/**
	 * 리뷰 삭제하기
	 */
	public int adminReviewDelete(int rIndexNo) throws SQLException;
	
	/**
	 * 회원 정보 확인
	 * 비번 빼고 모든 회원정보 확인..?
	 */
	public List<MemberDTO> adminSelectAllMember() throws SQLException;
	
	
	/**
	 * 상품 추가하기
	 * p_code, p_name, p_price, p_size, p_date, p_ea, p_image, p_detail_image
	 */
	public int adminProductInsert(ProductDTO productDTO) throws SQLException;
	
	/**
	 * 상품 수정하기
	 * 가격, 수량, 상품(메인,디테일)이미지를 변경할 수 있음 p_price, p_ea, p_image, p_detail_image
	 */
	public int adminProductUpdate(ProductDTO productDTO) throws SQLException;
	
	/**
	 * 상품 삭제하기
	 */
	public int adminProductDelete(String pCode) throws SQLException;
	
	/**
	 * 회원 강퇴시키기 - cascade 옵션 추가해야 함
	 */
	public int adminUserDelete(String memberID) throws SQLException;

}
