package top.clarkhg.democms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean<MyFilter> registrationBean() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/*"); // 设置拦截路径，如果要拦截多个路径，可以传入集合
        filterRegistrationBean.setName("myFilter"); // 设置拦截器名称
        filterRegistrationBean.setOrder(1); // 设置过滤器顺序，值越小优先级越高
        return filterRegistrationBean;
    }
}
