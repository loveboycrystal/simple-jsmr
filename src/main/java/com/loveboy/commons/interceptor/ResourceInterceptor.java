package com.loveboy.commons.interceptor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.loveboy.commons.SysConstant;
import com.loveboy.commons.YHFunction;
import com.loveboy.commons.annotation.ResourceLogInfo;
import com.loveboy.commons.base.form.vo.LogInfoVo;
import com.loveboy.commons.base.form.vo.ResultInfoVo;
import com.loveboy.commons.base.form.vo.SimpleResultVo;
import com.loveboy.commons.base.form.vo.TokenYhUserVo;
import com.loveboy.commons.util.RequestUtil;
import com.loveboy.commons.util.SecretWordUtil;
import com.loveboy.sys.log.service.LogsService;
import com.loveboy.sys.user.form.vo.SysUserLoginVo;
import com.loveboy.sys.user.service.IUserService;

/**
 * Resource aop切面
 * 1.初始化Resource相关变量
 * 2.用于记录日志
 * @author chenes
 */
@Service
public class ResourceInterceptor {
	
	@Autowired
	private LogsService logsService;
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private IUserService iUserService;

	 private static final Logger  log =  Logger.getLogger(ResourceInterceptor.class);
	
	 public Object resourceAspect(ProceedingJoinPoint point,Path resourcePath,ResourceLogInfo resourceLogInfo){
		//请求的唯一ID(可用于日志查询)
		String requestId = RequestUtil.createRequstId();
		StringBuffer logSb = new StringBuffer();
		Object ret = null;
		LogInfoVo logVo = null;
		try {
			
			/*
			 * *************************
			 * 		Resource 执行之前   
			 * *************************
			 */
			//执行的resource类（已被实例化）
			Object target = point.getTarget();
			
			//通过反射获取 请求 对象
			Field requestField = target.getClass().getField("request");
			HttpServletRequest request =  (HttpServletRequest) requestField.get(target);
			
			//通过反射获取 uriinfo 对象
			Field uriInfoField = target.getClass().getField("uriInfo");
			UriInfo uriInfo = (UriInfo) uriInfoField.get(target);
			
			//通过反射获取 gson 对象
			Field jsonField = target.getClass().getField("json");
			JSON json = (JSON) jsonField.get(target);
			
			
			//Resource 方法名称
			String moduleName = "";
			//Resource 方法描述
			String resourceDesc = "";
			//Resource function 详情
			YHFunction function = YHFunction.none;
			if(resourceLogInfo!=null){
				moduleName = resourceLogInfo.moduleName();
				resourceDesc = resourceLogInfo.description();
				function = resourceLogInfo.function();
			}
			
			
			
			//前端传入的加密参数
			String paramsJson = request.getParameter("paramsJson");
			
			logSb.append("requestId(receive):").append(requestId);
			logSb.append("\turi:").append(request.getRequestURI());//.append(uriInfo.getRequestUri());
			logSb.append("\tmethod:").append(request.getMethod());
			logSb.append("\tparamsJson:").append(paramsJson);
			log.info(logSb.toString());
			
			Method method = target.getClass().getMethod("setRequestId",String.class);
			method.invoke(target, requestId);
			String  decodeParamJson = "";
			if(!StringUtils.isBlank(paramsJson)){
				decodeParamJson = SecretWordUtil.getDecodeStr(paramsJson);
				method = target.getClass().getMethod("setDataJson",String.class);
				method.invoke(target, decodeParamJson);
			}
			//Resource 的方法属性为YHFunction.none不记录日志
			if(function.getFnId() != YHFunction.none.getFnId()){
				//存储请求日志
				logVo = new LogInfoVo();
				logVo.setReqId(requestId);
				logVo.setReqUrl(request.getRequestURI());
				logVo.setReqParam(paramsJson);
				logVo.setReqMethod(request.getMethod());
				logVo.setReqDate(new Date());
				logVo.setReqIp(RequestUtil.getIpAddr(request));
				logVo.setModuleName(moduleName);
				logVo.setDescription(resourceDesc);
				logVo.setBusinessId(function.getFnId());
				logVo.setDoneStatus("00");
				 // Mgr结尾的请求
				 if (request.getRequestURI().endsWith("Mgr/")  || request.getRequestURI().endsWith("Mgr")) {
					 logVo.setRequestType(1);
	             }else{
	            	 logVo.setRequestType(0);
	             }
				 logsService.requestSysLogs(logVo);
			}
			
			//resource第一个参数的值
			//String value = point.getArgs()[0].toString();
			
			/*
			 * *************************
			 * 		Resource 执行
			 * *************************
			 */
			ret = point.proceed();
			logSb = new StringBuffer();
			logSb.append("requestId(done): ").append(requestId);
			logSb.append("\tresponse:").append(JSON.toJSONString(ret));
			log.info(logSb.toString());
			/*
			 * *************************
			 * 		Resource 执行 结束
			 * *************************
			 */
			
			//Resource 的方法属性为YHFunction.none不记录日志
			if(function.getFnId() != YHFunction.none.getFnId()){
				//app 登录的用户 tokend对应用户id
				TokenYhUserVo tokenUser = null;
				//获取后台操作用户
				Object loginObject = null;
				loginObject = request.getSession().getAttribute("loginUser");
				tokenUser = JSON.parseObject(decodeParamJson, TokenYhUserVo.class);
				if(loginObject==null && (tokenUser==null || "".equals(tokenUser.getTokenId()))  ){
					logVo.setUserId(0l);
				}else{
					SysUserLoginVo loginUserVo = null;
					try{
						//app 登录用户
						if(tokenUser!=null && (tokenUser.getTokenId()!=null && !"".equals(tokenUser.getTokenId().trim()))){
						 //后台管理用户
						}else if(loginObject!=null){ 
							loginUserVo = (SysUserLoginVo) loginObject;
						}
						logVo.setUserId(loginUserVo.getId());
					}catch(Exception e){
						logVo.setUserId(0l);
					}
				}
				//更新用户操作失败日志
				if(ret instanceof ResultInfoVo){
					logVo.setDoneStatus(String.valueOf(((ResultInfoVo)ret).getResCode()));
					logVo.setErrMsg(String.valueOf(((ResultInfoVo)ret).getLogErrorMsg()));
				}else if(ret instanceof SimpleResultVo){
					logVo.setDoneStatus(String.valueOf(((SimpleResultVo)ret).getResCode()));
					logVo.setErrMsg(String.valueOf(((SimpleResultVo)ret).getLogErrorMsg()));
				}else{
					logVo.setDoneStatus(SysConstant.BossDbOpertorErrorCode.reponse_obj_error.getCode());
					logVo.setErrMsg(SysConstant.BossDbOpertorErrorCode.reponse_obj_error.getDescription());
				}
				logVo.setRespDate(new Date());
				logVo.setRespData(JSON.toJSONString(ret));
				logsService.responseSysLogs(logVo);
			}
		} catch (Throwable e) {
			/*
			 * *************************
			 * 		Resource 执行异常
			 * *************************
			 */
			logSb = new StringBuffer();
			logSb.append("requestId(error):").append(requestId);
			logSb.append("\terror:").append(e.toString());
			log.error(logSb.toString());
			return ret;
		}
		return ret;
	 };
	
	
	/*
	@Pointcut("execution(public * com.loveboy..resource.*.*(..))")
    public void myMethod(){};
    
    //@Before("execution(public void com.oumyye.dao.impl.UserDAOImpl.save(com.oumyye.model.User))")
    @Before("myMethod()")
    public void before(JoinPoint point) throws Exception {
    	Signature signature = point.getSignature();
    	Object target = point.getTarget();
    	try {
			Method method = target.getClass().getMethod("setMyParamsJson",String.class);
			String value = point.getArgs()[0].toString();
			method.invoke(target, value);
		}  catch (SecurityException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println("@Before：模拟权限检查...");
        System.out.println("@Before：目标方法为：" + 
                signature.getDeclaringTypeName() + 
                "." + signature.getName());
        System.out.println("@Before：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@Before：被织入的目标对象为：" + target);
        System.out.println("method staet");
    } 
    @After("myMethod()")
    public void after() {
        System.out.println("method after");
    } 
    @AfterReturning("execution(public * com.loveboy..resource.*.*(..))")
    public void AfterReturning() {
        System.out.println("method AfterReturning");
    } 
    @AfterThrowing("execution(public * com.loveboy..resource.*.*(..))")
    public void AfterThrowing() {
        System.out.println("method AfterThrowing");
    } 
    */
}
