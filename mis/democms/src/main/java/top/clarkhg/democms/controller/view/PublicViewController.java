package top.clarkhg.democms.controller.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.AboutPageContent;
import top.clarkhg.democms.dao.AffairItem;
import top.clarkhg.democms.dao.AffairServiceItem;
import top.clarkhg.democms.dao.ClubItem;
import top.clarkhg.democms.dao.EducationPageContent;
import top.clarkhg.democms.dao.NewsItem;
import top.clarkhg.democms.dao.NoticeItem;
import top.clarkhg.democms.dao.PartyMemberItem;
import top.clarkhg.democms.dao.PartyPageContent;
import top.clarkhg.democms.dao.SiteConfig;
import top.clarkhg.democms.dao.TeacherItem;
import top.clarkhg.democms.dto.pojo.DContact;
import top.clarkhg.democms.dto.pojo.DDepartment;
import top.clarkhg.democms.dto.pojo.DImage;
import top.clarkhg.democms.dto.pojo.DLeader;
import top.clarkhg.democms.service.AboutPageContentService;
import top.clarkhg.democms.service.AffairItemService;
import top.clarkhg.democms.service.AffairPageContentService;
import top.clarkhg.democms.service.AffairServiceItemService;
import top.clarkhg.democms.service.ClubItemService;
import top.clarkhg.democms.service.EducationPageContentService;
import top.clarkhg.democms.service.NewsItemService;
import top.clarkhg.democms.service.NoticeItemService;
import top.clarkhg.democms.service.PartyMemberItemService;
import top.clarkhg.democms.service.PartyPageContentService;
import top.clarkhg.democms.service.SiteConfigService;
import top.clarkhg.democms.service.TeacherItemService;

@Controller
@Slf4j
public class PublicViewController {
    @Autowired
    private SiteConfigService siteConfigService;
    @Autowired
    private AboutPageContentService aboutPageContentService;
    @Autowired
    private AffairPageContentService affairPageContentService;
    @Autowired
    private AffairItemService affairItemService;
    @Autowired
    private AffairServiceItemService affairServiceItemService;
    @Autowired
    private NoticeItemService noticeItemService;
    @Autowired
    private NewsItemService newsItemService;
    @Autowired
    private PartyPageContentService partyPageContentService;
    @Autowired
    private PartyMemberItemService partyMemberItemService;
    @Autowired
    private EducationPageContentService educationPageContentService;
    @Autowired
    private TeacherItemService teacherItemService;
    @Autowired
    private ClubItemService clubItemService;

    @RequestMapping(path = "/")
    public String index(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        List<NoticeItem> noticeItems = noticeItemService.getDescOffsetLimit(0,5);
        model.addAttribute("noticeItems", noticeItems);
        List<NewsItem> newsItems = newsItemService.getDescOffsetLimit(0,5);
        model.addAttribute("newsItems", newsItems);

        return "index";
    }

    // =======================================Nav -> about
    @RequestMapping(path = "/about")
    public String about(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        AboutPageContent aboutPageContentIntroP = aboutPageContentService.getByName("intro_p");
        String introP = aboutPageContentIntroP.getValue();
        // log.debug(introP);
        model.addAttribute("introP", introP);
        AboutPageContent aboutPageContentIntroPhoto = aboutPageContentService.getByName("intro_photo");
        log.debug(aboutPageContentIntroPhoto.getValue());
        List<DImage> introPhoto = JSONArray.parseArray(aboutPageContentIntroPhoto.getValue(), DImage.class);
        // log.debug(introPhoto.toString());
        model.addAttribute("photos", introPhoto);
        return "about/intro";
    }

    @RequestMapping(path = "/about/intro")
    public String aboutIntro(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        AboutPageContent aboutPageContentIntroP = aboutPageContentService.getByName("intro_p");
        String introP = aboutPageContentIntroP.getValue();
        // log.debug(introP);
        model.addAttribute("introP", introP);
        AboutPageContent aboutPageContentIntroPhoto = aboutPageContentService.getByName("intro_photo");
        // log.debug(aboutPageContentIntroPhoto.getValue());
        List<DImage> introPhoto = JSONArray.parseArray(aboutPageContentIntroPhoto.getValue(), DImage.class);
        // log.debug(introPhoto.toString());
        model.addAttribute("photos", introPhoto);
        return "about/intro";
    }

