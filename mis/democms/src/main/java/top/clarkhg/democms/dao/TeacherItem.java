package top.clarkhg.democms.dao;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("`education_teacher_item`")
public class TeacherItem implements java.io.Serializable {
    private Integer id;
    private String name;
    private Integer gender;
    private String avatar;
    private String slogan;
    private String desp;

}
