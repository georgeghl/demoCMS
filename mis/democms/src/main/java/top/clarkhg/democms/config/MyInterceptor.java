package top.clarkhg.democms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {
    private Logger logger=LoggerFactory.getLogger(MyInterceptor.class);
    long start = System.currentTimeMillis();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        start = System.currentTimeMillis();
        // 获取请求头中的Authorization属性，并验证登录是否有效
        String authorization = request.getHeader("Authorization");

        // 这里只是简单判断一下，实际可能要查询缓存
        if (authorization==null) {
            // 设置HTTP状态码为403 Forbidden
            response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403 status code
            // 可选：设置响应内容类型和返回自定义错误信息
            response.setContentType("application/json; charset=UTF-8");
            // response.getWriter().write("{\"error\": \"Forbidden: Please provide valid Authorization header\"}");
            // 或者：重定向到自定义403错误页面
            response.sendRedirect("/error/403"); // 假设你有自定义403页面
            return false; // 阻止请求继续处理
            // throw new RuntimeException("请登录");
        }

        return true; // 返回true则继续处理请求，
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        logger.debug("Interceptor cost=" + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
           Object handler, Exception e) throws Exception {
    }
}
