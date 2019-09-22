package com.johnny.pattern.build.singlton;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wjq
 * date:  2019/9/22 14:11
 * description: EnumSingletonTest
 **/
public class EnumSingletonTest {

    @Test
    public void test1() {
        Assert.assertTrue(EnumSingleton.SINGLETON_INSTANCE == EnumSingleton.SINGLETON_INSTANCE);
    }
}
