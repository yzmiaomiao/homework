package com.mercury.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.component.GenerateComponent;
import com.mercury.entity.ClassInfo;
import com.mercury.entity.TemplateTypeEnum;

@Controller
@RequestMapping(value = "code")
public class CodeGenerateController {

	@Autowired
	private GenerateComponent generateComponent;

	@RequestMapping(value = "index")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("code/index");
		return mav;
	}

	@RequestMapping(value = "generate")
	public ModelAndView generate(ModelAndView mav, ClassInfo param) {
		try {
			for (TemplateTypeEnum type : TemplateTypeEnum.values()) {
				ClassInfo classInfo = generateComponent.generateClassInfo(param.getOutputFilePath(),
						param.getBasePackageName(), param.getTemplateDir(), type.getTemplateType(),
						param.getTableName());
				generateComponent.WriteFileFromClassInfo(classInfo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		mav.setViewName("redirect:/code/index");
		return mav;
	}

}
