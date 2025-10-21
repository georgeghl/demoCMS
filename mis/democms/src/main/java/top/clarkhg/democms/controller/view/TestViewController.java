package top.clarkhg.democms.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestViewController {
    @RequestMapping(path = "/test")
    public String test(Model model) {
        return "test/test";
    }
}
