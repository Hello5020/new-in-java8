package study.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @className: LambdaTest1
 * 格式:
 *  ->:lambda操作符
 *  ->左边:lambda形参列表(就是接口中抽象方法的列表)
 *  ->右边:lambda体(就是重写抽象方法的方法体)
 *  lambda的使用方法:(6种方法)
 *  lambda的本质是作为函数式接口的实例
 *
 *      总结:
 *      ->左边:lambda的形参列表类型可以省略;如果参数列表只有一个参数小括号可以省略
 *      ->右边:lambda体应该有一对{}进行包裹;如果lambda体只有一条执行语句就可以省略大括号和return
 *        接口里面必须只有一个抽象方法才能使用lambda表达式(即函数式接口)
 *
 * @author: crowgzy
 * @date: 2023/3/18
 **/
public class LambdaTest1 {
    //语法格式1:无参无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        };
        r1.run();

        System.out.println("+++++++++++++++++++++++++++");
        Runnable r2 = () -> System.out.println("hello2");
        r2.run();
    }

    //语法格式2:有参无返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("haha");
        System.out.println("+++++++++++++++++++++++++++");
        Consumer<String> con1 = (String s) -> System.out.println(s);
        con1.accept("lili");
    }

    //语法格式3:数据类型可以省略,可以由编译器推断得出,称为"类型推断"
    @Test
    public void test3(){
        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("lili");
    }

    @Test
    public void test4(){
        ArrayList<String> arrayList = new ArrayList<>();//此时等号右边的尖括号为类型推断
    }
    //语法格式4:Lambda只需要一个参数时小括号可以省略
    @Test
    public void test5(){
        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("lili");
    }
    //语法格式5:Lambda需要两个个参数,多条执行语句,并有返回值
    @Test
    public void test6(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1,o2);
            }

        };
        int compare1 = com1.compare(12, 21);
        System.out.println("+++++++++++++++++++++++++++");
        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };
        int compare2 = com2.compare(32, 12);
        System.out.println(compare2);
        System.out.println("+++++++++++++++++++++++++++");
    }
    //语法格式6:Lambda只有一条执行语句,return与大括号若有可以省略
    @Test
    public void test7(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }

        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);
        System.out.println("+++++++++++++++++++++++++++");
        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        int compare2 = com2.compare(32, 12);
        System.out.println(compare2);
    }

}

