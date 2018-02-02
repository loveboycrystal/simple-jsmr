var　 xuzhaojie = [{
				modulesName: "用户相关by-徐兆杰",
				modulesInter: [
					{
						interName: "用户自定义分类",
						url: "api/yh/app/selectSelectCategory",
						method :"GET",
						paramName: ["paramsJson","menuId","tokenId"],
						paramValue: ["eyJtZW51SWQiOjEwMDJ9=","1002","sdfdfd10"],
						required: ["Y","Y","N"],
							memo: ["加密后的字符串","菜单id","tokenId"],
						reponse : [
							{field : ["id","Long","分类id"]},
							{field : ["name","String","分类名称"]}
						]
					},{
						interName: "根据分类型菜单筛选分类和专辑",
						url: "api/yh/app/selectMain",
						method :"GET",
						paramName: ["paramsJson","navCode","tokenId"],
						paramValue: ["eyJuYXZDb2RlIjoiaG9tZSIsInRva2VuSWQiOiJzbHNsZGtkZGRkIn0=","home","slsldkdddd"],
						required: ["Y","Y","N",],
							memo: ["加密后的字符串","菜单标识码","tokenId"],
						reponse : [
							{field : ["audioCount","Long","当前专辑含义音频数"]},
							{field : ["authorId","Long","作者id"]},
							{field : ["author","String","作者名称"]},
							{field : ["categoryId","Long","分类id（app无用）"]},
							{field : ["disPrice","Long","专辑会员购买价 （扩大1000倍）"]},
							{field : ["episodes","int","总集数"]},
							{field : ["freeListenTimes","int","免听需要分享次数"]},
							{field : ["gradeCodes","String","学段字符串"]},
							{field : ["id","Long","专辑id"]},
							{field : ["imageUrl","String","封面url"]},
							{field : ["info","String","专辑介绍"]},
							{field : ["name","String","专辑名称"]},
							{field : ["outline","String","专辑概要"]},
							{field : ["playCount","Long","专辑总播放量"]},
							{field : ["pubdate","Date","发布时间"]},
							{field : ["publishingId","Long","出版社id"]},
							{field : ["publishing","String","出版社名称"]},
							{field : ["readerId","Long","朗读者id"]},
							{field : ["reader","String","朗读者id"]},
							{field : ["shareBuyPrice","Long","增值专辑使用，分享购买佣金价格，特定账号有权限（扩大1000倍）"]},
							{field : ["subjectCodes","学科id字符串","学科id字符串"]},
							{field : ["subscribe","Long","订阅数"]},
							{field : ["thumbs","Long","点赞数"]}
						]
					},{
						interName: "发送登录验证短信",
						url: "api/yh/user/sendMsgCode",
						method :"GET",
						paramName: ["paramsJson","account"],
						paramValue: ["eyJhY2NvdW50IjoiMTUwODgxMzI0MjEifQ==","15088132421"],
						required: ["Y","Y"],
							memo: ["加密后的字符串","手机号"],
						reponse : [
							{field : ["reqId","String","请求id"]}
						]
					},{// 当用account登录时，必要要传code,reqId,即短信验证码,其他只需要传其中一个
						interName: "用户登录   (当用account登录时，必要要传code,reqId,即短信验证码和发送验证码带回来的reqId，其他只需要传其中一个)",
						url: "api/yh/user/loginUser",
						method :"GET",
						paramName: ["paramsJson","account","code","reqId","wxId","wbId","qqId","userInfo.nickname","userInfo.gender","userInfo.headImage"],
						paramValue: ["eyJhY2NvdW50IjoiMTUwODgxMzI0MjEiLCJjb2RlIjoiMTIzNCIsInJlcUlkIjoiZmRzYWQiLCJ1c2VySW5mbyI6eyJuaWNrbmFtZSI6ImtpZGRpZSIsImdlbmRlciI6Im1hbiIsImhlYWRJbWFnZSI6Imh0dHA6Ly9iYWlkdS5jb20vaWNvbi5qcGcifX0=","15088132422","1234","sfdasdggg","wxId","wbId","qqId","kiddie","man","http://baidu.com/icon.jpg"],
						required: ["Y","Y","Y","Y","Y","Y","Y","Y","Y","Y"],
							memo: ["加密后的字符串","手机号","验证码","发送验证码带回来的reqId","微信id","微博id","QQId","用户名","用户性别","用户头像"],
						reponse : [
							{field : ["tokenId","String","token密钥"]}
						]
					},{
						interName: "刷新token信息",
						url: "api/yh/user/refreshToken",
						method :"GET",
						paramName: ["paramsJson","tokenId"],
						paramValue: ["eyJ0b2tlbklkIjoiMTUwODgxMzI0MjIifQ==","fdsadgfadg"],
						required: ["Y","Y"],
							memo: ["加密后的字符串","tokenId"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "获取登录用户信息",
						url: "api/yh/user/selectUserInfoById",
						method :"GET",
						paramName: ["paramsJson","tokenId"],
						paramValue: ["eyJ0b2tlbklkIjoiMTUwODgxMzI0MjIifQ==","fdsadgfadg"],
						required: ["Y","Y"],
							memo: ["加密后的字符串","tokenId"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "用户登录注销",
						url: "api/yh/user/loginUser",
						method :"GET",
						paramName: ["paramsJson","tokenId"],
						paramValue:["eyJ0b2tlbklkIjoiMTUwODgxMzI0MjIifQ==","fdsadgfadg"],
						required: ["Y","Y"],
						memo: ["加密后的字符串","tokenId"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{// 0为1级，1为2级
						interName: "根据筛选所有分类信息",
						url: "api/yh/app/selectAllCategory",
						method :"GET",
						paramName: ["paramsJson"],
						paramValue: ["eyJwYWdlUGFyYW1WbyI6eyJwYWdlTnVtIjMH0="],
						required: ["Y"],
							memo: ["加密后的字符串"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{// 0为1级分类
						interName: "根据父类id筛选子分类信息",
						url: "api/yh/category/selectCategoryByParentId",
						method :"GET",
						paramName: ["paramsJson","parentId"],
						paramValue: ["eyJwYWdlUGFyYW1WbyI6eyJwYWdlTnVtIjoxLCJwYWdlU2l6ZSI6MTB9LCJwYXJlbnRJZCI6MH0=","0"],
						required: ["Y","Y"],
							memo: ["加密后的字符串","父类id"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{// userCategories
						// 为数据[{"categoryId":1002,"sort":1},{"categoryId":1003,"sort":2}]
						interName: "保存用户与分类关系",
						url: "api/yh/category/saveUserAndCategory",
						method :"GET",
						paramName: ["paramsJson","tokenId","menuId","userCategories"],
						paramValue: ["eyJ0b2tlbklkIjoiZGRkIiwibWVudUlkIjoxMDAyLHVzZXJDYXRlZ29yaWVzOlt7ImNhdGVnb3J5SWQiOjEwMDIsInNvcnQiOjF9LHsiY2F0ZWdvcnlJZCI6MTAwMywic29ydCI6Mn1dfQ==","ddd0","1002","[{\"categoryId\":1002,\"sort\":1},{\"categoryId\":1003,\"sort\":2}]"],
						required: ["Y","Y","Y","Y"],
							memo: ["加密后的字符串","tokenid","菜单id","用户关系分类数组"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "上传用户头像",
						url: "api/yh/user/uploadHeadImage",
						method :"GET",
						paramName: ["paramsJson","tokenId","file"],
						paramValue: ["u0562UIn0=","ddd0","文件流"],
						required: ["Y","Y","Y"],
							memo: ["加密后的字符串","tokenid","文件"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "保存用户资料",
						url: "api/yh/user/saveUserInfo",
						method :"GET",
						paramName: ["paramsJson","tokenId","headImage","nickname","gender","birthday","cityId","memo"],
						paramValue: ["eyJ0b2tlbklkIjoieWh0aWRlMWRiNDIzOGRmYTU0MTk0YmIxZDdkMzA4NzI4MTgzOCIsImhlYWRJbWFnZSI6Imljb24uanBnIiwibmlja25hbWUiOiLlvpDmnpdLaWRkaWUiLCJnZW5kZXIiOiLnlLciLCJiaXJ0aGRheSI6IjE5NzEtMDYtMjEiLCJjaXR5SWQiOiLlub/lt54iLCJtZW1vIjoi5oiR5Y+r5ru0562U5ru0562U5ru0562U5ru0562U5ru0562U5ru0562U5ru0562U5ru0562U5ru0562U5ru0562U5ru0562UIn0=","ddd0","http://www.baidu.com/icon.jpg","徐林Kiddie","男","1997-06-21","广州","我的简介"],
						required: ["Y","Y","Y","Y","Y","Y","Y","Y"],
							memo: ["加密后的字符串","tokenid","头像","昵称","性别","生日","地区","简介"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "根据用户id获取他的baby信息",
						url: "api/yh/baby/selectBabyInfoByUserInfoId",
						method :"GET",
						paramName: ["paramsJson","tokenId"],
						paramValue: ["eyJ0b2tlbklkIjoieWh0aWRlMWRiNDIzOGRmYTU0MTk0YmIxZDdkMzA4NzI4MTgzOCJ9","ddd0"],
						required: ["Y","Y"],
							memo: ["加密后的字符串","tokenid"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "根据baby的id获取baby信息",
						url: "api/yh/baby/selectBabyInfoByIdAndUserId",
						method :"GET",
						paramName: ["paramsJson","tokenId","id"],
						paramValue: ["edddddd","ddd0","id"],
						required: ["Y","Y","Y"],
							memo: ["加密后的字符串","tokenid","baby的id"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "保存baby资料",
						url: "api/yh/baby/saveBabyInfo",
						method :"GET",
						paramName: ["paramsJson","tokenId","id","nickname","babyHeadUrl","gender","relation","grade","school"],
						paramValue: ["eyJ0b2tlbklkIjoieWh0aWRlMWRiNDIzOGRmYTU0MTk0YmIxZDdkMzA4NzI4MTgzOCIsImJhYnlIZWFkVXJsIjoiaWNvbi5qcGciLCJuaWNrbmFtZSI6IuW+kOael0tpZGRpZSIsImdlbmRlciI6IjEiLCJncmFkZSI6Miwic2Nob29sIjoi5aSp5rKz5bCP5a2mIn0=","ddd0","123","徐林baby","http://dd.sdf.jpg","男",1,2,"天河小学"],
						required: ["Y","Y","Y","Y","Y","Y","Y","Y","Y"],
							memo: ["加密后的字符串","tokenid","id","昵称","头像","性别","关系","年级","学校"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "删除baby资料",
						url: "api/yh/baby/deleteBabyInfoById",
						method :"GET",
						paramName: ["paramsJson","tokenId","id"],
						paramValue: ["edddddd","ddd0","123"],
						required: ["Y","Y","Y"],
							memo: ["加密后的字符串","tokenid","id"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "搜索好友",
						url: "api/yh/user/selectUserInfoByWord",
						method :"GET",
						paramName: ["paramsJson","word","pageParamVo.pageNum","pageParamVo.pageSize"],
						paramValue: ["edddddd","ddd0","1","10"],
						required: ["Y","Y","Y","Y"],
							memo: ["加密后的字符串","搜索关键词","页码","页面大小"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "添加好友",
						url: "api/yh/friend/addFriend",
						method :"GET",
						paramName: ["paramsJson","tokenId","toFriendId"],
						paramValue: ["edddddd","ddd0","1002"],
						required: ["Y","Y","Y"],
							memo: ["加密后的字符串","tokenId","好友id"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "同意好友",
						url: "api/yh/friend/agreeFriend",
						method :"GET",
						paramName: ["paramsJson","tokenId","toFriendId"],
						paramValue: ["edddddd","ddd0","1002"],
						required: ["Y","Y","Y"],
							memo: ["加密后的字符串","tokenId","好友id"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "删除好友",
						url: "api/yh/friend/deleteFriend",
						method :"GET",
						paramName: ["paramsJson","tokenId","toFriendId"],
						paramValue: ["eyJ0b2tlbklkIjoieWh0aWQ0OWU3MThmZmY2MTI0ZjNjOWFjNDYwZDMwYmEyZjg1YiJ9","ddd0","1002"],
						required: ["Y","Y","Y"],
							memo: ["加密后的字符串","tokenId","好友id"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					}
					,{
						interName: "获取好友",
						url: "api/yh/friend/selectFriendWhoIsFriend",
						method :"GET",
						paramName: ["paramsJson","tokenId"],
						paramValue: ["eyJ0b2tlbklkIjoieWh0aWQ0OWU3MThmZmY2MTI0ZjNjOWFjNDYwZDMwYmEyZjg1YiJ9","ddd0"],
						required: ["Y","Y"],
							memo: ["加密后的字符串","tokenId"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					}
					,{
						interName: "获取待好友",
						url: "api/yh/friend/selectFriendWhoWaitAgree",
						method :"GET",
						paramName: ["paramsJson","tokenId"],
						paramValue: ["eyJ0b2tlbklkIjoieWh0aWQ0OWU3MThmZmY2MTI0ZjNjOWFjNDYwZDMwYmEyZjg1YiJ9","ddd0"],
						required: ["Y","Y"],
							memo: ["加密后的字符串","tokenId"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "获取榜单",
						url: "api/yh/top/selectTopsAndAlbums",
						method :"GET",
						paramName: ["paramsJson"],
						paramValue: ["edddddd"],
						required: ["N"],
							memo: ["加密后的字符串"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					},{
						interName: "获取榜单下更多的专辑",
						url: "api/yh/top/selectTopAlbumsByTopId",
						method :"GET",
						paramName: ["paramsJson","topCode","pageParamVo.pageNum","pageParamVo.pageSize"],
						paramValue: ["eyJwYWdlUGFyYW1WbyI6eyJwYWdlTnVtIjoxLCJwYWdlU2l6ZSI6MTB9LCJpZCI6MTAwMB99","1000",1,10],
						required: ["Y","Y","Y","Y"],
							memo: ["加密后的字符串","榜单topCode","页码","页面大小"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					}
					,{
						interName: "获取榜单下的随机推荐专辑",
						url: "api/yh/top/selectRecommendTops",
						method :"GET",
						paramName: ["paramsJson","tokenId","grade","count"],
						paramValue: ["eyJncmFkZSI6MSwiY291bnQiOjEwfQ==","dddddd",1,10],
						required: ["Y","N","N","N"],
						memo: ["加密后的字符串","tokenId","年级","数量"],
						reponse : [
						           {field : ["address","String","用户地址"]},
						           {field : ["createTime","String","用户创建时间"]},
						           {field : ["id","Long","用户编号"]},
						           {field : ["phone","String","用户手机号码"]}
						           ]
					},{
						interName: "上传通讯录 (没有tokenId可不传)",
						url: "api/yh/biguser/uploadBigUser",
						method :"GET",
						paramName: ["paramsJson","tokenId","bigUsers"],
						paramValue: ["eyJ0b2tlbklkIjoieWh0aWQ0OWU3MThmZmY2MTI0ZjNjOWFjNDYwZDMwYmEyZjg1YiIsImJpZ1VzZXJzIjpbeyJuaWNrbmFtZSI6ImtpZGRpZSIsInBob25lIjoiMTM2NjIxMjMyMTIifSx7Im5pY2tuYW1lIjoiSmFjayIsInBob25lIjoiMTM2NjIxMjMzMTIifV19","ddd0","dddd"],
						required: ["Y","Y","Y"],
							memo: ["加密后的字符串","tokenId","通讯录数组"],
						reponse : [
							{field : ["address","String","用户地址"]},
							{field : ["createTime","String","用户创建时间"]},
							{field : ["id","Long","用户编号"]},
							{field : ["phone","String","用户手机号码"]}
						]
					}
				]
			}];
// jiekouProp[0].modulesInter = [];
