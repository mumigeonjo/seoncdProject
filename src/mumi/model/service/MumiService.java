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
import mumi.model.dto.ReviewDTO;

public class MumiService {
	private static MumiDAO mumiDAO = new MumiDAOImpl();
	private static UserDAO userDAO = new UserDAOImpl();
	
	/*//��ٱ��� ����
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
	
	//1:1 ���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int deleteQA() throws SQLException{
		return 0;
	}
	
	//1:1 ���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int updateQA() throws SQLException{
		return 0;
	}
	*/
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
	}
	
	//���� �Խñ� ����(�ڱⰡ �� �۸�)
	public static int deleteUserReview() throws SQLException{
		return 0;
	}
	
	//���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int insertUserReview() throws SQLException{
		return 0;
	}
	
	//���� �Խñ� ����(�α��� �� ������ �۸�)
	public static int updateUserReview() throws SQLException{
		return 0;
	}
	
	//��� ���� �Խñ� �б�(�α��� �� ������ �۸�)
	public static List<ReviewDTO> selectUserReview() throws SQLException{
		return null;
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
}
