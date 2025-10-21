package top.clarkhg.democms.dto.pojo;

import lombok.Data;

@Data
public class DImage implements java.io.Serializable{
    private Integer id;
    private String name;
    private String base64content;
}
