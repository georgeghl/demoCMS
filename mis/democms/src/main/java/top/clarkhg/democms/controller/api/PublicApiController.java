package top.clarkhg.democms.controller.api;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import top.clarkhg.democms.dao.AffairItem;
import top.clarkhg.democms.dao.AffairServiceItem;
import top.clarkhg.democms.dao.NewsItem;
import top.clarkhg.democms.dao.NoticeItem;
import top.clarkhg.democms.service.AffairItemService;
import top.clarkhg.democms.service.AffairServiceItemService;
import top.clarkhg.democms.service.NewsItemService;
import top.clarkhg.democms.service.NoticeItemService;

@RestController
@Slf4j
public class PublicApiController {
    @Autowired
    private AffairItemService affairItemService;
    @Autowired
    private AffairServiceItemService affairServiceItemService;
    @Autowired
    private NoticeItemService noticeItemService;
    @Autowired
    private NewsItemService newsItemService;

    @GetMapping(path = "/api/affair/getCount")
    public Long getAffairItemCount() {
        return affairItemService.count();
    }

    @PostMapping(path = "/api/affair/getDescOffsetLimit")
    public List<AffairItem> getAffairItemDescOffsetLimit(@RequestBody Map<String, Integer> params) {
        Integer offset = params.get("offset");
        Integer limit = params.get("limit");
        if (offset == null || limit == null) {
            throw new IllegalArgumentException("offset and limit are required");
        }
        log.debug("================="+offset+"======="+limit);
        List<AffairItem> ais = affairItemService.getDescOffsetLimit(offset, limit);
        return ais;
    }

    @GetMapping(path = "/api/affairService/getCount")
    public Long getAffairServiceItemCount() {
        return affairServiceItemService.count();
    }

    @PostMapping(path = "/api/affairService/getAscOffsetLimit")
    public List<AffairServiceItem> getAffairServiceItemAscOffsetLimit(@RequestBody Map<String, Integer> params) {
        Integer offset = params.get("offset");
        Integer limit = params.get("limit");
        if (offset == null || limit == null) {
            throw new IllegalArgumentException("offset and limit are required");
        }
        log.debug("================="+offset+"======="+limit);
        List<AffairServiceItem> ais = affairServiceItemService.getAscOffsetLimit(offset, limit);
        return ais;
    }

    @PostMapping(path = "/api/affairService/getDescOffsetLimit")
    public List<AffairServiceItem> getAffairServiceItemDescOffsetLimit(@RequestBody Map<String, Integer> params) {
        Integer offset = params.get("offset");
        Integer limit = params.get("limit");
        if (offset == null || limit == null) {
            throw new IllegalArgumentException("offset and limit are required");
        }
        log.debug("================="+offset+"======="+limit);
        List<AffairServiceItem> ais = affairServiceItemService.getDescOffsetLimit(offset, limit);
        return ais;
    }

    @GetMapping(path = "/api/notice/getCount")
    public Long getNoticeItemCount() {
        return noticeItemService.count();
    }

    @PostMapping(path = "/api/notice/getDescOffsetLimit")
    public List<NoticeItem> getNoticeItemDescOffsetLimit(@RequestBody Map<String, Integer> params) {
        Integer offset = params.get("offset");
        Integer limit = params.get("limit");
        if (offset == null || limit == null) {
            throw new IllegalArgumentException("offset and limit are required");
        }
        log.debug("================="+offset+"======="+limit);
        List<NoticeItem> ais = noticeItemService.getDescOffsetLimit(offset, limit);
        return ais;
    }

    @GetMapping(path = "/api/news/getCount")
    public Long getNewsItemCount() {
        return newsItemService.count();
    }

    @PostMapping(path = "/api/news/getDescOffsetLimit")
    public List<NewsItem> getNewsItemDescOffsetLimit(@RequestBody Map<String, Integer> params) {
        Integer offset = params.get("offset");
        Integer limit = params.get("limit");
        if (offset == null || limit == null) {
            throw new IllegalArgumentException("offset and limit are required");
        }
        log.debug("================="+offset+"======="+limit);
        List<NewsItem> ais = newsItemService.getDescOffsetLimit(offset, limit);
        return ais;
    }
}
