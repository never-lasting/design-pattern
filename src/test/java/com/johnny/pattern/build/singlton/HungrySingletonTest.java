package com.johnny.pattern.build.singlton;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wjq
 * date:  2019/9/22 2:15
 * description: HungrySingletonTest
 **/
public class HungrySingletonTest {

    @Test
    public void test() {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        Assert.assertTrue(instance == instance2);
    }


    // 瑕疵1
    // 构造器私有并不能安全阻止外部创建对象
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<HungrySingleton> clazz = HungrySingleton.class;
        Constructor<HungrySingleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        HungrySingleton hungrySingleton1 = constructor.newInstance();
        HungrySingleton hungrySingleton2 = constructor.newInstance();
        Assert.assertTrue(hungrySingleton1 == hungrySingleton2);
    }

    // 瑕疵2
    // 反序列化会生成一个新的对象
    @Test
    public void test3() {
        HungrySingleton instance = HungrySingleton.getInstance();
        String filePath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "instance.obj";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            oos.writeObject(instance);
            Object obj = ois.readObject();
            Assert.assertTrue(instance == obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
