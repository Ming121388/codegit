package sy;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component("accessControllAllowFilter")
public class AccessControllAllowFilter implements Filter {

@Override
public void init(FilterConfig filterConfig) throws ServletException {
//To change body of implemented methods use File | Settings | File Templates.
}

@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
httpResponse.addHeader("Access-Control-Allow-Origin", "*");
httpResponse.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
filterChain.doFilter(servletRequest, servletResponse);
//To change body of implemented methods use File | Settings | File Templates.
}

@Override
public void destroy() {
//To change body of implemented methods use File | Settings | File Templates.
}
}
