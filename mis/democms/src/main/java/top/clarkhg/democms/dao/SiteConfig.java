package top.clarkhg.democms.dao;

import com.baomidou.mybatisplus.annotation.TableName;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("`site_config`")
public class SiteConfig implements java.io.Serializable{
    private Integer id;
    private String name;
    private String value;

}
