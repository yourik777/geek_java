package Lesson_7;

public class TestClass {
    public static void met1(){
        System.out.println("met1");
    }
    @BeforeSuite
    public static void start(){
        System.out.println("start");
    }
    @Test(priority = 9)
    public static void met2(){
        System.out.println("met2");
    }
    @Test(priority = 5)
    public static void met3(){
        System.out.println("met3");
    }
    @Test(priority = 3)
    public static void met4(){
        System.out.println("met4");
    }
    @AfterSuite
    public static void stop(){
        System.out.println("stop");
    }
}
