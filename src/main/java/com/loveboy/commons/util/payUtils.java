package com.loveboy.commons.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;





public class payUtils {
	private static final Logger log = Logger.getLogger(payUtils.class);
	
	public static void main(String[] args) throws Exception {
		String xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
		Map<Object,Object> map = xmlToMap(xml);
		System.out.println(map.toString());
		/*Map<String, String> reqData=new HashMap<String,String>();
		reqData.put("appid", PropertiesUtil.getDataSourceProp().getProperty("appid"));
		reqData.put("mch_id", PropertiesUtil.getDataSourceProp().getProperty("mch_id"));
		reqData.put("body", "壹号课堂-充值");
		reqData.put("device_info", "013467007045764");
		String randomStr = "c485ea980e4e4901bdbca1b16b32173e";
		reqData.put("nonce_str", randomStr);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");
		String time_start = format1.format(new Date());  //交易起始时间
		Calendar now=Calendar.getInstance();
		now.add(Calendar.MINUTE,30);
		String time_expire = format1.format(now.getTimeInMillis());  //交易结束时间
		reqData.put("time_start", "20171017104947");
		reqData.put("time_expire", "20171017111947");
		reqData.put("out_trade_no", "1507963450042504204");  //订单流水号
		reqData.put("total_fee", 45000+"");
		reqData.put("spbill_create_ip", "123.12.12.123");
		reqData.put("notify_url", PropertiesUtil.getDataSourceProp().getProperty("notifyurl"));  //接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数
		reqData.put("trade_type", "APP");
		
		String key="1272550101";
		String signType="MD5";
		Set<String> keySet = reqData.keySet();
		String[] keyArray = keySet.toArray(new String[keySet.size()]);
		Arrays.sort(keyArray);
		StringBuilder sb = new StringBuilder();
		for (String k : keyArray) {
			if (k.equals("sign")) {
				continue;
			}
			if (StringUtils.isNoneBlank(reqData.get(k)) && reqData.get(k).length() > 0) // 参数值为空，则不参与签名
				sb.append(k).append("=").append(reqData.get(k)).append("&");
		}
		sb.append("key=").append(key);
		System.out.println(sb.toString());
		if ("MD5".equals(signType)) {
			System.out.println(MD5(sb.toString()).toUpperCase());
		}else {
			throw new Exception(String.format("Invalid sign_type: %s", signType));
		}*/
	}
	
