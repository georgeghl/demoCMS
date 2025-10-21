package top.clarkhg.democms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.PartyPageContent;
import top.clarkhg.democms.mapper.PartyPageContentMapper;
import top.clarkhg.democms.service.PartyPageContentService;

@Service
@Slf4j
public class PartyPageContentServiceImpl extends ServiceImpl<PartyPageContentMapper,PartyPageContent> implements PartyPageContentService {
    @Autowired
    private PartyPageContentMapper partyPageContentMapper;

    public PartyPageContent getByName(String name){
        QueryWrapper<PartyPageContent> qw = new QueryWrapper<>();
        qw.eq("name", name);
        PartyPageContent aboutPageContent=partyPageContentMapper.selectOne(qw);
        if(aboutPageContent==null){
            aboutPageContent=new PartyPageContent();
            aboutPageContent.setId(0);
            aboutPageContent.setName(name);
            aboutPageContent.setValue(null);
        }
        log.debug(aboutPageContent.toString());
        return aboutPageContent;
    }


}
