package top.clarkhg.democms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.EducationPageContent;
import top.clarkhg.democms.dao.SiteConfig;
import top.clarkhg.democms.mapper.EducationPageContentMapper;
import top.clarkhg.democms.service.EducationPageContentService;

@Service
@Slf4j
public class EducationPageContentServiceImpl extends ServiceImpl<EducationPageContentMapper,EducationPageContent> implements EducationPageContentService {
    @Autowired
    private EducationPageContentMapper educationPageContentMapper;

    public EducationPageContent getByName(String name){
        QueryWrapper<EducationPageContent> qw = new QueryWrapper<>();
        qw.eq("name", name);
        EducationPageContent aboutPageContent=educationPageContentMapper.selectOne(qw);
        if(aboutPageContent==null){
            aboutPageContent=new EducationPageContent();
            aboutPageContent.setId(0);
            aboutPageContent.setName(name);
            aboutPageContent.setValue(null);
        }
        log.debug(aboutPageContent.toString());
        return aboutPageContent;
    }


}
