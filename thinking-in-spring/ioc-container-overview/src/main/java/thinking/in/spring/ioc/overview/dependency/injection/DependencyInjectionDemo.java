package thinking.in.spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import thinking.in.spring.ioc.overview.annotation.Super;
import thinking.in.spring.ioc.overview.domain.User;
import thinking.in.spring.ioc.overview.repository.UserRepository;

import java.util.Map;

/**
 * 依赖注入的方式
 * 1.通过名称注入:实时注入+延迟注入
 * 2.通过类型注入:单个对象+集合对象
 * 3.通过名称+类型进行注入
 * 4.通过注解注入
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        /**
         * 1.配置XML配置文件
         * 2.启动Spring应用上下文
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");

        //1.Bean来源-自定义Bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository.getUsers());

        /**
         * 对象不等-DefaultListableBeanFactory
         * 注入内建对象
         */
        //        System.out.println(userRepository.getBeanFactory()==beanFactory);
        //依赖注入(2.Bean来源-内建依赖)
        System.out.println(userRepository.getBeanFactory());

        ObjectFactory userObjectFactory = userRepository.getObjectFactory();
        System.out.println(userObjectFactory.getObject());
        System.out.println(userObjectFactory.getObject()==beanFactory);
        //依赖查找
//        System.out.println(beanFactory.getBean(BeanFactory.class));
        //3.Bean来源-容器内建Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);
    }
}
