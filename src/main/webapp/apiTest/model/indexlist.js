var data = {
	interName: "获取列表页数据",
	url: "video/getlistbytype.htm",
	paramName: ["videoType"],
	paramValue: ["1"],
	required: ["N"],
	memo: ["分类:1.精品课程,2.幼小衔接,3.亲子互动"]
};

jiekouProp[0].modulesInter[jiekouProp[0].modulesInter.length] = data;

data = {
	interName: "获取列表页数据(分页)",
	url: "video/getVideLit.htm",
	paramName: ["videoType","pageIndex","pageSize","classify"],
	paramValue: ["1","1","10","103"],
	required: ["N","N","N","N"],
	memo: ["分类:1.精品课程,2.幼小衔接,3.亲子互动","当前页","页大小","栏目"]
};

jiekouProp[0].modulesInter[jiekouProp[0].modulesInter.length] = data;