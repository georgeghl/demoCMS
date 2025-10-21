package top.clarkhg.democms.runner;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyAppRunner implements ApplicationRunner, DisposableBean, Ordered {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationRunnerInit 系统启动...");
    }

    @Override
    public int getOrder() {
        return 0;
    }


    @Override
    public void destroy() throws Exception {
        log.warn("ApplicationRunnerInit 系统关闭...");
    }
}
