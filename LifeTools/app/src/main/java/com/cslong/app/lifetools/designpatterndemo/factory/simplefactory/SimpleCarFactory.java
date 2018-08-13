package com.cslong.app.lifetools.designpatterndemo.factory.simplefactory;

public class SimpleCarFactory {

    public static final int TYPE_T = 1;//丰田
    public static final int TYPE_N = 2;//日产
    public static final int TYPE_H = 3;//本田
    public static final int TYPE_C = 4;//雪佛兰

    public static ICar createCars(int type) {
        switch (type) {
            case TYPE_T:
                return new Toyota();
            case TYPE_N:
                return new Nissan();
            case TYPE_H:
                return new Honda();
            case TYPE_C:
                return new Chevrolet();
            default:
                return new ZhaZhaCar();
        }
    }
}
