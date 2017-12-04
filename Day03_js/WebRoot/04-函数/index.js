var num = 20;
console.debug(num);

//定义函数

//1.无参数,无返回
function doWork(){
	var num = 30;
	console.debug("函数,"+num);
}

//第一种调用方式
/*doWork();*/
//第二种调用方式
/*window.onload = doWork;*/


//2.有参数  无返回
function p(a) {
	console.debug(a);
}
p(123456);
p("hello");


//3.有参数  有返回
function getSum(x, y) {
	return x+y;
}
p(getSum(10,30));
p(getSum("10","30"));


//匿名函数
var add = function(x, y){
	return x+y;
};
p(add(20,40));

var xxx = add;
p(xxx(50,60));

//练习：使用js函数求1~100累加的和。

function theSum(n) {
	var sum = 0;
	for(i=1;i<=n;i++){
		sum += i;
	}
	p(sum);
}

theSum(100);

//全局变量和局部变量
p("---------------------------");
var msg = "全局变量";
function show() {
	msg = "局部变量";
}
show();
p(msg);


var msg1 = "全局变量";
function show1() {
	var msg1;
	msg1 = "局部变量";
}
show1();
p(msg1);





