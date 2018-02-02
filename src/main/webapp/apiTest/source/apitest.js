//接口所在地址
var ipath = "http://" + window.location.host + "/ww_xcx/";
$(document).ready(function() {
	//在窗口左侧添加链接导航
	setNavPostion();
	$(window).resize(function() {
		setNavPostion();
	});

	function setNavPostion() {
		$("#interFaceList").addClass("navDiv");
		var divLeft = ($(document).width() - 1050) / 2;
		var divWidth = $("#interFaceList").width();
		var p;
		if(divLeft < divWidth) {
			p = [0, 0];
		} else {
			p = [(divLeft - divWidth) / 2, 0];
		}
		$("#interFaceList").css({
			"position": "absolute",
			"top": "40px",
			"left": 20 + "px"
			//"left": p[0] + "px"
		});
		$(".box").css({
			"position": "absolute",
			"top": "30px",
			"left": ($("#interFaceList").width() + 50 )+"px"
			//"left": p[0] + "px"
		});
		// w1050
		if($("#interFaceList .CodeContainqweer").length <= 0) {
			var navHtml = "";
			console.info( allApi)
			for(var m = 0; m < allApi.length; m++) {
				var jiekouProp = allApi[m];
				//console.info(allApi)
				
					 // code to try				
					for(var i = 0; i < jiekouProp.length; i++) {
						var modulesName = jiekouProp[i].modulesName;
						navHtml += "<pre class=\"CodeContainqweer\">";
						navHtml += "<span  style=\"margin-left:8px;font-size:16px;font-weight:bold; height: 30px;line-height: 30px\"><img style=\"width:16px\"  onclick=\"ExpImgClicked(this)\" src=\"images/dk.png\" >" + modulesName + "</span><span class=\"collapsible\" style=\"display: inline;\">";
						for(var j = 0; j < jiekouProp[i].modulesInter.length; j++) {
							var prop = jiekouProp[i].modulesInter[j];
							var pUrl = prop.url;
							var pParamNames = prop.paramName;
							var pParamValues = prop.paramValue;
							var interName = prop.interName;
							//传入接口配置在allApi的坐标 who:谁的接口 i:模块坐标 j:接口坐标，
							navHtml += "<br/> <span title=\""+interName+"\" style=\"margin-left:32px;font-size:14px;height: 24px;line-height: 24px\" id=\"nav" + m + i + j + "\"><a href=\"#\" who=\""+m+"\" mi=\"" + i + "\" ii=\"" + j + "\" intera=\"true\">" + (j + 1) + "." + interName + "</a></span>";
						}
						navHtml += "</span>";
						navHtml += "</pre>";
					}
				
			 }
			$("#interFaceList").html(navHtml);
		}

	};
	$("[intera=true]").on("click", function() {
		showApi($(this).attr("mi"), $(this).attr("ii"),$(this).attr("who"));
	});

	function showApi(modulesIndex, interIndex,who) {
		$("[id^=nav]").removeClass("navSelected");
		$("#nav" + who + modulesIndex + interIndex).addClass("navSelected");
		$("#RawJson").val("");
		Process();
		var jiekouProp = allApi[who];
		var curModules = jiekouProp[modulesIndex];
		var curInterFace = curModules.modulesInter[interIndex];
		$("#submitType").val(curInterFace.method);
		$("#curPath").html("( " + curModules.modulesName + "->" + curInterFace.interName + " )");
  //debugger;
		//接口参数赋值
		$("#btnUrl").val(ipath + curInterFace.url);
		var fields = curInterFace.paramName;
		var fieldValues = curInterFace.paramValue;
		var required = curInterFace.required;
		var memo = curInterFace.memo;
		if(fields.length != fieldValues.length || fieldValues.length != required.length || memo.length != required.length) {
			alert("接口参数名称、参数值、是否必填、备注数量要一致.");
			return;
		}
		$("#paramTable tr").each(function(i, n) {
			if(i != 0) {
				$(this).remove();
			}
		});
		for(var i = 0; i < fields.length; i++) {
			addParamRow(fields[i], fieldValues[i], required[i], memo[i])
		}
		var respTables = "<table id='restableCss'>";
		respTables += "<caption>data.list 响应字段说明<br></caption>";
		respTables += "<tr>";
		respTables += "<th>序号</th>";
		respTables += "<th>字段名称</th>";
		respTables += "<th>类型</th>";
		respTables += "<th>说明</th>";
		respTables += "</tr>";
		
		for (i = 0; i < curInterFace.reponse.length; i++) {
			console.info(curInterFace.reponse[i])
			var fieldArr = curInterFace.reponse[i].field;
			respTables += "<tr>";
			respTables += "<td>"+(i+1)+"</td>";
			respTables += "<td>"+fieldArr[0]+"</td>";
			respTables += "<td>"+fieldArr[1]+"</td>";
			respTables += "<td>"+fieldArr[2]+"</td>";
			respTables += "</tr>";
		}
			respTables += "<tr>";
			respTables += "<td colspan='4'>其他说明：</td>";
			respTables += "<td>";
			respTables += "</tr>";
			
			respTables += "<tr>";
			respTables += "<td>**</td>";
			respTables += "<td>data.list</td>";
			respTables += "<td>Array</td>";
			respTables += "<td>返回数据集合</td>";
			respTables += "</tr>";
			
			respTables += "<tr>";
			respTables += "<td>**</td>";
			respTables += "<td>reqId</td>";
			respTables += "<td>String</td>";
			respTables += "<td>请求编号</td>";
			respTables += "</tr>";
			
			respTables += "<tr>";
			respTables += "<td>**</td>";
			respTables += "<td>resCode</td>";
			respTables += "<td>String</td>";
			respTables += "<td>请求响应编码( 1 :成功， 0 和其他编码为失败)</td>";
			respTables += "</tr>";
		respTables += "</table>";
		$("#responseMemo").html(respTables);
		var paramValueImput = $("[name=paramsJson]").parent().parent().find("td").eq(1).find("input").eq(0);
		paramValueImput.css({
			width: "500px"
		});
		
		$("#decoderTa").val(paramValueImput.val());
		 myDecoder();
	}
});

