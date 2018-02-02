package com.trickster.addmybatis.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
    @RequestMapping(value={"", "index"})
    public String index(){
        return "index";
    }
}
