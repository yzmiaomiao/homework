package com.mercury.entity;

public enum OutputFileNameEnum {

	ENTITY(0, ".java"), DAO(1, "Service.java"), SERVICE(2, "ServiceImpl.java"), MAPPER(3, "Mapper.xml");

	private int templateType;
	private String fileName;

	private OutputFileNameEnum(int templateType, String fileName) {
		this.templateType = templateType;
		this.fileName = fileName;
	}

	public int getTemplateType() {
		return templateType;
	}

	public void setTemplateType(int templateType) {
		this.templateType = templateType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public static String getFileName(int type) {
		for (OutputFileNameEnum outputFileEnum : OutputFileNameEnum.values()) {
			if (outputFileEnum.getTemplateType() == type) {
				return outputFileEnum.getFileName();
			}
		}
		return null;
	}

}
