package com.mercury.entity;

import java.util.HashMap;
import java.util.Map;

public class DataTypeMapper {

	// 数据库数据类型、java数据类型映射map
	public static Map<String, String> dataTypeMapping = new HashMap<String, String>();

	// 初始化数据库类型与java类型转换
	static {
		dataTypeMapping.put("int", "int");
		dataTypeMapping.put("tinyint", "int");
		dataTypeMapping.put("smallint", "int");
		dataTypeMapping.put("mediumint", "int");
		dataTypeMapping.put("integer", "int");
		dataTypeMapping.put("bigint", "long");
		dataTypeMapping.put("bit", "boolean");
		dataTypeMapping.put("real", "float");
		dataTypeMapping.put("double", "double");
		dataTypeMapping.put("float", "float");
		dataTypeMapping.put("float", "float");
		dataTypeMapping.put("decimal", "BigDecimal");
		dataTypeMapping.put("numeric", "BigDecimal");
		dataTypeMapping.put("char", "String");
		dataTypeMapping.put("varchar", "String");
		dataTypeMapping.put("date", "Date");
		dataTypeMapping.put("time", "Time");
		dataTypeMapping.put("year", "Date");
		dataTypeMapping.put("timestamp", "Timestamp");
		dataTypeMapping.put("datetime", "Date");
		dataTypeMapping.put("tinyblob", "byte[]");
		dataTypeMapping.put("blob", "byte[]");
		dataTypeMapping.put("mediumblob", "byte[]");
		dataTypeMapping.put("longblob", "byte[]");
		dataTypeMapping.put("tinytext", "String");
		dataTypeMapping.put("text", "String");
		dataTypeMapping.put("mediumtext", "String");
		dataTypeMapping.put("longtext", "String");
		dataTypeMapping.put("binary", "byte[]");
	}

}
