package com.cslong.app.lifetools.rxjavademo;

import android.os.Bundle;
import android.util.Log;
import android.widget.ViewAnimator;

import com.cslong.app.lifetools.BaseActivity;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * 创建Observables方式
 */
public class CreateObservablesActivity extends BaseActivity {

    private static final String TAG = "CreateObservables";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }


    /**
     *  创建被观察者，用于被观察者订阅。
     *
     *  传入了一个 OnSubscribe 对象作为参数。
     *  OnSubscribe 会被存储在返回的 Observable 对象中，它的作用相当于一个计划表，
     *  当 Observable 被订阅的时候，OnSubscribe 的 call() 方法会自动被调用，
     *  事件序列就会依照设定依次触发（对于上面的代码，就是观察者Subscriber 将会被调用三次 onNext()
     *  和一次 onCompleted()）。
     *  这样，由被观察者调用了观察者的回调方法，就实现了由被观察者向观察者的事件传递，即观察者模式。
     *
     * @return
     */
    private Observable<Integer> createObservable() {

        Observable<Integer> ObservableDemo1 =  Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {

                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onCompleted();

            }
        });

//        observableDemo3.subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//
//            }
//        })

        //just(T...): 将传入的参数依次发送出来。
        Observable observableDemo2 = Observable.just("Hello", "Hi", "Aloha");

//        from(T[]) / from(Iterable<? extends T>) : 将传入的数组或 Iterable 拆分成具体对象后，依次发送出来。
        String[] words = {"Hello", "Hi", "Aloha"};
        Observable observableDemo3 = Observable.from(words);




        return ObservableDemo1;

    }

    /**
     *  创建观察者，用于订阅被观察者。
     * @return
     */
    private Observer<Integer> createObserver() {
         Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onNext(Integer s) {
                Log.d(TAG, "Item: " + s);
            }

            @Override
            public void onCompleted() {
                Log.d(TAG, "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error!");
            }
        };

         return observer;
    }

    /**
     *  创建观察者Subscriber，用于订阅被观察者。
     *
     *  Subscriber 是实现Observer的抽象类。具体方法基本一致。但Subscriber有两个区别
     *  --1
     *  onStart(): 这是 Subscriber 增加的方法。它会在 subscribe 刚开始，
     *  而事件还未发送之前被调用，可以用于做一些准备工作，例如数据的清零或重置。
     *  这是一个可选方法，默认情况下它的实现为空。需要注意的是，如果对准备工作的线程有要求
     *  （例如弹出一个显示进度的对话框，这必须在主线程执行）， onStart() 就不适用了，
     *  因为它总是在 subscribe 所发生的线程被调用，而不能指定线程。
     *  要在指定的线程来做准备工作，可以使用 doOnSubscribe() 方法，具体可以在后面看到。
     *
     *  --2
     *  unsubscribe(): 这是 Subscriber 所实现的另一个接口 Subscription 的方法，用于取消订阅。
     *  在这个方法被调用后，Subscriber 将不再接收事件。
     *  一般在这个方法调用前，可以使用 isUnsubscribed() 先判断一下状态。
     *  unsubscribe() 这个方法很重要，因为在 subscribe() 之后， Observable 会持有 Subscriber 的引用，
     *  这个引用如果不能及时被释放，将有内存泄露的风险。
     *  所以最好保持一个原则：要在不再使用的时候尽快在合适的地方
     *  （例如 onPause() onStop() 等方法中）调用 unsubscribe() 来解除引用关系，以避免内存泄露的发生。
     *
     *
     *
     * @return
     */
    private  Observer<Integer> createSubscriber() {
        Subscriber<Integer> observer = new Subscriber<Integer>() {
            @Override
            public void onNext(Integer s) {
                Log.d(TAG, "Item: " + s);
            }

            @Override
            public void onCompleted() {
                Log.d(TAG, "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error!");
            }
        };

        return observer;
    }


    /**
     * Subscribe (订阅)
     * 创建了 Observable 和 Observer 之后，再用 subscribe() 方法将它们联结起来，整条链子就可以工作了。代码形式很简单：
     *  Observable.subscribe(Subscriber) 的内部实现是这样的（仅核心代码）：
     *  主要代码
     *  public Subscription subscribe(Subscriber subscriber) {
            subscriber.onStart();
            onSubscribe.call(subscriber);
            return subscriber;
        }
     *
     *  可以看到，subscriber() 做了3件事：

        1 调用 Subscriber.onStart() 。这个方法在前面已经介绍过，是一个可选的准备方法。
        2 调用 Observable 中的 OnSubscribe.call(Subscriber) 。在这里，事件发送的逻辑开始运行。
            从这也可以看出，在 RxJava 中， Observable 并不是在创建的时候就立即开始发送事件，
            而是在它被订阅的时候，即当 subscribe() 方法执行的时候。
        3 将传入的 Subscriber 作为 Subscription 返回。这是为了方便 unsubscribe().
     *
     *
     *
     */
    private void  SubscribeDemo()
    {
        createObservable().subscribe(createObserver());
    }

