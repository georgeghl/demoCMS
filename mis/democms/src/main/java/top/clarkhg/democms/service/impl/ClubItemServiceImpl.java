package top.clarkhg.democms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.ClubItem;
import top.clarkhg.democms.mapper.ClubItemMapper;
import top.clarkhg.democms.service.ClubItemService;

@Service
@Slf4j
public class ClubItemServiceImpl extends ServiceImpl<ClubItemMapper,ClubItem> implements ClubItemService {
    @Autowired
    private ClubItemMapper clubItemMapper;

    

}
