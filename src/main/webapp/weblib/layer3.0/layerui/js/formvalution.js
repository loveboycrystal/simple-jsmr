//表单赋值
$.fn.setForm = function(jsonValue) {
					    var obj=this;  
					    $.each(jsonValue, function (name, ival) {  
					        var $oinput = obj.find("input[name=" + name + "]");
					        if ($oinput.attr("type")== "radio" || $oinput.attr("type")== "checkbox"){  
					             $oinput.each(function(){  
					                 if(Object.prototype.toString.apply(ival) == '[object Array]'){//是复选框，并且是数组  
					                      for(var i=0;i<ival.length;i++){  
					                          if($(this).val()==ival[i])  
					                             $(this).attr("checked", "checked");  
					                      }  
					                 }else{  
					                     if($(this).val()==ival)  
					                        $(this).attr("checked", "checked");  
					                 }  
					             });  
					        }else if($oinput.attr("type")== "textarea"){//多行文本框  
					            obj.find("[name="+name+"]").html(ival);  
					        }else{
					             obj.find("[name="+name+"]").val(ival);
					        }  
					   });  
					}
//获取url参数
function GetQueryString(name)
			{
			     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			     var r = window.location.search.substr(1).match(reg);
			     if(r!=null)return  unescape(r[2]); return null;
			}
//时间转换为时间戳			
function getStampTime(nS){
			if(nS==null)return " ";
			return Date.parse(new Date(nS));
}
//时间戳转换为时间			
function getLocalTime(nS) {  
				if(nS==null)return " ";
			    return new Date(parseInt(nS)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");      
			    }

function add0(m){return m<10?'0'+m:m }
function format(shijianchuo)
{
//shijianchuo是整数，否则要parseInt转换
var time = new Date(shijianchuo);
var y = time.getFullYear();
var m = time.getMonth()+1;
var d = time.getDate();
var h = time.getHours();
var mm = time.getMinutes();
var s = time.getSeconds();
return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
}
//下拉选项加载
function dynamicselect(selector,_url,_data,mecthod){
	var _o=null;
	if (_data) {
		_o={
			paramsJson: BASE64.encoder(JSON.stringify(_data))
		}
	}
	$.ajax({
		type:mecthod?mecthod:"get",
		url:_url,
		data:_o,
		async:false,
		success:function(data){
						
			var html='<option value=""></option>'
			if(data.data!=null){
				var result=data.data.list;
				for (var i=0;i<result.length;i++) {
					html+=	'<option value="'+result[i].selev+'">'+result[i].selek+'</option>'
				}
			}
			$(selector).html(html);
		}
	});
}
//错误处理
function erro(erro){
	layer.msg(erro)
}

//查看消息
function _check(data){
	layer.open({
		content:data
	})
}
//去掉所有的html标记  
 function delHtmlTag(str){  
  return str.replace(/<[^>]+>/g,"");
} 
