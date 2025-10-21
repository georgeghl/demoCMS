package top.clarkhg.democms.dao;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("`party_page_content`")
public class PartyPageContent extends BasePageContent{

}
