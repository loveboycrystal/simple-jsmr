package com.loveboy.commons.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.loveboy.commons.SysConstant;
import com.loveboy.commons.base.form.vo.SimpleResultVo;
import com.loveboy.commons.util.RequestUtil;
import com.loveboy.commons.util.SystemTool;
import com.loveboy.sys.user.form.vo.SysUserLoginVo;

public class RequestPermissionsFilter  extends HttpServlet  implements Filter {
	private static final Logger  log =  Logger.getLogger(RequestPermissionsFilter.class);
	private static final long serialVersionUID = 1L;
	
	 public FilterConfig config;

	public void init(FilterConfig filterConfig) throws ServletException {
		 config = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletResponse resp  =(HttpServletResponse) response;    
		HttpServletRequest req  =(HttpServletRequest) request;    
        HttpSession session = req.getSession(true);     
        
       
        
       // System.out.println("sessionId"+session.getId()+"\t");
       // System.out.println("SessionIP"+request.getServerName()+"\t");
        
        //获取登录对象
        SysUserLoginVo loginUser =  (SysUserLoginVo) req.getSession().getAttribute("loginUser");
   /*     Enumeration e = session.getAttributeNames();
        while (e.hasMoreElements()) {
           String name = (String)e.nextElement();
           String value = session.getAttribute(name).toString();
               System.out.println( name + " = " + value);
         }*/
        
       // log.info(request.getServerName());
        String url=req.getRequestURI();   
        String[] leveStr  =  url.split("/");
        int leveCount = leveStr.length - 1; 
        //log.info("url="+url);
        // */*/admin/*/*.html   or */*/admin/*/*.jsp
        if(
        		(loginUser==null &&  leveCount==2 && url.endsWith("index.html") ) ||
        		(	loginUser==null  && leveCount==5 && (url.endsWith(".html") || url.endsWith(".jsp")) && leveStr[3].equals("admin") ) ||
        		(	loginUser!=null &&  leveCount==5 && loginUser.getType().intValue() != SysConstant.UserType.mgr_user.getValue().intValue() && 
        		    (url.endsWith(".html") || url.endsWith(".jsp")) && leveStr[3].equals("admin")
        		) 
        		
    	){
        	String path = req.getContextPath();
        	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        	resp.sendRedirect(basePath+"tologin.jsp");  
            return;  
        }
        //所有方法均测试开关 true 为测试，无权限；false 为超管功能
        String resourceTest = SystemTool.getSystemProp("resourceTest").toUpperCase();
        // Mgr结尾的请求只能运营用户访问
        String nofilterEndwith = config.getInitParameter("mgrEndwith");
        if( this.isEndwith(url, nofilterEndwith) && resourceTest.equals("FALSE")){
        	if(loginUser==null || (loginUser!=null &&  loginUser.getType().intValue() != SysConstant.UserType.mgr_user.getValue().intValue())){
        		String reqId = RequestUtil.createRequstId();
        		SimpleResultVo srinf = new SimpleResultVo(reqId);
        		srinf.setResMsg(SysConstant.ValidErrorCode.not_permise_error.getDescription());
        		srinf.setResCode(SysConstant.ValidErrorCode.not_permise_error.getCode());
        		String tmpStr = JSON.toJSONString(srinf);
        		this.writeJson(resp,tmpStr);
        		log.warn("requestId(done):"+reqId+"\tresponse:"+tmpStr);
        		return;
        	}
        }
        
        
         chain.doFilter(request, response);   
		
	}

	public void destroy() {
		this.config = null;
	}


	public static boolean isEndwith(String container, String strRegx) {
        boolean result = false;
        String[] regx = strRegx.split(";");
        for (int i = 0; i < regx.length; i++) {
        	 if (container.endsWith(regx[i]+"/")  || container.endsWith(regx[i])) {
                return true;
            }
        }
        return result;
    }
	
	public static boolean isStartwith(String container, String strRegx) {
        boolean result = false;
        String[] regx = strRegx.split(";");
        for (int i = 0; i < regx.length; i++) {
        	 if (container.startsWith(regx[i]) ) {
                return true;
            }
        }
        return result;
    }
	
    public static void writeJson(HttpServletResponse response, String jsonText)
			throws IOException
	{
		response.setContentType("text/json;charset=UTF-8"); 
		PrintWriter print = response.getWriter();
		print.print(jsonText);
		print.flush();
		print.close();
	}
	public static void main(String[] args) {
		String str = "http://192.168.0.130:8080/eg_manage/demo/login/touloginGrnCard/";
		
		System.out.println(str.endsWith("touloginGrnCard/"));
	}


}
