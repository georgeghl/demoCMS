package top.clarkhg.democms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.AboutPageContent;
import top.clarkhg.democms.dao.SiteConfig;
import top.clarkhg.democms.mapper.AboutPageContentMapper;
import top.clarkhg.democms.service.AboutPageContentService;

@Service
@Slf4j
public class AboutPageContentServiceImpl extends ServiceImpl<AboutPageContentMapper,AboutPageContent> implements AboutPageContentService {
    @Autowired
    private AboutPageContentMapper aboutPageContentMapper;

    public AboutPageContent getByName(String name){
        QueryWrapper<AboutPageContent> qw = new QueryWrapper<>();
        qw.eq("name", name);
        AboutPageContent aboutPageContent=aboutPageContentMapper.selectOne(qw);
        if(aboutPageContent==null){
            aboutPageContent=new AboutPageContent();
            aboutPageContent.setId(0);
            aboutPageContent.setName(name);
            aboutPageContent.setValue(null);
        }
        log.debug(aboutPageContent.toString());
        return aboutPageContent;
    }


}
