# simple-jsmr

纯净版前后端分离web框架 

 软件环境：jdk 1.7+Tomcat 7 + redis 4.01 + mariadb 5.5.5-10.2.6-MariaDB Maven 3.05
 
 技术环境： jersey 1.19 + spring 4.3.8 + mybatis 3.4.4  .
 
 前端技术：
  
   layUI，jquery HMTL解析接口返回json
   
 后端接口JSON标准：
 
  1.通用JSON格式 
  
  
   {
   
    "data": Object,   //响应结果
    
    
    "reqId": "311f9ffe5319445b8b939c17b637c62d", //请求编号ID
    
    
    "resCode": 1,  //请求响应编码( 1 :成功， 0 和其他自定义编码为失败)
    
    
    "resMsg": "successed"   //响应结果说明
    
    
   }
   
   2.简易JSON格式
   
   {
   
    "reqId": "311f9ffe5319445b8b939c17b637c62d",  //请求编号ID
    
    "resCode": 0, /请求响应编码( 1 :成功， 0 和其他自定义编码为失败)
    
    "resMsg": "boss done failed" //响应结果说明
    
   }
   
基础功能有：

   1.用户管理
   
   2.部门管理
   
   3.日志管理
   
   4.微信小程序支付封装功能模块
   
   
