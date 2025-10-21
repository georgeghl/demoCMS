package top.clarkhg.democms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.PartyMemberItem;
import top.clarkhg.democms.mapper.PartyMemberItemMapper;
import top.clarkhg.democms.service.PartyMemberItemService;

@Service
@Slf4j
public class PartyMemberItemServiceImpl extends ServiceImpl<PartyMemberItemMapper,PartyMemberItem> implements PartyMemberItemService {
    @Autowired
    private PartyMemberItemMapper partyMemberItemMapper;

    

}
