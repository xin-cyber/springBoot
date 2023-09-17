package org.example.config;

import ch.qos.logback.core.db.DBHelper;
import org.example.bean.Pet;
import org.example.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 * Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 * Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 * 组件依赖必须使用Full模式默认。其他默认是否Lite模式
 * 4、@Import({User.class, DBHelper.class})
 * 给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 * 5、@ImportResource("classpath:beans.xml")导入Spring的配置文件，
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false) // 配置类 == 配置文件
//@ConditionalOnBean(name = "user01") // 条件装配，容器中有tom组件才注册
@ImportResource("classpath:beans.xml") // xml方式组件装配，class装配
//@EnableConfigurationProperties(Car.class)
//1、开启Car配置绑定功能
//2、把这个Car这个组件自动注册到容器中
//不用在car中使用@component
public class MyConfig {
    @Bean //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01() {
        User zhangsan = new User("zhangsan", 18);
        //user组件依赖了Pet组件
//        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