//      上面只介绍了。观察者 被观察者 订阅关系
//      线程控制 Scheduler
    /**
     * 在不指定线程的情况下， RxJava 遵循的是线程不变的原则，
     * 即：在哪个线程调用 subscribe()，就在哪个线程生产事件；
     * 在哪个线程生产事件，就在哪个线程消费事件。
     * 如果需要切换线程，就需要用到 Scheduler （调度器）。
     *
     * 1) Scheduler 的 API (一)
     在RxJava 中，Scheduler ——调度器，相当于线程控制器，RxJava 通过它来指定每一段代码应该运行在什么样的线程。
     RxJava 已经内置了几个 Scheduler ，它们已经适合大多数的使用场景：

        1 Schedulers.immediate(): 直接在当前线程运行，相当于不指定线程。这是默认的 Scheduler。
        2 Schedulers.newThread(): 总是启用新线程，并在新线程执行操作。
        3 Schedulers.io(): I/O 操作（读写文件、读写数据库、网络信息交互等）所使用的 Scheduler。
            行为模式和 newThread() 差不多，区别在于 io() 的内部实现是是用一个无数量上限的线程池，可以重用空闲的线程，
            因此多数情况下 io() 比 newThread() 更有效率。不要把计算工作放在 io() 中，可以避免创建不必要的线程。
        4 Schedulers.computation(): 计算所使用的 Scheduler。这个计算指的是 CPU 密集型计算，即不会被 I/O 等操作限制性能的操作，例如图形的计算。
            这个 Scheduler 使用的固定的线程池，大小为 CPU 核数。不要把 I/O 操作放在 computation() 中，否则 I/O 操作的等待时间会浪费 CPU。
        5 另外， Android 还有一个专用的 AndroidSchedulers.mainThread()，它指定的操作将在 Android 主线程运行。

     *
     * 有了这几个 Scheduler ，就可以使用 subscribeOn() 和 observeOn() 两个方法来对线程进行控制了。
     * * subscribeOn(): 指定 subscribe() 所发生的线程，即 Observable.OnSubscribe 被激活时所处的线程。或者叫做事件产生的线程。
     * * observeOn(): 指定 Subscriber 所运行在的线程。或者叫做事件消费的线程。
     */

//    来看个例子
    private void SchedulerDemo() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        Log.d("TTT", "number:" + number);
                    }
                });

//      上面这段代码中，由于 subscribeOn(Schedulers.io()) 的指定，被创建的事件的内容 1、2、3、4 将会在 IO 线程发出；
//      而由于 observeOn(AndroidScheculers.mainThread()) 的指定，因此 subscriber 数字的打印将发生在主线程 。
//      事实上，这种在 subscribe() 之前写上两句 subscribeOn(Scheduler.io())
//      和 observeOn(AndroidSchedulers.mainThread()) 的使用方式非常常见，
//      它适用于多数的 『后台线程取数据，主线程显示』的程序策略。
    }

//    Scheduler 的原理 (一) 跟着变换一起讲解





}
