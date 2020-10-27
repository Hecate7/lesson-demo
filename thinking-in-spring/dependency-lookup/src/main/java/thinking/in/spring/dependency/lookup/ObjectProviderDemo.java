package thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import thinking.in.spring.ioc.overview.domain.User;

//@Configuration是非必须的
public class ObjectProviderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();

        lookupByObjectProvider(applicationContext);

        lookupIfAvaiable(applicationContext);

        lookupByStream(applicationContext);

        applicationContext.close();
    }

    private static void lookupByStream(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        beanProvider.stream().forEach(System.out::println);
//        Iterable<String> iterable = beanProvider;
//        for (String s : iterable) {
//            System.out.println(s);
//        }
    }

    private static void lookupIfAvaiable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        User user = userObjectProvider.getIfAvailable(User::createUser);
        System.out.println("当前User对象："+user);
    }

    @Bean
    @Primary
    //方法名就是Bena的名称
    public String helloWorld(){
        return "hello, world";
    }

    @Bean
    public String message(){
        return "message";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        //处理多类型时使用
//        applicationContext.getBeanProvider()
        System.out.println(objectProvider.getObject());
    }
}
