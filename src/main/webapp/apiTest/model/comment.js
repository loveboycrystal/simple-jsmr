data = {
	interName: "添加评论",
	url: "/comments/addcomment.htm",
	paramName: ["openId","princial_id","remark","sh_check"],
	paramValue: ["sdfsd23","12132","评论内容",""],
	required: ["N","N","N","N"],
	memo: ["微信用户id","视频id","评论内容","分享标识"]
};


jiekouProp[0].modulesInter[jiekouProp[0].modulesInter.length] = data;

data = {
	interName: "根据视频id获取评论",
	url: "/comments/getlist.htm",
	paramName: ["videoId"],
	paramValue: ["12287"],
	required: ["N"],
	memo: ["视频id"]
};
jiekouProp[0].modulesInter[jiekouProp[0].modulesInter.length] = data;