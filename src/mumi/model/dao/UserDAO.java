package mumi.model.dao;

import java.util.List;

import mumi.model.dto.MemberDTO;
import mumi.model.dto.NoticeDTO;
import mumi.model.dto.OrderDTO;
import mumi.model.dto.ProductDTO;
import mumi.model.dto.QADTO;
import mumi.model.dto.ReviewDTO;

public interface UserDAO{
	
	//���������� MemberDTO�� �����Ѵ�.
	//����� MemberDTO���� memberID, addr, phone���� ������ ����Ѵ�.
	
	/**
	 * �α���
	 * @param memberid
	 * @param pwd
	 * @return ��Ʈ�� ���� or �Ҹ����� ��
	 */
	public int loginFunction(String memberid, String pwd);
	
	/**
	 * ȸ������
	 * @param memberid
	 * @param pwd
	 * @param name
	 * @param phone
	 * @param addr
	 * @param memberDTO ���� ������ �޴� ������ �����ʿ�.
	 * @return int������ ����, 0�̸� true, 1�̸� false
	 */
	public int registerMember(MemberDTO memberDTO); 
	
	/**
	 * ȸ������ ���� �޼ҵ� 
	 * @param memberDTO
	 * @return
	 */
	public int userInfoUpdate(MemberDTO memberDTO);
	
	/**
	 * ȸ��Ż�� 
	 * @return
	 */
	public int userLeave();
	
	/**
	 * ��ü��ǰ��ȸ 
	 * @return ��ü����Ʈ ��ȸ 
	 */
	public List<ProductDTO> goodsRead();
	
	/**
	 * �󼼻�ǰ��ȸ 
	 * @param pCode 
	 * @return
	 */
	public ProductDTO goodsDetailRead(String pCode);
	
	/**
	 * ���ݺ� ���� 	
	 * @return ���ĵ� ����Ʈ����
	 */
	public List<ProductDTO> goodsSortByPrice();
	
	/**
	 * �α������ 
	 * @return ����Ʈ���� 
	 */
	public List<ProductDTO> goodsSortByPopularity();
	
	/**
	 * �ֽŻ�ǰ�� 
	 * @return ����Ʈ���� 
	 */
	public List<ProductDTO> goodsSortByNew();
	
	/**
	 * ��ٱ�����ü��ȸ 
	 * @return ����Ʈ�� ��ü ���� 
	 * memberID�� ���������� ����Ǿ� �ִ� ���� �����´�.
	 */
	public List<OrderDTO> cartShowAll();
	
	/**
	 * ��ٱ����߰� 
	 * @param pCode ��ǰ�ڵ� 
	 * @param pSize ��ǰ������ 
	 * @param pEA ��ǰ���� 
	 * @param productDTO pCode, pSize, pEA�� �޴´�.
	 * @param �� ���� �߿� pCode�� �޾ƿͼ� �ش��ϴ� �ڵ带 order���̺� �ִ´�. 
	 * @return �߰��Ǿ���(1)/�ȵǾ���(0)
	 */
	public int cartInsert(String pCode);
	
	/**
	 * ��ٱ��ϼ��� 
	 * @param oIndexNo �ֹ��ε����ѹ� 
	 * @param oEA �ֹ����� 
	 * @param orderDTO�� ���� ������ �μ��� �޾ƿ´�. 
	 * @return �������/�ȉ��.
	 */
	public int cartUpdate(OrderDTO orderDTO);
	
	/**
	 * ��ٱ��ϼ����� ������ȸ�޼ҵ�.
	 * @param oIndexNo
	 * @return
	 */
	public OrderDTO cartDetailForUpdate(String oIndexNo);
	
	/**
	 * ��ٱ��ϻ��� 
	 * @param oIndexNo
	 * @return �����Ǿ���/�ȵǾ���.
	 */
	public int cartDelete(String oIndexNo);

	/**
	 * �Һ����� ������ ��������(�ֹ�������) 
	 * @return
	 * MemberDTO�� ���������� �����ϰ� or �ش��ϴ°����� �ҷ��ͼ� OrderDTO�� �־ ����? 
	 * �ش��ϴ� ������ �ҷ��ͼ� �ּ�,��ȣ�� ����.
	 */
	public OrderDTO userOrderContactInfo();
	
	/**
	 * �����Ϸ�޼ҵ� 
	 * @param oIndexNo �ش��ϴ� ������ o_status�� ������Ʈ���ش�. 
	 * @return �����ϷἺ��/����.
	 */
	public int userOrderComplete(String oIndexNo);
	
	/**
	 * ��ü������ȸ 
	 * @return
	 */
	public List<NoticeDTO> noticeRead();
	
	/**
	 * �󼼰�����ȸ 
	 * @param nIndexNo
	 * @return
	 */
	public NoticeDTO noticeDetailRead(String nIndexNo);
	
	/**
	 * �ֹ���(o_status���� 0�� �ڷ��)���� ��ȸ 
	 * @return
	 */
	public List<OrderDTO> orderListRead();
	
	/**
	 * QA��ȸ�޼ҵ� 
	 * @return ����Ʈ�� �������ش�.
	 * ���������� ����Ǿ��ִ� MemberID�� �ҷ��ͼ� ��ȸ�Ѵ�.
	 */
	public List<QADTO> userQARead();
	
	/**
	 * Q&A�Խ��� ��� �޼ҵ� 
	 * @param qADTO
	 * @return
	 * 
	 */
	public int userQAInsert(QADTO qADTO);
	
	/**
	 * Q&A�Խ��� ���� �޼ҵ� 
	 * @param qADTO
	 * @return �����Ǿ���/�ȵǾ���.
	 */
	public int userQAUpdate(QADTO qADTO);
	
	/**
	 * �Խ��Ǽ����������������� 
	 * @param qIndexNo
	 * @return �����ѷ��ֱ�.
	 */
	public QADTO userQAReadForUpdate(String qIndexNo);
	
	/**
	 * Q&A�Խ��� ���� �޼ҵ� 
	 * @param qADTO
	 * @return �����Ǿ���/���.
	 * 
	 */
	public int userQADelete(String bIndexNo);
	
	/**
	 * ������ȸ�޼ҵ� 
	 * @param pCode ��ǰ�ڵ� �����ͼ� �ش��ϴ� ���� ������� �ѷ��ش�. 
	 * @return
	 */
	public List<ReviewDTO> userReviewRead(String pCode);
	
	/**
	 * ������Ը޼ҵ� 
	 * @param reviewDTO 
	 * @return
	 */
	public int userReviewInsert(ReviewDTO reviewDTO);
	
	/**
	 * ���������Ʈ �޼ҵ� 
	 * @param reviewDTO
	 * @return
	 */
	public int userReviewUpdate(ReviewDTO reviewDTO);
	

	
	/**
	 * ���� �����޼ҵ� 
	 * @param rIndexNo
	 * @return
	 */
	public int userReviewDelete(String rIndexNo);
}