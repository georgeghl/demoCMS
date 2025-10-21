package top.clarkhg.democms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.AffairServiceItem;
import top.clarkhg.democms.mapper.AffairServiceItemMapper;
import top.clarkhg.democms.service.AffairServiceItemService;

@Service
@Slf4j
public class AffairServiceItemServiceImpl extends ServiceImpl<AffairServiceItemMapper, AffairServiceItem>
        implements AffairServiceItemService {
    @Autowired
    private AffairServiceItemMapper affairServiceItemMapper;

    public AffairServiceItem getByUid(String uid) {
        QueryWrapper<AffairServiceItem> qw = new QueryWrapper<>();
        qw.eq("uid", uid);
        AffairServiceItem ni = affairServiceItemMapper.selectOne(qw);
        if (ni == null) {
            ni = new AffairServiceItem();
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

    public List<AffairServiceItem> getAscOffsetLimit(Integer offset, Integer limit) {
        QueryWrapper<AffairServiceItem> qw = new QueryWrapper<>();
        qw.orderByAsc("id");
        qw.last("LIMIT " + offset + ", " + limit);
        List<AffairServiceItem> nis = affairServiceItemMapper.selectList(qw);
        log.debug(nis.toString());
        return nis;
    }

    public List<AffairServiceItem> getDescOffsetLimit(Integer offset, Integer limit) {
        QueryWrapper<AffairServiceItem> qw = new QueryWrapper<>();
        qw.orderByDesc("id");
        qw.last("LIMIT " + offset + ", " + limit);
        List<AffairServiceItem> nis = affairServiceItemMapper.selectList(qw);
        log.debug(nis.toString());
        return nis;
    }
}
