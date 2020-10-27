package thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import thinking.in.spring.ioc.overview.domain.User;

public class ApiDependencySetterInjectionDemo {
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册UserHolder的BeanDefinition
        BeanDefinition beanDefinition = createUserHolderBeanDefinition();
        applicationContext.registerBeanDefinition("userHolder", beanDefinition);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String classpath = "classpath:/META-INF/dependency-lookup-context.xml";
        //加载XML、资源、解析并且生成BeanDefinition
        reader.loadBeanDefinitions(classpath);
        //启动Spring应用上下文
        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);

        //显示关闭Spring应用上下文
        applicationContext.close();


    }

    private static BeanDefinition createUserHolderBeanDefinition(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        beanDefinitionBuilder.addPropertyReference("user", "superUser");
        return beanDefinitionBuilder.getBeanDefinition();
    }

//    @Bean
//    public UserHolder userHolder(User user){
//        UserHolder userHolder = new UserHolder();
//        userHolder.setUser(user);
//        return userHolder;
//    }
}
