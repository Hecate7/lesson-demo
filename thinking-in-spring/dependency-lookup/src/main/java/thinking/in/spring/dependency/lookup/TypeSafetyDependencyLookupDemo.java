package thinking.in.spring.dependency.lookup;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import thinking.in.spring.ioc.overview.domain.User;

public class TypeSafetyDependencyLookupDemo {
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类作为配置类
        applicationContext.register(TypeSafetyDependencyLookupDemo.class);
        //启动应用上下文
        applicationContext.refresh();

        //BeanFactory#getBean不安全性
        displayBeanFactoryGetBean(applicationContext);
        //ObjectFactory#getObject不安全性
        displayObjectFactoryGetObject(applicationContext);
        //ObjectProvider#getIfAvailable安全性
        displayObjectProviderGetIfAvailable(applicationContext);


        //ListableBeanFactory#getBeansOfType的安全性
        displayListableBeanFactoryGetBeansOfType(applicationContext);
        //ObjectProvider#stream的安全性
        displayObjectProviderStream(applicationContext);
        //关闭应用上下文
        applicationContext.close();
    }

    private static void displayObjectProviderStream(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
        printBeanException("displayObjectProviderStream", ()->{
            beanProvider.forEach(System.out::println);
        });
        beanProvider.stream();
    }

    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory listableBeanFactory) {
        printBeanException("displayListableBeanFactoryGetBeansOfType", ()->listableBeanFactory.getBeansOfType(User.class));


    }

    private static void displayObjectProviderGetIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
        printBeanException("displayObjectProviderGetIfAvailable", ()-> beanProvider.getIfAvailable());
    }

    public static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
        printBeanException("displayObjectFactoryGetObject", ()->beanProvider.getObject());

    }

    public static void displayBeanFactoryGetBean(BeanFactory beanFactory){
        printBeanException("displayBeanFactoryGetBean", () -> beanFactory.getBean(User.class));
    }

    private static void printBeanException(String message, Runnable runnable){
        System.err.println("#################################");
        System.err.println("source from " + message);
        try {
            runnable.run();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
