package top.clarkhg.democms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.NewsItem;
import top.clarkhg.democms.mapper.NewsItemMapper;
import top.clarkhg.democms.service.NewsItemService;

@Service
@Slf4j
public class NewsItemServiceImpl extends ServiceImpl<NewsItemMapper,NewsItem> implements NewsItemService {
    @Autowired
    private NewsItemMapper newsItemMapper;

    public NewsItem getByUid(String uid) {
        QueryWrapper<NewsItem> qw = new QueryWrapper<>();
        qw.eq("uid", uid);
        NewsItem ni=newsItemMapper.selectOne(qw);
        if(ni==null){
            ni=new NewsItem();
            ni.setId(0);
            ni.setUid(uid);
            ni.setCategoryId(null);
            ni.setTitle(null);
            ni.setAuthor(null);
            ni.setTime(null);
            ni.setCover(null);
            ni.setDesp(null);
            ni.setContent(null);
        }
        log.debug(ni.toString());
        return ni;
    }

    public List<NewsItem> getDescOffsetLimit(Integer offset, Integer limit){
        QueryWrapper<NewsItem> qw = new QueryWrapper<>();
        qw.orderByDesc("id");
        qw.last("LIMIT "+offset+", "+limit);
        List<NewsItem> nis=newsItemMapper.selectList(qw);
        log.debug(nis.toString());
        return nis;
    }

    // public List<NewsItem> getByCatrgoryId(Integer categoryId){
    //     QueryWrapper<NewsItem> qw = new QueryWrapper<>();
    //     qw.eq("category_id", categoryId);
    //     List<NewsItem> nis=newsItemMapper.selectList(qw);
    //     log.debug(nis.toString());
    //     return nis;
    // }

    public List<NewsItem> getByCatrgoryIdDescOffsetLimit(Integer categoryId,Integer offset, Integer limit){
        QueryWrapper<NewsItem> qw = new QueryWrapper<>();
        qw.eq("category_id", categoryId);
        qw.orderByDesc("id");
        qw.last("LIMIT "+offset+", "+limit);
        List<NewsItem> nis=newsItemMapper.selectList(qw);
        log.debug(nis.toString());
        return nis;
    }

}
