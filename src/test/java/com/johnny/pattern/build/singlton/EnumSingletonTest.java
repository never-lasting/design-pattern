package com.johnny.pattern.build.singlton;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * @author wjq
 * date:  2019/9/22 14:11
 * description: EnumSingletonTest
 **/
public class EnumSingletonTest {

    // 测试发序列化问题
    @Test
    public void test2() {
        EnumSingleton instance = EnumSingleton.SINGLETON_INSTANCE;
        String filePath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "instance.obj";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            oos.writeObject(instance);
            oos.flush();
            Object obj = ois.readObject();
            Assert.assertTrue(instance == obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        System.out.println(Enum.valueOf(EnumSingleton.class, "SINGLETON_INSTANCE"));
    }
}
