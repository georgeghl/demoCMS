package top.clarkhg.democms.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.github.yulichang.base.MPJBaseMapper;

import top.clarkhg.democms.dao.EducationPageContent;


@Mapper
public interface EducationPageContentMapper extends MppBaseMapper<EducationPageContent>, MPJBaseMapper<EducationPageContent> {

}
