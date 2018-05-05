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
				QADTO qaDTO = new QADTO(rs.getInt(1), rs.getString(2), rs.getInt(3),
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
		Connection con=null;
		PreparedStatement ps=null;
		int re=0;
		
		try {
			con= DBUtil.getConnection();
			ps= con.prepareStatement("delete review where r_indexNo=?");
			ps.setInt(1, rIndexNo);
			re=ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return 0;
	}

	@Override
	public List<MemberDTO> adminSelectAllMember() throws SQLException {
		
		return null;
	}

	@Override //다영
	public int adminProductInsert(ProductDTO productDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int re=0;
		try {
			con= DBUtil.getConnection();
			ps= con.prepareStatement("insert into product values(?,?,?,?,?,?)");
			ps.setString(1, productDTO.getpCode());
			ps.setString(2, productDTO.getpName());
			ps.setInt(3, productDTO.getpPrice());
			ps.setString(4, productDTO.getpSize());
			ps.setString(5, productDTO.getpDate());
			ps.setInt(6, productDTO.getpEA());
			ps.setString(7, productDTO.getpImage());
			ps.setString(8, productDTO.getpDetailImage());
			re=ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return re;
	}

	@Override //다영
	public int adminProductUpdate(ProductDTO productDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int re=0;
		try {
			con= DBUtil.getConnection();
			ps= con.prepareStatement("update product set p_price=?,p_ea=?,p_image=?,p_detail_image=?"
										+ "where p_code = ?");
			ps.setInt(1, productDTO.getpPrice());
			ps.setInt(2, productDTO.getpEA());
			ps.setString(3, productDTO.getpImage());
			ps.setString(4, productDTO.getpDetailImage());
			ps.setString(5, productDTO.getpCode());
			re = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return re;
	}

	@Override //다영
	public int adminProductDelete(String pCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int re=0;
		try {
			con= DBUtil.getConnection();
			ps= con.prepareStatement("delete product where p_code = ?");
			ps.setString(1, pCode);
			re = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return re;
	}

	@Override
	public int adminUserDelete(String memberID) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
