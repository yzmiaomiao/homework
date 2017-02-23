package com.mercury.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

	@RequestMapping(value = "index")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("admin/index");
		return mav;
	}

}
