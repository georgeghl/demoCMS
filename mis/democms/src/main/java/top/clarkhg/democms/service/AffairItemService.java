package top.clarkhg.democms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import top.clarkhg.democms.dao.AffairItem;

@Service
public interface AffairItemService  extends IService<AffairItem>{
    public AffairItem getByUid(String uid);
    public List<AffairItem> getDescOffsetLimit(Integer offset,Integer limit) ;
}
