/*alert(11111);*/

//获取服务端时间的函数
function getServerTime() {
	//1.创建Ajax对象
	var ajax = createAjax();
	
	/*Method  http方法
	  url 请求的URL地址，可以为绝对地址也可以为相对地址
	  async  布尔型，指定此请求是否为异步方式，默认为true
	*
	*/
	//2.请求参数的配置
	ajax.open("get", "/Day18_ajax_json/server2222222?"+new Date().toTimeString(), true);
	
	//获取请求状态  异步  回调函数
	ajax.onreadystatechange = function() {
		//4.
		//console.debug(ajax.readyState);//请求状态  4表示完成
		if(ajax.readyState == 4 && ajax.status == 200){//接收响应数据
			var text = ajax.responseText;
			/*console.debug(text);*/
			
			document.getElementById("time").innerHTML = text;
		}
	};
	
	//3.发送请求
	ajax.send();
	
	
	
	
	
	
	
	/*var text = ajax.responseText;
	console.debug(text);*/
	
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


