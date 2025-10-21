package top.clarkhg.democms.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import top.clarkhg.democms.dao.PartyPageContent;


@Service
public interface PartyPageContentService extends IService<PartyPageContent>{
    public PartyPageContent getByName(String name);
}
