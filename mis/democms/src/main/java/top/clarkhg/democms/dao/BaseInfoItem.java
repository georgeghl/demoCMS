package top.clarkhg.democms.dao;

import java.util.Date;



import lombok.Data;

@Data
public class BaseInfoItem implements java.io.Serializable{
    private Integer id;
    private String uid;
    // private Integer categoryId;
    private String title;
    private String author;
    private Date time;
    private String cover;
    private String desp;
    private String content; 

}
