package com.mercury.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesComponent {

	@Value("${log.env}")
	private String logEnv;

	@Value("${projectName}")
	private String projectName;

	@Value("${uploadDir}")
	private String uploadDir;

	public String getLogEnv() {
		return logEnv;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getUploadDir() {
		return uploadDir;
	}

}
