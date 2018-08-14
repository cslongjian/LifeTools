package com.cslong.app.lifetools.designpatterndemo.create_pattern.factory.factoryfunction;

// 工厂方法模式_工厂接口
public interface ICarFactory {
    public ICar createCar(String carType);
}
