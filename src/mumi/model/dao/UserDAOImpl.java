package mumi.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.media.sound.PCMtoPCMCodec;

import mumi.model.dto.MemberDTO;
import mumi.model.dto.NoticeDTO;
import mumi.model.dto.OrderDTO;
import mumi.model.dto.ProductDTO;
import mumi.model.dto.QADTO;
import mumi.model.dto.ReviewDTO;

public class UserDAOImpl implements UserDAO {

	@Override
	public int loginFunction(String memberid, String pwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registerMember(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userInfoUpdate(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userLeave() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductDTO> goodsRead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO goodsDetailRead(String pCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> goodsSortByPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> goodsSortByPopularity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> goodsSortByNew() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> cartShowAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cartInsert(String pCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cartUpdate(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderDTO cartDetailForUpdate(String oIndexNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cartDelete(String oIndexNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderDTO userOrderContactInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userOrderComplete(String oIndexNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<NoticeDTO> noticeRead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeDTO noticeDetailRead(String nIndexNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> orderListRead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QADTO> userQARead() {
		// TODO Auto-generated method stub
		return null;
	public List<QADTO> userQARead(String memberid) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QADTO> qlist = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from QA where member_id=?");
			ps.setString(1, memberid);
			// ??의 순서대로 개수만큼 setXxx( , ) 작성
			rs = ps.executeQuery();
			while (rs.next()) {
				QADTO cusDTO = new QADTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				qlist.add(cusDTO);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps, rs);
		}

		return qlist;
	}

	@Override
	public int userQAInsert(QADTO qaDTO) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result=0;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into QA(b_indexNo,member_id,b_category,b_content,b_title,b_date) "
					+ "values(qa_seq.nextval,?,?,?,?,sysdate)");
			ps.setString(1, qaDTO.getMemberID());
			ps.setInt(2, qaDTO.getbCategory());
			ps.setString(3, qaDTO.getbContent());
			ps.setString(4, qaDTO.getbTitle());
			
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps);
		}

		return result;
	}


	@Override
	public int userQAUpdate(QADTO qaDTO) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int result=0;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("update QA set b_category=?,b_content=?,b_title=?,b_date=sysdate) "
					+ "  where b_indexNo=?");
			ps.setInt(1, qaDTO.getbCategory());
			ps.setString(2, qaDTO.getbContent());
			ps.setString(3, qaDTO.getbTitle());
			ps.setInt(4, qaDTO.getbIndexNo());
			
			// ??의 순서대로 개수만큼 setXxx( , ) 작성
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps);
		}

		return result;
	}

	@Override
	public QADTO userQAReadForUpdate(int qIndexNo) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		QADTO qDTO=null;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from QA where b_indexNo=?");
			ps.setInt(1, qIndexNo);
			// ??의 순서대로 개수만큼 setXxx( , ) 작성
			rs = ps.executeQuery();
			while (rs.next()) {
				qDTO = new QADTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps, rs);
		}

		return qDTO;
	}

	@Override
	public int userQADelete(int bIndexNo) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		int result=0;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("delete QA where b_indexNo=?");
			ps.setInt(1, bIndexNo);
			// ??의 순서대로 개수만큼 setXxx( , ) 작성
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, ps);
		}

		return result;
	}

	@Override
	public List<ReviewDTO> userReviewRead(String pCode) {
		Connection con= null;
		PreparedStatement ps= null;
		List<ReviewDTO> list = new ArrayList<>();
		ResultSet rs=null;
		
		try {
			con= DBUtil.getConnection();
			ps= con.prepareStatement("select * from review where p_Code=?");
			ps.setString(1, pCode);
			rs=ps.executeQuery();
			while(rs.next()) {
				ReviewDTO dto= new ReviewDTO(
						rs.getInt("rIndexNo"), 
						rs.getString("pCode"),
						rs.getString("memberID"),
						rs.getString("rDate"),
						rs.getString("rContent"),
						rs.getString("rPhoto"),
						rs.getInt("rRate"));
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public int userReviewInsert(ReviewDTO reviewDTO) {
		Connection con=null;
		PreparedStatement ps =null;
		int re=0;
		
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("insert into review values(?,?,?,sysdate,?,?,?,)");
			ps.setInt(1, reviewDTO.getrIndexNo());
			ps.setString(2, reviewDTO.getpCode());
			ps.setString(3, reviewDTO.getMemberID());
			ps.setString(4, reviewDTO.getrContent());
			ps.setString(5, reviewDTO.getrPhoto());
			ps.setInt(6, reviewDTO.getrRate());
			re=ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		
		return re;
	}

	@Override
	public int userReviewUpdate(ReviewDTO reviewDTO) {
		Connection con= null;
		PreparedStatement ps= null;
		int re=0;
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("update review set pCode=?, sysdate, rContent=?, rPhoto=?, rRate=? ");
			ps.setString(1, reviewDTO.getpCode());
			ps.setString(2, reviewDTO.getrContent());
			ps.setString(3, reviewDTO.getrPhoto());
			ps.setInt(4, reviewDTO.getrRate());
			re=ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return re;
	}

	
	@Override
	public int userReviewDelete(String rIndexNo) {
		Connection con= null;
		PreparedStatement ps= null;
		int re=0;
		try {
			con= DBUtil.getConnection();
			ps= con.prepareStatement("delete review where r_indexNo=?");
			ps.setString(1, rIndexNo);
			re=ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return re;
	}

}
