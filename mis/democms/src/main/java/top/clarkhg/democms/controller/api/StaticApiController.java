package top.clarkhg.democms.controller.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.bean.MyApp;

@RestController
@Slf4j
public class StaticApiController {
    // 注入配置条目
    @Value("${myapp.testitem.name1}")
    private String name1;
    // 直接注入配置的Bean
    @Autowired
    private MyApp myApp;

    @RequestMapping(path = "/error/400")
    public HttpServletResponse error400(HttpServletResponse response) throws IOException {
        response.sendRedirect("/error/400.html");
        return response;
    }

    @RequestMapping(path = "/error/403")
    public HttpServletResponse error403(HttpServletResponse response) throws IOException {
        response.sendRedirect("/error/403.html");
        return response;
    }

    @RequestMapping(path = "/error/404")
    public HttpServletResponse error404(HttpServletResponse response) throws IOException {
        response.sendRedirect("/error/404.html");
        return response;
    }

    @RequestMapping(path = "/error/4xx")
    public HttpServletResponse error4xx(HttpServletResponse response) throws IOException {
        response.sendRedirect("/error/4xx.html");
        return response;
    }

    @RequestMapping(path = "/error/500")
    public HttpServletResponse error500(HttpServletResponse response) throws IOException {
        response.sendRedirect("/error/500.html");
        return response;
    }

    @RequestMapping(path = "/error/5xx")
    public HttpServletResponse error5xx(HttpServletResponse response) throws IOException {
        response.sendRedirect("/error/5xx.html");
        return response;
    }

    @RequestMapping(path = "/error/xxx")
    public HttpServletResponse errorxxx(HttpServletResponse response) throws IOException {
        response.sendRedirect("/error/xxx.html");
        return response;
    }

}
