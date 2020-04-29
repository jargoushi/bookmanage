package com.bijian.bookmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/24
 * @Content:
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "/admin/user/index";
    }
}
