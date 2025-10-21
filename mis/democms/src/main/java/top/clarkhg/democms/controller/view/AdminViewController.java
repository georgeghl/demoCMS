package top.clarkhg.democms.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminViewController {

    @RequestMapping(path="/admin/1145141919810")
    public String admin(Model model){
        return "admin/index";
    }
}