var IMG_PATH = "http://r.phpddt.com/resources/img";
var paramRowIndex = 1;

function testApi() {
	var url = $("#btnUrl").val();
	var param = $("#paramTable input[type=text]");
	var urlParam = "";
	var _data = {};
	var jsonUrlParam = "";
	$("#paramTable tr").each(function(i, n) {
		var tempParamSet = $(n);
		var pst = tempParamSet.find("input[type=text]");
		if(tempParamSet.find("input[type=checkbox]:checked").eq(0).val() != 1 || pst.eq(0).val() == "" || pst.eq(1).val() == "") {
			//continue;
		} else {
			_data[pst.eq(0).val()] = pst.eq(1).val();
			if(urlParam == "" ) {
				urlParam += pst.eq(0).val() + "=" + pst.eq(1).val();
				//jsonUrlParam += "\""+pst.eq(0).val() + "\":\"" + pst.eq(1).val()+"\";
			} else {
				urlParam += "&" + pst.eq(0).val() + "=" + pst.eq(1).val();
				//jsonUrlParam += "&" + pst.eq(0).val() + "=" + pst.eq(1).val();
			}

		}

	});
	if(url == "") {
		alert("请输入URL");
		return;
	}
	$("#btnSend").val("请求中..").css({
		"background-color": "gray",
		"cursor": "wait"
	});
	//alert(urlParam)
	//alert($("#submitType").val());
	$.ajax({
		url: url + "?"+ urlParam,
		//data:_data,
		type: $("#submitType").val(),
		success: function(data) {
			//if(data.indexOf("请重新登录！") > 0) {
				//$("#loginMsg").show();
			//}
			$("#RawJson").val(JSON.stringify(data));
			setTimeout(function() {
				$("#btnSend").val("发送").css({
					"background-color": "#007BCC",
					"cursor": "pointer"
				});
				Process();
				location.hash = "ControlsRow"
			}, 100);
		}
	});
}

function addParamRow(paramName, paramValue, required, memo) {
	if(typeof(paramName) == "undefined") {
		paramName = "";
		paramValue = "";
		memo = "";
	}
	var trId = "param" + paramRowIndex;
	var rowHtml = "<tr id=\"" + trId + "\">";
	rowHtml += "<td>";
	var tempReadonly = "";
	if(required == "Y") {
		rowHtml += "<input type=\"checkbox\" style=\"margin-right:10px\"  value=\"1\"  checked=true title=\"不勾选为屏蔽此参数\" disabled/>";
		tempReadonly = "readonly=\"readonly\" disabled";
	} else {
		rowHtml += "<input type=\"checkbox\" style=\"margin-right:10px\"  value=\"1\" checked=true title=\"不勾选为屏蔽此参数\"/>";
	}
	rowHtml += "<input type=\"text\" style=\"height: 26px; width: 300px;\" " + tempReadonly + " name=\""+paramName+"\"   value=\"" + paramName + "\"/>";
	rowHtml += "</td>";
	rowHtml += "<td>";
	rowHtml += "<input type=\"text\" style=\"height: 26px; width: 200px;\" value=\"" + paramValue + "\"/>";
	if(required != "Y") {
		rowHtml += "<input type=\"Button\" value=\"X\" trId=\"" + trId + "\"  onclick=\"delParamRow('" + trId + "')\" style=\"margin-left: 10px; background: gray; cursor: pointer; color: white; font-weight: bold; padding: 1px; border: 1px solid #cccccc; border-radius: 18px;\">";
	}
	if(memo != "") {
		rowHtml += "<font color=\"gray\" style=\"margin-left:4px\" area=\"tips\">&nbsp;&nbsp;(" + memo + ")</font>";
	}
	rowHtml += "</td>";
	rowHtml += "</tr>";
	$("#paramTable").append(rowHtml);
	paramRowIndex++;
}

function delParamRow(trId) {
	$("#" + trId).remove();
}

function goLogin() {
	var interPath = $("#btnUrl").val();
	interPath = interPath.substring(0, interPath.indexOf("ucp/") + 4);
	window.open(interPath);
	$("#loginMsg").hide();
}

//加密
function myDecoder(){
		var tmDeStr = $("#decoderTa");
	var tmEnStr = $("#encoderTa");
	tmEnStr.val(BASE64.decoder(tmDeStr.val()));
}

//解密
function myEncoder(){
	var tmDeStr = $("#decoderTa");

	var tmEnStr = $("#encoderTa");
		console.info(tmEnStr.val())
	tmDeStr.val(BASE64.encoder(tmEnStr.val()));

}