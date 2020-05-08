package cuibo.Mypackage;

import java.io.IOException;
import java.util.Properties;

public class PropertyManage {
    //这个东西可以用来读取在同一目录下面的txt文件，
    private static Properties property;
    static {
        try {
            property=new Properties();
            property.load(PropertyManage.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 真心搞不清楚返回值到底是什么类型的
     * @param input
     * @return
     */

    public static int getNumber(String input) {
        return Integer.parseInt((String) property.get(input));
    }
    public static  String get(String input)
    {
        return (String) property.get(input);
    }
    public static void main(String[] args) {
        System.out.println(get("tankFireStrategy"));
    }
}
