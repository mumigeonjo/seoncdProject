package mumi.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public List<QADTO> userQARead(String memberid) {
		
		Connection conn= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QADTO> qlist = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from QA where member_id=?");
			ps.setString(1, memberid);
			//??의 순서대로 개수만큼 setXxx( , ) 작성
			rs = ps.executeQuery();
			while(rs.next()) {
				QADTO cusDTO = new QADTO(rs.getString("id"), rs.getString("name"), rs.getInt("age"),
						rs.getString("tel"), rs.getString("addr"));
				qlist.add(cusDTO);
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(conn, ps, rs);
		}
		
		return qlist;
	}
	}

	@Override
	public int userQAInsert(QADTO qADTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userQAUpdate(QADTO qADTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public QADTO userQAReadForUpdate(String qIndexNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userQADelete(String bIndexNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReviewDTO> userReviewRead(String pCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userReviewInsert(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userReviewUpdate(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReviewDTO userReviewReadForUpdate(String rIndexNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userReviewDelete(String rIndexNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
