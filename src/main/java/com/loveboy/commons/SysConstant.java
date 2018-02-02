package com.loveboy.commons;

public class SysConstant {

	public static final int SUCCESSED = 1;  //处理成功
	public static final int FAILED = 0;	 //处理失败
	
	public static final int DOING = 2;	 //处理中
	
	//用户类型
	public enum UserType {
	    mgr_user(99),
	    brow_user(0);
	    private Integer value;
	    private UserType(Integer value) {
	        this.value = value;
	    }

	    public Integer getValue() {
	        return value;
	    }
	    
	}
	
	//用户来源
	public enum UserFrom {
	    sys(99),
	    yh(0),
	    yx(1);
	    private Integer value;
	    private UserFrom(Integer value) {
	        this.value = value;
	    }

	    public Integer getValue() {
	        return value;
	    }
	    
	}
	
	//用户状体
	public enum UserStatus{
	    normal(0),
	    down_line(1);
	    private Integer value;
	    private UserStatus(Integer value) {
	        this.value = value;
	    }

	    public Integer getValue() {
	        return value;
	    }
	    
	}
	
	public enum BusinessErrorCode {
	    login_error ( "40001" , "用户名或密码不正确" ),
	    not_primary_user_error ( "40002" , "用户不唯一" ),
	    dont_mgr_user_error ( "40003" , "非管理员用户" ),
	    db_error ( "40004" , "操作数据库失败" ),
	    other_error ( "49999", "其他错误");

	    private String code;
	    private String description;

	    private BusinessErrorCode(String value,String descpt) {
	        this.code = value;
	        this.description = descpt;
	    }

	    public String getCode() {
	        return code;
	    }
	    
	    public String getDescription() {
	        return description;
	    }
	}
	
	//作用域
	public enum Scope {
	    request("request"),
	    session("session"),
	    application("application");
	    private String value;
	    private Scope(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	    
	}
	
	/**
	 * true 处理成功，false 处理失败
	 * @param resCode
	 * @return
	 */
	public static boolean isResultSuccess(Object resCode){
		boolean flag = false;
		if(String.valueOf(resCode).equals( String.valueOf(SysConstant.SUCCESSED) )){
			flag = true;
		}
		return flag;
	}

	public enum BossDbOpertorErrorCode {
	    req_save_log_error ( "30001" , "接收请求失败" ),
	    resp_save_log_error ( "30002", "响应日志更新错误"),
	    param_to_obj_error ( "30003", "参数加密不正确"),
	    reponse_obj_error ( "30004", "返回对象不规范"),
	    other_error ( "39999", "其他错误");

	    private String code;
	    private String description;

	    private BossDbOpertorErrorCode(String value,String descpt) {
	        this.code = value;
	        this.description = descpt;
	    }

	    public String getCode() {
	        return code;
	    }
	    
	    public String getDescription() {
	        return description;
	    }
	}

	//验证类 
	public enum ValidErrorCode {
	    url_notfound ( "10001" , "请求链接不存在" ),
	    param_format_error ( "10002", "参数格式不正确"),
	    boss_lose ( "10004", "boss服务器不可用"),
	    inner_server_error ( "10005" , "proxy内部错误"),
	    no_valid_server ( "10006" , "无可用服务"),
	    param_valid_error ( "10007" , "请求uri格式不正确"),
	    boss_done_error ( "10008" , "boss处理失败"),
	    boss_uri_error ( "10009" , "boss uri 请求地址不正确"),
	    json_param_error ( "10010" , "参数加密不正确"),
	    not_permise_error ( "10011" , "无权限访问"),
	    other_error ( "19999", "其他错误");

	    private String code;
	    private String description;

	    private ValidErrorCode(String value,String descpt) {
	        this.code = value;
	        this.description = descpt;
	    }

	    public String getCode() {
	        return code;
	    }
	    
	    public String getDescription() {
	        return description;
	    }
	}
	
	
	//权限类
	public enum OperatorErrorCode {
	    interface_not_power("2001","请求接口无权限"),
	    not_allow_ip("2002","无效的proxy请求IP");

	    private String code;
	    private String description;
	    private OperatorErrorCode(String value,String descpt) {
	        this.code = value;
	        this.description = descpt;
	    }

	    public String getCode() {
	        return code;
	    }
	    
	    public String getDescription() {
	        return description;
	    }
	}
}
