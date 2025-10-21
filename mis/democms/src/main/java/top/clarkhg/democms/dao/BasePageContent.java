package top.clarkhg.democms.dao;


import lombok.Data;

@Data
public class BasePageContent implements java.io.Serializable{
    private Integer id;
    private String name;
    private String value;
}
