var huangshuhong = [{
				modulesName: "订单相关-by黄树洪",
				modulesInter: [
					{
						interName: "首页作家列表",
						url: "api/xcx/author/listAuthor",
						method :"GET",
						paramName: ["paramsJson","pageParamVo.pageNum","pageParamVo.pageSize"],
						paramValue: ["eyJwYWdlUGFyYW1WbyI6eyJwYWdlTnVtIjoxLCJwYWdlU2l6ZSI6MTB9fQ==","1","10"],
						required: ["Y","N","N"],
						memo: ["加密后的字符串","当前页码","每页显示条数"],
						reponse : [
						           {field : ["id","Long","专辑ID"]},
						           {field : ["authorName","String","作家名称"]}, 
						           {field : ["gender","String","性别"]}, 
						           {field : ["imageUrl","String","作家头像图片地址"]},
						           {field : ["outline","String","作家简介"]},
						           {field : ["info","String","作家详细介绍"]},
						           {field : ["imageUrl","String","作家介绍音频地址"]},
						           {field : ["label","String","标签"]},
						           {field : ["createTime","Date","创建时间"]},
						           {field : ["modifyId","Long","修改人ID"]},
						           {field : ["modifyTime","Date","修改时间"]}
						           ]
					
					},
					{
						interName: "用户已购专辑列表",
						url: "api/xcx/xcxOrder/listAlbumOrderByUserId",
						method :"GET",
						paramName: ["paramsJson","pageParamVo.pageNum","pageParamVo.pageSize","tokenId"],
						paramValue: ["eyJwYWdlUGFyYW1WbyI6eyJwYWdlTnVtIjoxLCJwYWdlU2l6ZSI6MTB9LCJ0b2tlbklkIjoieWh0aWRlZWE0YWMzNGIzNzQ0MGQ3OGRkMTFlM2Y0ZTJiOWU3ZCJ9","1","10","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N","N"],
						memo: ["加密后的字符串","当前页码","每页显示条数","tokenId"],
						reponse : [
						           {field : ["id","Long","专辑ID"]},
						           {field : ["name","String","专辑名称"]}, 
						           {field : ["authorName","String","作家名称"]}, 
						           {field : ["outline","String","专辑概要"]},
						           {field : ["imageUrl","String","专辑图片地址"]},
						           {field : ["playCount","Long","音频播放次数"]}
						           ]
					
					},
					{
						interName: "用户订阅列表",
						url: "api/xcx/mySubscribe/getByUserId",
						method :"GET",
						paramName: ["paramsJson","pageParamVo.pageNum","pageParamVo.pageSize","tokenId"],
						paramValue: ["eyJwYWdlUGFyYW1WbyI6eyJwYWdlTnVtIjoxLCJwYWdlU2l6ZSI6MTB9LCJ0b2tlbklkIjoieWh0aWRlZWE0YWMzNGIzNzQ0MGQ3OGRkMTFlM2Y0ZTJiOWU3ZCJ9","1","10","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N","N"],
						memo: ["加密后的字符串","当前页码","每页显示条数","tokenId"],
						reponse : [
						           {field : ["id","Long","专辑ID"]},
						           {field : ["name","String","专辑名称"]},
						           {field : ["outline","String","专辑概要"]},
						           {field : ["authorName","String","作家名称"]},
						           {field : ["info","String","专辑信息"]},
						           {field : ["imageUrl","String","音频图片地址"]},
						           {field : ["audioCount","Long","集数"]},
						           {field : ["playCount","Long","播放次数"]},
						           {field : ["otherId","Long","订阅记录ID"]}
						           ]
					
					},
					{
						interName: "新增用户订阅",
						url: "api/xcx/mySubscribe/addMySubscribe",
						method :"POST",
						paramName: ["paramsJson","albumId","tokenId"],
						paramValue: ["eyJhbGJ1bUlkIjoiMTAwOCIsInRva2VuSWQiOiJ5aHRpZGVlYTRhYzM0YjM3NDQwZDc4ZGQxMWUzZjRlMmI5ZTdkIn0=","1008","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N"],
						memo: ["加密后的字符串","专辑ID","tokenId"],
						reponse : [	
						        {field : ["otherId","Long","订阅ID"]},      
						        {field : ["isSubscribe","boolean","专辑是否被订阅的标记，true为已订阅"]}
						]
					
					},
					{
						interName: "删除用户订阅",
						url: "api/xcx/mySubscribe/deleteMySubscribe",
						method :"GET",
						paramName: ["paramsJson","ids","albumId","tokenId"],
						paramValue: ["eyJpZHMiOiIxIiwiYWxidW1JZCI6IjEwMDIiLCJ0b2tlbklkIjoieWh0aWRlZWE0YWMzNGIzNzQ0MGQ3OGRkMTFlM2Y0ZTJiOWU3ZCJ9","1","1002","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N","N"],
						memo: ["加密后的字符串","订阅记录ID(多个id以,间隔)","专辑Id","tokenId"],
						reponse : [
						         {field : ["isSubscribe","boolean","专辑是否被订阅的标记，false为未订阅"]}
						]
					
					},
					{
						interName: "获取用户最近播放历史",
						url: "api/xcx/playHistory/getByUserId",
						method :"GET",
						paramName: ["paramsJson","pageParamVo.pageNum","pageParamVo.pageSize","tokenId"],
						paramValue: ["eyJwYWdlUGFyYW1WbyI6eyJwYWdlTnVtIjoxLCJwYWdlU2l6ZSI6MTB9LCJ0b2tlbklkIjoieWh0aWRlZWE0YWMzNGIzNzQ0MGQ3OGRkMTFlM2Y0ZTJiOWU3ZCJ9","1","10","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N","N"],
						memo: ["加密后的字符串","当前页码","每页显示条数","tokenId"],
						reponse : [
						    {field : ["id","Long","音频ID"]},
						    {field : ["albumId","Long","专辑ID"]},
						    {field : ["name","String","音频名称"]},
						    {field : ["albumName","String","专辑名称"]},
						    {field : ["authorName","String","作家名称"]},
						    {field : ["imageUrl","String","音频图片地址"]},
						    {field : ["audioUrl","String","音频播放地址"]},
						    {field : ["canPlay","boolean","是否可以播放此音频"]},
						    {field : ["otherId","Long","播放历史ID"]}
						]
						
					},
					{
						interName: "新增最近播放历史",
						url: "api/xcx/playHistory/addPlayHistory",
						method :"POST",
						paramName: ["paramsJson","audioId","albumId","tokenId"],
						paramValue: ["eyJhdWRpb0lkIjoiMSIsImFsYnVtSWQiOiIxMDA0IiwidG9rZW5JZCI6InlodGlkZWVhNGFjMzRiMzc0NDBkNzhkZDExZTNmNGUyYjllN2QifQ","1","1004","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N","N"],
						memo: ["加密后的字符串","音频ID","专辑ID","tokenId"],
						reponse : [
						]
						
					},
					{
						interName: "删除播放历史",
						url: "api/xcx/playHistory/deletePlayHistory",
						method :"GET",
						paramName: ["paramsJson","ids","tokenId"],
						paramValue: ["eyJpZHMiOiIxLDIiLCJ0b2tlbklkIjoieWh0aWRlZWE0YWMzNGIzNzQ0MGQ3OGRkMTFlM2Y0ZTJiOWU3ZCJ9","1,2","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N"],
						memo: ["加密后的字符串","播放记录ID","tokenId"],
						reponse : [
						]
					},
					{
						interName: "打赏",
						url: "api/xcx/xcxOrder/askPay",
						method :"GET",
						paramName: ["paramsJson","price","albumId","orderType","type","tokenId"],
						paramValue: ["eyJwcmljZSI6IjEyMDAwIiwiYWxidW1JZCI6IjEwMDIiLCJvcmRlclR5cGUiOiIyIiwidHlwZSI6IjAiLCJ0b2tlbklkIjoieWh0aWRlZWE0YWMzNGIzNzQ0MGQ3OGRkMTFlM2Y0ZTJiOWU3ZCJ9","12000","1002","2","0","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N","N","N","N"],
						memo: ["加密后的字符串","价格","专辑ID","订单类型，这里取2( 0自购 1赠送 2打赏 ) ","卡大类型( 0无1专辑卡2用户平台卡 )","tokenId"],
						reponse : [
								    {field : ["paySign-appId","String","小程序ID"]},
								    {field : ["paySign-timeStamp","String","签名所用的时间戳"]},
								    {field : ["paySign-nonceStr","String","随机字符串"]},
								    {field : ["paySign-package","String","数据包"]},
								    {field : ["paySign-signType","String","签名方式"]},
								    {field : ["paySign-paySign","String","签名"]},
								    {field : ["orderFlowId-orderFlowId","String","本地订单流水号"]}
						]
						
					},
					{
						interName: "购买平台会员卡",
						url: "api/xcx/xcxOrder/askPay",
						method :"GET",
						paramName: ["paramsJson","price","cardId","cardType","isContinue","orderType","type","tokenId"],
						paramValue: ["eyJwcmljZSI6IjEzMDAwIiwiY2FyZElkIjoiMTAwMCIsImNhcmRUeXBlIjoiMSIsImlzQ29udGludWUiOiIwIiwib3JkZXJUeXBlIjoiMCIsInR5cGUiOiIyIiwidG9rZW5JZCI6InlodGlkZWVhNGFjMzRiMzc0NDBkNzhkZDExZTNmNGUyYjllN2QifQ==","13000","1000","1","0","0","2","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N","N","N","N","N","N"],
						memo: ["加密后的字符串","价格","卡ID","卡小类型(类型1，2，3)","是否连续包月（0 否 1 是）","订单类型，这里取0( 0自购 1赠送 2打赏 ) ","卡大类型( 0无1专辑卡2用户平台卡 )","tokenId"],
						reponse : [
						           {field : ["paySign-appId","String","小程序ID"]},
						           {field : ["paySign-timeStamp","String","签名所用的时间戳"]},
						           {field : ["paySign-nonceStr","String","随机字符串"]},
						           {field : ["paySign-package","String","数据包"]},
						           {field : ["paySign-signType","String","签名方式"]},
						           {field : ["paySign-paySign","String","签名"]},
						           {field : ["orderFlowId-orderFlowId","String","本地订单流水号"]}
						           ]
					},
					{
						interName: "购买专辑卡，自购",
						url: "api/xcx/xcxOrder/askPay",
						method :"GET",
						paramName: ["paramsJson","albumId","price","cardId","cardType","isContinue","orderType","type","tokenId"],
						paramValue: ["eyJhbGJ1bUlkIjoiMTAwMiIsInByaWNlIjoiMTMwMDAiLCJjYXJkSWQiOiIxMDAwIiwiY2FyZFR5cGUiOiIxIiwiaXNDb250aW51ZSI6IjAiLCJvcmRlclR5cGUiOiIwIiwidHlwZSI6IjEiLCJ0b2tlbklkIjoieWh0aWRlZWE0YWMzNGIzNzQ0MGQ3OGRkMTFlM2Y0ZTJiOWU3ZCJ9","1002","13000","1000","1","0","0","1","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N","N","N","N","N","N","N"],
						memo: ["加密后的字符串","专辑ID","price","卡ID","卡小类型(类型1，2，3)","是否连续包月（0 否 1 是）","订单类型，这里取0( 0自购 1赠送 2打赏 ) ","卡大类型( 0无1专辑卡2用户平台卡 )","tokenId"],
						reponse : [
								    {field : ["paySign-appId","String","小程序ID"]},
								    {field : ["paySign-timeStamp","String","签名所用的时间戳"]},
								    {field : ["paySign-nonceStr","String","随机字符串"]},
								    {field : ["paySign-package","String","数据包"]},
								    {field : ["paySign-signType","String","签名方式"]},
								    {field : ["paySign-paySign","String","签名"]},
								    {field : ["orderFlowId-orderFlowId","String","本地订单流水号"]}
						]
						
					},
					{
						interName: "购买专辑卡，赠送",
						url: "api/xcx/xcxOrder/askPay",
						method :"GET",
						paramName: ["paramsJson","albumId","price","cardId","cardType","isContinue","orderType","type","tokenId"],
						paramValue: ["eyJhbGJ1bUlkIjoiMTAwMiIsInByaWNlIjoiMTMwMDAiLCJjYXJkSWQiOiIxMDAwIiwiY2FyZFR5cGUiOiIxIiwiaXNDb250aW51ZSI6IjAiLCJvcmRlclR5cGUiOiIxIiwidHlwZSI6IjEiLCJ0b2tlbklkIjoieWh0aWRlZWE0YWMzNGIzNzQ0MGQ3OGRkMTFlM2Y0ZTJiOWU3ZCJ9","1002","13000","1000","1","0","1","1","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N","N","N","N","N","N","N"],
						memo: ["加密后的字符串","专辑ID","price","卡ID","卡小类型(类型1，2，3)","是否连续包月（0 否 1 是）","订单类型，这里取1( 0自购 1赠送 2打赏 ) ","卡大类型( 0无1专辑卡2用户平台卡 )","tokenId"],
						reponse : [
						           {field : ["paySign-appId","String","小程序ID"]},
						           {field : ["paySign-timeStamp","String","签名所用的时间戳"]},
						           {field : ["paySign-nonceStr","String","随机字符串"]},
						           {field : ["paySign-package","String","数据包"]},
						           {field : ["paySign-signType","String","签名方式"]},
						           {field : ["paySign-paySign","String","签名"]},
						           {field : ["orderFlowId-orderFlowId","String","本地订单流水号"]}
						           ]
					
					},
					{
						interName: "更改订单目标用户ID",
						url: "api/xcx/xcxOrder/setGoalUser",
						method :"GET",
						paramName: ["paramsJson","orderFlowId","tokenId"],
						paramValue: ["eyJvcmRlckZsb3dJZCI6IjE1MDk3NjMzNzU0Mzc2NDQ1MzciLCJ0b2tlbklkIjoieWh0aWRlZWE0YWMzNGIzNzQ0MGQ3OGRkMTFlM2Y0ZTJiOWU3ZCJ9","1509763375437644537","yhtideea4ac34b37440d78dd11e3f4e2b9e7d"],
						required: ["Y","N","N"],
						memo: ["加密后的字符串","本地支付订单号","tokenId"],
						reponse : [
						           ]
					},
					{
						interName: "忽略————支付结果查询",
						url: "api/xcx/xcxOrder/orderQuery",
						method :"POST",
						paramName: ["paramsJson","orderFlowId","tokenId"],
						paramValue: ["eyJvcmRlckZsb3dJZCI6IjE1MDg0OTEyOTE3OTQ3ODgzMTIiLCJ0b2tlbklkIjoieWh0aWQ1YTg0ZmZjNzc2OWE0MmE4OWRhY2E0MmFhNWU1NTJlMSJ9","1508491291794788312","yhtid5a84ffc7769a42a89daca42aa5e552e1"],
						required: ["Y","N","N"],
						memo: ["加密后的字符串","订单流水号","tokenId"],
						reponse : [
						           {field : ["result_code","String","支付结果。SUCCESS支付成功NOPAY未支付USERPAYING支付中PAYERROR支付失败"]}      
						]
						
					}
				]
			}];
//jiekouProp[0].modulesInter = [];