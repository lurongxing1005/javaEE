
//打开窗口
function openWin() {
	/*window.open("https://www.baidu.com","_self");*/
    window.open("close.html");
} 

//关闭窗口
function closeWin(){
	window.close();
}

//移动窗口
function moveWin() {
	//moveBy(-50, -50);
	moveTo(100,100);
	
}

//改变窗口
function resizeWin(){
	//resizeBy(50,50);
	resizeTo(1000,1000);
}

//获取位置
function getWindowSize() {
	var x = window.screenX || window.screenLeft  || 0;
	var y = window.screenY || window.screenTop  || 0;
	alert("X坐标=" + x + ", Y坐标=" + y);
}







