var toolbar = [{
	text : '删除',
	iconCls : 'icon-remove',
	handler : function() {
		var row = $('#dg').datagrid('getSelected');
		$.messager.confirm('确认','你确认要删除此问题吗?',function(r){
			if(r){
				$.post('question/deleteQuestionById',{id:row.id},function(result){
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