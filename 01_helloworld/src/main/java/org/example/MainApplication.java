package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author JX
 * @ClassName: org.example.MainApplication
 * @Create 2023-09-17 14:44
 * @Description: TODO
 */
// 主程序类

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("org.example")
public class MainApplication {
    public static void main(String[] args) {
        //1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3、从容器中获取组件
        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
//        MyConfig bean = run.getBean(MyConfig.class); // MyConfig也是一个组件
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println(user == user1);

        // 4、 @Conditional()使用
        boolean tom = run.containsBean("tom");
        System.out.println("组件" + tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件：" + user01);

        // 5、 @ImportResource使用
        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha：" + haha);
        System.out.println("hehe：" + hehe);
    }
}
