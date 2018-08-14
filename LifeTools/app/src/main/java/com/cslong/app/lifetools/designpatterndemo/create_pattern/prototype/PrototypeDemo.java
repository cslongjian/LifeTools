package com.cslong.app.lifetools.designpatterndemo.create_pattern.prototype;

/**
 * 原型模式中我们可以利用过一个原型对象来指明我们所要创建对象的类型，然后通过复制这个对象的方法来获得与该对象一模一样的对象实例。这就是原型模式的设计目的。
 * <p>
 * 浅拷贝：使用一个已知实例对新创建实例的成员变量逐个赋值，这个方式被称为浅拷贝。
 * <p>
 * 深拷贝：当一个类的拷贝构造方法，不仅要复制对象的所有非引用成员变量值，还要为引用类型的成员变量创建新的实例，并且初始化为形式参数实例值。
 * <p>
 * <p>
 * clone()方法满足：
 * (1) 对任何的对象x，都有x.clone() !=x，即克隆对象与原对象不是同一个对象。
 * (2) 对任何的对象x，都有x.clone().getClass()==x.getClass()，即克隆对象与原对象的类型一样。
 * (3) 如果对象x的equals()方法定义恰当，那么x.clone().equals(x)应该成立。
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        //原型A对象
        Resume a = new Resume("小李子");
        a.setPersonInfo("2.16", "男", "XX大学");
        a.setWorkExperience("2012.09.05", "XX科技有限公司");

        //克隆B对象
        Resume b = (Resume) a.clone();

        //输出A和B对象
        System.out.println("----------------A--------------");
        a.display();
        System.out.println("----------------B--------------");
        b.display();

        /*
         * 测试A==B?
         * 对任何的对象x，都有x.clone() !=x，即克隆对象与原对象不是同一个对象
         */
        System.out.print("A==B?");
        System.out.println(a == b);

        /*
         * 对任何的对象x，都有x.clone().getClass()==x.getClass()，即克隆对象与原对象的类型一样。
         */
        System.out.print("A.getClass()==B.getClass()?");
        System.out.println(a.getClass() == b.getClass());
    }

}
//
        //优点
//        1、如果创建新的对象比较复杂时，可以利用原型模式简化对象的创建过程，同时也能够提高效率。
//
//        2、可以使用深克隆保持对象的状态。
//
//        3、原型模式提供了简化的创建结构。
//
//        缺点
//        1、在实现深克隆的时候可能需要比较复杂的代码。
//
//        2、需要为每一个类配备一个克隆方法，而且这个克隆方法需要对类的功能进行通盘考虑，这对全新的类来说不是很难，但对已有的类进行改造时，不一定是件容易的事，必须修改其源代码，违背了“开闭原则”。



