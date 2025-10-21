package top.clarkhg.democms.dto.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class MyResponse<T> implements Serializable {
    private Integer status=0;
    private String message="";
    private T content;
}
