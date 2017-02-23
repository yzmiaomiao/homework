package com.mercury.component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.mercury.entity.ClassInfo;
import com.mercury.entity.Column;
import com.mercury.entity.OutputFileNameEnum;
import com.mercury.entity.OutputFolderEnum;
import com.mercury.entity.TemplateTypeEnum;
import com.mercury.service.ColumnServiceImpl;
import com.mercury.util.MercuryStringUtils;

@Component
public class GenerateComponent {
	@Autowired
	private ColumnServiceImpl columnService;

	public ClassInfo generateClassInfo(String baseOutputFilePath, String basePackageName, String templateDir,
			int templateType, String tableName) {
		ClassInfo classInfo = new ClassInfo();
		classInfo.setTableName(tableName);
		classInfo.setBasePackageName(basePackageName);
		classInfo.setClassName(MercuryStringUtils.firstLetterUpper(tableName));
		classInfo.setFirstLetterLowerClassName(MercuryStringUtils.firstLetterLower(tableName));
		List<Column> columns = columnService.listColumns();
		Boolean hasDate = false;
		Column primaryKey = null;
		Iterator<Column> sListIterator = columns.iterator();
		while (sListIterator.hasNext()) {
			Column column = sListIterator.next();
			if (column.getColumnKey().equals("PRI")) {
				primaryKey = column;
			}
			if (column.getDataType().equals("Date")) {
				hasDate = true;
			}
			if (!Strings.isNullOrEmpty(column.getColumnDefault())) {
				sListIterator.remove();
			}
		}
		classInfo.setColumns(columns);
		classInfo.setHasDate(hasDate);
		classInfo.setPrimaryKey(primaryKey);
		classInfo.setTemplateDir(templateDir);
		classInfo.setTemplateType(templateType);
		classInfo.setOutputFilePath(new StringBuffer(baseOutputFilePath).append(basePackageName.replace(".", "/"))
				.append("/").append(OutputFolderEnum.getFolerName(templateType)).append("/")
				.append(MercuryStringUtils.firstLetterUpper(tableName))
				.append(OutputFileNameEnum.getFileName(templateType)).toString());
		return classInfo;
	}

	/**
	 * 将 ClassInfo 中定义的信息写入到文件
	 * 
	 * @param classInfo
	 * @throws IOException
	 */
	public void WriteFileFromClassInfo(ClassInfo classInfo) throws IOException {
		VelocityContext context = new VelocityContext();
		context.put("classInfo", classInfo);
		WriteFileFromVelocityContext(context);
	}

	/**
	 * 将 VelocityContext 内容写入文件
	 * 
	 * @param context
	 * @throws IOException
	 */
	public void WriteFileFromVelocityContext(VelocityContext context) throws IOException {
		ClassInfo classInfo = (ClassInfo) context.get("classInfo");
		Properties pro = new Properties();
		pro.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
		pro.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
		pro.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, classInfo.getTemplateDir());
		VelocityEngine ve = new VelocityEngine(pro);

		Template t = ve.getTemplate(TemplateTypeEnum.getTemplateName(classInfo.getTemplateType()), "UTF-8");
		File file = new File(classInfo.getOutputFilePath());
		System.out.println(file.getAbsolutePath());
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream outStream = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(outStream, "UTF-8");
		BufferedWriter sw = new BufferedWriter(writer);
		t.merge(context, sw);
		sw.flush();
		sw.close();
		outStream.close();
	}

}
