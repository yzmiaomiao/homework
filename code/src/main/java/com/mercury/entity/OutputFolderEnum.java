package com.mercury.entity;

public enum OutputFolderEnum {

	ENTITY(0, "entity"), DAO(1, "dao"), SERVICE(2, "service"), MAPPER(3, "mapping");

	private int templateType;
	private String folerName;

	private OutputFolderEnum(int templateType, String folerName) {
		this.templateType = templateType;
		this.folerName = folerName;
	}

	public int getTemplateType() {
		return templateType;
	}

	public void setTemplateType(int templateType) {
		this.templateType = templateType;
	}

	public String getFolerName() {
		return folerName;
	}

	public void setFolderName(String folerName) {
		this.folerName = folerName;
	}

	public static String getFolerName(int type) {
		for (OutputFolderEnum outputFolderEnum : OutputFolderEnum.values()) {
			if (outputFolderEnum.getTemplateType() == type) {
				return outputFolderEnum.getFolerName();
			}
		}
		return null;
	}

}
