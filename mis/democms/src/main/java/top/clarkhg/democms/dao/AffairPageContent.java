package top.clarkhg.democms.dao;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("`affair_page_content`")
public class AffairPageContent extends BasePageContent{

}
