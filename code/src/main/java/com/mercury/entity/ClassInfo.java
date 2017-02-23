package com.mercury.entity;

import java.util.List;

public class ClassInfo {

	private String tableName;// 表名
	private String basePackageName;// 包名
	private String className;// 类名
	private String firstLetterLowerClassName;// 首字母小写的类名，用于对象
	private List<Column> columns;// 字段信息
	private Column primaryKey; // 主键
	private Boolean hasDate;// 是否有日期值
	private String templateDir;// 模版文件目录
	/**
	 * 模版文件类型
	 * 
	 * @see com.mercury.entity.TemplateTypeEnum
	 */
	private int templateType;
	private String outputFilePath;// 输出文件地址

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getBasePackageName() {
		return basePackageName;
	}

	public void setBasePackageName(String basePackageName) {
		this.basePackageName = basePackageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFirstLetterLowerClassName() {
		return firstLetterLowerClassName;
	}

	public void setFirstLetterLowerClassName(String firstLetterLowerClassName) {
		this.firstLetterLowerClassName = firstLetterLowerClassName;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public Column getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Column primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Boolean getHasDate() {
		return hasDate;
	}

	public void setHasDate(Boolean hasDate) {
		this.hasDate = hasDate;
	}

	public String getTemplateDir() {
		return templateDir;
	}

	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}

	public int getTemplateType() {
		return templateType;
	}

	public void setTemplateType(int templateType) {
		this.templateType = templateType;
	}

	public String getOutputFilePath() {
		return outputFilePath;
	}

	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	@Override
	public String toString() {
		return "ClassInfo [tableName=" + tableName + ", basePackageName=" + basePackageName + ", className=" + className
				+ ", firstLetterLowerClassName=" + firstLetterLowerClassName + ", columns=" + columns + ", primaryKey="
				+ primaryKey + ", hasDate=" + hasDate + ", templateDir=" + templateDir + ", templateType="
				+ templateType + ", outputFilePath=" + outputFilePath + "]";
	}
}
