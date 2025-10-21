package top.clarkhg.democms.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired // 注入拦截器
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 根据需要取消拦截指定的请求
        List<String> excludePathList = new ArrayList<>();
        // 管理员放行页面
        excludePathList.add("/admin/1145141919810");

        // 拦截所有请求，排除指定请求
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns(excludePathList);

        // ...如果有多个拦截器，可以addInterceptor()多次
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有请求路径跨域访问
                .allowCredentials(true) // 是否携带Cookie，默认false
                .allowedHeaders("*") // 允许的请求头类型
                .maxAge(3600)  // 预检请求的缓存时间（单位：秒）
                .allowedMethods("*") // 允许的请求方法类型
                .allowedOrigins("**"); // 允许哪些域名进行跨域访问
    }


    // public void addInterceptors(InterceptorRegistry registry) {
    // // 根据需要取消拦截指定的请求
    // List<String> excludePathList = new ArrayList<>();
    // // 静态资源放行
    // excludePathList.add("/favicon.ico");
    // excludePathList.add("/js/**");
    // excludePathList.add("//css/**");
    // excludePathList.add("/font/**");
    // excludePathList.add("/img/**");
    // excludePathList.add("/error/**");
    // // cms放行页面
    // excludePathList.add("/");
    // excludePathList.add("/page/**");
    // // 管理员放行页面
    // excludePathList.add("/admin/login");

    // // 拦截所有请求，排除指定请求
    // registry.addInterceptor(myInterceptor)
    // .addPathPatterns("/**").excludePathPatterns(excludePathList);

    // // ...如果有多个拦截器，可以addInterceptor()多次
    // }
}
