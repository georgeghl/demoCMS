package top.clarkhg.democms.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import top.clarkhg.democms.dao.AboutPageContent;


@Service
public interface AboutPageContentService extends IService<AboutPageContent>{
    public AboutPageContent getByName(String name);
}
