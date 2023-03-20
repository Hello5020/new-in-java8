package study.java8.study2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Locale;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *	1.使用情境: 当要传递给Lambda体的操作,已经有实现方法了,可以使用方法引用
 *	2.方法引用本质上就是lambda表达式
 *
 * 	3.使用格式:	类(或者对象) :: 方法名
 *
 * 	4.具体分为如下三种情况
 * 		a.对象 :: 非静态方法
 * 		b.类 :: 静态方法
 * 		c.类 :: 非静态方法
 *
 * 	5.方法引用的使用要求:要求接口中的抽象方法的形参列表和返回值类型和方法引用的
 * 	形参列表和返回值类型相同(主要针对a,b)
 * Created by crow.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> con1 = str -> System.out.println(str);
		con1.accept("beijing");
		System.out.println("***************");
		PrintStream printStream = System.out;
		Consumer<String> con2 = printStream::println;
		con2.accept("北京");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee employee = new Employee();
		employee.setName("Bob");
		Supplier<String> supplier = ()-> employee.getName();
		System.out.println(supplier.get());
		System.out.println("***************");
		Supplier<String> supplier1 = employee::getName;
		System.out.println(supplier1.get());
	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> comparator = (t1,t2)->Integer.compare(t1,t2);
		System.out.println("***************");
		Comparator<Integer> comparator1 = Integer::compare;
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {

		Function<Double, Long> function = (t)->Math.round(t);
		System.out.println("***************");
		Function<Double, Long> function1 = Math::round;
	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> comparator = (t1,t2)->t1.compareTo(t2);
		System.out.println("***************");
		Comparator<String> comparator1 = String::compareTo;
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String,String> predicate = (t1,t2)-> t1.equals(t2);
		BiPredicate<String,String> predicate1 = String::equals;
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Function<Employee,String> func = (t) -> t.getName();
		System.out.println(func.apply(new Employee(10000, "bob", 43, 2489)));
		Function<Employee,String> func1 = Employee::getName;
		System.out.println(func.apply(new Employee(10000, "bob", 43, 2489)));
	}

}
