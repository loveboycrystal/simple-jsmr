//富文本编辑器
 window.UEDITOR_CONFIG.toolbars=[[
			 'source', //源代码
             'anchor', //锚点
        'redo', //重做
        'bold', //加粗
        'indent', //首行缩进
        'italic', //斜体
        'underline', //下划线
        'strikethrough', //删除线
        'subscript', //下标
        'fontborder', //字符边框
        'superscript', //上标
        'blockquote', //引用
        'preview', //预览
        'horizontal', //分隔线
        'time', //时间
        'date', //日期
        'insertrow', //前插入行
        'insertcol', //前插入列
        'inserttitle', //插入标题
        'cleardoc', //清空文档
        'fontfamily', //字体
        'fontsize', //字号
        'paragraph', //段落格式
        'link', //超链接
        'emotion', //表情
        'spechars', //特殊字符
        'searchreplace', //查询替换
        'justifyleft', //居左对齐
        'justifyright', //居右对齐
        'justifycenter', //居中对齐
        'justifyjustify', //两端对齐
        'forecolor', //字体颜色
        'backcolor', //背景色
        'rowspacingtop', //段前距
        'rowspacingbottom', //段后距
        'imagenone', //默认
        'imageleft', //左浮动
        'imageright', //右浮动
        'imagecenter', //居中
        'lineheight', //行间距
        'customstyle', //自定义标题
        'autotypeset', //自动排版
        'touppercase', //字母大写
        'tolowercase', //字母小写
        'background', //背景
        'template', //模板
        ]]
		var ue = UE.getEditor('info',{
			maximumWords:2000
		});