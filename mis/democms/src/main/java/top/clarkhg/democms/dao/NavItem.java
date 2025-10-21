package top.clarkhg.democms.dao;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@TableName("`nav_item`")
public class NavItem implements java.io.Serializable {
    private Integer id;
    private String path;
    private Integer parentId;
    private Integer level;
    private Boolean deletable;
}
