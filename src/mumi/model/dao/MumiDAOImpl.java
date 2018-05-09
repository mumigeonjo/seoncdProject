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
		Connection con = null;
		PreparedStatement ps = null;
		List<OrderDTO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select member_id, p_code, o_ea, o_date" + "from order_detail"
					+ "where o_status=1" + "order by o_date desc");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new OrderDTO(0, rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), 1, null,
						null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

		Connection conn = null;
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		Connection con = null;
		PreparedStatement ps = null;
		int re = 0;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete review where r_indexNo=?");
			ps.setInt(1, rIndexNo);
			re = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}

		return re;
	}

	@Override 
	public List<MemberDTO> adminSelectAllMember() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MemberDTO> list = new ArrayList<>();

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from member");
			rs = ps.executeQuery();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override // 다영
	public int adminProductInsert(ProductDTO productDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int re = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into product values(?,?,?,?,?,?)");
			ps.setString(1, productDTO.getpCode());
			ps.setString(2, productDTO.getpName());
			ps.setInt(3, productDTO.getpPrice());
			ps.setString(4, productDTO.getpSize());
			ps.setString(5, productDTO.getpDate());
			ps.setInt(6, productDTO.getpEA());
			ps.setString(7, productDTO.getpImage());
			ps.setString(8, productDTO.getpDetailImage());
			re = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return re;
	}

	@Override // 다영
	public int adminProductUpdate(ProductDTO productDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int re = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(
					"update product set p_price=?,p_ea=?,p_image=?,p_detail_image=?" + "where p_code = ?");
			ps.setInt(1, productDTO.getpPrice());
			ps.setInt(2, productDTO.getpEA());
			ps.setString(3, productDTO.getpImage());
			ps.setString(4, productDTO.getpDetailImage());
			ps.setString(5, productDTO.getpCode());
			re = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return re;
	}

	@Override // 다영
	public int adminProductDelete(String pCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int re = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete product where p_code = ?");
			ps.setString(1, pCode);
			re = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return re;
	}

	@Override // 다영
	public List<ProductDTO> adminProductAllRead() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from product");
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductDTO dto = new ProductDTO(rs.getString("p_code"), rs.getString("p_name"), rs.getInt("p_price"),
						rs.getString("p_size"), rs.getString("p_date"), rs.getInt("p_ea"), rs.getString("p_image"),
						rs.getString("p_detail_image"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}		
		return list;
	}
	
	@Override // 다영
	public ProductDTO adminProductRead(String pCode) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductDTO productDTO = new ProductDTO();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from product where p_code = ?");
			ps.setString(1, pCode);
			rs = ps.executeQuery();
			if (rs.next()) {
				productDTO = new ProductDTO(rs.getString("p_code"), rs.getString("p_name"), rs.getInt("p_price"),
						rs.getString("p_size"), rs.getString("p_date"), rs.getInt("p_ea"), rs.getString("p_image"),
						rs.getString("p_detail_image"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return productDTO;
	}
	
	@Override
	public int adminUserDelete(String memberID) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from member where member_id=?");
			ps.setString(1, memberID);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		System.out.println("ado"+memberID);
		return result;
	}

}
