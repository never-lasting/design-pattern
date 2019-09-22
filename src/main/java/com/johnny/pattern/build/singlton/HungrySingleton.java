package com.johnny.pattern.build.singlton;

import java.io.Serializable;

/**
 * @author wjq
 * date:  2019/9/22 1:57
 * description: HungrySingleton
 **/
public final class HungrySingleton implements Serializable {

    private static final long serialVersionUID = -2891065107778310790L;

    private static final HungrySingleton SINGLETON  = new HungrySingleton();

    /**
     * private constructor
     * make sure the instance of HungrySingleton can only be created in this class.
     */
    private HungrySingleton() {
    }

    /**
     * since other classes cannot create HungrySingleton instance
     * provide a static method to expose the SINGLETON instance
     * @return the SINGLETON instance
     */
    public static HungrySingleton getInstance() {
        return SINGLETON;
    }

}
