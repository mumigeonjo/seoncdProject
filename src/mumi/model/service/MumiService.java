package mumi.model.service;

import java.sql.SQLException;
import java.util.List;

import mumi.model.dao.MumiDAO;
import mumi.model.dao.MumiDAOImpl;
import mumi.model.dao.UserDAO;
import mumi.model.dao.UserDAOImpl;
import mumi.model.dto.NoticeDTO;
import mumi.model.dto.OrderDTO;
import mumi.model.dto.ProductDTO;
import mumi.model.dto.QADTO;
import mumi.model.dto.ReviewDTO;

public class MumiService {
	private static MumiDAO mumiDAO = new MumiDAOImpl();
	private static UserDAO userDAO = new UserDAOImpl();
	
	
	//��ٱ��� ����
	public static int deleteCart() throws SQLException{
		return 0;
	}
	
	//��ٱ��� ����
	public static int insertCart() throws SQLException{
		return 0;
	}
	
	//��ٱ��� �б�
	public static List<DTO> readCart() throws SQLException{
		return null;
	}
	
	//��ٱ��� ������Ʈ
	public static int updateCart() throws SQLException{
		return 0;
	}
	
	//�α���
	public static UserDTO selectUserById() throws SQLException{
		return null;
	}
	
	//ȸ������
	public static int insertUser() throws SQLException{
		return 0;
	}
	
	//ȸ��Ż��
	public static int deleteUserById() throws SQLException{
		return 0;
	}
	
	//�������� ��ȸ
	public static List<NoticeDTO> selectNoticeAll() throws SQLException{
		return null;
	}
	
	//�ֹ��ϱ�(UserOrderInsertAction)
	public static int InsertOrder() throws SQLException{
		return 0;
	}
	
	//��� �������� Ȯ��(�α��� �� ������ �۸�)
	public static List<OrderDTO> selectOrderAllById() throws SQLException{
		return null;
	}
	
	//���� �� �Ѹ���(UserOrderReadAction)
	public static OrderDTO selectOrderByProductNum() throws SQLException{
		return null;
	}
	
	//��ǰ ��� ����(UserProductAllReadAction) -�ٿ�
	public static List<ProductDTO> userProductAllRead() throws SQLException{
		List<ProductDTO> list = userDAO.userProductAllRead();
		return list;
	}
	
	//��ǰ �����Ϻ���(UserProductReadAction) -�ٿ�
	public static ProductDTO userProductRead(String pCode) throws SQLException{
		ProductDTO productDTO = userDAO.userProductRead(pCode);
		if(productDTO==null)throw new SQLException(pCode+"�� �ش��ϴ� ��ǰ������ �����ϴ�.");
		return productDTO;
	}
	
	//1:1 ���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int deleteQA() throws SQLException{
		return 0;
	}
	
	//1:1 ���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int updateQA() throws SQLException{
		return 0;
	}
	
	//1:1 ���� �Խñ� ����(�α��� �� ������ �۸�)
	public static List<QADTO> selectQAByQAIndex(String userid) throws SQLException{	
		List<QADTO> list = null;	
		list = userDAO.userQARead(userid);
		return list;
	}
	/*
	//1:1 ���� �Խñ� �󼼺���(�α��� �� ������ �۸�)
	public static QADTO selectQADetailByQANO() throws SQLException{
		return null;
	}
	
	//1:1 ���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int updateQA() throws SQLException{
		return 0;
	}*/
	
	//���� �Խñ� ����(�ڱⰡ �� �۸�)
	public static int userReviewDelete(int rIndexNo) throws SQLException{
		 int re = userDAO.userReviewDelete(rIndexNo);
		 if(re==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		 return re;
	}
	
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
		
	}
	
	//��� ���� �Խñ� �б�(�α��� �� ������ �۸�)
	public static List<ReviewDTO> userReviewRead(String pCode) throws SQLException{
		List<ReviewDTO> list = userDAO.userReviewRead(pCode); 
		return list;
		
	}
	
	
	/*
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
		return null;
	}
	*/
	//��ǰ �߰�  -�ٿ�
	public static int adminProductInsert(ProductDTO productDTO) throws SQLException{
		int re = mumiDAO.adminProductInsert(productDTO);
		if(re==0)throw new SQLException("�߰����� �ʾҽ��ϴ�.");
		return re;
	}
	
	//��ǰ ����  -�ٿ�
	public static int adminProductUpdate(ProductDTO productDTO) throws SQLException{
		int re = mumiDAO.adminProductUpdate(productDTO);
		if(re==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		return re;
	}
	
	//��ǰ ����  -�ٿ�
	public static int adminProductDelete(String pCode) throws SQLException{
		int re = mumiDAO.adminProductDelete(pCode);
		if(re==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		return re;
	}
	/*
	//QA �Խñ� ����
	public static int deleteQA(QAindex) throws SQLException{
		return 0;
	}
	
	//QA ��� ����
	public static int insertAnswer() throws SQLException{
		return 0;
	}
	*/
	//QA �Խñ� ��� ��ȸ
	public static List<QADTO> selectQAListAll() throws SQLException{
		List<QADTO> list = null;
		list = mumiDAO.adminQAReadAll();	
		return list;
	}
	/*
	//QA �Խñ� ������ ��ȸ
	public static QADTO selectQADetail() throws SQLException{
		return null;
	}
	
	//QA ��� ����
	public static int updateAnswer() throws SQLException{
		return 0;
	}
	
	//QA ��� ����
	public static int deleteAnswer() throws SQLException{
		return 0;
	}
	
	//ȸ������ ��� ����
	public List<MemberDTO> selectAllUser() throws SQLException{
		return null;
	}
	
	//ȸ�� ���� Ż��
	public int dropUser() throws SQLException{
		return 0;
	
	}*/
	public int adminReviewDelete(int rIndexNo) throws SQLException{
		 int re = mumiDAO.adminReviewDelete(rIndexNo);
		 if(re==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		 return re;
	}
}
