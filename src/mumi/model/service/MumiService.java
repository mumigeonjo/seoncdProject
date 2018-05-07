package mumi.model.service;

import java.sql.SQLException;
import java.util.List;


import mumi.model.dao.MumiDAO;
import mumi.model.dao.MumiDAOImpl;
import mumi.model.dao.UserDAO;
import mumi.model.dao.UserDAOImpl;
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
	
	
	///////////////////////////////review//////////////
	
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
	
	//��ǰ �߰�
	public static int insertProduct() throws SQLException{
		return 0;
	}
	
	//��ǰ ����
	public static int updateProduct() throws SQLException{
		return 0;
	}
	*/
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
