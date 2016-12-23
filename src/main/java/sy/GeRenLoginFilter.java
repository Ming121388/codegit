package sy;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:陈伟
 * @date:2008-5-23
 * 
 */
public class GeRenLoginFilter implements Filter {

	private final static String[] eixt_url = { "index.jsp", "index.html",
			"login.html", "login.jsp", "userController/login.do",
			"relogin.jsp", "uholdcard.do", "/js", "/css", "/images",
			"userController/showUser.do", "userController/zhuCe.do",
			"keywordslist.jsp", "regprotocol.jsp", "register.jsp", "uarea.do" }; // 不用做权限判断的URL

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		boolean haveFind = true;
		boolean requestAdmin = false;

		// System.out.println("req.getRequestURI()==="+req.getRequestURI());
		if (req.getRequestURL().indexOf("orderManager") >= 0){
			requestAdmin = true;
			System.out.println("requestAdmin:true");
		}
		if (req.getRequestURI().indexOf(".jsp") >= 0
				|| req.getRequestURI().indexOf(".do") >= 0
				|| req.getRequestURI().indexOf(".html") >= 0)
			haveFind = false;

		for (int i = 0; i < eixt_url.length; i++) {
			if (req.getRequestURI().indexOf(eixt_url[i]) >= 0) {
				haveFind = true;
				System.out.println("这个不用拦截");
				break;
			}
		}

		// System.out.println("haveFind==="+haveFind);

		if (!haveFind && req.getSession().getAttribute("name") == null) {
			res.sendRedirect(req.getContextPath() + "/login.html");
			System.out.println("sesson has no user name");
			return;
		}
//		if (requestAdmin == true && req.getSession().getAttribute("name").equals("ming")) {
//			//res.sendRedirect(req.getContextPath() + "/orderManager.html");
//			//return;
//			}
		 if (requestAdmin == true && !req.getSession().getAttribute("name").equals("ming")) {
			 System.out.println("not admin");
				res.sendRedirect(req.getContextPath() + "/login.html");
				return;
				}

		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

}