/**
 * checkbox.js
 */
$(function(){
	$("#checkBoxs").click(function(){
		if($("#checkAll").prop("checked")){
			$(":checkbox[name='check']").prop("checked",true);
		}
		else{
			$("input:checkbox[name='check']").prop("checked",false);
		}
	});
	$("input:checkbox[name='check']").click(function(){
		var tot = $("input:checkbox[name='check']").length;
		var cnt = $("input:checkbox[name='check']:checked").length;
		if(tot==cnt) $("#checkAll").prop("checked",true);
		else $("#checkAll").prop("checked",false);
	})
});