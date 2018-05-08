package mumi.admincontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mumi.model.dto.OrderDTO;
import mumi.model.service.MumiService;
import mumi.usercontroller.Action;
import mumi.usercontroller.ModelAndView;
import net.sf.json.JSONArray;

/**
 * 모든 사용자의 결제 내역 확인
 */

public class AdminOrderListReadAction implements Action{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		List<OrderDTO> customerOrderList = new ArrayList<>();
		try {
			customerOrderList = MumiService.selectOrderAll();
			JSONArray orderList = JSONArray.fromObject(customerOrderList);
			request.setAttribute("orderList", orderList);
			mv.setPath("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

}
