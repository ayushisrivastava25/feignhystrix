package com.ayushi.feign.circuit.breaker;

import com.ayushi.feign.circuit.breaker.clients.ClassicalClient;
import com.netflix.hystrix.HystrixCommandGroupKey;
        import com.netflix.hystrix.HystrixObservableCommand;
        import rx.Observable;
        import rx.Subscriber;
        import rx.schedulers.Schedulers;

public class SongsCommand extends HystrixObservableCommand<Integer> {

    private String type;
    private ClassicalClient classicalClient;

public SongsCommand(String type, ClassicalClient classicalClient) {
        super(HystrixCommandGroupKey.Factory.asKey("SongsCommand"));
        this.type = type;
        this.classicalClient = classicalClient;
        }

@Override
protected Observable<Integer> construct() {
        return Observable.create(new Observable.OnSubscribe<Integer>(){
@Override
public void call(Subscriber<? super Integer> observer) {
        try {
        if (!observer.isUnsubscribed()){

        if (type == null){
        throw new IllegalArgumentException("name cannot be null");
        }

        observer.onNext(classicalClient.getClassicalSongsCount(type));
        observer.onCompleted();
        }
        } catch (Exception e){
        observer.onError(e);
        }
        }
        }).subscribeOn(Schedulers.io());
        }

@Override
protected Observable<Integer> resumeWithFallback() {
        return Observable.create((Observable.OnSubscribe<Integer>) observer -> {
        if (!observer.isUnsubscribed()){
        observer.onNext(12);
        observer.onCompleted();
        }
        }).subscribeOn(Schedulers.io());
        }
        }
