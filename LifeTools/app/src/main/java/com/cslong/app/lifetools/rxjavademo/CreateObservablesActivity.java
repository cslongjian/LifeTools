package com.cslong.app.lifetools.rxjavademo;

import android.os.Bundle;

import com.cslong.app.lifetools.BaseActivity;

import rx.Observable;
import rx.Subscriber;


/**
 * 创建Observables方式
 */
public class CreateObservablesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    private Observable<Integer> createObserver() {

        return  Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {


                subscriber.onNext(1);

            }
        });

//        .subscribe(new Subscriber<Integer>() {
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

    }


}
