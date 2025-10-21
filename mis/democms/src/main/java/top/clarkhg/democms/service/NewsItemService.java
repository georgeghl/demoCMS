package top.clarkhg.democms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import top.clarkhg.democms.dao.NewsItem;

@Service
public interface NewsItemService extends IService<NewsItem> {
    public NewsItem getByUid(String uid);
    public List<NewsItem> getDescOffsetLimit(Integer offset, Integer limit);
    // public List<NewsItem> getByCatrgoryId(Integer categoryId);
    public List<NewsItem> getByCatrgoryIdDescOffsetLimit(Integer categoryId,Integer offset, Integer limit);
}
