//面向对象
function p(data) {
	console.debug(data);
}

//定义一个普通函数
function sayHello() {
	p("hello");
}


//定义一个类  第一种
function User() {
	
}

//创建对象
var user = new User();
p(user);

user.username="jack";
user.age=17;
user.sayHi = function(){
	p("你好,师姐");
};

p(user);
//调用user对象的方法
user.sayHi();


p("-----------------");
var user1 = new User();
p(user1);
user1.sex = 1;
p(user1);


p("-----------------");
//定义一个类  第二种
function Person(name,age) {
	//属性
	this.name = name;
	this.age = age;
	
	//方法
	this.doWork = function(){
		p(this.name+","+this.age);
	};
}

//创建对象
var person = new Person("rose",18);
p(person);

person.doWork();


//函数参数的值传递方式
//1.基本数据类型  值
function changeValue(x) {
	x = 5;
}
var x = 3;
changeValue(x);
p(x);


//2.对象类型  地址
function Person1(name,age) {
	this.name = name;
	this.age = age;
	
	//方法
	this.say = sayFunc;
	
	
}
function sayFunc() {
	p("sayFunc");
	p(this.name+","+this.age);
}

function change(p1) {
	p1.name = "jack";
}

var person1 = new Person1("tom",20);
person1.say();
change(person1);
person1.say();


