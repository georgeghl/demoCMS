package top.clarkhg.democms.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import top.clarkhg.democms.dao.SiteConfig;

@Service
public interface SiteConfigService  extends IService<SiteConfig> {
    public SiteConfig getSiteConfigByName(String name);
}
