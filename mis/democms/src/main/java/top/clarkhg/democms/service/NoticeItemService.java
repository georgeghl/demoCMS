package top.clarkhg.democms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import top.clarkhg.democms.dao.NoticeItem;

@Service
public interface NoticeItemService  extends IService<NoticeItem>{
    public NoticeItem getByUid(String uid);
    public List<NoticeItem> getDescOffsetLimit(Integer offset,Integer limit);
}
