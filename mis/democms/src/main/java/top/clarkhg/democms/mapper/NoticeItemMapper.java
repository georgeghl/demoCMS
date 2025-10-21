package top.clarkhg.democms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.github.yulichang.base.MPJBaseMapper;

import top.clarkhg.democms.dao.NoticeItem;

@Mapper
public interface NoticeItemMapper extends MppBaseMapper<NoticeItem>, MPJBaseMapper<NoticeItem> {

}
