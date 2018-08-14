package com.cslong.app.lifetools.designpatterndemo.factory.factoryfunction;

import java.util.Map;

//工厂方法模式_产品接口
public interface ICar {

    public Map<String, Object> getMessageParam();

    public void setMessageParam(Map<String, Object> messageParam);

    public void sendMesage() throws Exception;// 发送通知/消息

}
