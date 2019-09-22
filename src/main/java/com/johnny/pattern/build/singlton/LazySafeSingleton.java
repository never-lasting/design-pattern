package com.johnny.pattern.build.singlton;

/**
 * @author wjq
 * date:  2019/9/22 2:58
 * description: LazySafeSingleton
 **/
public final class LazySafeSingleton {

    private static LazySafeSingleton SINGLETON = null;

    /**
     * private constructor
     * make sure the instance of HungrySingleton can only be created in this class.
     */
    private LazySafeSingleton() {
    }

    /**
     * thread-safe but not perform well
     * @return the SINGLETON instance
     */
    public static synchronized LazySafeSingleton getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new LazySafeSingleton();
            return SINGLETON;
        }
        return SINGLETON;
    }

    // 双重校验锁
    public static LazySafeSingleton getInstance2() {
        if (SINGLETON == null) {
            synchronized (LazySafeSingleton.class) {
                if (SINGLETON == null) {
                    SINGLETON = new LazySafeSingleton();
                }
            }
        }
        return SINGLETON;
    }
}
