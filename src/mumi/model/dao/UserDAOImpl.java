package mumi.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import mumi.model.dto.CartDTO;
import mumi.model.dto.MemberDTO;
import mumi.model.dto.NoticeDTO;
import mumi.model.dto.OrderDTO;
import mumi.model.dto.ProductDTO;
import mumi.model.dto.QADTO;
import mumi.model.dto.ReviewDTO;

public class UserDAOImpl implements UserDAO {

	@Override
	public MemberDTO loginFunction(String memberid, String pwd) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDTO memberDTO = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from Member where member_id=? and pwd=?");
			ps.setString(1, memberid);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while (rs.next()) {
				memberDTO = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}

		return memberDTO;
	}

	@Override
	public int userInfoUpdate(MemberDTO memberDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("update member set pwd=?, mname=?, phone=?, addr=? where member_id=?");
			ps.setString(1, memberDTO.getPwd());
			ps.setString(2, memberDTO.getName());
			ps.setString(3, memberDTO.getPhone());
			ps.setString(4, memberDTO.getAddr());
			ps.setString(5, memberDTO.getMemberID());
			result=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override // 다영
	public List<ProductDTO> userProductAllRead() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select p_name, p_image, p_size, min(p_price) from product where p_size='M' GROUP BY p_name, p_image, p_size");
			rs = ps.executeQuery();
			while (rs.next()) {
				ProductDTO dto = new ProductDTO(null, rs.getString("p_name"), rs.getInt("min(p_price)"),
						rs.getString("p_size"), null, 0, rs.getString("p_image"), null);
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
	public List<ProductDTO> userProductRead(String pName) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from product where p_name = ?");
			ps.setString(1, pName);
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
	public List<CartDTO> cartShowAll(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CartDTO> cartList = new ArrayList<>();
		try {

			con=DBUtil.getConnection();
			ps=con.prepareStatement("select o_indexno, p_name, p_price "
					+ "from order_detail join product "
					+ "on order_detail.p_code=product.p_code "
					+ "and member_id=? "
					+ "and o_status=0 "
					+ "order by o_date desc");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				cartList.add(new CartDTO(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return cartList;
	}

	@Override
	public int cartInsert(OrderDTO orderDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {

			con=DBUtil.getConnection();
			ps=con.prepareStatement("insert into order_detail values("
					+ "order_detail_seq.nextval,"
					+ "?, ?, ?, sysdate, ?, ?, ?)");
			ps.setString(1, orderDTO.getpCode());
			ps.setString(2, orderDTO.getMemberID());
			ps.setInt(3, orderDTO.getoEA());
			ps.setInt(4, orderDTO.getoStatus());
			ps.setString(5, orderDTO.getoAddr());
			ps.setString(6, orderDTO.getoPhone());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public int cartUpdate(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CartDTO cartDetailForUpdate(int oIndexNo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CartDTO cartDTO = new CartDTO();
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select o_indexno, order_detail.p_code, p_name, p_price, o_addr, o_phone "
					+ "from order_detail join product "
					+ "on o_IndexNo=? and product.p_code=order_detail.p_code");
			ps.setInt(1, oIndexNo);

			rs=ps.executeQuery();
			if(!rs.next())
				throw new SQLException("해당되는 주문이 없습니다.");
			cartDTO.setoIndexNo(rs.getInt(1));
			cartDTO.setpCode(rs.getString(2));
			cartDTO.setpName(rs.getString(3));
			cartDTO.setpPrice(rs.getInt(4));
			cartDTO.setoAddr(rs.getString(5));
			cartDTO.setoPhone(rs.getString(6));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return cartDTO;
	}

	@Override
	public int cartDelete(int oIndexNo) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from order_detail where o_indexNo=?");
			ps.setInt(1, oIndexNo);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public OrderDTO userOrderContactInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userOrderComplete(OrderDTO orderDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		int updateResult = 0;
		int minusResult = 0;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);

			
			ps=con.prepareStatement("update order_detail set p_code=?, o_ea=?, o_date=sysdate, "
					+ "o_status=1, o_addr=?, o_phone=? "
					+ "where o_indexno=?");
			ps.setString(1, orderDTO.getpCode());
			ps.setInt(2, orderDTO.getoEA());
			ps.setString(3, orderDTO.getoAddr());
			ps.setString(4, orderDTO.getoPhone());
			ps.setInt(5, orderDTO.getoIndexNo());

			updateResult = ps.executeUpdate();
			if (updateResult == 0) {
				con.rollback();
				return updateResult;
			}
			
			ps=con.prepareStatement("update product "
					+ "set p_ea=p_ea-(select o_ea from order_detail where o_indexno=?) "
					+ "where p_code=?");
			ps.setInt(1, orderDTO.getoIndexNo());
			ps.setString(2, orderDTO.getpCode());
			
			minusResult=ps.executeUpdate();
			if(minusResult==0) {
				con.rollback();
				return 0;
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return updateResult;
	}

	@Override //지안
	public List<NoticeDTO> noticeRead() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		String sql="select * from notice";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public NoticeDTO noticeDetailRead(String nIndexNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartDTO> orderListRead(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CartDTO> list = new ArrayList<>();
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("select o_date, p_name, o_ea, (o_ea*p_price)as price, o_addr "
					+ "from order_detail join product "
					+ "on member_id=? "
					+ "and order_detail.p_code=product.p_code "
					+ "and o_status='1' "
					+ "order by o_date desc");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CartDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

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
				QADTO cusDTO = new QADTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getInt(7));
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
		int result = 0;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into QA(b_indexNo,member_id,b_category,b_content,b_title,b_date,b_hasanswer) "
					+ "values(qa_seq.nextval,?,?,?,?,sysdate,0)");
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
		int result = 0;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(
					"update QA set b_content=?,b_title=?,b_date=sysdate where b_indexNo=?");
			
			ps.setString(1, qaDTO.getbContent());
			ps.setString(2, qaDTO.getbTitle());
			ps.setInt(3, qaDTO.getbIndexNo());

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
		QADTO qDTO = null;

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from QA where b_indexNo=?");
			ps.setInt(1, qIndexNo);
			// ??의 순서대로 개수만큼 setXxx( , ) 작성
			rs = ps.executeQuery();
			while (rs.next()) {
				qDTO = new QADTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6),rs.getInt(7));

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

		int result = 0;

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
		Connection con = null;
		PreparedStatement ps = null;
		List<ReviewDTO> list = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from review where p_Code=?");
			ps.setString(1, pCode);
			rs = ps.executeQuery();
			while (rs.next()) {
				ReviewDTO dto = new ReviewDTO(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), Integer.parseInt(rs.getString(7)));
				
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public int userReviewInsert(ReviewDTO reviewDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		int re = 0;

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into review values(review_seq.nextval,?,?,sysdate,?,?,?)");
			ps.setString(1, reviewDTO.getpCode());
			ps.setString(2, reviewDTO.getMemberID());
			ps.setString(3, reviewDTO.getrContent());
			ps.setString(4, reviewDTO.getrPhoto());
			ps.setInt(5, reviewDTO.getrRate());
			re = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}

		return re;
	}



	@Override
	public int userReviewDelete(int rIndexNo) {
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
	public int userLeave(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("delete from member where member_id=?");
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int insertMember(MemberDTO memberDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("insert into member values(?,?,?,?,?,?)");
			ps.setString(1, memberDTO.getMemberID());
			ps.setString(2, memberDTO.getPwd());
			ps.setString(3, memberDTO.getName());
			ps.setString(4, memberDTO.getPhone());
			ps.setString(5, memberDTO.getAddr());
			ps.setInt(6, memberDTO.getIsMGR());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps);
		}

		return result;
	}

	@Override
	public MemberDTO userUpdateForm(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDTO memberDTO = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from member where member_id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				memberDTO = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return memberDTO;
	}

	@Override
	public ReviewDTO userReviewUpdateForm(String rIndexNo) {
		Connection con = null;
		PreparedStatement ps = null;
		ReviewDTO dto = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select * from review where r_indexNo=?");
			ps.setString(1, rIndexNo);
			rs = ps.executeQuery();
			while (rs.next()) {
			dto = new ReviewDTO(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), Integer.parseInt(rs.getString(7)));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		
		return dto;
	}

	@Override
	public int userReviewUpdate(ReviewDTO reviewDTO) {
		Connection con = null;
		PreparedStatement ps= null;
		int result=0;
		
		try {
			con= DBUtil.getConnection();
			ps= con.prepareStatement("update review set r_date=sysdate, r_content=?, r_Rate=? where R_indexNo=?");
			ps.setString(1, reviewDTO.getrContent());
			ps.setInt(2, reviewDTO.getrRate());
			ps.setInt(3, reviewDTO.getrIndexNo());
			result =ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}



/*	@Override
	public int userOrderComplete(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return 0;
	}*/

}
