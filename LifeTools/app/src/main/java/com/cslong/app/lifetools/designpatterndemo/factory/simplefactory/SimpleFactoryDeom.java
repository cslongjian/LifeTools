package com.cslong.app.lifetools.designpatterndemo.factory.simplefactory;


/**
 * 特点
 * 1 它是一个具体的类，非接口 抽象类。有一个重要的create()方法，利用if或者 switch创建产品并返回。
 * <p>
 * 2 create()方法通常是静态的，所以也称之为静态工厂。
 * <p>
 * 缺点
 * 1 扩展性差（我想增加一种车，除了新增一个车产品类，还需要修改工厂类方法）
 * <p>
 * 2 不同的产品需要不同额外参数的时候 不支持。
 */
public class SimpleFactoryDeom {

    public static void main(String arg[]) {
        ICar mycar = SimpleCarFactory.createCars(SimpleCarFactory.TYPE_C);
        mycar.desc();

        ICar mycar1 = SimpleCarFactory.createCars(SimpleCarFactory.TYPE_T);
        mycar1.desc();

        ICar mycar2 = SimpleCarFactory.createCars(SimpleCarFactory.TYPE_N);
        mycar2.desc();

        ICar mycar3 = SimpleCarFactory.createCars(SimpleCarFactory.TYPE_H);
        mycar3.desc();
    }
}
