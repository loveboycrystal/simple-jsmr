var　 lishengte = [{
				modulesName: "专辑相关-by李胜特",
				modulesInter: [
					{  //{"pageParamVo":{"pageNum":1,"pageSize":10},"name":"子"}
						interName: "通过作品id获取作品详情信息",
						url: "api/xcx/album/getAlbum/byId",
						method :"GET",
						paramName: ["paramsJson","id","tokenId","pageParamVo.pageNum", "pageParamVo.pageSize"],
						paramValue: ["eyJpZCI6IjEwMDgiLCJwYWdlUGFyYW1WbyI6eyJwYWdlTnVtIjoiMSIsInBhZ2VTaXplIjoiMTAifX0=",
									"1008",
									"yhtid49e718fff6124f3c9ac460d30ba2f85b",
									"0","10"
									],
						required: ["Y","Y","Y","Y","Y"],
						memo: ["加密后的字符串","专辑id","tokenId","分页数","页大小"],
						reponse : [
							{field : ["id","Long","作品id"]},
							{field : ["author","Long","作者id"]},
							{field : ["authorName","String","作者名称"]},
							{field : ["canPlay","Long","是否能播放（除前三个音频）"]},
							{field : ["cardId","Long","绑定的卡id"]},
							{field : ["dayDiscoun","Long","日卡优惠价"]},
							{field : ["dayPrice","Long","日卡原价"]},
							{field : ["monthDiscoun","Long","月卡优惠价"]},
							{field : ["monthPrice","Long","月卡原价"]},				
							{field : ["weekPrice","Long","周卡原价"]},
							{field : ["weekDiscoun","Long","周卡优惠价"]},
							{field : ["episode","Long","总集数"]},
							{field : ["imageUrl","String","图片1"]},
							{field : ["imageUrlM","String","图片2"]},
							{field : ["imageUrlX","String","图片3"]},
							{field : ["info","Long","作品介绍"]},
							{field : ["lastUpdateTime","Long","最后更新时间"]},
							{field : ["name","Long","名称"]},
							{field : ["playCount","Long","播放数"]},
							{field : ["type","Long","作品类型"]}
						]
				},{  //{"pageParamVo":{"pageNum":1,"pageSize":10},"name":"子"}
						interName: "根据作者id获取作品列表",
						url: "api/xcx/album/getAlbum/byAuthor",
						method :"GET",
						paramName: ["paramsJson","id","tokenId","pageParamVo.pageNum", "pageParamVo.pageSize"],
						paramValue: ["eyJpZCI6IjEiLCJwYWdlUGFyYW1WbyI6eyJwYWdlTnVtIjoiMSIsInBhZ2VTaXplIjoiMTAifX0=",
									"1",
									"yhtid49e718fff6124f3c9ac460d30ba2f85b",
									"0","10"
									],
						required: ["Y","Y","Y","Y","Y"],
						memo: ["加密后的字符串","作者id","tokenId","分页数","页大小"],
						reponse : [
							{field : ["id","Long","作品id"]},
							{field : ["author","Long","作者id"]},
							{field : ["authorName","String","作者名称"]},
							{field : ["canPlay","Long","是否能播放（除前三个音频）"]},
							{field : ["cardId","Long","绑定的卡id"]},
							{field : ["dayDiscoun","Long","作品id"]},
							{field : ["dayPrice","Long","作品id"]},
							{field : ["monthDiscoun","Long","作品id"]},
							{field : ["monthPrice","Long","作品id"]},				
							{field : ["weekPrice","Long","作品id"]},
							{field : ["weekDiscoun","Long","作品id"]},
							{field : ["episode","Long","总集数"]},
							{field : ["imageUrl","String","图片1"]},
							{field : ["imageUrlM","String","图片2"]},
							{field : ["imageUrlX","String","图片3"]},
							{field : ["info","Long","作品介绍"]},
							{field : ["lastUpdateTime","Long","最后更新时间"]},
							{field : ["name","Long","名称"]},
							{field : ["playCount","Long","播放数"]},
							{field : ["type","Long","作品类型"]}

						]
				},{//app 根据搜索条件获取专辑列表(分页)
						interName: "根据作品id获取音频列表",
						url: "api/xcx/audio/getAudio/byId",
						method :"GET",
						paramName: ["paramsJson","albumId","tokenId", "pageParamVo.pageNum", "pageParamVo.pageSize"],
						paramValue: ["eyJhbGJ1bUlkIjoiMTAwOCIsInBhZ2VQYXJhbVZvIjp7InBhZ2VOdW0iOiIxIiwicGFnZVNpemUiOiIxMCJ9fQ==","1","11","1","10"],
						required: ["Y","N","N","Y","Y"],
						memo: ["加密后的字符串","作品id","用户token", "分页索引", "分页大小"],
						reponse : [
							{field : ["albumId","Long","作品id"]},
							{field : ["albumName","Long","作品名称"]},
							{field : ["audioUrl","String","音频地址"]},
							{field : ["authorName","String","音频名称"]},
							{field : ["canPlay","boolean","是否能播放"]},
							{field : ["id","Long","id"]},
							{field : ["imageUrl","String","音频图片"]},
							{field : ["name","String","名称"]},
							{field : ["playCount","Long","播放数"]},
							{field : ["sort","Long","音频排序"]},
							{field : ["otherId","Long","当前专辑含义音频数"]}
						]
					
				},{  //{"pageParamVo":{"pageNum":1,"pageSize":10},"name":"子"}
						interName: "根据作品id获取卡信息",
						url: "api/xcx/card/getCardInfo/byAlbumId",
						method :"GET",
						paramName: ["paramsJson","albumId"],
						paramValue: ["eyJhbGJ1bUlkIjoiMTAwOCJ9","1008"],
						required: ["Y","Y"],
						memo: ["加密后的字符串","作品id"],
						reponse : [
							{field : ["dayDiscoun","Long","日卡优惠价"]},
							{field : ["dayPrice","Long","日卡原价"]},
							{field : ["monthDiscoun","Long","月卡优惠价"]},
							{field : ["monthPrice","Long","月卡原价"]},				
							{field : ["weekPrice","Long","周卡原价"]},
							{field : ["weekDiscoun","Long","周卡优惠价"]},
							{field : ["endTime","Long","优惠结束时间"]},
							{field : ["startTime","Long","优惠开始时间"]},
							{field : ["name","String","名称"]},
							{field : ["id","Long","id"]},
							{field : ["type","Long","卡类型"]}
						]
					},{  //{"pageParamVo":{"pageNum":1,"pageSize":10},"name":"子"}
						interName: "获取全平台用户卡信息",
						url: "api/xcx/card/getCardInfo/byCard",
						method :"GET",
						paramName: [],
						paramValue: [],
						required: [],
						memo: [],
						reponse : [
							{field : ["dayDiscoun","Long","日卡优惠价"]},
							{field : ["dayPrice","Long","日卡原价"]},
							{field : ["monthDiscoun","Long","月卡优惠价"]},
							{field : ["monthPrice","Long","月卡原价"]},				
							{field : ["weekPrice","Long","周卡原价"]},
							{field : ["weekDiscoun","Long","周卡优惠价"]},
							{field : ["endTime","Long","优惠结束时间"]},
							{field : ["startTime","Long","优惠开始时间"]},
							{field : ["name","String","名称"]},
							{field : ["id","Long","id"]},
							{field : ["type","Long","卡类型"]}
						]
					},{  //{"pageParamVo":{"pageNum":1,"pageSize":10},"name":"子"}
						interName: "根据卡id获取卡信息",
						url: "api/xcx/card/getCardInfo/byId",
						method :"GET",
						paramName: ["paramsJson","id"],
						paramValue: ["eyJpZCI6IjEwMDMifQ==","1003"],
						required: ["Y","Y"],
						memo: ["加密后的字符串","卡id"],
						reponse : [
							{field : ["dayDiscoun","Long","日卡优惠价"]},
							{field : ["dayPrice","Long","日卡原价"]},
							{field : ["monthDiscoun","Long","月卡优惠价"]},
							{field : ["monthPrice","Long","月卡原价"]},				
							{field : ["weekPrice","Long","周卡原价"]},
							{field : ["weekDiscoun","Long","周卡优惠价"]},
							{field : ["endTime","Long","优惠结束时间"]},
							{field : ["startTime","Long","优惠开始时间"]},
							{field : ["name","String","名称"]},
							{field : ["id","Long","id"]},
							{field : ["type","Long","卡类型"]}
						]
					},{  //{"pageParamVo":{"pageNum":1,"pageSize":10},"name":"子"}
						interName: "获取banner列表",
						url: "api/xcx/banner/getBannerList",
						method :"GET",
						paramName: ["paramsJson","pageParamVo.pageNum","pageParamVo.pageSize"],
						paramValue: ["eyJuYW1lIjoi5bCPIiwib3JkZXJUeXBlIjoiMSIsInBhZ2VQYXJhbVZvLnBhZ2VOdW0iOiIwIiwicGFnZVBhcmFtVm8ucGFnZVNpemUiOiIxMCIsInBhZ2VQYXJhbVZvIjp7InBhZ2VOdW0iOiIwIiwicGFnZVNpemUiOiIxMCJ9fQ==","0","10"],
						required: ["Y","Y","Y"],
						memo: ["加密后的字符串","页索引", "页大小"],
						reponse : [
							{field : ["imageUrl","String","图片地址"]},
							{field : ["name","String","名称"]},
							{field : ["pageParm","Long","预设参数"]},
							{field : ["sort","Long","排序"]},
							{field : ["type","Long","banner跳转类型"]},
							{field : ["startTime","Long","开始时间"]},
							{field : ["endTime","Long","结束时间"]},
						]
				}
				]
			}];
//jiekouProp[0].modulesInter = [];