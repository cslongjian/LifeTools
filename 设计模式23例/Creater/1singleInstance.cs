// https://www.cnblogs.com/zhili/p/SingletonPatterm.html
/// <summary>
/// 单例模式的实现
/// </summary>
public class Singleton {
    // 定义一个静态变量来保存类的实例
    private static Singleton uniqueInstance;
    // 定义私有构造函数，使外界不能创建该类实例
    private Singleton() {
    }

    public static Singleton GetInstance() {
        // 如果类的实例不存在则创建，否则直接返回
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

}

// 上面的单例模式的实现在单线程下确实是完美的,然而在多线程的情况下会得到多个Singleton实例,因为在两个线程同时运行GetInstance方法时，
// 此时两个线程判断(uniqueInstance ==null)这个条件时都返回真，此时两个线程就都会创建Singleton的实例，
// 这样就违背了我们单例模式初衷了，既然上面的实现会运行多个线程执行，
// 那我们对于多线程的解决方案自然就是使GetInstance方法在同一时间只运行一个线程运行就好了，也就是我们线程同步的问题了

public class Singleton {
    // 定义一个静态变量来保存类的实例
    private static Singleton uniqueInstance;
    // 定义一个标识确保线程同步
    private static readonly object lockHelper = new object();   
    // 定义私有构造函数，使外界不能创建该类实例
    private Singleton() {
        
    }

    public static Singleton GetInstance() {
        // 当第一个线程运行到这里时，此时会对lockHelper对象 "加锁"
        // 当第二个线程运行该方法时，首先检测到lockHelper对象为"加锁"状态，该线程就会挂起等待第一个线程解锁
        // lock语句运行完之后（即线程运行完之后）会对该对象"解锁"
        // 这样就能保证同一时间只有一个线程能够执行该方法
        lock (lockHelper) {
            // 如果类的实例不存在则创建，否则直接返回
            if (uniqueInstance == null) {
                uniqueInstance = new Singleton();       
            }
        }
        return uniqueInstance;
    }


// 上面这种解决方案确实可以解决多线程的问题,但是上面代码对于每个线程都会对线程辅助对象locker加锁之后再判断实例是否存在，
// 对于这个操作完全没有必要的，因为当第一个线程创建了该类的实例之后，后面的线程此时只需要直接判断（uniqueInstance==null）为假，
// 此时完全没必要对线程辅助对象加锁之后再去判断，所以上面的实现方式增加了额外的开销，损失了性能，为了改进上面实现方式的缺陷，
// 我们只需要在lock语句前面加一句（uniqueInstance==null）的判断就可以避免锁所增加的额外开销，这种实现方式我们就叫它 “双重锁定”
   public static Singleton GetInstance2()
        {
            // 当第一个线程运行到这里时，此时会对locker对象 "加锁"，
            // 当第二个线程运行该方法时，首先检测到locker对象为"加锁"状态，该线程就会挂起等待第一个线程解锁
            // lock语句运行完之后（即线程运行完之后）会对该对象"解锁"
            // 双重锁定只需要一句判断就可以了
            if (uniqueInstance == null)
            {
                lock (locker)
                {
                    // 如果类的实例不存在则创建，否则直接返回
                    if (uniqueInstance == null)
                    {
                        uniqueInstance = new Singleton();
                    }
                }
            }
            return uniqueInstance;
        }

}



