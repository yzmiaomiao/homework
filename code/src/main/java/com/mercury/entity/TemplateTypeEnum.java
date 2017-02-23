package com.mercury.entity;

public enum TemplateTypeEnum {
	ENTITY(0, "EntityTemplate.java"), DAO(1, "DaoTemplate.java"), SERVICE(2, "ServiceTemplate.java"), MAPPER(3,
			"MapperTemplate.xml");

	private int templateType;
	private String templateName;

	private TemplateTypeEnum(int templateType, String templateName) {
		this.templateType = templateType;
		this.templateName = templateName;
	}

	public int getTemplateType() {
		return templateType;
	}

	public void setTemplateType(int templateType) {
		this.templateType = templateType;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public static String getTemplateName(int type) {
		for (TemplateTypeEnum templateTypeEnum : TemplateTypeEnum.values()) {
			if (templateTypeEnum.getTemplateType() == type) {
				return templateTypeEnum.getTemplateName();
			}
		}
		return null;
	}

}
