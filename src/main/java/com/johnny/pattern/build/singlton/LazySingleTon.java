package com.johnny.pattern.build.singlton;

/**
 * @author wjq
 * date:  2019/9/22 2:20
 * description: LazySingleTon
 **/
public final class LazySingleTon {

    private static LazySingleTon SINGLETON = null;

    /**
     * private constructor
     * make sure the instance of HungrySingleton can only be created in this class.
     */
    private LazySingleTon() {
    }

    /**
     * note that this way is not thread-safe
     * @return the SINGLETON instance
     */
    public static LazySingleTon getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new LazySingleTon();
            return SINGLETON;
        }
        return SINGLETON;
    }

}
