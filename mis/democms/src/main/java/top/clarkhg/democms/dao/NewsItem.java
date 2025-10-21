package top.clarkhg.democms.dao;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@TableName("`news_item`")
public class NewsItem extends BaseInfoItem{
    private Integer categoryId;
}
