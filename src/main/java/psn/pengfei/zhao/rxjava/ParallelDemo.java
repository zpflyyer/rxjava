package psn.pengfei.zhao.rxjava;

import io.reactivex.Flowable;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;

public class ParallelDemo {

    public static void main(String[] args) {
        System.out.println("---------------flatMap---------------");
        Flowable.range(1, 10).flatMap(v -> Flowable.just(v).subscribeOn(Schedulers.computation()).map(w -> {
            System.out.println("flatting map for emission " + w);
            return w * w;
        })).blockingSubscribe(System.out :: println);

        System.out.println("---------------concatMap---------------");
        Flowable.range(1, 10).concatMap(v -> Flowable.just(v).subscribeOn(Schedulers.computation()).map(w -> {
            System.out.println("flatting map for emission " + w);
            return w * w;
        })).blockingSubscribe(System.out :: println);

        System.out.println("---------------concatMapEager---------------");
        Flowable.range(1, 10).concatMapEager(v -> Flowable.just(v).subscribeOn(Schedulers.computation()).map(w -> {
            System.out.println("flatting map for emission " + w);
            return w * w;
        })).blockingSubscribe(System.out :: println);

        System.out.println("---------------parallel()---------------");

        System.out.println("---------------ParallelFlowable---------------");

    }
}
