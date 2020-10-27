package thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@Configuration是非必须的
public class HierarchicalDependencyLookupDemo {
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类作为配置类
        applicationContext.register(HierarchicalDependencyLookupDemo.class);
        //启动应用上下文
        applicationContext.refresh();

        //1.获取Hierarchical Bean Factroy <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("当前BeanFactory的parent BeanFactory："+beanFactory.getParentBeanFactory());
        //2.设置parent Bean Factory
        HierarchicalBeanFactory parentBeanFactory = (HierarchicalBeanFactory) createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);
        System.out.println("当前BeanFactory的parent BeanFactory："+beanFactory.getParentBeanFactory());
        //
        displayContainsLocalBean(beanFactory, "user");
        displayContainsLocalBean(parentBeanFactory, "user");
        //
        displayContainsBean(beanFactory, "user");
        displayContainsBean(parentBeanFactory, "user");
        //关闭应用上下文
        applicationContext.close();
    }

    private static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName){
        System.out.printf("当前BeanFactory{%s}是否包含bean{name:%s}: %s\n", beanFactory, beanName, containsBean(beanFactory, beanName));
    }


    private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName){
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory){
            HierarchicalBeanFactory hierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if (containsBean(hierarchicalBeanFactory, beanName)){
                return true;
            }
        }

        return beanFactory.containsLocalBean(beanName);
    }

    private static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory, String beanName){
        System.out.printf("当前BeanFactory{%s}是否包含bean{name:%s}: %s\n", beanFactory, beanName, beanFactory.containsLocalBean(beanName));
    }

    private static BeanFactory createParentBeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(location);

        return beanFactory;
    }
}
