package top.clarkhg.democms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.SiteConfig;
import top.clarkhg.democms.mapper.SiteConfigMapper;
import top.clarkhg.democms.service.SiteConfigService;

@Service
@Slf4j
public class SiteConfigServiceImpl extends ServiceImpl<SiteConfigMapper,SiteConfig> implements SiteConfigService {
    @Autowired
    private SiteConfigMapper siteConfigMapper;

    public SiteConfig getSiteConfigByName(String name) {
        QueryWrapper<SiteConfig> qw = new QueryWrapper<>();
        qw.eq("name", name);
        SiteConfig sc=siteConfigMapper.selectOne(qw);
        if(sc==null){
            sc=new SiteConfig();
            sc.setName(name);
            sc.setValue("null");
            sc.setId(0);
        }
        log.debug(sc.toString());
        return sc;
    }

}
