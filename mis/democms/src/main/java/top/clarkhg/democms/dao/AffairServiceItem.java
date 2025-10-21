package top.clarkhg.democms.dao;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("`affair_service_item`")
public class AffairServiceItem implements java.io.Serializable{
    private Integer id;
    private String uid;
    private Integer categoryId;
    private String title;
    private String author;
    private Date time;
    private String cover;
    private String desp;
    private String content; 

}
