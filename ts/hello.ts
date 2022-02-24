

console.log('hello world');

// let arraystring = ['123','56','22'];
const arraystring = new Set(['apple','pear','mango']);
// arraystring['aa']='ad';


console.log('for fo 效果 取的是对应的value');
for(let value of arraystring)[
    console.log(value)
]

console.log('for in 效果 取的是下标的');
for(let value in arraystring)[
    console.log(value)
]

console.log('异步编程 generator函数');
function * generator(){
    console.log('excution start');
    yield 0;
    console.log('excution resumed');
    yield 1;
    console.log('excution end');
}

const iterator = generator();

console.log(iterator.next());

console.log(iterator.next());

//这里没有返回了。所以value undfined   done操作为true了。
console.log(iterator.next());

//在执行一次。还是一样的。
console.log(iterator.next());