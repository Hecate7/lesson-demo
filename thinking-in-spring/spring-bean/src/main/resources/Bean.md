BeanDefinition注册
1.XML配置辕信息
    <bean name="" .../>
2.Java注解配置元信息
    @Bean
    @Component
    @Import
3.Java Api配置元信息
    命名方式:BeanDefinitionRegistry#RegistryBeanDefinition(String, BeanDefinition)
    非命名方式:BeanDefinitionReaderUtils#registerWithGeneratedName(AbstractBeanDefinition, BeanDefinitionRegistry)
    配置类方式:AnnotationBeanDefinitionReader#Register(Class)       
    
    
实例化Spring Bean
常规方式
    1.通过构造器(配置元信息:XML、Java注解、Java API)
    2.通过静态工厂方法（配置元信息：XML、Java API）
    3.通过Bean工厂方法（配置元信息：XML、Java API）
    4.通过FactoryBean（配置元信息：XML、Java注解、Java API）
特殊方式    
    1.通过ServiceLoaderFactoryBean（配置元信息：XML、Java注解、Java API）
    2.通过AutowireCapableBeanFactory#CreateBean(Class, int, boolean)
    3.通过BeanDefinitionRegistry#registerBeanDefinition(String, BeanDefinition)