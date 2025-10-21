package top.clarkhg.democms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.AffairPageContent;
import top.clarkhg.democms.dao.SiteConfig;
import top.clarkhg.democms.mapper.AffairPageContentMapper;
import top.clarkhg.democms.service.AffairPageContentService;

@Service
@Slf4j
public class AffairPageContentServiceImpl extends ServiceImpl<AffairPageContentMapper,AffairPageContent> implements AffairPageContentService {
    @Autowired
    private AffairPageContentMapper affairPageContentMapper;

    public AffairPageContent getByName(String name){
        QueryWrapper<AffairPageContent> qw = new QueryWrapper<>();
        qw.eq("name", name);
        AffairPageContent aboutPageContent=affairPageContentMapper.selectOne(qw);
        if(aboutPageContent==null){
            aboutPageContent=new AffairPageContent();
            aboutPageContent.setId(0);
            aboutPageContent.setName(name);
            aboutPageContent.setValue(null);
        }
        log.debug(aboutPageContent.toString());
        return aboutPageContent;
    }


}
