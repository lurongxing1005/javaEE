//系统函数
function p(data) {
	console.debug(data);
}

//encodeURI方法
var ret1 = "https://www.baidu.com?name=张三";
var ret2 = encodeURI(ret1);
p(ret2);
var ret22 = encodeURIComponent(ret1);
p(ret22);

p("------------------------");
var ret3 = decodeURI("https://www.baidu.com?name=%E5%BC%A0%E4%B8%89");
p(ret3);
var ret33 = decodeURIComponent("https%3A%2F%2Fwww.baidu.com%3Fname%3D%E5%BC%A0%E4%B8%89");
p(ret33);

//parseInt方法
//字符串----->int float number
p(parseInt("123"));//123
p(parseInt("1A23SE45"));//1
p(parseInt("123.456"));//123  
p(parseInt("123S"));//123

p("------------------");

p(parseFloat("123S"));//123
p(parseFloat("456"));//456
p(parseFloat("789.123"));//789.123 
p(parseFloat("2W345SE"));//2


p("------------------");
p(isNaN(0.0/0.0));//true
p(isNaN(1/1));//false

p("------------------");
var str = "alert('你好,师姐');";
p(str);
/*eval(str);*/

p("------------------");
p(isFinite(1/0));//false
p(isFinite(-1/0));//false
p(isFinite(1/1));//true








