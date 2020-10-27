package thinking.in.spring.dependency.lookup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoUniqueBeanDefinitionExceptionDemo {
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类作为配置类
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);
        //启动应用上下文
        applicationContext.refresh();
    }

}
