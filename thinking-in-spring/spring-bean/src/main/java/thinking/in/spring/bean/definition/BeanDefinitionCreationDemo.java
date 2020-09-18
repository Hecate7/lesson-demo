package thinking.in.spring.bean.definition;


import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import thinking.in.spring.ioc.overview.domain.User;

public class BeanDefinitionCreationDemo {
    /**
     * 构建BeanDefinition：
     * 1.通过BeanDefinitionBuilder
     * 2.通过AbstractBeanDefinition以及派生类
     *
     */
    public static void main(String[] args) {
        //1.通过BeanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //通过属性设置
        beanDefinitionBuilder
                .addPropertyValue("id",1)
                .addPropertyValue("name", "lrq");
        //获取实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //beanDefinition并非Bean的最终状态，可以自定义修改


        //2.通过AbstractBeanDefinition以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置Bean类型
        genericBeanDefinition.setBeanClass(User.class);
        //通过MutablePropertyValues进行批量设置
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues
                .add("id", 1)
                .add("name","lll");
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
