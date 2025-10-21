package top.clarkhg.democms.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import top.clarkhg.democms.dao.AdminUser;
import top.clarkhg.democms.mapper.AdminUserMapper;
import top.clarkhg.democms.service.AdminUserService;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper,AdminUser> implements AdminUserService{

}
