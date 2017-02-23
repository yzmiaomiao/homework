package com.mercury.service;


import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mercury.component.DynamicDataSource;
import com.mercury.component.GenerateComponent;
import com.mercury.entity.ClassInfo;
import com.mercury.entity.Column;
import com.mercury.util.Const;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-test-dynamic-datasource.xml" })
public class ColumnServiceTest {

	@Autowired
	private ColumnServiceImpl columnService;
	@Autowired
	private GenerateComponent generateComponent;

	@Test
	public void testListColumns() throws IOException {
		DynamicDataSource.setDateSource("READ");
		List<Column> columns = columnService.listColumns();
		for(Column column:columns){
			System.out.println(column.toString());
		}
		DynamicDataSource.setDateSource("WRITE");
		List<Column> columns2 = columnService.listColumns();
		for(Column column2:columns2){
			System.out.println(column2.toString());
		}
	}

}
