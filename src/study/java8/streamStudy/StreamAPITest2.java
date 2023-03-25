package study.java8.streamStudy;

import org.junit.Test;
import study.java8.study2.Employee;
import study.java8.study2.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream 的终止操作
 *
 *
 * @className: StreamAPITest2
 * @author: crowgzy
 * @date: 2023/3/24
 **/
public class StreamAPITest2 {

    //1-匹配与查找
    @Test
    public void test(){
//        allMatch(Predicate p) 检查是否匹配所有元素
        //练习是否所有的员工的年龄都大于18

        boolean match = EmployeeData
                .getEmployees().stream()
                .allMatch(employee -> employee.getAge() > 18);
        System.out.println(match);
//        anyMatch(Predicate p) 检查是否至少匹配一个元素
        //练习是否存在员工的工资都大于10000
        boolean x = EmployeeData
                .getEmployees().stream()
                .anyMatch(employee -> employee.getSalary() > 10000);
        System.out.println(x);
//        noneMatch(Predicate p) 检查是否没有匹配所有元素
        //练习:是否有员工姓"雷"
        boolean noneMatch = EmployeeData
                .getEmployees().stream().noneMatch(employee -> employee.getName().contains("雷"));
        System.out.println(noneMatch);
//        findFirst() 返回第一个元素

//        findAny() 返回当前流中的任意元素
//        count() 返回流中元素总数
//        max(Comparator c) 返回流中最大值
        //练习:返回最高工资
        Optional<Double> max = EmployeeData
                .getEmployees().stream().map(employee -> employee.getSalary()).max(Double::compareTo);
        System.out.println(max);
//        min(Comparator c) 返回流中最小值
        Optional<Employee> min = EmployeeData
                .getEmployees().stream().min((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()));
        System.out.println(min);
        //练习:返回最高工资的员工
//        forEach(Consumer c)
//        内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，StreamAPI使用内部迭代——它帮你把迭代做了)
    }

//2-归约
    @Test
    public void test2(){
        //reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
        //练习1:计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        //reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        //练习2:计算公司所有员工的工资总和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(employee -> employee.getSalary()).reduce(Double::sum);
        System.out.println(reduce1);
    }

    //3-收集

    @Test
    public void test3(){
        //collect(Collector c)将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习1:查找工资大于6000的员工,结果返回为一个List或set
        List<Employee> collect = EmployeeData.getEmployees().stream()
                .filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}

