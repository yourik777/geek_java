package Lesson_7;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class DZ_2 {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        DZ_2 dz2 = new DZ_2();
        dz2.test();

    }

    public void test() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        File file = new File("C:/geek");
        String[] fileList = file.list();

        ArrayList<String> fileName = new ArrayList<>();

        for (String f: fileList) {
            String[] mass = f.split("\\.");
            if (mass[1].equalsIgnoreCase("class")){
                fileName.add(mass[0]);
            }

        }

        for (int i = 0; i < fileName.size(); i++) {
            String name = String.valueOf(fileName.get(i));
            Class clas = URLClassLoader.newInstance(new URL[]{new File("C:/geek").toURL()}).loadClass(name);
            Constructor constructor = clas.getConstructor();
            Object obj = constructor.newInstance();

            Method m = clas.getDeclaredMethod("obj", int.class, int.class, int.class, int.class);
            int res = (Integer) m.invoke(obj, 1,2,3,4);
            System.out.println(res);
        }

    }
}
