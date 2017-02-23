package com.mercury.entity;

import com.google.common.base.Strings;

public class Column {

	private String columnName; // 字段名称
	private String dataType; // 字段类型
	private String columnDefault; // 字段默认值
	private String columnComment;// 数据库中对字段的备注
	private String columnKey;// 是否特殊字段，例如某些唯一约束、主键约束或者外键约束限制的字段
	private String firstLetterUpperColumnName;// 首字母大写的字段名称,用于实体类属性
	private String firstLetterLowerColumnName;// 首字母小写的字段名称,用于实体类属性

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = DataTypeMapper.dataTypeMapping.get((dataType));
	}

	public String getColumnDefault() {
		return columnDefault;
	}

	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		if (Strings.isNullOrEmpty(columnComment)) {
			this.columnComment = "";
		} else {
			this.columnComment = "// " + columnComment;
		}
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getFirstLetterUpperColumnName() {
		return firstLetterUpperColumnName;
	}

	public void setFirstLetterUpperColumnName(String firstLetterUpperColumnName) {
		this.firstLetterUpperColumnName = firstLetterUpperColumnName;
	}

	public String getFirstLetterLowerColumnName() {
		return firstLetterLowerColumnName;
	}

	public void setFirstLetterLowerColumnName(String firstLetterLowerColumnName) {
		this.firstLetterLowerColumnName = firstLetterLowerColumnName;
	}

	@Override
	public String toString() {
		return "Column [columnName=" + columnName + ", dataType=" + dataType + ", columnDefault=" + columnDefault
				+ ", columnComment=" + columnComment + ", columnKey=" + columnKey + ", firstLetterUpperColumnName="
				+ firstLetterUpperColumnName + ", firstLetterLowerColumnName=" + firstLetterLowerColumnName + "]";
	}

}
