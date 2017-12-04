var num1 = 8;
var num2 = 2;

var ret = num1+num2;
console.debug(ret);

console.debug("---------------");

var age1 = 18;
var age2 = "18";

console.debug(age1==age2);//true  值一样
console.debug(age1===age2); //false 值和类型 一样

if(age1){
	console.debug("值为true");
}

console.debug("---------------");
console.debug(true && true);//true
console.debug(1 && true);//true
console.debug(1 && 2);//2
console.debug("A" && 2);//2
console.debug("" && 2);//""
console.debug(null && "B");//null
console.debug("A" && "B");//"B"
console.debug(1 && 2 && 3);//3
console.debug(1 && null && 3);//null
console.debug("" && null && 0);//""

console.debug("---------------");
console.debug(true || true);//true
console.debug(1 || true);//1
console.debug(1 || 2);//1
console.debug("A" || 2);//A
console.debug("" || 2);//2
console.debug(null || "B");//B
console.debug("A" || "B");//"A"
console.debug(1 || 2 || 3);//1
console.debug(1 || null || 3);//1
console.debug("" || null || 0);//0




