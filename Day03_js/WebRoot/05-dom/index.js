function p(data){
	console.debug(data);
}


function getInputValue() {
	//js 通过id获取html中的标签   value是字符串
	
	
	//获取标签的值value
	var a = document.getElementById("num1").value;
	p(a);
	
	//给标签赋值
	document.getElementById("num1").value = "123456";
	
} 

