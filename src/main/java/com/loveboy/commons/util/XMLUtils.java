package com.loveboy.commons.util;

import java.lang.reflect.Field;

import com.thoughtworks.xstream.XStream;

public class XMLUtils {

	public static String beanToXML(Object object) {
		return beanToXML(object, "xml");
	}

	public static String beanToXML(Object object, String rootName) {
		XStream xStream = new XStream();
		xStream.setMode(XStream.NO_REFERENCES);
		// 注册使用了注解的VO
		xStream.processAnnotations(object.getClass());
		xStream.alias(rootName, object.getClass());
		String xml = xStream.toXML(object);
		xml = xml.replace("__", "_");
		return xml;
	}

	public static String myBeanToXML(Object model, String rootName) {
		StringBuilder sb = new StringBuilder();
		sb.append("<" + rootName + ">");
		if (model != null) {
			Field[] field = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组

			for (int j = 0; j < field.length; j++) { // 遍历所有属性
				field[j].setAccessible(true);
				String name = field[j].getName(); // 获取属性的名字
				Object value = null;
				try {
					value = field[j].get(model);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if (value != null) {
					sb.append("<" + name + ">");
					if(!"total_fee".equals(name)){
						sb.append("<![CDATA["+value.toString()+"]]>");
					}else{
						sb.append(value.toString());
					}
					sb.append("</" + name + ">");
				}
			}
		}
		sb.append("</" + rootName + ">");
		return sb.toString();
	}

	public static <T> T xmlToBean(String xml, Class<?> clazz) {
		return xmlToBean(xml, clazz, "xml");
	}

	@SuppressWarnings("unchecked")
	public static <T> T xmlToBean(String xml, Class<?> clazz, String rootName) {
		Object obj = null;
		try {
			obj = clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		XStream xStream = new XStream();
		xStream.setMode(XStream.NO_REFERENCES);
		// 注册使用了注解的VO
		xStream.processAnnotations(clazz);
		xStream.alias(rootName, clazz);
		obj = xStream.fromXML(xml);
		return (T) obj;
	}

	public static void main(String[] args) {
	/*	String xml = "<xml><appid><![CDATA[wx3ccf494c3cfc3bbd]]></appid><body><![CDATA[客盛果品]]></body><fee_type><![CDATA[1]]></fee_type><mch_id><![CDATA[1268297101]]></mch_id><nonce_str><![CDATA[9fc3d7152ba9336a670e36d0ed79bc43]]></nonce_str><notify_url><![CDATA[http://gioc.easier.cn/ksgp/wxpay!callback]]></notify_url><openid><![CDATA[ojaR6wdMXtzujoer8T9lL29cYN7k]]></openid><out_trade_no><![CDATA[KSGP0010175201608161750040004]]></out_trade_no><sign><![CDATA[1588A2AE1C0C3F2EA5CDC8474346A591]]></sign><spbill_create_ip><![CDATA[211.147.242.132]]></spbill_create_ip><total_fee><![CDATA[1]]></total_fee><trade_type><![CDATA[JSAPI]]></trade_type></xml>";
		WechatPay pay = xmlToBean(xml, WechatPay.class, "xml");
		System.out.println(pay);
		xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><appid><![CDATA[wx3ccf494c3cfc3bbd]]></appid><mch_id><![CDATA[1268297101]]></mch_id><nonce_str><![CDATA[IkDrZAsh2FK9a1sF]]></nonce_str><sign><![CDATA[A5C0BC02CFDDBE238BAAEE651F9E3719]]></sign><result_code><![CDATA[SUCCESS]]></result_code><prepay_id><![CDATA[wx2016081617505932e19c83c60017591171]]></prepay_id><trade_type><![CDATA[JSAPI]]></trade_type></xml>";
		WechatPayResult result = xmlToBean(xml, WechatPayResult.class, "xml");
		System.out.println(result);

		System.err.println(XMLUtils.beanToXML(pay, "xml"));*/
	}

}
