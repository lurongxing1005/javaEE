/*alert(11111);*/

//登录验证
function loginCheck() {
	var username = document.getElementById("usernameId").value;
	var password = document.getElementById("passwordId").value;
	
	//1.创建Ajax对象
	var ajax = createAjax();
	
	ajax.open("post","/Day18_ajax_json/login");
	
	
	//获取请求状态  异步  回调函数
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){//接收响应数据
			var text =  ajax.responseText;
			
			document.getElementById("tipId").innerHTML = text;
		}
	};
	
	//3.发送请求
	//使用post 要设置Content-Type  为  application/x-www-form-urlencoded
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	//post 传递数据  参数key=value&key=value
	ajax.send("username="+username+"&password="+password);
	
}


//创建Ajax对象
function createAjax() {
	var ajax;
	try {
		ajax = new XMLHttpRequest();
		
	} catch (e) {
		// : handle exception
		ajax = new ActiveXObject();
		
	}
	return ajax;
}


