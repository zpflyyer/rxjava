# RxJava学习

----
## RxJava核心特性
see [https://github.com/ReactiveX/RxJava](https://github.com/ReactiveX/RxJava)

> RxJava is a Java VM implementation of **Reactive Extensions**: a library for composing **asynchronous** and **event-based** programs by using observable sequences.

> It extends the **observer pattern** to support sequences of data/events and adds operators that allow you to compose sequences together declaratively while abstracting away concerns about things like low-level threading, synchronization, thread-safety and concurrent data structures.

----
## 核心
###  四个接口和七个方法：
 1. Publisher(T)：publish(Subscriber<? super T>)
    
 2. Subscriber(T)：onSubscribe(Subscription),onNext(T),onError(Throwable),onComplete()
    
 3. Subscription:request(long)
    
 4. Processor.

### 五个基础类

 1. [io.reactivex.rxjava3.core.Flowable](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Flowable.html):
    0..N flows, supporting Reactive-Streams and backpressure
 2. [io.reactivex.rxjava3.core.Observable](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Observable.html):
    0..N flows, no backpressure,
    
 3. [io.reactivex.rxjava3.core.Single](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Single.html):
    a flow of exactly 1 item or an error,
    
 4. [io.reactivex.rxjava3.core.Completable](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Completable.html):
    a flow without items but only a completion or error signal,
    
 5. [io.reactivex.rxjava3.core.Maybe](http://reactivex.io/RxJava/3.x/javadoc/io/reactivex/rxjava3/core/Maybe.html):
    a flow with no items, exactly one item or an error.

### RxJava主要概念术语

 - 1个策略：backpressure
> a form of flow control where the **steps can express how many items are they ready to process**. This allows constraining the memory usage of the dataflows in situations where there is generally no way for a step to know how many items the upstream will send to it.
 - 2个方向：
    - Upstream
    - downstream
 - 3个时间
     - Assembly time:the preparation of dataflows by applying various **intermediate operators** happens in the so-called assembly time
     - Subscription time: when **subscribe()** is called on a flow that establishes the chain of processing steps internally
     - Runtime: This is the state when the flows are actively **emitting items**, errors or completion signals
 - 4个调度
     - Schedulers.computation(): Run computation intensive work on a fixed number of dedicated threads in the background. Most asynchronous operator use this as their default Scheduler.
     - Schedulers.io(): Run I/O-like or blocking operations on a dynamically changing set of threads.
     - Schedulers.single(): Run work on a single thread in a sequential and FIFO manner.
     - Schedulers.trampoline(): Run work in a sequential and FIFO manner in one of the participating threads, usually for testing purposes.
 - 并发
    - Flows in RxJava are sequential in nature split into processing stages that may run **concurrently** with each other:
        - 对于流里的1个元素而言，其按顺序依次经历每个processing stage;
        - 对于1个processing stage而言，其本身并不并发处理多个元素;
        - 所以，只是不同的stage可以并发处理不同的元素而已
    - Practically, parallelism in RxJava means **running independent flows and merging their results back into a single flow**
        - flatMap： **doesn't guarantee any order** and the end result from the inner flows may end up interleaved. 
        - concatMap： maps and runs **one inner flow at a time**.
        - concatMapEager： runs all inner flows "at once" but the **output flow will be in the order** those inner flows were created.
     
