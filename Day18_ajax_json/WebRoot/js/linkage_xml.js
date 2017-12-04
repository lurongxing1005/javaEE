/*alert(11111);*/

//通过省ID 获取市的数据
function getCityChange(){
	var provinceId =  document.getElementById("province").value;
	
	//1.创建Ajax对象
	var ajax = createAjax();
	
	ajax.open("get","/Day18_ajax_json/linkage?cmd=city&provinceId="+provinceId);
	
	
	//获取请求状态  异步  回调函数
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){//接收响应数据
			var doc =  ajax.responseXML;
			var datas = doc.getElementsByTagName("data");
			var html = "";
			for(i=0;i<datas.length;i++){
				html+="<option value='"+datas[i].id+"'>"+
				datas[i].innerHTML+"</option>";
			}
			document.getElementById("city").innerHTML = html;
		}
	};
	
	//3.发送请求
	ajax.send();
}



//二级联动
 window.onload = function () {
	
	//1.创建Ajax对象
	var ajax = createAjax();
	
	ajax.open("get","/Day18_ajax_json/linkage?cmd=province");
	
	
	//获取请求状态  异步  回调函数
	ajax.onreadystatechange = function() {
		if(ajax.readyState == 4 && ajax.status == 200){//接收响应数据
			var doc =  ajax.responseXML;
			var datas = doc.getElementsByTagName("data");
			var html = "";
			for(i=0;i<datas.length;i++){
				html+="<option value='"+datas[i].id+"'>"+
				datas[i].innerHTML+"</option>";
			}
			
		//console.debug(html);
			document.getElementById("province").innerHTML = html;
			getCityChange();
		}
	};
	
	//3.发送请求
	ajax.send();
	
};




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


