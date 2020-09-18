package thinking.in.spring.ioc.overview.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.ioc.overview.annotation.Super;
import thinking.in.spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * 依赖查找的方式
 * 1.通过名称查找:实时查找+延迟查找
 * 2.通过类型查找:单个对象+集合对象
 * 3.通过名称+类型进行查找
 * 4.通过注解查找
 */
public class DependencyLookUpDemo {
    public static void main(String[] args) {
        /**
         * 1.配置XML配置文件
         * 2.启动Spring应用上下文
         */
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
//        lookupByType(beanFactory);
//        lookupByCollectionType(beanFactory);
//        lookupInRealTime(beanFactory);
//        lookupInLazy(beanFactory);
        lookupByAnnotation(beanFactory);
    }

    /**
     * 通过注解来查找
     * @param beanFactory
     */
    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> beans = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("所有标注@Super对象: "+beans.toString());
        }
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory factory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = factory.getBeansOfType(User.class);
            System.out.println("查找到的所有User集合对象: "+users.toString());
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找: "+user.toString());
    }

    /**
     * 名称实时查找
     * @param beanFactory
     */
    private static void lookupInRealTime(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找: "+user.toString());
    }

    /**
     * 名称延迟查找
     * @param beanFactory
     */
    private static void lookupInLazy(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找: "+user.toString());

    }
}
