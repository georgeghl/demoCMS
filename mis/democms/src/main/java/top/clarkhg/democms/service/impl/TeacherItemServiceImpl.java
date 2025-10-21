package top.clarkhg.democms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.TeacherItem;
import top.clarkhg.democms.mapper.TeacherItemMapper;
import top.clarkhg.democms.service.TeacherItemService;

@Service
@Slf4j
public class TeacherItemServiceImpl  extends ServiceImpl<TeacherItemMapper,TeacherItem> implements TeacherItemService {
    @Autowired
    private TeacherItemMapper teacherItemMapper;

    

}