    @RequestMapping(path = "/about/photo")
    public String aboutPhoto(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        AboutPageContent aboutPageContentPhotoPhoto = aboutPageContentService.getByName("photo_photo");
        log.debug(aboutPageContentPhotoPhoto.getValue());
        List<DImage> photoPhoto = JSONArray.parseArray(aboutPageContentPhotoPhoto.getValue(), DImage.class);
        model.addAttribute("photos", photoPhoto);
        return "about/photo";
    }

    @RequestMapping(path = "/about/leader")
    public String aboutLeader(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        AboutPageContent aboutPageContentLeaderLeader = aboutPageContentService.getByName("leader_leader");
        // log.debug(aboutPageContentLeaderLeader.getValue());
        List<DLeader> leaderLeader = JSONArray.parseArray(aboutPageContentLeaderLeader.getValue(), DLeader.class);
        // log.debug(leaderLeader.toString());
        model.addAttribute("leaders", leaderLeader);
        return "about/leader";
    }

    @RequestMapping(path = "/about/organization")
    public String aboutOrganization(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        AboutPageContent aboutPageContentOrganP = aboutPageContentService.getByName("organ_p");
        String organP = aboutPageContentOrganP.getValue();
        log.debug(organP);
        model.addAttribute("organP", organP);
        AboutPageContent aboutPageContentOrganDiagram = aboutPageContentService.getByName("organ_diagram");
        String organDiagram = aboutPageContentOrganDiagram.getValue();
        log.debug(organDiagram);
        model.addAttribute("organDiagram", organDiagram);
        AboutPageContent aboutPageContentDept = aboutPageContentService.getByName("organ_dept");
        List<DDepartment> depts = JSONArray.parseArray(aboutPageContentDept.getValue(), DDepartment.class);
        log.debug(depts.toString());
        model.addAttribute("depts", depts);
        return "about/organization";
    }

    @RequestMapping(path = "/about/contact")
    public String aboutContact(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        AboutPageContent aboutPageContentDept = aboutPageContentService.getByName("contact_contact");
        List<DContact> contacts = JSONArray.parseArray(aboutPageContentDept.getValue(), DContact.class);
        log.debug(contacts.toString());
        model.addAttribute("contacts", contacts);
        return "about/contact";
    }

    @RequestMapping(path = "/about/privacy")
    public String aboutPrivacy(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        AboutPageContent aboutPageContentPrivacy = aboutPageContentService.getByName("privacy_p");
        log.debug(aboutPageContentPrivacy.getValue());
        model.addAttribute("privacy", aboutPageContentPrivacy.getValue());
        return "about/privacy";
    }

    // =======================================Nav -> affair
    @RequestMapping(path = "/affair")
    public String affair(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        List<AffairItem> affairs = affairItemService.getDescOffsetLimit(0,15);
        model.addAttribute("affairs", affairs);
        List<AffairServiceItem> affairServices = affairServiceItemService.getDescOffsetLimit(0, 15);
        model.addAttribute("affairServices", affairServices);
        return "affair/board";
    }

    @RequestMapping(path = "/affair/board")
    public String affairBoard(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        List<AffairItem> affairs = affairItemService.getDescOffsetLimit(0,15);
        model.addAttribute("affairs", affairs);
        List<AffairServiceItem> affairServices = affairServiceItemService.getDescOffsetLimit(0, 15);
        model.addAttribute("affairServices", affairServices);
        return "affair/board";
    }

    @RequestMapping(path = "/affair/detail/{uid}")
    public String affairDetail(Model model, @PathVariable String uid) {
        log.debug("====================" + uid);
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        AffairItem affairItem = affairItemService.getByUid(uid);
        model.addAttribute("affairItem", affairItem);
        return "affair/detail";
    }

    @RequestMapping(path = "/affair//service/detail/{uid}")
    public String affairServiceDetail(Model model, @PathVariable String uid) {
        log.debug("====================" + uid);
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        AffairServiceItem affairServiceItem = affairServiceItemService.getByUid(uid);
        model.addAttribute("affairServiceItem", affairServiceItem);
        return "affair/serviceDetail";
    }

