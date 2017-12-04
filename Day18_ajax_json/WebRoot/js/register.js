/*alert(11111);*/

//JQuery检查账号是否存在
function checkUserName() {
	var username = $("#usernameId").val();
	/*$.get("/Day18_ajax_json/register?username="+username,function(data,status){
	    alert("数据: " + data + "\n状态: " + status);
	  });*/
	
	
	$.post("/Day18_ajax_json/register",{
		"username":username
	},function(data,status){
	    alert("数据: " + data + "\n状态: " + status);
	  });

}





