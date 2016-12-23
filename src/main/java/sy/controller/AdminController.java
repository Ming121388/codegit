package sy.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sy.model.Detail;
import sy.model.Good;
import sy.model.Order;
import sy.model.User;
import sy.service.GoodServiceI;
import sy.service.OrderServiceI;
import sy.service.UserServiceI;
import sy.service.UserServiceImpl;

@Controller
@RequestMapping("/adminController")
public class AdminController {
	private OrderServiceI orderService;

	public OrderServiceI getOrderService() {
		return orderService;
	}

	@Autowired
	public void setOrderService(OrderServiceI orderService) {
		this.orderService = orderService;
	}

	@RequestMapping("/showOrderList")
	public @ResponseBody Map<String, List<Order>> getOrderList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, List<Order>> map = new HashMap<String, List<Order>>();
		System.out.println("开始调用adminController/showOrderList");
//		 Order o =new Order();
//		 List<Order> list=orderService.getAllOrder();
//		 Iterator<Order> it=list.iterator();		
//		 int i = 0;
//		 while(it.hasNext()){
//		 o= it.next();
//		 String orderId="orderId"+i;
//		 map.put(orderId, String.valueOf(o.getOrderId()));

		List<Order> li = orderService.getAllOrder();
		map.put("li", li);

		// i++;
		// }
		// System.out.println(map.size());

		return map;

	}
	@RequestMapping("/showDetail")
	public  @ResponseBody Map<String,List<Detail>> getDetail(Long orderId){
		Map<String , List<Detail>> map = new HashMap<String ,List<Detail>>();
		List<Detail> de = orderService.getDetailByOrderId(orderId);
		System.out.println("orderId=>"+orderId);
		Iterator<Detail> it = de.iterator();
		while(it.hasNext()){
			Detail d = it.next();
			System.out.println(d.getOrderId()+"=>"+d.getDetailId());
		}
		map.put("de",de);
		return map;
	}
	@RequestMapping("/operateDetail")
	public @ResponseBody Map<String,String> operateDetail(HttpSession session,String detailId){
		Map<String,String> map =new HashMap<String, String>();
		String type=detailId.toString().substring(0,1);
		
		long value=Long.valueOf(detailId.toString().substring(1, detailId.length()));
		Detail d =orderService.getDetailByDetailId(value);
		System.out.println(type +"+"+ value);
		if(type.equals("1")){
			orderService.setdetailIsComplete(value, 1);
			System.out.println("1111");
			orderService.setDetailCompleter(value, session.getAttribute("name").toString());
			map.put("msg",d.getDetailGoodName()+" x "+d.getDetailGoodQuantity()+" 订单完成！" );
		}
		if(type.equals("2")){
			orderService.setdetailIsCancel(value, 1);
			orderService.setDetailCompleter(value, session.getAttribute("name").toString());
			map.put("msg",d.getDetailGoodName()+" x "+d.getDetailGoodQuantity()+" 订单取消！" );
		}
		return map;
	}
	

}