    // =======================================Nav -> notice
    @RequestMapping(path = "/notice")
    public String notice(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        List<NoticeItem> noticeItems = noticeItemService.getDescOffsetLimit(0, 15);
        model.addAttribute("noticeItems", noticeItems);
        return "notice/board";
    }

    @RequestMapping(path = "/notice/board")
    public String noticeBoard(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        List<NoticeItem> noticeItems = noticeItemService.getDescOffsetLimit(0, 15);
        model.addAttribute("noticeItems", noticeItems);
        return "notice/board";
    }

    @RequestMapping(path = "/notice/detail/{uid}")
    public String noticeDetail(Model model, @PathVariable String uid) {
        log.debug("====================" + uid);
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        NoticeItem noticeItem = noticeItemService.getByUid(uid);
        model.addAttribute("noticeItem", noticeItem);
        return "notice/detail";
    }

    // =======================================Nav -> news
    @RequestMapping(path = "/news")
    public String news(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        List<NewsItem> newsItems = newsItemService.getDescOffsetLimit(0,15);
        model.addAttribute("newsItems", newsItems);
        return "news/board";
    }

    @RequestMapping(path = "/news/board")
    public String newsBoard(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        List<NewsItem> newsItems = newsItemService.getDescOffsetLimit(0,15);
        model.addAttribute("newsItems", newsItems);
        return "news/board";
    }

    @RequestMapping(path = "/news/detail/{uid}")
    public String newsDetail(Model model, @PathVariable String uid) {
        log.debug("====================" + uid);
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        NewsItem newsItem = newsItemService.getByUid(uid);
        model.addAttribute("newsItem", newsItem);
        return "news/detail";
    }

    // =======================================Nav -> party
    @RequestMapping(path = "/party")
    public String party(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        PartyPageContent partyOrgan = partyPageContentService.getByName("party_organ");
        model.addAttribute("partyOrgan", partyOrgan.getValue());
        List<NewsItem> newsItems = newsItemService.getByCatrgoryIdDescOffsetLimit(105,0,5);
        log.debug(newsItems.toString());
        model.addAttribute("newsItems", newsItems);
        List<PartyMemberItem> members = partyMemberItemService.list();
        model.addAttribute("members", members);
        return "party/party";
    }

    @RequestMapping(path = "/party/party")
    public String partyParty(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        PartyPageContent partyOrgan = partyPageContentService.getByName("party_organ");
        model.addAttribute("partyOrgan", partyOrgan.getValue());
        List<NewsItem> newsItems = newsItemService.getByCatrgoryIdDescOffsetLimit(105,0,5);
        log.debug(newsItems.toString());
        model.addAttribute("newsItems", newsItems);
        List<PartyMemberItem> members = partyMemberItemService.list();
        model.addAttribute("members", members);
        return "party/party";
    }

    @RequestMapping(path = "/party/moral")
    public String partyMoral(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        PartyPageContent moralConcept = partyPageContentService.getByName("moral_concept");
        model.addAttribute("moralConcept", moralConcept.getValue());
        PartyPageContent moralActivity = partyPageContentService.getByName("moral_activity");
        model.addAttribute("moralActivity", moralActivity.getValue());
        PartyPageContent moralAchievement = partyPageContentService.getByName("moral_achievement");
        model.addAttribute("moralAchievement", moralAchievement.getValue());
        return "party/moral";
    }

    // =======================================Nav -> education
    @RequestMapping(path = "/education")
    public String education(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        // log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        // log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        // log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        List<TeacherItem> teachers = teacherItemService.list();
        model.addAttribute("teachers", teachers);
        return "education/teacher/teacher";
    }

    @RequestMapping(path = "/education/teacher")
    public String educationTeacher(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        // log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        // log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        // log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        List<TeacherItem> teachers = teacherItemService.list();
        model.addAttribute("teachers", teachers);
        return "education/teacher/teacher";
    }

    @RequestMapping(path = "/education/teacher/teacher")
    public String educationTeacherTeacher(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        // log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        // log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        // log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        List<TeacherItem> teachers = teacherItemService.list();
        model.addAttribute("teachers", teachers);
        return "education/teacher/teacher";
    }

