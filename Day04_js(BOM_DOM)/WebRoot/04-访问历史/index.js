

function goHistory(){
	/*window.history.go(-1);*/
	alert(history.length);
	window.history.back();
	
	//console.debug(history.length);
	
}


function showInfo(){
	//console.debug(window.navigator);
	
	console.dir(window.navigator);
}

function locationPage(){
	//window.location.href="https://www.baidu.com";
	
	location.href="https://www.baidu.com";
}