package study.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置是4大核心函数式接口
 * 消费型接口 Consumer<T>  void accept(T t)
 * 供给型接口 Supplier<T> T get()
 * 函数型接口 Function<T> R apply(T t)
 * 断定型接口 Predicate<T> boolean test(T t)
 *
 * @className: LambdaTest2
 * @author: crowgzy
 * @date: 2023/3/20
 **/
public class LambdaTest2 {

    @Test
    public void test(){
        double money = 100.2;
        happyTime(money,(a) -> {System.out.println("花费"+ a);});
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test1(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普金");
        List<String> list1 = filterString(list, string -> string.contains("京"));
        System.out.println(list1);
    }
    //根据规则过滤字符串
    public List<String> filterString(List<String> stringList, Predicate<String> stringPredicate){
        ArrayList<String> arrayList = new ArrayList<>();
        stringList.forEach( (string) -> {
           if (stringPredicate.test(string)) {
               arrayList.add(string);
           }
        });
        return arrayList;
    }

}
