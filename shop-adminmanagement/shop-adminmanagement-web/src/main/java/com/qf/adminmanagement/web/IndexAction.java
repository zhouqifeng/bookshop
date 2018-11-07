package com.qf.adminmanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexAction {

    @GetMapping("/{path}")
    public String index1(@PathVariable String path){
        return path;
    }

    @GetMapping("/pages/{path}")
    public String index2(@PathVariable String path) {
        return "pages/" + path;
    }

}
