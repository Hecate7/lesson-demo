package thinking.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.ioc.overview.domain.User;

public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-definition-context.xml");

        User user = (User) beanFactory.getBean("user");
        User userAlias = (User) beanFactory.getBean("lrq-user");
        System.out.println("user == userAlias: "+ (user==userAlias));

    }
}
