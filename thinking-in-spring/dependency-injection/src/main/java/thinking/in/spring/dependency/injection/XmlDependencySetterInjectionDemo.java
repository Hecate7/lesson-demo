package thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class XmlDependencySetterInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String classpath = "classpath:/META-INF/dependency-setter-injection.xml";
        //加载XML、资源、解析并且生成BeanDefinition
        reader.loadBeanDefinitions(classpath);

        //依赖查找并创建Bean
        UserHolder bean = beanFactory.getBean(UserHolder.class);
        System.out.println(bean);


    }
}
