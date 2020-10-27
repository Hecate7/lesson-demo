package thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import thinking.in.spring.ioc.overview.domain.User;

import javax.annotation.Resource;

/**
 * 方法注入-Java注解配置元信息
 */
public class AnnotationDependencyMethodInjectionDemo {

    private UserHolder userHolder;

    private UserHolder userHolder2;

    @Autowired
    public void init(UserHolder userHolder){
        this.userHolder = userHolder;
    }

    @Resource
    public void init2(UserHolder userHolder){
        this.userHolder2 = userHolder;
    }

    @Bean
    public UserHolder userHolder(User user){
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册配置类-Spring Java Bean
        applicationContext.register(AnnotationDependencyMethodInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String classpath = "classpath:/META-INF/dependency-lookup-context.xml";
        //加载XML、资源、解析并且生成BeanDefinition
        reader.loadBeanDefinitions(classpath);
        //启动Spring应用上下文
        applicationContext.refresh();

        //通过依赖查找AnnotationDependencyFieldInjectionDemo Bean
        AnnotationDependencyMethodInjectionDemo demo = applicationContext.getBean(AnnotationDependencyMethodInjectionDemo.class);
        //@Autowired字段关联
        UserHolder userHolder = demo.userHolder;
        System.out.println(userHolder);
        System.out.println(demo.userHolder2);
        //指向同一个对象
        System.out.println(demo.userHolder==demo.userHolder2);

        //显示关闭Spring应用上下文
        applicationContext.close();


    }


}
