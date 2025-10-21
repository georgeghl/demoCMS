package top.clarkhg.democms.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
// @PropertySource(value = { "classpath:application-myapp.yml" })
// @ConfigurationProperties(prefix = "myapp.testitem")
public class MyApp {
    private String name1;
}
