package com.skytech.application.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Lianhong_ on 2018/06/21 17:00
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "/index.html";
    }
}