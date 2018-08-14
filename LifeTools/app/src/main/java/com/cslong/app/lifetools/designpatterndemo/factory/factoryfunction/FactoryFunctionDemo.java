package com.cslong.app.lifetools.designpatterndemo.factory.factoryfunction;

public class FactoryFunctionDemo {

    public static void main(String arg[]) {
        ICarFactory carFactory = new CarFactory();
        ICar car;
        // 对于这个消费者来说，不用知道如何生产message这个产品，耦合度降低
        try {
            //
            car = carFactory.createCar(CarFactory.TYPE_BMW);
            car.sendMesage();

            //
            car = carFactory.createCar(CarFactory.TYPE_TOYOTA);
            car.sendMesage();

            //
            car = carFactory.createCar(CarFactory.TYPE_CHEVROLET);
            car.sendMesage();

//
            car = carFactory.createCar(CarFactory.TYPE_GUOCHAN);
            car.sendMesage();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
