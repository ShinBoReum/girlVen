package com.girlvengers.gvc.controller;


import com.girlvengers.gvc.service.CSVService;
import com.girlvengers.gvc.service.GvcService;
import com.girlvengers.gvc.vo.CSVVo;
import com.girlvengers.gvc.vo.GvcVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class gvcController {

    @RequestMapping(value = "/home")
    public String home(){
        return "index.html";
    }

    @ResponseBody
    @RequestMapping("/valueTest")
    public String valueTest(){
        String value = "valueTest";
        return value;
    }


    @RequestMapping(value = "/hot")
    public String hot(){
        return "hotDepTest.html";
    }

    @RequestMapping("/thymeleafTest")
    public String thymeleafTest(Model model) {
        GvcVo gvcVo = new GvcVo("boReum", "보름잉");
        model.addAttribute("testModel", gvcVo);
        return "views/thymeleafTest";
        
    }

    @Autowired
    GvcService gvcService;

    @RequestMapping(value = "/gvc")
    public ModelAndView gvc() throws Exception{
        ModelAndView mav = new ModelAndView("gvc");

        List<GvcVo> gvcVoList = gvcService.selectTest();
        mav.addObject("list",gvcVoList);


        return mav;
    }

    @RequestMapping("/test")
    public ModelAndView test() throws Exception{
        ModelAndView mav = new ModelAndView("test");

        List<GvcVo> gvcVoList = gvcService.selectTest();
        mav.addObject("list",gvcVoList);


        return mav;
    }

    @Autowired
    CSVService csvService;

    @RequestMapping(value = "/csv")
    public ModelAndView csv() throws Exception{
        ModelAndView mav = new ModelAndView("csv");
;
        mav.addObject("list","success");


        return mav;
    }




}
