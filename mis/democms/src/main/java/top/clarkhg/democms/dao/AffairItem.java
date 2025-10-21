package top.clarkhg.democms.dao;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("`affair_item`")
@EqualsAndHashCode(callSuper = false)
public class AffairItem extends BaseInfoItem {

}
