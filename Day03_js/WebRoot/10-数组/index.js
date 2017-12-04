//数组
function p(data) {
	console.debug(data);
}
//---------------数组的创建
//方法1
var arr1 = new Array();
arr1[0] = "A";
arr1[1] = "B";
arr1[2] = "C";
arr1[10] = "X";
p(arr1);

//方法2
var arr2 = new Array("A","B","C","D");
p(arr2);

//方法3
var arr3 = new Array(5);
p(arr3);

//方法4(使用比较多)
var arr4 = ["A","B","C","D"];
p(arr4);

//---------------数组的遍历
for(var i=0;i<arr4.length;i++){
	p(arr4[i]);
}
p("--------------------------");
for ( var a in arr4) {
	p(a+","+arr4[a]);
}
//----------------数组的属性和方法
p("--------------------------");

p(arr4.concat(4,5,6));
p(arr4.join("+"));
p(arr4.pop()); //删除并返回数组的最后一个元素
p(arr4);
p(arr4.push("E")); //向数组的末尾添加一个或更多元素，并返回新的长度。
p(arr4);

p(arr4.reverse());

//------------------sort－排序数组;
/*//方法1
var arr5 = [1,0,-1,2,7,11];
arr5.sort();
for ( var i in arr5) {
	document.write(arr5[i]+"    ");
}
document.write("<br/>");

//方法2
arr5.sort(function (a,b) {
	return b-a;
});
for ( var i in arr5) {
	document.write(arr5[i]+"   ");
}
document.write("<br/>");*/


//-------------splice(start, deletecount, items) 
    //方法用于插入、删除或替换数组的元素
p("--------------------");
var arr7 = ["tom","jack","rose"];
p(arr7);

//删除rose
arr7.splice(2, 1);
p(arr7);

//添加lily
arr7.splice(0, 0, "lily");
p(arr7);


//tom---->will
arr7.splice(1, 1, "will");
p(arr7);



