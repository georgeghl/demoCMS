package top.clarkhg.democms.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;

import top.clarkhg.democms.dao.EducationPageContent;


@Service
public interface EducationPageContentService extends IService<EducationPageContent>{
    public EducationPageContent getByName(String name);
}
