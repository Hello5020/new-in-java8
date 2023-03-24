package study.java8.study2;

import org.junit.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      和方法引用类似,函数式接口的抽象方法的形参列表和构造器的形参列表一致
 *      抽象方法的返回值类型即为构造器所返回的类
 * 二、数组引用
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
        Supplier<Employee> supplier = () -> new Employee();
        Employee employee = supplier.get();
        System.out.println("*********************");
        Supplier<Employee> supplier1 = Employee::new;
        Employee employee1 = supplier1.get();
    }

	//Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer, Employee> func = id -> new Employee(id);
        Employee employee = func.apply(10086);
        System.out.println(employee);
        System.out.println("*********************");
        Function<Integer, Employee> func1 = Employee::new;
        Employee employee1 = func1.apply(10087);
        System.out.println(employee1);
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> biFunction = (id,name) -> new Employee(id,name);
        System.out.println(biFunction.apply(100887, "钱玉玲"));
        System.out.println("*********************");
        BiFunction<Integer,String,Employee> biFunction1 = Employee::new;
        System.out.println(biFunction.apply(100886, "钱御灵"));
    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer, String[]> func1 = (length) -> new String[length];
        System.out.println("*********************");
        Function<Integer, String[]> func2 = String[]::new;   }

}
