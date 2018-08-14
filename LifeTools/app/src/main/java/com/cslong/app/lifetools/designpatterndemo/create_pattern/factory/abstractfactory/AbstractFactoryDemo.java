package com.cslong.app.lifetools.designpatterndemo.create_pattern.factory.abstractfactory;

public class AbstractFactoryDemo {

    public static void main(String ars[]) {
        IFactory factory = new Factory();
        factory.createProduct1().show();
        factory.createProduct2().show();
    }

}
