package thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import thinking.in.spring.ioc.overview.domain.User;

import javax.annotation.Resource;

/**
 * 字段注入-Java注解配置元信息
 */
public class AnnotationDependencyFieldInjectionDemo {

    @Autowired //@Autowired会忽略静态字段
    private UserHolder userHolder;
    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册配置类-Spring Java Bean
        applicationContext.register(AnnotationDependencyFieldInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String classpath = "classpath:/META-INF/dependency-lookup-context.xml";
        //加载XML、资源、解析并且生成BeanDefinition
        reader.loadBeanDefinitions(classpath);
        //启动Spring应用上下文
        applicationContext.refresh();

        //通过依赖查找AnnotationDependencyFieldInjectionDemo Bean
        AnnotationDependencyFieldInjectionDemo demo = applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);
        //@Autowired字段关联
        UserHolder userHolder = demo.userHolder;
        System.out.println(userHolder);
        System.out.println(demo.userHolder2);
        //指向同一个对象
        System.out.println(demo.userHolder==demo.userHolder2);

        //显示关闭Spring应用上下文
        applicationContext.close();


    }

    @Bean
    public UserHolder userHolder(User user){
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }
}
