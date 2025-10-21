package top.clarkhg.democms.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import top.clarkhg.democms.dao.AffairPageContent;


@Service
public interface AffairPageContentService extends IService<AffairPageContent>{
    public AffairPageContent getByName(String name);
}
