package mumi.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public int insertMember(MemberDTO memberDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con=DBUtil.getConnection();
			ps=con.prepareStatement("insert into Member values(?,?,?,?,?,?)");
			ps.setString(1, memberDTO.getMemberID());
			ps.setString(2, memberDTO.getPwd());
			ps.setString(3, memberDTO.getName());
			ps.setString(4, memberDTO.getPhone());
			ps.setString(5, memberDTO.getAddr());
			ps.setInt(6, memberDTO.getIsMGR());
			result=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
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
