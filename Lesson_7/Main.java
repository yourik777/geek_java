package Lesson_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        processing(TestClass.class);

    }

    public static void processing (Class c) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = c.getDeclaredMethods();
        List<Method> list = new ArrayList<Method>();
        for (Method m: methods) {
            if(m.isAnnotationPresent(Test.class)){
                int priority = m.getAnnotation(Test.class).priority();
                if(priority < 1 || priority > 10) throw new RuntimeException("Priority ERROR");
                list.add(m);
            }

        }
        list.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });
        for (Method m: methods) {
            if(m.isAnnotationPresent(BeforeSuite.class)){
                if(list.get(0).isAnnotationPresent(BeforeSuite.class))
                    throw new RuntimeException("BeforeSuite exception");
                list.add(0, m);
            }
            if(m.isAnnotationPresent(AfterSuite.class)){
                if(list.get(list.size()-1).isAnnotationPresent(AfterSuite.class))
                    throw new RuntimeException("AfterSuite exception");
                list.add(m);
            }


        }
        for (Method l: list) {
            l.invoke(null);
        }
    }
}
