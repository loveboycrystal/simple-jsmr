function select(parm, _url,_function) {
	var _o="";
	if (parm!=null) {
		_o={paramsJson: BASE64.encoder(JSON.stringify(parm))}
	}
	if(parm!=""  && typeof(parm)!="undefined"){
		
//		console.info(parm)
	}
	$.ajax({
		type: "get",
		url: _url+"?r="+Math.random(),
		async: false,
		data: _o,
		success: function(data) {
			_function(data);
		}
	});
}

var parm = {
				pageParamVo: {
					pageNum: 1,
					pageSize: 10
				}
			};


function init(){
	parm = {
			pageParamVo: {
				pageNum: 1,
				pageSize: 10
			}
		};
}

