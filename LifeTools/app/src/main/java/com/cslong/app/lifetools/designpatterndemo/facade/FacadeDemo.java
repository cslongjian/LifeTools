package com.cslong.app.lifetools.designpatterndemo.facade;


//外观模式（Facade）

import java.util.logging.Logger;

/**
 * 他隐藏了系统的复杂性，并向客户端提供了一个可以访问系统的接口。
 * 这种类型的设计模式属于结构性模式。为子系统中的一组接口提供了一个统一的访问接口，这个接口使得子系统更容易被访问或者使用。
 * <p>
 * 　　1）.门面角色：外观模式的核心。它被客户角色调用，它熟悉子系统的功能。内部根据客户角色的需求预定了几种功能的组合。
 * <p>
 * 　　2）.子系统角色:实现了子系统的功能。它对客户角色和Facade时未知的。它内部可以有系统内的相互交互，也可以由供外界调用的接口。
 * <p>
 * 　　3）.客户角色:通过调用Facede来完成要实现的功能。
 * <p>
 * 个人简单理解  封装一层以供外部调用。内部具体各个子系统逻辑相互组合复杂调用都隔离在这一层门面上。
 */

//客户端类
public class FacadeDemo {

    public static final Logger LOGGER = Logger.getLogger("Cilent.class");

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        LOGGER.info("=================");
        computer.shutDown();
    }

}

//从上面的实例来看，有了这个Facade类，也就是Computer类，用户就不用亲自去调用子系统中的Disk,Memory、CPU类了，
// 不需要知道系统内部的实现细节，甚至都不用知道系统内部的构成。客户端只需要跟Facade交互就可以了。
