package top.clarkhg.democms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.AffairItem;
import top.clarkhg.democms.mapper.AffairItemMapper;
import top.clarkhg.democms.service.AffairItemService;

@Service
@Slf4j
public class AffairItemServiceImpl extends ServiceImpl<AffairItemMapper, AffairItem> implements AffairItemService {
    @Autowired
    private AffairItemMapper affairItemMapper;

    public AffairItem getByUid(String uid) {
        QueryWrapper<AffairItem> qw = new QueryWrapper<>();
        qw.eq("uid", uid);
        AffairItem ni = affairItemMapper.selectOne(qw);
        if (ni == null) {
            ni = new AffairItem();
            ni.setId(0);
            ni.setUid(uid);
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

    public List<AffairItem> getDescOffsetLimit(Integer offset, Integer limit) {
        QueryWrapper<AffairItem> qw = new QueryWrapper<>();
        qw.orderByDesc("id");
        qw.last("LIMIT "+offset+", "+limit);
        List<AffairItem> nis = affairItemMapper.selectList(qw);
        log.debug(nis.toString());
        return nis;
    }

}
