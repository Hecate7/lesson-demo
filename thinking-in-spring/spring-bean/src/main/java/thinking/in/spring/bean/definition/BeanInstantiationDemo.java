package thinking.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.ioc.overview.domain.User;

/**
 * Bean实例化
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        //配置Spring上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-instantiation-context.xml");

        //1.通过静态方法进行构建
        User user = beanFactory.getBean("user-by-static-method", User.class);
        System.out.println(user);
        //2.通过实例方法进行构建
        User user1 = beanFactory.getBean("user-by-instance-method", User.class);
        System.out.println(user1);
        System.out.println(user==user1);
        //3.通过FactoryBean进行构建
        User user2 = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(user2);
        System.out.println(user==user2);
    }
}
