package top.clarkhg.democms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.github.yulichang.base.MPJBaseMapper;

import top.clarkhg.democms.dao.AboutPageContent;
import top.clarkhg.democms.dao.BasePageContent;


@Mapper
public interface AboutPageContentMapper extends MppBaseMapper<AboutPageContent>, MPJBaseMapper<AboutPageContent> {

}
