package top.clarkhg.democms.dto.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DLeader extends DPeople {
    private String intro;
    private String photo;
}
