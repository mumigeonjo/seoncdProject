package mumi.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface MumiDAO {
	
	/**
	 * �ֹ� ���� ���� - ��� ������� �ֹ� ������ DB�κ��� �����´�.
	 * ��, O_STATUS�� true(1?)�� ��츸 �����´�. O_STATUS�� false(0?)�̸� ��ٱ��Ͽ��� �ִٴ� ��.
	 * SELECT MEMBER_ID, P_CODE, O_EA, O_DATE FROM ORDER WHERE O_STATUS=1;
	 */
	public List<Order> adminOrderListRead() throws SQLException;
	
	/**
	 * ���� ���� �߰��ϱ�
	 * �����ڿ� ���� ���������� '�߰�'��ư�� ���� ����ȴ�.
	 * ���� �ۼ� ���������� ���� �о DB�� NOTICE ���̺� �����Ѵ�.
	 * insert into notice (n_indexno, n_title, n_content, n_date) values (notice_seq, ?, ?, sysdate);
	 */
	public int adminNoticeInsert(Notice notice) throws SQLException;
	
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
	public int adminNoticeUpdate(Notice notice) throws SQLException;
	
	/**
	 * ���� �ۼ��� Q&A �б�
	 * QA�Խ��ǿ� �ö�� ��� �Խñ��� ����Ѵ�. (��� �޷ȳ� ǥ�õ�?) - SQL�� ����
	 */
	public List<QA> adminQAReplyRead() throws SQLException;
	
	/**
	 * �� �����ۿ� �亯 �ޱ�
	 * �� ���� �����ۿ� ���� �������� �亯�� �� �� �ִ�.
	 */
	public int adminQAReplyInsert(Reply reply) throws SQLException;
	
	/**
	 * �亯 �����ϱ�
	 */ 
	public int adminQAReplyUpdate(Reply reply) throws SQLException;
	
	/**
	 * �亯 �����ϱ�
	 */
	public int adminQAReplyDelete(int qIndexNo) throws SQLException;
	
	/**
	 * QA �ڼ��� �б�. QA Ŭ���ϸ� ���� ����ֱ�?
	 * ������ ��� �����ñ�. ���� �޼ҵ��?
	 */
	public QADTO adminQAReadDetail() throws SQLEx
	
	/**
	 * ���� �����ϱ�
	 */
	public int adminReviewDelete(int rIndexNo) throws SQLException;
	
	/**
	 * ȸ�� ���� Ȯ��
	 * ��� ���� ��� ȸ������ Ȯ��..?
	 */
	public List<Member> adminAllMemberSelect() throws SQLException;
	
	
	/**
	 * ��ǰ �߰��ϱ�
	 * p_code, p_name, p_price, p_size, p_ea
	 */
	public int adminProductInsert(Product product) throws SQLException;
	
	/**
	 * ��ǰ �����ϱ�
	 * ����, ������ ������ �� ����
	 */
	public int adminProductUpdate(Product product) throws SQLException;
	
	/**
	 * ��ǰ �����ϱ�
	 */
	public int adminProductDelete(int pCode) throws SQLException;
	
	/**
	 * ȸ�� �����Ű�� - cascade �ɼ� �߰��ؾ� ��
	 */
	public int adminMemberDelete(String memberID) throws SQLException;

}
