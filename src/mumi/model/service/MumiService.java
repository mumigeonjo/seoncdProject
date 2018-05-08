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
	
	/**��ٱ��� ����
	 */
	public static int deleteCart(int oIndexNo) throws SQLException{
		int result=userDAO.cartDelete(oIndexNo);
		if(result==0)
			throw new SQLException("���� ����");
		return result;
	}

	// ȸ������
	public static int insertUser(MemberDTO memberDTO) throws SQLException {
		int result = userDAO.insertMember(memberDTO);
		if(result==0) {throw new SQLException();}
		return result;
	}
	
	/**��ٱ��� ����
	 */
	public static int insertCart(OrderDTO orderDTO) throws SQLException{
		int result = userDAO.cartInsert(orderDTO);
		if(result==0)
			throw new SQLException("��ٱ��� �߰� ����");
		return result;
	}

	// �α���
	public static MemberDTO selectUserById(String id, String pwd) throws SQLException {
		MemberDTO memberDTO = userDAO.loginFunction(id, pwd);
		return memberDTO;
	}
	
	/**��ٱ��� �б�
	 */
	public static List<CartDTO> readCart(String id) throws SQLException{
		return userDAO.cartShowAll(id);
		//���̾ ��� ����. �ƹ��͵� ��� �� �� �ž�.
	}

	// ȸ��Ż��
	public static int deleteUserById(String id) throws SQLException {
		int result = userDAO.userLeave(id);
		return result;
	}

	// ȸ����������
	public static int updateUser(MemberDTO memberDTO) throws SQLException {
		int result = userDAO.userInfoUpdate(memberDTO);
		return result;
	}
	
	//�α���
	public static MemberDTO selectUserById() throws SQLException{
		return null;
	}

	// ���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int userReviewInsert(ReviewDTO reviewDTO) throws SQLException {
		int re = userDAO.userReviewInsert(reviewDTO);
		if (re == 0)
			throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		return re;

	}

	// ���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int userReviewUpdate(ReviewDTO reviewDTO) throws SQLException {
		int re = userDAO.userReviewUpdate(reviewDTO);
		if (re == 0)
			throw new SQLException("�������� �ʾҽ��ϴ�.");
		return re;

	}
	
	//�������� ��ȸ
	public static List<NoticeDTO> selectNoticeAll() throws SQLException{
		return null;
	}
	
	//�ֹ��ϱ�(UserOrderInsertAction)
	public static int insertOrder(OrderDTO orderDTO) throws SQLException{
		int result = userDAO.userOrderComplete(orderDTO);
		if(result==0)
			throw new SQLException("���� �����Ͽ����ϴ�.");
		return result;
	}
	
	//��� �������� Ȯ��(�α��� �� ������ �۸�)
	public static List<CartDTO> selectOrderAllById(String id) throws SQLException{
		return userDAO.orderListRead(id);
		//���̾ ��� ����. ��� �� �ϸ� �׸�.
	}
	
	/**���� �� �Ѹ���(UserOrderReadAction)
	 */
	public static CartDTO selectOrderByProductNum(int oIndexNo) throws SQLException{
		CartDTO cartDTO = userDAO.cartDetailForUpdate(oIndexNo);
		if(cartDTO==null)
			throw new SQLException("��ٱ��� ������ �ҷ��� �� �����ϴ�.");
		return cartDTO;
	}
	
	//��ǰ ��� ����(UserProductAllReadAction)
	public static List<ProductDTO> selectProductAll() throws SQLException{
		return null;
	}
	
	//��ǰ �����Ϻ���(UserProductReadAction)
	public static ProductDTO selectProductByProductCode() throws SQLException{
		return null;
	}
	//////////////////////////////qa//////////////////////
	
	//1:1 ���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int deleteQA(int bIndexNo) throws SQLException{
		int result = 0;
		
		result = userDAO.userQADelete(bIndexNo);
		if(result==0)throw new SQLException("������Ʈ���� �ʾҽ��ϴ�.");
		return result;
	}
	
	//1:1 ���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int updateQA(QADTO qaDTO) throws SQLException{
		int result = 0;
		
		result = userDAO.userQAUpdate(qaDTO);
		if(result==0)throw new SQLException("������Ʈ���� �ʾҽ��ϴ�.");
		return result;
	}
	
	//1:1 ���� �Խñ� ����(�α��� �� ������ �۸�)
	public static List<QADTO> selectQAByQAIndex(String userid) throws SQLException{
		
		List<QADTO> list = null;
		
		list = userDAO.userQARead(userid);
		
		return list;
	}
	
	//1:1 ���� �Խñ� �󼼺���(�α��� �� ������ �۸�)
	public static QADTO selectQADetailByQANO(int bIndexNo) throws SQLException{
		QADTO qaDTO = null;
		qaDTO = userDAO.userQAReadForUpdate(bIndexNo);
		
		return qaDTO;
	}
	
	//1:1���� �Խñ� �����ϱ� 
	public static int insertQA(QADTO qaDTO) throws SQLException{
		int result = 0;
		
		result = userDAO.userQAInsert(qaDTO);
		if(result==0)throw new SQLException("������Ʈ���� �ʾҽ��ϴ�.");
		return result;
	}
	
	// ��ǰ �߰� -�ٿ�
	public static int adminProductInsert(ProductDTO productDTO) throws SQLException {
		int re = mumiDAO.adminProductInsert(productDTO);
		if (re == 0)
			throw new SQLException("�߰����� �ʾҽ��ϴ�.");
		return re;
	}

	// ��ǰ ���� -�ٿ�
	public static int adminProductUpdate(ProductDTO productDTO) throws SQLException {
		int re = mumiDAO.adminProductUpdate(productDTO);
		if (re == 0)
			throw new SQLException("�������� �ʾҽ��ϴ�.");
		return re;
	}
	
	
	///////////////////////////////review//////////////
	
	//���� �Խñ� ����(�ڱⰡ �� �۸�)
	public static int userReviewDelete(int rIndexNo) throws SQLException{
		 int re = userDAO.userReviewDelete(rIndexNo);
		 if(re==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		 return re;
	}

	// ��ǰ ���� -�ٿ�
	public static int adminProductDelete(String pCode) throws SQLException {
		int re = mumiDAO.adminProductDelete(pCode);
		if (re == 0)
			throw new SQLException("�������� �ʾҽ��ϴ�.");
		return re;
	}
	/*
	//���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int userReviewInsert(ReviewDTO reviewDTO) throws SQLException{
		 int re = userDAO.userReviewInsert(reviewDTO);
		 if(re==0)throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		 return re;
		
	}
	
	//���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int userReviewUpdate(ReviewDTO reviewDTO) throws SQLException{
		  int re = userDAO.userReviewUpdate(reviewDTO);
		  if(re==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		  return re;
		
	}*/
	
	//��� ���� �Խñ� �б�(�α��� �� ������ �۸�)
	public static List<ReviewDTO> userReviewRead(String pCode) throws SQLException{
		List<ReviewDTO> list = userDAO.userReviewRead(pCode);
		 
		return list;
		
	}
	
	
	
	////////////////////////������ ////////////////////////////
	//�������� ����
	public static int deleteNotice() throws SQLException{
		return 0;
	}
	
	//�������� ����
	public static int insertNotice() throws SQLException{
		return 0;
	}
	
	//�������� ����
	public static int updateNotice() throws SQLException{
		return 0;
	}
	
	//��� �ֹ����� ����
	public static List<OrderDTO> selectOrderAll() throws SQLException{
		return mumiDAO.adminOrderListRead();
		//���̾ ������! �׳� ��� �� �ϸ� �׸�?
	}
	
	//��ǰ �߰�
	public static int insertProduct() throws SQLException{
		return 0;
	}
	
	//��ǰ ����
	public static int updateProduct() throws SQLException{
		return 0;
	}
	
	//QA�����ȸ
	public static QAReplyDTO readAnswer(int bIndexNo) throws SQLException{
		QAReplyDTO qaReplyDTO = null;
		
		qaReplyDTO = mumiDAO.adminQAReplyReadDetail(bIndexNo);
		
		return qaReplyDTO;
	}
	
	
	
	//QA ��� ����
	public static int insertAnswer(QAReplyDTO qaReplyDTO) throws SQLException{
		int result = 0;
		
		result = mumiDAO.adminQAReplyInsert(qaReplyDTO);
		if(result==0)throw new SQLException("������Ʈ���� �ʾҽ��ϴ�.");
		return result;
	}
	
	//QA �Խñ� ��� ��ȸ
	public static List<QADTO> selectQAListAll() throws SQLException{
		List<QADTO> list = null;
		
		list = mumiDAO.adminQAReadAll();
		
		return list;
	}
	
	//QA ��� ����
	public static int updateAnswer(QAReplyDTO qaReplyDTO) throws SQLException{
		int result = 0;
		
		result = mumiDAO.adminQAReplyUpdate(qaReplyDTO);
		if(result==0)throw new SQLException("������Ʈ���� �ʾҽ��ϴ�.");
		return result;
	}

	public static ProductDTO userProductRead(String pCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//QA ��� ����
	public static int deleteAnswer(int qIndexNo) throws SQLException{
		int result = 0;
		
		result = mumiDAO.adminQAReplyDelete(qIndexNo);
		if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		return result;
	}

	
	
	/*
	//ȸ������ ��� ����
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
