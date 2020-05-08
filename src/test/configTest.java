package test;

import java.io.IOException;
import java.util.Properties;

public class configTest {
    /**
     * 用来测试配置文件
     * 读取配置文件
     *
     * @param args
     */

    public static void main(String[] args) throws IOException {
        Properties property = new Properties();
        property.load(configTest.class.getClassLoader().getResourceAsStream("config"));

        String str = (String) property.get("initTankCount");
        System.out.println(str);

    }


}