# rxJava学习入门

----
## rxJava核心特性
see [https://github.com/ReactiveX/RxJava](https://github.com/ReactiveX/RxJava)

> RxJava is a Java VM implementation of **Reactive Extensions**: a library for composing **asynchronous** and **event-based** programs by using observable sequences.

> It extends the **observer pattern** to support sequences of data/events and adds operators that allow you to compose sequences together declaratively while abstracting away concerns about things like low-level threading, synchronization, thread-safety and concurrent data structures.

----
## 核心
###  四个接口和七个方法：
* Publisher(T)：publish(Subscriber<? super T>)
* Subscriber(T)：onSubscribe(Subscription),onNext(T),onError(Throwable),onComplete()
* Subscription:request(long)
* Processor.

### 五个基础类
* [io.reactivex.rxjava3.core.Flowable](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Flowable.html): 0..N flows, supporting Reactive-Streams and backpressure
* [io.reactivex.rxjava3.core.Observable](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html): 0..N flows, no backpressure,
* [io.reactivex.rxjava3.core.Single](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Single.html): a flow of exactly 1 item or an error,
* [io.reactivex.rxjava3.core.Completable](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html): a flow without items but only a completion or error signal,
* [io.reactivex.rxjava3.core.Maybe](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Maybe.html): a flow with no items, exactly one item or an error.

