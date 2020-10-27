package thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thinking.in.spring.dependency.injection.annotation.UserGroup;
import thinking.in.spring.ioc.overview.domain.User;

import java.util.Collection;

/**
 * Qualifier注解依赖注入
 */
public class QualifierAnnotationDependencyInjectionDemo {

    //整体应用上下文存在4个user Bean:superUser、User、User1、User2
    @Autowired
    private User user;

    @Autowired
    @Qualifier("user")
    private User namedUser;

    @Bean
    @Qualifier
    public User user1(){
        return createUser(7L);
    }

    @Bean
    @Qualifier
    public User user2(){
        return createUser(8L);
    }

    @Bean
    @UserGroup
    public User user3(){
        return createUser(9L);
    }

    @Bean
    @UserGroup
    public User user4(){
        return createUser(10L);
    }

    @Autowired
    private Collection<User> allUsers;

    @Autowired
    @Qualifier
    private Collection<User> qualifierUsers;

    @Autowired
    @UserGroup
    private Collection<User> userGroupUsers;

    private static User createUser(long id){
        User user = new User();
        user.setId(id);
        return user;
    }

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册配置类-Spring Java Bean
        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String classpath = "classpath:/META-INF/dependency-lookup-context.xml";
        //加载XML、资源、解析并且生成BeanDefinition
        reader.loadBeanDefinitions(classpath);
        //启动Spring应用上下文
        applicationContext.refresh();

        //通过依赖查找AnnotationDependencyFieldInjectionDemo Bean
        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);

        System.out.println(demo.allUsers);
        System.out.println();
        System.out.println(demo.qualifierUsers);
        System.out.println();
        System.out.println(demo.userGroupUsers);

        //显示关闭Spring应用上下文
        applicationContext.close();


    }
}
