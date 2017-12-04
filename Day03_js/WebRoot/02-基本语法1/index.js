//alert("hello");
/**/

//定义变量

/*强类型
int age = 17;
string name = "jack";
*/

//弱类型   值是什么类型,变量就是什么类型
var age = "17";
console.debug("age="+age);
console.debug(typeof(age));

console.debug("----------------------");

age = 19;
console.debug("age="+age);
console.debug(typeof(age));

a = 18;
console.debug(a);

username="jack";
console.debug(username);
console.debug("----------------------");
var a = 1;
var b = "abc";
var c = 10.34;
var d = true;
var e;
console.debug(typeof(a));
console.debug(typeof(b));
console.debug(typeof(c));
console.debug(typeof(d));
console.debug(typeof(e));

console.debug("----------------------");
console.info("hello");
console.warn("hello");
console.error("hello");
console.log("hello");
console.debug("hello");

console.debug("----------------------");
var num = 17;
console.debug(num);
console.debug(num instanceof Number);//false

var num1 = new Number(18);
console.debug(num1);
console.debug(num1 instanceof Number);//true

num1 = "tom";
console.debug(num1);
console.debug(num1 instanceof Number);






