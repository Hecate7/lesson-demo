什么是IOC
反转控制-控制流
好莱坞原则
IOC容器及DI

IOC主要实现策略:
1.using a service locator pattern
服务定位模式(JNDI组件)
2.using dependency injection, for example
依赖注入
    constructor injection-构造器注入
    parameter injection-参数注入
    setter injection-setter注入
    interface injection-接口注入
3.using a contextualized lookup
上下文依赖查询(Java Beans)
4.using template method design pattern
模板方法设计模式(JDBC Template)
5.using strategy design pattern 
策略模式

构造器注入 VS setter注入

Dependency Lookup:依赖查找
上下文查询获取组件
Dependency Injection:依赖注入
容器自动注入/手动注入

IOC容器的职责:
Inversion of control serves the following design pattern:
1.to decouple the execution of a task from implementation
实现与执行任务之间的解耦
2.to focus a module on the task it is designed for
关注模块设计上的最终目标而不是具体实现
3.to free modules from assumptions about how other system do what they do and instead rely on contracts
其他模块不依赖某个契约来关联这个模块
4.to prevent side effects when replacing a module
防止依赖变更时的副作用

通用职责:
1.依赖处理:依赖是怎么来的?怎么返回依赖给客户端来进行处理的?
    依赖查找
    依赖注入
2.生命周期管理
    容器
    托管资源(Java Beans或其他资源-Spring容器事件)
3.配置
    容器
    外部化配置
    托管的资源
    
    
IOC容器的实现
Java SE-最底层:依赖查找
    Java Beans-Bean的管理
    Java ServiceLoader SPI
    JNDI-查找资源
Java EE
    EJB-Enterprise Java Beans
    Servlet
开源
    Apache Avalon
    Spring Framework    
    
    
Java Beans作为IOC容器的特性
1.依赖查找
2.生命周期管理
3.配置元信息
4.事件
5.自定义
6.资源管理
7.持久化 

依赖查找        依赖注入   
主动获取        被动提供(依赖处理)
相对繁琐1.2     相对便利1(实现便利性)-1.依赖搜索 2.依赖的注入
侵入业务逻辑    低侵入性(代码侵入性)
依赖容器API     不依赖容器API(API依赖性)
良好            一般(可读性)
                
  
Spring IOC依赖查找-注入-来源
Spring IOC依赖查找
    根据Bean名称查找:实时查找、延迟查找
Spring IOC配置元信息
Spring IOC容器
Spring应用上下文      
