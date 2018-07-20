package com.cslong.app.lifetools.rxjavademo;

import android.os.Bundle;
import android.util.Log;

import com.cslong.app.lifetools.BaseActivity;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;


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



}
