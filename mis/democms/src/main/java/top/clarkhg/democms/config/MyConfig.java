package top.clarkhg.democms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import top.clarkhg.democms.bean.MyApp;

@Configuration
public class MyConfig {
    @Bean
    public MyApp myApp(@Value("${myapp.testitem.name1}") String name1) {
        MyApp myApp = new MyApp();
        myApp.setName1(name1);
        return myApp;
    }

    @Bean
    public MyApp myApp1() {
        MyApp myApp1 = new MyApp();
        myApp1.setName1("hello");
        return myApp1;
    }
}
