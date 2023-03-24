package study.java8.streamStudy;

import org.junit.Test;
import study.java8.study2.Employee;
import study.java8.study2.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @className: StreamAPITest1
 * @author: crowgzy
 * @date: 2023/3/24
 **/
public class StreamAPITest1 {
    //1-筛选与切片

    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
//        filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
        //练习:得到list中工资大于七千的员工
        Stream<Employee> stream = list.stream();
        stream.filter(employee -> employee.getSalary()>7000).forEach(System.out::println);
        System.out.println();
//        limit(long maxSize) 截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();
//        skip(long n)跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();
//        distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素(去重)
        list.add(new Employee(1010,"刘强西",40,8000));
        list.add(new Employee(1010,"刘强西",40,8000));
        list.add(new Employee(1010,"刘强西",40,8000));
        list.add(new Employee(1010,"刘强西",40,8000));
        list.add(new Employee(1010,"刘强西",40,8000));
        list.stream().distinct().forEach(System.out::println);
    }

    //2-映 射

    @Test
    public void test2(){

        //map(Function f)接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        Arrays.asList("aa","bb","cc","dd").stream().map(string -> string.toUpperCase()).forEach(System.out::println);
        //练习:获取员工名字长度大于三的员工名字
        EmployeeData.getEmployees().stream().map(Employee::getName).filter(s -> s.length()>3).forEach(System.out::println);
        //flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
    }

    //3-排序

    @Test
    public void test3(){
//        sorted() 产生一个新流，其中按自然顺序排序
        Arrays.asList(433,34,3,2,34,3,42,3,4,4,45,4,56,655,76,85).stream().sorted().forEach(System.out::println);
        System.out.println("*******************************");
//        sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        Arrays.asList(433,34,3,2,34,3,42,3,4,4,45,4,56,655,76,85).stream().sorted((t1,t2) -> {return t2-t1;}).forEach(System.out::println);
    }
}
