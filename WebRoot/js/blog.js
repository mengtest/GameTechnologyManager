var toolbar = [ {
	text : '添加',
	iconCls : 'icon-add',
	handler : function() {
		window.location.href = "blog/toWrite";
	}
}, '-', {
	text : '删除',
	iconCls : 'icon-remove',
	handler : function() {
		var row = $('#dg').datagrid('getSelected');
		$.messager.confirm('确认','你确认要删除此文章吗?',function(r){
			if(r){
				$.post('blog/deleteBlogById',{id:row.id},function(result){
					if(result.success){
						$("#dg").datagrid('reload');
					}else {
						alert(result.msg);
						top.location.href = '';
					}
				});
			}
		},'json');
	}
},'-',{
	text:'编辑',
	handler:function(){
		var row =$('#dg').datagrid('getSelected');
		window.location.href='blog/toEditor/' + row.id;
	}
} ];
function changeP() {
	var dg = $('#dg');
	dg.datagrid('loadData', []);
	dg.datagrid({
		pagePosition : $('#p-pos').val()
	});
	dg.datagrid('getPager').pagination(
			{
				layout : [ 'list', 'sep', 'first', 'prev', 'sep',
						$('#p-style').val(), 'sep', 'next', 'last', 'sep',
						'refresh' ]
			});
}
//获取文章列表中选择的文章id
function getSelected(){
    var row = $('#dg').datagrid('getSelected');
    if (row){
       return row.id
    }
}
$(document).ready(function() {
	$("#checkCode").blur(function() {
		checkCode();
	});
	// 提交文章
	$("#publish").click(function() {
		var ue = UE.getEditor("container");
		var content = ue.getContentTxt();
		var title = $("#title").val();
		var articalTag = $("#tag").val();
		var sortNames = $("#sortId").val();
		var classify = $("#classifyId").val();
		if (title == "") {
			alert("请填写标题!");
			return;
		}
		if (content == "") {
			alert("文章内容不能为空");
			return;
		}
		if (articalTag == "") {
			alert("请填写标签");
			return;
		}
		if (classify == -1) {
			alert("请选择文章分类");
			return;
		}
		document.submitForm.submit();
	});
});