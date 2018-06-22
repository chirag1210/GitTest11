package com.chirag.mygittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Main activity from branch1
 */

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JustOperator();
        JustOperator1();
        FromOpertor();
    }

    private void FromOpertor() {
        Observable<String> myArrayObservable = Observable.from(new String[]{"Chirag", "Komal", "Snehal"});
        Action1<String> myAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, s);
                MyLogger.logWithLink(TAG, " " + s);
            }
        };
        myArrayObservable.subscribe(myAction);
    }

    private void JustOperator() {
        Log.d("----------------", "--------");
        Observable<String> myObservable = Observable.just("Hello"); // Emits "Hello"
        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext " + s);
            }
        };
        Subscription subscription = myObservable.subscribe(myObserver);
        subscription.unsubscribe();
    }


    private void JustOperator1() {
        Observable<String> myObservable = Observable.just("Hello"); // Emits "Hello"
        Action1<String> myAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, s);
                MyLogger.logWithLink(TAG, " " + s);
            }
        };
        Subscription subscription = myObservable.subscribe(myAction);
        subscription.unsubscribe();
    }

}
