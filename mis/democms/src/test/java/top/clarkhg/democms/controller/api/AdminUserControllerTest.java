package top.clarkhg.democms.controller.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class AdminUserControllerTest {
    @Test
    void contextLoads() {
        String info = "001";
        log.debug(info);
        System.out.println(System.getProperty("user.dir"));
        // 还可以对返回结果进行断言，判断是否符合预期效果
        Assertions.assertEquals("001", info);
    }
}
