package top.clarkhg.democms.dao;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("`notice_item`")
@EqualsAndHashCode(callSuper = false)
public class NoticeItem  extends BaseInfoItem{

}
