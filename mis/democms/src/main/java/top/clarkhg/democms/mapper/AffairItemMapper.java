package top.clarkhg.democms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.github.yulichang.base.MPJBaseMapper;

import top.clarkhg.democms.dao.AffairItem;

@Mapper
public interface AffairItemMapper extends MppBaseMapper<AffairItem>, MPJBaseMapper<AffairItem> {

}
