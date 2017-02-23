package com.mercury.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.component.PropertiesComponent;
import com.mercury.service.ColumnServiceImpl;

@Controller
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    private PropertiesComponent propertiesComponent;

    @Autowired
    private ColumnServiceImpl columnService;

    @RequestMapping(value = "index")
    public ModelAndView index(ModelAndView model) {
        System.out.println(columnService.listColumns().toString());
        model.addObject("test", propertiesComponent.getUploadDir());
        model.setViewName("test/index");
        return model;
    }

}
