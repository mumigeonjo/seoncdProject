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
		Connection con=null;
		PreparedStatement ps = null;
		List<OrderDTO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select member_id, p_code, o_ea, o_date"
					+ "from order_detail"
					+ "where o_status=1"
					+ "order by o_date desc");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new OrderDTO(0, rs.getString(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4), 1, null, null));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override //지안
	public int adminNoticeInsert(NoticeDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql="insert into notice values(notice_seq.nextval, ?, ?, sysdate)";
		
		System.out.println("수정");
		int re =0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getnTitle());
			ps.setString(2, dto.getnContent());

			re = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return re;
	}

	@Override //지안
	public int adminNoticeDelete(int nIndexNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql="delete from notice where n_indexno=?";
		int re =0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, nIndexNo);
			
			re = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return re;
	}

	@Override //지안
	public int adminNoticeUpdate(NoticeDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql="update notice set n_title=?, n_content=? where n_indexno=?";
		int re =0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getnTitle());
			ps.setString(2, dto.getnContent());
			ps.setInt(3, Integer.parseInt(dto.getnIndexNo()));

			re = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return re;
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
		Connection con=null;
		PreparedStatement ps =null;
		int re=0;
		
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("insert into qa_reply values(qa_reply_seq.nextval,?,sysdate,?)");
			
			ps.setInt(1, reply.getbIndexNo());
			ps.setString(2, reply.getqContent());
			
			re=ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		
		return re;
	}


	@Override
	public int adminQAReplyUpdate(QAReplyDTO reply) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int result=0;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("update QA_Reply set q_date=sysdate,q_content=?) "
					+ "  where q_indexNo=?");
			
			ps.setString(1, reply.getqContent());
			ps.setInt(2, reply.getqIndexNo());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps);
		}

		return result;
	}

	@Override
	public int adminQAReplyDelete(int qIndexNo) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		int result=0;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("delete QA_reply where q_indexNo=?");
			ps.setInt(1, qIndexNo);
			// ??의 순서대로 개수만큼 setXxx( , ) 작성
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps);
		}

		return result;
	}

	
/*user꺼로 사용한다.
	@Override
	public QADTO adminQAReadDetail() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public QAReplyDTO adminQAReplyReadDetail(int bIndexNo) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		QAReplyDTO qReplyDTO=null;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select q_date, q_content from QA_Reply where b_indexNo=?");
			ps.setInt(1, bIndexNo);
			// ??의 순서대로 개수만큼 setXxx( , ) 작성
			rs = ps.executeQuery();
			while (rs.next()) {
				qReplyDTO = new QAReplyDTO(rs.getString(1), rs.getString(2));
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps, rs);
		}

		return qReplyDTO;
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
		
		return re;
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
