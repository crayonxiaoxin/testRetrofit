package com.ormediagroup.myapplication.network;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Lau on 2020-01-07.
 */
public abstract class BaseObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        onFailed(e);
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T t);

    public abstract void onFailed(Throwable e);
}
