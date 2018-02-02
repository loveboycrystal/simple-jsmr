//HTML前端通用共有变量 
var Const = {
	SUCCESS : 1,  //处理成功
	FAILED  : 0  //处理失败
}

//项目配置
var Config = {
	appName:'jsm',
	port : 8080,
	ip : "localhost",
	basePath : function (){
		return "http://"+this.ip+":"+this.port+"/"+this.appName+"/"
	}
}
