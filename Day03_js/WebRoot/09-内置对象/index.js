//内置对象
function p(data) {
	console.debug(data);
}

//1.forin
function Person(name,age) {
	this.name = name;
	this.age = age;
}

var person = new Person("jack",30);
for ( var p1 in person) {
	p("key="+p1+",value="+person[p1]);
}

//2.object
var obj = new Object();
obj.name = "will";
obj.age = 19;
p(obj);
p(obj.constructor);
p(obj.hasOwnProperty("age"));

//3.date
var d = new Date();
p(d);
p(d.toLocaleString());

// 2017-10-10
var year = d.getFullYear();
var month = d.getMonth()+1;
var day = d.getDate();

var time = year+"-"+month+"-"+day;
p(time);
p(d.getTime());

p("---------------------------------");
//4.Math
//random  返回0--0.999999
p(Math.random());
for(var i=0;i<5;i++){ //1-10
	//var h =Math.round( Math.random()*10+1);
	var h =Math.floor( Math.random()*10+1);
	
	p(h);
}


//5.String
var s1 = new String("jack");
var s2 = new String("jack");


p(s1==s2);//false 地址

p(s1.valueOf() == s2.valueOf());//内容

p("ABCD".charAt(1));
p("ABCD".length);
p("aBCD".charCodeAt(0));

//随机生成A到Z之间的字母:65+26  [65  91]
//随机生成0~25
var num = parseInt(Math.random()*26);//
num = num + 65;
p(String.fromCharCode(num));











