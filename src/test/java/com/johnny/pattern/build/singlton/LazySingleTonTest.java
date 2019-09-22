package com.johnny.pattern.build.singlton;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wjq
 * date:  2019/9/22 2:31
 * description: LazySingleTonTest
 **/
public class LazySingleTonTest {

    /**
     * 使用debug重现多线程问题
     * 在{@link LazySingleTon#getInstance()} null判断之后处打上断点
     */

    @Test
    public void test() throws ExecutionException, InterruptedException {
        Callable<LazySingleTon> callable = LazySingleTon::getInstance;
        FutureTask<LazySingleTon> futureTask1 = new FutureTask<>(callable);
        FutureTask<LazySingleTon> futureTask2 = new FutureTask<>(callable);
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        Assert.assertTrue(futureTask1.get() == futureTask2.get());
    }



}
