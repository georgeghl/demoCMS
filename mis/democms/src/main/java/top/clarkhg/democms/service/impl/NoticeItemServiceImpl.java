package top.clarkhg.democms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.NoticeItem;
import top.clarkhg.democms.mapper.NoticeItemMapper;
import top.clarkhg.democms.service.NoticeItemService;


@Service
@Slf4j
public class NoticeItemServiceImpl extends ServiceImpl<NoticeItemMapper,NoticeItem> implements NoticeItemService {
    @Autowired
    private NoticeItemMapper NoticeItemMapper;

    public NoticeItem getByUid(String uid) {
        QueryWrapper<NoticeItem> qw = new QueryWrapper<>();
        qw.eq("uid", uid);
        NoticeItem ni=NoticeItemMapper.selectOne(qw);
        if(ni==null){
            ni=new NoticeItem();
            ni.setId(0);
            ni.setUid(uid);
            ni.setTitle(null);
            ni.setAuthor(null);
            ni.setTime(null);
            ni.setContent(null);
        }
        log.debug(ni.toString());
        return ni;
    }

    public List<NoticeItem> getDescOffsetLimit(Integer offset,Integer limit){
        QueryWrapper<NoticeItem> qw = new QueryWrapper<>();
        qw.orderByDesc("id");
        qw.last("LIMIT "+offset+", "+limit);
        List<NoticeItem> nis=NoticeItemMapper.selectList(qw);
        log.debug(nis.toString());
        return nis;
    }

}
