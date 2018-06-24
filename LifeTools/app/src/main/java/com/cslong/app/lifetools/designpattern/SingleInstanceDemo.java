package com.cslong.app.lifetools.designpattern;

/**
 * Created by chenlongjian on 2018/6/24.
 */

public class SingleInstanceDemo {

    private static SingleInstanceDemo instance;

    //私有构造方式。禁止外部调用
    private SingleInstanceDemo() {
    }


    //1#    多线程并发时，可能会出现重复new对象的情况，因此不提倡使用。
    public static SingleInstanceDemo getInstanceType1() {
        if (instance == null) {
            instance = new SingleInstanceDemo();
        }
        return instance;
    }

    //2# 每条线程都会依次进入方法块内部，虽然实现了单例，但是影响了运行效率，可以使用但是也不怎么提倡。
    public static synchronized SingleInstanceDemo getInstanceType2() {
        if (instance == null) {
            instance = new SingleInstanceDemo();
        }
        return instance;
    }

    //3#   这种方式只是第二种方法的一种优化，但是优化有限。
    public static SingleInstanceDemo getsInstanceType3() {
        synchronized (SingleInstanceDemo.class) {
            if (instance == null) {
                instance = new SingleInstanceDemo();
                return instance;
            } else {
                return instance;
            }
        }
    }


    //4#   双层判断加锁，效率影响小且保证了线程安全。  推荐使用
    public static SingleInstanceDemo getsInstance() {
        if (instance == null) {
            synchronized (SingleInstanceDemo.class) {
                if (instance == null) {
                    instance = new SingleInstanceDemo();
                }
            }
        }
        return instance;
    }


    //5#    静态内部类方式 在内部类中new对象，再将内部类的对象返回，
    // 这种方法是使用了java中class加载时互斥的原理来实现了线程的安全。不加线程锁也使得运行效率不会受到较大的影响。比较提倡。
    private static class SingletonHolder {
        private static final SingleInstanceDemo instance = new SingleInstanceDemo();
    }
    public static SingleInstanceDemo getInstance5() {
        return SingletonHolder.instance;
    }

}
