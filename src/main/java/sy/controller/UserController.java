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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sy.model.Detail;
import sy.model.Good;
import sy.model.Order;
import sy.model.User;
import sy.service.GoodServiceI;
import sy.service.OrderServiceI;
import sy.service.UserServiceI;
import sy.service.UserServiceImpl;

@Controller
@RequestMapping("/userController")
public class UserController {
	private UserServiceI userService;
	private GoodServiceI goodService;
	private OrderServiceI orderService;

	public OrderServiceI getOrderService() {
		return orderService;
	}
	@Autowired
	public void setOrderService(OrderServiceI orderService) {
		this.orderService = orderService;
	}
	public GoodServiceI getGoodService() {
		return goodService;
	}
	@Autowired
	public void setGoodService(GoodServiceI goodService) {
		this.goodService = goodService;
	}

	private UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	private void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@RequestMapping("/showUser")
	public String showUser(HttpSession session, String name, String psw,
			HttpServletRequest request) throws Exception {
		User u = new User();
		String temp = null;
		try {
			temp = userService.getUserByName(name).getPsw();
		} catch (Exception e) {
			System.out.println("数据库没人此人，无法登陆");

		}
		if (temp.equals(psw) && name != "" && psw != "") {
			request.setAttribute("user", u);
			session.setAttribute("name", name);
			System.out.println("user" + name + "login success");
			return "showUser";
		} else {
			return "loginFail";
		}
	}

	@RequestMapping("/login")
	// 8月3日要更新vo类jifenyue
	public @ResponseBody Map<String, Object> login(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// System.out.println(request.getParameter("name"));
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		response.addHeader("Access-Control-Allow-Headers",
//				"Origin, X-Requested-With, Content-Type, Accept");
		System.out.println("11111");
		User u = new User();
		int i = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> lists = userService.getAll();
		Iterator<User> it = lists.iterator();
		System.out.println("输入的name+" + request.getParameter("name"));
		while (it.hasNext()) {
			u = it.next();
			if (u.getName().equals(request.getParameter("name"))) {
				if (u.getPsw().equals(request.getParameter("psw"))) {
					i = 1;
					System.out.println("用户名有，密码对");
					break;
				} else {
					System.out.println("用户名有,密码错");
					i = 2;
					break;
				}

			} else {
				System.out.println("用户名");
				i = 0;

			}
		}
		if (i == 1) {
			map.put("name", u.getName());
			map.put("msg", "登录成功");
		//	map.put("msgs", "登录成功" + "<a href="+localUrl+"/sssm/showUser.html'>去操作</a>");
			map.put("hide", "1");
			session.setAttribute("name", u.getName());
			System.out.println("session 插入"+u.getName());
//			if(
			return map;
		}
		else if (i == 2) {
			map.put("msg", "密码错误，登录失败");
			return map;
		} else {
			map.put("name", request.getParameter("name"));
			map.put("msg", "用户名不存在，登录失败");
			return map;
		}

	}

	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		System.out.println(session.getAttribute("name") + "退出登录成功，删除session");
		session.invalidate();

		return "login";
	}

	@RequestMapping("/zhuCe")
	public @ResponseBody Map<String, Object> zhuCe(Integer id, String name,
			String psw, HttpServletRequest request,HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		User u = new User();
		boolean temp = false;
		List<User> lists = userService.getAll();
		
		//System.out.println(u.getName());
		
		Iterator<User> it = lists.iterator();
		while (it.hasNext()) {
			u = (User) it.next();
			if (u.getName().equals(name)) {
				temp = true;
				System.out.println(u.getName() + "有了");
				break;
			}
			System.out.println(u.getName());
		}
		map.put("name", name);
		if (temp == false) {
			userService.setUser(name, psw);
			
			map.put("msg", "注册成功" + "<a href ='login.html'>去登录</a>");
			return map;
		} else {
			map.put("msg", "用户名存在，注册失败");
			return map;
		}
	}

	@RequestMapping("/chuanZ")
	public void zhuCe(@RequestParam String x, @RequestParam String y,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String x= request.getParameter("x");
		// String y=request.getParameter("y");

		int z = Integer.valueOf(x) + Integer.valueOf(y);
		String res = "{\"x" + "\":\"" + x + "\"," + "\"y" + "\":" + y + "}";
		request.setAttribute("z", z);
		System.out.println(x);
		System.out.println(res);
		response.getWriter().write(res);
		// return "ajax";
	}

	@RequestMapping("/showYue")
	// 8月3日要更新vo类jifenyue
	public @ResponseBody Map<String, Object> showYue(
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		// System.out.println(request.getParameter("name"));
		User u = new User();
		u = userService.getUserByName((String) session.getAttribute("name"));
		System.out.println(u.getYue());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("yue", u.getYue());
		// if (request.getParameter("name").equals("123")) {
		// System.out.println("yonghuming");
		// map.put("msg", "chenggong");
		// } else {
		// System.out.println("sibai");
		// map.put("msg", "sibai");
		// }
		return map;

	}

	@RequestMapping("/order")
	//@ResponseBody
	public @ResponseBody Map<String, Object> order(HttpServletRequest request,
			HttpServletResponse response ,HttpSession session, @RequestBody String[][] str) {
		//以上若是对象用 List<Good> good 数组用String[] good
		//System.out.println(request.getParameter("name"));
		System.out.println("开始调用 oreder.do");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmss");
		DecimalFormat df=new  DecimalFormat("#.00");
      //Calendar cal=Calendar.getInstance();
		Date date=new Date();
		Long orderId=Long.parseLong(sdf1.format(date));
		double totalP=0;
		for(int i=0 ;i<str.length;i++){
			totalP+=Double.parseDouble(str[i][3]);
		}
		//插入订单数据
	    Order o=new Order();
	    o.setOrderId(orderId);
	    System.out.println("设置orderID"+orderId);
	    o.setOrderBuyer((String)session.getAttribute("name"));
	    System.out.println("设置orderbuyer"+session.getAttribute("name"));
	    o.setOrderTotalprice(Double.parseDouble(df.format(totalP)));
	    System.out.println("shezhi totalP"+Double.parseDouble(df.format(totalP)));
	    o.setOrderIscancel(0);
	    o.setOrderIscomplete(0);
	    o.setOrderDate(date);
	    orderService.setOrder(o);
	    //插入订单详细数据
	    Detail d=new Detail();
	    for(int i=0;i<str.length;i++){
	    	Long detailId=Long.parseLong(String.valueOf(orderId)+String.valueOf(i));
	    	d.setDetailId(detailId);
	    	System.out.println("shezhi detail id "+ detailId);
	    	d.setDetailGoodName(str[i][0]);
	    	d.setDetailGoodPrice(Double.parseDouble(df.format(Double.parseDouble(str[i][1]))));
	    	d.setDetailGoodQuantity(Integer.parseInt(str[i][2]));
	    	d.setDetailGoodTotalprice(Double.parseDouble(df.format(Double.parseDouble(str[i][3]))));
	    	d.setOrderId(orderId);
	    	d.setdetailIsCancel(0);
	    	d.setdetailIsComplete(0);
	        orderService.setDetail(d);
	    }

//System.out.println(good);
		

		Map<String, Object> map = new HashMap<String, Object>();
		
		return map;
		
	}

}
