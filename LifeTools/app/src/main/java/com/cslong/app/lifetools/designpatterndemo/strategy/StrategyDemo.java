package com.cslong.app.lifetools.designpatterndemo.strategy;


import com.cslong.app.lifetools.designpatterndemo.strategy.demo.Player;
import com.cslong.app.lifetools.designpatterndemo.strategy.demo.Player2;

/**
 * 策略模式
 * <p>
 * 个人见解：针对接口编程。对不同需求进行对应的变换响应。
 * <p>
 * <p>
 * 1定义：策略模式定义了一系列的算法，并将每一个算法封装起来，而且使他们可以相互替换，让算法独立于使用它的客户而独立变化。
 * <p>
 * 分析下定义，策略模式定义和封装了一系列的算法，它们是可以相互替换的，也就是说它们具有共性，而它们的共性就体现在策略接口的行为上，另外为了达到最后一句话的目的，也就是说让算法独立于使用它的客户而独立变化，我们需要让客户端依赖于策略接口。
 * <p>
 * 2策略模式的使用场景：
 * <p>
 * 1.针对同一类型问题的多种处理方式，仅仅是具体行为有差别时；
 * 2.需要安全地封装多种同一类型的操作时；
 * 3.出现同一抽象类有多个子类，而又需要使用 if-else 或者 switch-case 来选择具体子类时。
 */
public class StrategyDemo {

    public static void main(String ars[]) {


        //简单实例。策略封装在player内buy内。有更好的封装。换成由工厂模式提供策略执行对象。
        Player player = new Player();
        player.buy(5000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());

         //业务分离
        Player2 player2 = new Player2();
        player2.buy(5000D);
        System.out.println("玩家需要付钱：" + player2.calLastAmount());
        player2.buy(12000D);
        System.out.println("玩家需要付钱：" + player2.calLastAmount());
        player2.buy(12000D);
        System.out.println("玩家需要付钱：" + player2.calLastAmount());
        player2.buy(12000D);
        System.out.println("玩家需要付钱：" + player2.calLastAmount());


    }

}
