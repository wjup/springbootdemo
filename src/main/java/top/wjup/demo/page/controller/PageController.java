package top.wjup.demo.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by wjup on 2020/5/26 17:24
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/index")
    public String index() {

        return "index";
    }
}
