// ---------------字符串（字面量）;
// @@@@@@@@1  普通变量  Literal 
let strFace = `${value}On`;
// @@@@@@@@2  对象内的属性key 用法
this.root.action.setDevice({
    aOn: false,
    [`${value}On`]: this[`subscribe_${value}`][`${value}On`],
});

// ---------------数组（遍历，去重，排序）;
// @@@@@@@@1  Array traversal;
// 1for循环
for (var i = 0; i < 数组.length; i++) {}
// @@@@@@@@2  Array sorting;
eventList = eventList.sort((a, b) => {
    return b.time - a.time;
});
// @@@@@@@@3  Array deduplication;
// mothed 1 use map
let map = new Map();
eventList.forEach((item) => {
    map.set(item.time, item);
});
let newData = [...map.values()];
// method 2 use filter function
const uniqueArr = tmpList.filter((item, index, self) => {
    return index === self.findIndex((obj) => obj.time === item.time);
});

// ---------------对象;

// ---------------函数;

// ---------------正则表达式;

// ---------------日期;

// ---------------数学;

// 遍历方法说明 forEach、map、filter、reduce、some、every

// forEach，map，filter，some，every 传递的第一个参数相同 
// callbackFn(item,index,arr)
// item：当下遍历的数组元素的值；当数组的元素为基本数据类时，item是直接赋值为元素的值；当数组的元素为引用数据类型时，此时item是引用赋值，即该地址值会指向原数组的元素(在map方法里会举例说明）。
// index：当下遍历的数组元素的索引；
// arr：表示原数组。

// forEach方法：没有返回结果，返回值为undefined，本质上等同于 for 循环；
// map方法：会返回一个新数组，新数组的元素为原始数组元素调用函数处理的后return返回的值。
// filter 遍历数组并返回一个新的数组，新数组中的元素是通过检查指定数组中满足条件的所有元素。
// some方法只要有一个元素符合return的条件就返回true，后面元素就不会再执行判断
// every方法要求所有元素符合return的判断条件才返回true，不然就返回false

// reduce特殊

// （1）forEach方法没有返回值，一般用于直接修改原数组；
// （2）map方法会返回新的数组，在处理元素为引用数据类型的数组时可以通过数据的拷贝不修改原数组（拷贝的方法我们会在下回和大家做专门的讲解），并且可以结合其他方法执行更多层的操作；
// （3）filter()方法用于过滤数组，返回的结果就是过滤后的新数组；
// （4）reduce()方法在一般需要对数组元素的数据进行一些运算处理时使用，返回的值就是最终的结果；(有种递归操作的意思)
// （5）some()方法用于判断数组中是否有满足条件的元素，返回结果是布尔值，只要有一个符合就是true；
// （6）every()方法用于判断数组中的元素是否都符合判断条件，返回结果是布尔值，都符合才会返回true。
