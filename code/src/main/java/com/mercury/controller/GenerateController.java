package com.mercury.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.entity.Column;
import com.mercury.service.ColumnServiceImpl;

@Controller
@RequestMapping(value = "generate")
public class GenerateController {

	@Autowired
	private ColumnServiceImpl columnService;

	@RequestMapping(value = "class")
	public ModelAndView generateClass(ModelAndView mv) {
		String packageName = "com.mercury.entity";
		List<Column> columns = columnService.listColumns();
		boolean hasDate = false;
		for (Column column : columns) {
			if (column.getDataType().equals("Date")) {
				hasDate = true;
			}
		}
		mv.addObject("packageName", packageName);
		mv.addObject("hasDate", hasDate);
		mv.addObject("columns", columns);
		mv.setViewName("generate/class");
		return mv;
	}

}
