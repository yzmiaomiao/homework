package com.mercury.service;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mercury.component.GenerateComponent;
import com.mercury.entity.ClassInfo;
import com.mercury.util.Const;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-test.xml" })
public class GenerateMybatisServiceTest {

	@Autowired
	private GenerateComponent generateComponent;

	@Test
	public void testGenerateMybatis() throws IOException {
		String baseOutputFilePath = "/Users/gix/Documents/workspace/mercury/src/main/java/";
		String basePackageName = "com.mercury";
		String templateDir = "/Users/gix/Documents/workspace/mercury/src/main/webapp/WEB-INF/velocity/template/";
		int templateType = Const.TEMPLATE_TYPE_MAPPER;
		// String outputFilePath =
		// "/Users/gix/Documents/workspace/mercury/src/main/java/com/mercury/mapping/TestMapper.xml";
		String tableName = "test";
		ClassInfo classInfo = generateComponent.generateClassInfo(baseOutputFilePath, basePackageName, templateDir,
				templateType, tableName);
		System.out.println(classInfo.toString());
		 generateComponent.WriteFileFromClassInfo(classInfo);
	}

}
