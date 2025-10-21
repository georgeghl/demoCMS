package top.clarkhg.democms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import top.clarkhg.democms.dao.AffairServiceItem;

@Service
public interface AffairServiceItemService  extends IService<AffairServiceItem>{
    public AffairServiceItem getByUid(String uid);
    public List<AffairServiceItem> getAscOffsetLimit(Integer offset,Integer limit) ;
    public List<AffairServiceItem> getDescOffsetLimit(Integer offset,Integer limit) ;
}
