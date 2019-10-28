package psn.pengfei.zhao.rxjava;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Test.class);
        Flowable.fromCallable(() -> {
            Thread.sleep(3000);
            String msg = "task done after 3 seconds";
            logger.info(msg);
            logger.info("thread:{}", Thread.currentThread().getClass());
            return msg;
        }).subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation()).subscribe(str -> logger.info("msg: {}", str));
        Thread.sleep(3100);
    }
}