	/**
	 * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。默认MD5加密
	 *
	 * @param data 待签名数据
	 * @param key API密钥
	 * @param signType 签名方式
	 * @return 签名
	 */
	public static String generateSignature(Map<Object, Object> data, String key, String signType) throws Exception {
		StringBuffer sb = new StringBuffer();
		if (!(data instanceof SortedMap<?, ?>)) {
			data = new TreeMap<Object, Object>(data);
		}
		Set<?> es = data.entrySet();// 所有参与传参的参数按照accsii排序（升序）
		Iterator<?> it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + key);
		String sign = MD5(sb.toString()).toUpperCase();
		return sign;
	}

	/**
	 * 生成 MD5
	 *
	 * @param data 待处理数据
	 * @return MD5结果
	 */
	public static String MD5(String data) throws Exception {
		java.security.MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] array = md.digest(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 生成 HMACSHA256
	 * @param data 待处理数据
	 * @param key 密钥
	 * @return 加密结果
	 * @throws Exception
	 */
	public static String HMACSHA256(String data, String key) throws Exception {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		sha256_HMAC.init(secret_key);
		byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}
	/**
	 * 生成 uuid， 即用来标识一笔单，也用做 nonce_str
	 * @return
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
	}

	/**
	 * 判断签名是否正确，必须包含sign字段，否则返回false。
	 *
	 * @param data Map类型数据
	 * @param key API密钥
	 * @param signType 签名方式
	 * @return 签名是否正确
	 * @throws Exception
	 */
	public static boolean isSignatureValid(Map<Object, Object> data, String key, String signType) throws Exception {
		if (!data.containsKey("sign") ) {
			return false;
		}
		String sign = (String) data.get("sign");
		return generateSignature(data, key, signType).equals(sign);
	}

	/**
	 * XML格式字符串转换为Map
	 *
	 * @param strXML XML字符串
	 * @return XML数据转换后的Map
	 * @throws Exception
	 */
	public static Map<Object, Object> xmlToMap(String strXML) throws Exception {
		try {
			Map<Object, Object> data = new HashMap<Object, Object>();
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
			org.w3c.dom.Document doc = documentBuilder.parse(stream);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getDocumentElement().getChildNodes();
			for (int idx = 0; idx < nodeList.getLength(); ++idx) {
				Node node = nodeList.item(idx);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					org.w3c.dom.Element element = (org.w3c.dom.Element) node;
					data.put(element.getNodeName(), element.getTextContent());
				}
			}
			try {
				stream.close();
			} catch (Exception ex) {
				// do nothing
			}
			return data;
		} catch (Exception ex) {
			log.info("Invalid XML, can not convert to map. Error message: {"+ex.getMessage()+"}. XML content: {"+strXML+"}");
			throw ex;
		}
	}

	
	/**
	 * 将Map转换为XML格式的字符串
	 *
	 * @param data Map类型数据
	 * @return XML格式的字符串
	 * @throws Exception
	 */
	public static String mapToXml(Map<String, String> data) throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder= documentBuilderFactory.newDocumentBuilder();
		org.w3c.dom.Document document = documentBuilder.newDocument();
		org.w3c.dom.Element root = document.createElement("xml");
		document.appendChild(root);
		for (String key: data.keySet()) {
			String value = data.get(key);
			if (value == null) {
				value = "";
			}
			value = value.trim();
			org.w3c.dom.Element filed = document.createElement(key);
			filed.appendChild(document.createTextNode(value));
			root.appendChild(filed);
		}
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(document);
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		transformer.transform(source, result);
		String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");
		try {
			writer.close();
		}
		catch (Exception ex) {
		}
		return output;
	}

	/**
	 * 处理 HTTPS API返回数据，转换成Map对象。return_code为SUCCESS时，验证签名。
	 * @param xmlStr API返回的XML格式数据
	 * @return Map类型数据
	 * @throws Exception
	 *//*
	public static Map<String, String> processResponseXml(String xmlStr) throws Exception {
		String RETURN_CODE = "return_code";
		String return_code;
		Map<Object, Object> respData = xmlToMap(xmlStr);
		if (respData.containsKey(RETURN_CODE)) {
			return_code = respData.get(RETURN_CODE);
		}
		else {
			throw new Exception(String.format("No `return_code` in XML: %s", xmlStr));
		}

		if (return_code.equals(YHConstant.FAIL)) {
			return respData;
		}
		else if (return_code.equals(YHConstant.SUCCESS)) {
			if (isSignatureValid(respData,PropertiesUtil.getDataSourceProp().getProperty("key"),"MD5")) {
				return respData;
			}
			else {
				throw new Exception(String.format("Invalid sign value in XML: %s", xmlStr));
			}
		}
		else {
			throw new Exception(String.format("return_code value %s is invalid in XML: %s", return_code, xmlStr));
		}
	}
*/
	
	
	/**
	 * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。默认MD5加密
	 *
	 * @param data 待签名数据
	 * @param key API密钥
	 * @param signType 签名方式
	 * @return 签名
	 
	public static String generateSignature(final Map<String, String> data, String key, String signType) throws Exception {
		Set<String> keySet = data.keySet();
		String[] keyArray = keySet.toArray(new String[keySet.size()]);
		Arrays.sort(keyArray);
		StringBuilder sb = new StringBuilder();
		for (String k : keyArray) {
			if (k.equals("sign")) {
				continue;
			}
			if (StringUtils.isNoneBlank(data.get(k)) && data.get(k).length() > 0) // 参数值为空，则不参与签名
				sb.append(k).append("=").append(data.get(k)).append("&");
		}
		sb.append("key=").append(key);
		if ("MD5".equals(signType)) {
			return MD5(sb.toString()).toUpperCase();
		}
		else if ("HMACSHA256".equals(signType)) {
			return HMACSHA256(sb.toString(), key);
		}
		else {
			throw new Exception(String.format("Invalid sign_type: %s", signType));
		}
	}*/
}
