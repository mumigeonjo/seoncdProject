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
	 * �ֹ� ���� ���� - ��� ������� �ֹ� ������ DB�κ��� �����´�.
	 * ��, O_STATUS�� true(1?)�� ��츸 �����´�. O_STATUS�� false(0?)�̸� ��ٱ��Ͽ��� �ִٴ� ��.
	 * SELECT MEMBER_ID, P_CODE, O_EA, O_DATE FROM ORDER WHERE O_STATUS=1;
	 */
	public List<OrderDTO> adminOrderListRead() throws SQLException;
	
	/**
	 * ���� ���� �߰��ϱ�
	 * �����ڿ� ���� ���������� '�߰�'��ư�� ���� ����ȴ�.
	 * ���� �ۼ� ���������� ���� �о DB�� NOTICE ���̺� �����Ѵ�.
	 * insert into notice (n_indexno, n_title, n_content, n_date) values (notice_seq, ?, ?, sysdate);
	 */
	public int adminNoticeInsert(NoticeDTO notice) throws SQLException;
	
	/**
	 * ���� ���� �����ϱ�
	 * ������ �����ؼ� ����, ���� ���� ���. �� ������ ���� ����..? 
	 * NOTICE ���̺�κ��� �ش� ������ �����Ѵ�.
	 */
	public int adminNoticeDelete(int nIndexNo) throws SQLException;
	
	/**
	 * ���� ���� ������Ʈ�ϱ�
	 * ������ �����ؼ� ����, ���� ���� ���. �� ������ ���� ����.
	 * ������ ����, ������ ������ �� �ִ�. 
	 * ������ ������ �ð����� N_DATE�� ���� ����ȴ�.
	 */
	public int adminNoticeUpdate(NoticeDTO notice) throws SQLException;
	
	/**
	 * ���� �ۼ��� Q&A �б�
	 * QA�Խ��ǿ� �ö�� ��� �Խñ��� ����Ѵ�. (��� �޷ȳ� ǥ�õ�?) - SQL�� ����
	 */
	public List<QADTO> adminQAReadAll() throws SQLException;
	
	/**
	 * �� �����ۿ� �亯 �ޱ�
	 * �� ���� �����ۿ� ���� �������� �亯�� �� �� �ִ�.
	 */
	public int adminQAReplyInsert(QAReplyDTO reply) throws SQLException;
	/**
	 * �亯 �����ϱ�
	 */ 
	public int adminQAReplyUpdate(QAReplyDTO reply) throws SQLException;
	
	/**
	 * �亯 �����ϱ�
	 */
	public int adminQAReplyDelete(int qIndexNo) throws SQLException;
	
	/**
	 * QA �ڼ��� �б�. QA Ŭ���ϸ� ���� ����ֱ�?
	 * ������ ��� �����ñ�. ���� �޼ҵ��?
	 
	public QADTO adminQAReadDetail() throws SQLException;
	*/
	/**
	 * QA �ڼ��� �б�- ���� �κи� �������� �޼ҵ�(�߰�)
	 */
	public QAReplyDTO adminQAReplyReadDetail(int bIndexNo) throws SQLException;
	
	/**
	 * ���� �����ϱ�
	 */
	public int adminReviewDelete(int rIndexNo) throws SQLException;
	
	/**
	 * ȸ�� ���� Ȯ��
	 * ��� ���� ��� ȸ������ Ȯ��..?
	 */
	public List<MemberDTO> adminSelectAllMember() throws SQLException;
	
	
	/**
	 * ��ǰ �߰��ϱ�
	 * p_code, p_name, p_price, p_size, p_date, p_ea, p_image, p_detail_image
	 */
	public int adminProductInsert(ProductDTO productDTO) throws SQLException;
	
	/**
	 * ��ǰ �����ϱ�
	 * ����, ����, ��ǰ(����,������)�̹����� ������ �� ���� p_price, p_ea, p_image, p_detail_image
	 */
	public int adminProductUpdate(ProductDTO productDTO) throws SQLException;
	
	/**
	 * ��ǰ �����ϱ�
	 */
	public int adminProductDelete(String pCode) throws SQLException;
	
	/**
	 * ȸ�� �����Ű�� - cascade �ɼ� �߰��ؾ� ��
	 */
	public int adminUserDelete(String memberID) throws SQLException;

}
