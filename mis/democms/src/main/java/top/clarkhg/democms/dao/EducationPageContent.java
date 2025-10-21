package top.clarkhg.democms.dao;


import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("`education_page_content`")
public class EducationPageContent extends BasePageContent{

}
