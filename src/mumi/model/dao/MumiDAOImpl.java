package mumi.model.dao;

import java.sql.SQLException;
import java.util.List;

import mumi.model.dto.MemberDTO;
import mumi.model.dto.NoticeDTO;
import mumi.model.dto.OrderDTO;
import mumi.model.dto.ProductDTO;
import mumi.model.dto.QADTO;
import mumi.model.dto.QAReplyDTO;

public class MumiDAOImpl implements MumiDAO {

	@Override
	public List<OrderDTO> adminOrderListRead() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminNoticeInsert(NoticeDTO notice) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminNoticeDelete(int nIndexNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminNoticeUpdate(NoticeDTO notice) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<QADTO> adminQAReplyRead() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminQAReplyInsert(QAReplyDTO reply) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminQAReplyUpdate(QAReplyDTO reply) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminQAReplyDelete(int qIndexNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public QADTO adminQAReadDetail() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QAReplyDTO adminQAReplyReadDetail() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminReviewDelete(int rIndexNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberDTO> adminSelectAllMember() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminProductAllInsert(ProductDTO product) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminProductAllUpdate(ProductDTO product) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminProductAllDelete(int pCode) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminUserDelete(String memberID) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
