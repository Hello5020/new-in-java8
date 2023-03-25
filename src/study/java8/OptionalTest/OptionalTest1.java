package study.java8.OptionalTest;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类:为了防止程序中出现空指针异常而创建
 * @className: OptionalTest1
 * @author: crowgzy
 * @date: 2023/3/25
 **/
public class OptionalTest1 {

    //创建Optional类对象的方法：
    // Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
    // Optional.empty() : 创建一个空的 Optional 实例
    // Optional.ofNullable(T t)：t可以为null

    @Test
    public void test1(){
        Girl girl = new Girl();
        //t必须非空；
        Optional.of(girl);
    }
    @Test
    public void test2(){
        Girl girl = new Girl();
        girl.setName("jojo");
        System.out.println(Optional.ofNullable(girl));
        girl = null;
        System.out.println(Optional.ofNullable(girl));
    }

   public String getGirlName(Boy boy){
        return boy.getGirl().getName();
   }

   //会发生空指针异常(test3)

    @Test
    public void test3(){
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化,防止空指针异常

    public String getGirlName1(Boy boy){
        if (boy == null) {
            return null;
        }
        if (boy.getGirl() == null){
            return null;
        }
        return boy.getGirl().getName();
    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }


//     T get(): 如果调用对象包含值，返回该值，否则抛异常
// T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象。
//             T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由
//    Supplier接口实现提供的对象。
//             T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返
//    回，否则抛出由Supplier接口实现提供的异常。
    //使用Optional类实现避免空指针异常
//     boolean isPresent() : 判断是否包含对象
// void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer
//    接口的实现代码，并且该值会作为参数传给它。

    public String getGirlName2(Boy boy){
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("lalala")));
        Optional<Girl> girl = Optional.ofNullable(boy1.getGirl());
        Girl girl1 = girl.orElse(new Girl("lilili"));
        return girl1.getName();
    }
    @Test
    public void test5(){
        Boy boy = null;
        boy = new Boy();
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }
}
