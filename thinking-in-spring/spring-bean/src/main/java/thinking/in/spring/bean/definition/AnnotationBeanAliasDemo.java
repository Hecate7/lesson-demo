package thinking.in.spring.bean.definition;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import thinking.in.spring.ioc.overview.domain.User;

import java.util.Map;


@Import(AnnotationBeanAliasDemo.Config.class)
public class AnnotationBeanAliasDemo {
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //通过BeanDefinition注册API实现
        registerUserBeanDefinition(applicationContext);
        registerUserBeanDefinition(applicationContext, "xxl-user");

        //1.通过@Bean方式定义
        //1. 注册(Configuration Class-代替XML文件)配置类
        //2.通过@Component方式
        //3.通过@Import方式
        applicationContext.register(Config.class);

        applicationContext.refresh();

        Map<String, Config> configBeans = applicationContext.getBeansOfType(Config.class);
        System.out.println("Config Beans: "+ configBeans);
        Map<String, User> userBeans = applicationContext.getBeansOfType(User.class);
        System.out.println("User Beans: "+ userBeans);
        applicationContext.close();
    }

    /**
     * 命名Bean的注册方式
     * @param registry
     * @param name
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String name){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", "1")
                .addPropertyValue("name", "nameeee");

        //判断name是否存在
        if (StringUtils.hasText(name)){
            //命名的方式
            registry.registerBeanDefinition(name, beanDefinitionBuilder.getBeanDefinition());
        } else {
            //非命名的方式
            BeanDefinitionReaderUtils.generateBeanName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }

    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry){
        registerUserBeanDefinition(registry, null);
    }

    //定义当前作为一个Spring Bean组件
    @Component
    public static class  Config{
        /**
         * 通过Java注解的方式定义了一个Bean
         * @return
         */
        @Bean(name = {"user","alias"})
        public User user(){
            User user = new User();
            user.setId("1");
            user.setName("name");
            return user;
        }
        /**
         * 方法被Spring引用上下文感知
         * 1.配置类
         * 2.Component方式
         */
    }



}
