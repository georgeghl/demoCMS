package top.clarkhg.democms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.github.yulichang.base.MPJBaseMapper;

import top.clarkhg.democms.dao.ClubItem;

@Mapper
public interface ClubItemMapper extends MppBaseMapper<ClubItem>, MPJBaseMapper<ClubItem> {

}
