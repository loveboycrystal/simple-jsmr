package com.loveboy.commons.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


@Component
@WebFilter(filterName="CrossFilter",urlPatterns="/*")  
public class CrossFilter implements Filter {

	public FilterConfig config;

	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		String m = req.getMethod();
		if (m.equals("OPTIONS")) {
			resp.addHeader("Access-Control-Allow-Origin", "*");
			resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,DELETE,PUT");
			resp.addHeader("Access-Control-Allow-Headers", "Content-Type");
			resp.addHeader("Access-Control-Allow-Credentials", "true");
			return;
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
		this.config = null;
	}

}
