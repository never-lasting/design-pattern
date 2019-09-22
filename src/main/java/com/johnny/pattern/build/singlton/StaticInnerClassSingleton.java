package com.johnny.pattern.build.singlton;

/**
 * @author wjq
 * date:  2019/9/22 3:15
 * description: StaticInnerClassSingleton
 **/
public final class StaticInnerClassSingleton {

    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton() {
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }

}
