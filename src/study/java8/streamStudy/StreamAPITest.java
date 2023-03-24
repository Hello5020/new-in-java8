package study.java8.streamStudy;

import org.junit.Test;
import study.java8.study2.Employee;
import study.java8.study2.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.Stream关注的是对数据的运算,与cpu打交道
 *  集合关注的数据的存储,与内存打交道
 *
 * 2.
 *  Stream自己不会存储元素
 *  Stream不会改变源对象.相反,他们会返回一个持有结构的新Stream
 *  Stream操作时延迟执行的.意味着他们会等到需要结果的时候才执行
 *
 * 3.Stream的执行流程
 *  (1).Stream的序列化
 *  (2).一系列的中间操作(过滤,映射,....)
 *  (3).终止操作
 *
 * 4.说明
 *  4.1 一个中间操作链,对数据源的数据进行处理
 *  4.2 一旦执行终止操作,就执行中间操作链,并产生结果,之后,不能再被使用
 *
 *      测试Stream的实例化
 * @className: StreamAPITest
 * @author: crowgzy
 * @date: 2023/3/24
 **/
public class StreamAPITest {

    //创建Stream方式1: 通过集合

    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream(): 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream(): 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    //创建Stream方式2: 通过数组

    @Test
    public void test2(){
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(new int[]{1, 2, 3});
        Employee e1 = new Employee(1001,"adfa");
        Employee e2 = new Employee(1002,"adfadasf");
        Employee[] employees = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(employees);
    }

    //创建Stream方式3: 通过Stream的of()

    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建Stream方式4: 创建无限流

    @Test
    public void  test4(){
        //迭代 public static <T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
        //遍历前十个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //生成 public static <T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
