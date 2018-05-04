package mumi.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public List<QADTO> adminQAReadAll() throws SQLException {
		
		Connection conn= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QADTO> qlist = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from QA");
			rs = ps.executeQuery();
			while(rs.next()) {
				QADTO qaDTO = new QADTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
				qlist.add(qaDTO);
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return qlist;
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
