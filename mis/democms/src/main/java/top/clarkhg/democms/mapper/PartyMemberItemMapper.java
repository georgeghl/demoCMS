package top.clarkhg.democms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.github.yulichang.base.MPJBaseMapper;

import top.clarkhg.democms.dao.PartyMemberItem;

@Mapper
public interface PartyMemberItemMapper extends MppBaseMapper<PartyMemberItem>, MPJBaseMapper<PartyMemberItem> {

}
