package com.loveboy.commons;

import com.loveboy.commons.util.SystemTool;

/**
 * 壹号课堂业务系统枚举
 * 
 * @author XuZhaoJie
 * 
 */
public class XCXConstant {

	/**
	 * 壹号课堂session的key值
	 */
	public static final String SESSION_TOKEN = "SESSION_TOKEN";// 用于token是否已经失效,一个token只有一个有效
	public static final String SESSION_USER = "SESSION_USER";// 用户登录的session凭证
	public static final String SESSION_SCHOOL = "SESSION_SCHOOL";//

	public static final String FAIL = "FAIL";
	public static final String SUCCESS = "SUCCESS";

	public static final String UNIFIEDORDER_URL_SUFFIX = "https://api.mch.weixin.qq.com/pay/unifiedorder"; // 统一下单接口
	public static final String ORDERQUERY_URL_SUFFIX = "https://api.mch.weixin.qq.com/pay/orderquery"; // 查询订单接口

	// 首页地址
	public static final String HOME_PAGE = SystemTool
			.getSystemProp("HOME_PAGE");//

	public enum XCXError {
		db_error("xcx_0001", "db 操作 失败"), params_error("xcx_0002", "参数缺少或者错误"), not_user_error(
				"xcx_0003", "没有用户信息"), data_not_found_error("xcx_0004",
				"没有找到相关数据"), pwd_not_equal("xcx_0005", "两个密码不一致"), oldpwd_not_equal(
				"xcx_0006", "旧密码不正确"), have_subscribe("xcx_0007",
				"已订阅过该专辑，不能重复订阅"), unifiedOrder_error("xcx_0008", "统一下单失败"), wechat_error(
				"xcx_0009", "微信请求出现错误"), net_error("xcx_0010", "https业务请求超时");

		private String desc;
		private String code;

		private XCXError(String code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

	public enum XCXStatus {
		status_enable(0L, "状态有效"), status_disable(1L, "状态无效"), stick_no(0L,
				"未置顶"), stick_yes(1L, "置顶"), publish_status_no(0L, "未发布"), publish_status_yes(
				1L, "已发布");

		private String desc;
		private Long code;

		private XCXStatus(Long code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public Long getCode() {
			return code;
		}

		public void setCode(Long code) {
			this.code = code;
		}
	}

}
