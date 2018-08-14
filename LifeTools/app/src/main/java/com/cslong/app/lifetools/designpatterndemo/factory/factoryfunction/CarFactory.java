package com.cslong.app.lifetools.designpatterndemo.factory.factoryfunction;

import java.util.HashMap;
import java.util.Map;

//工厂方法模式_工厂实现
public class CarFactory implements ICarFactory {
    public static final String TYPE_BMW = "BMW";
    public static final String TYPE_CHEVROLET = "XUEFULAN";
    public static final String TYPE_TOYOTA = "FENGTIAN";
    public static final String TYPE_GUOCHAN = "ZHAZHA";


    @Override
    public ICar createCar(String carType) {

        ICar myMessage;
        Map<String, Object> messageParam = new HashMap<String, Object>();
        // 根据某些条件去选择究竟创建哪一个具体的实现对象，条件可以传入的，也可以从其它途径获取。
        // sms
        if ("BMW".equals(carType)) {
            myMessage = new BMW();
            messageParam.put("BMW", "123456789");
        } else
            // OA待办
            if ("XUEFULAN".equals(carType)) {
                myMessage = new xuefulanCar();
                messageParam.put("xuefulanCar", "testUser");
            } else
                // email
                if ("FENGTIAN".equals(carType)) {
                    myMessage = new fengtian();
                    messageParam.put("fengtian", "test@test.com");
                } else
                // 默认生产email这个产品
                {
                    myMessage = new GuoChan();
                    messageParam.put("GuoChan", "test@test.com");
                }
        myMessage.setMessageParam(messageParam);
        return myMessage;

    }
}