    @RequestMapping(path = "/education/teacher/research")
    public String educationTeacherResearch(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        List<NewsItem> newsItems = newsItemService.getByCatrgoryIdDescOffsetLimit(104,0,5);
        log.debug(newsItems.toString());
        model.addAttribute("newsItems", newsItems);
        EducationPageContent teacherResearchPhotos = educationPageContentService.getByName("teacher_research_photo");
        // log.debug(teacherResearchPhotos.getValue());
        List<DImage> researchPhotos = JSONArray.parseArray(teacherResearchPhotos.getValue(), DImage.class);
        log.debug(researchPhotos.toString());
        model.addAttribute("researchPhotos", researchPhotos);
        return "education/teacher/research";
    }

    @RequestMapping(path = "/education/student")
    public String educationStudent(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        EducationPageContent studentClubP = educationPageContentService
                .getByName("student_club_p");
        model.addAttribute("studentClubP", studentClubP.getValue());
        List<ClubItem> clubItems = clubItemService.list();
        log.debug(clubItems.toString());
        Map<String, List<ClubItem>> categories = new HashMap<>();
        Set<String> c = new HashSet<>();
        for (ClubItem clubItem : clubItems) {
            c.add(clubItem.getCategory());
        }
        for (String cname : c) {
            List<ClubItem> l = new ArrayList<>();
            categories.put(cname, l);
        }
        for (ClubItem clubItem : clubItems) {
            categories.get(clubItem.getCategory()).add(clubItem);
        }
        log.debug(categories.toString());
        model.addAttribute("categories", categories);
        return "education/student/club";
    }

    @RequestMapping(path = "/education/student/club")
    public String educationStudentClub(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        EducationPageContent studentClubP = educationPageContentService
                .getByName("student_club_p");
        model.addAttribute("studentClubP", studentClubP.getValue());
        List<ClubItem> clubItems = clubItemService.list();
        log.debug(clubItems.toString());
        Map<String, List<ClubItem>> categories = new HashMap<>();
        Set<String> c = new HashSet<>();
        for (ClubItem clubItem : clubItems) {
            c.add(clubItem.getCategory());
        }
        for (String cname : c) {
            List<ClubItem> l = new ArrayList<>();
            categories.put(cname, l);
        }
        for (ClubItem clubItem : clubItems) {
            categories.get(clubItem.getCategory()).add(clubItem);
        }
        log.debug(categories.toString());
        model.addAttribute("categories", categories);
        return "education/student/club";
    }

    @RequestMapping(path = "/education/student/activity")
    public String educationStudentActivity(Model model) {
        SiteConfig schoolNameConfig = siteConfigService.getSiteConfigByName("schoolName");
        log.debug(schoolNameConfig.toString());
        model.addAttribute("schoolName", schoolNameConfig.getValue());
        SiteConfig schoolSloganConfig = siteConfigService.getSiteConfigByName("schoolSlogan");
        log.debug(schoolSloganConfig.toString());
        model.addAttribute("schoolSlogan", schoolSloganConfig.getValue());
        SiteConfig schoolAddressConfig = siteConfigService.getSiteConfigByName("schoolAddress");
        log.debug(schoolAddressConfig.toString());
        model.addAttribute("schoolAddress", schoolAddressConfig.getValue());
        EducationPageContent studentActivityCalender = educationPageContentService
                .getByName("student_activity_calender");
        model.addAttribute("studentActivityCalender", studentActivityCalender.getValue());
        List<NewsItem> newsItems = newsItemService.getByCatrgoryIdDescOffsetLimit(101,0,5);
        log.debug(newsItems.toString());
        model.addAttribute("newsItems", newsItems);
        EducationPageContent studentActivityPhotos = educationPageContentService.getByName("student_activity_photo");
        // log.debug(studentActivityPhotos.getValue());
        List<DImage> activityPhotos = JSONArray.parseArray(studentActivityPhotos.getValue(), DImage.class);
        model.addAttribute("activityPhotos", activityPhotos);
        return "education/student/activity";
    }

}
