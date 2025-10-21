package top.clarkhg.democms.dao;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("`education_club_item`")
public class ClubItem implements java.io.Serializable {
    private Integer id;
    private String name;
    private String category;
    private String desp;
    private String cover;
    private String supervisior;
}
