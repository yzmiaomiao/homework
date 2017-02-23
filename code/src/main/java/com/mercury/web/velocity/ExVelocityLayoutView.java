package com.mercury.web.velocity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolboxFactory;
import org.apache.velocity.tools.config.XmlFactoryConfiguration;
import org.apache.velocity.tools.view.ViewToolContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

public class ExVelocityLayoutView extends VelocityLayoutView {

	private static final Logger logger = LoggerFactory.getLogger(ExVelocityLayoutView.class);

	/**
	 * 这段代码在Spring中已经过时，重新实现
	 */
	@Override
	protected Context createVelocityContext(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ViewToolContext viewToolContext = new ViewToolContext(getVelocityEngine(), request, response,
				getServletContext());

		String rootPath = request.getContextPath();
		viewToolContext.put("rootPath", rootPath);

		// TODO 设置Tool-boox 可以做缓存处理
		if (StringUtils.isNotBlank(getToolboxConfigLocation())) {
			XmlFactoryConfiguration factoryConfiguration = new XmlFactoryConfiguration();
			Resource resource = new PathMatchingResourcePatternResolver().getResource(getToolboxConfigLocation());
			try {
				factoryConfiguration.read(resource.getURL());
				ToolboxFactory toolBoxfactory = factoryConfiguration.createFactory();
				viewToolContext.addToolbox(toolBoxfactory.createToolbox(Scope.APPLICATION));
				viewToolContext.addToolbox(toolBoxfactory.createToolbox(Scope.REQUEST));
				viewToolContext.addToolbox(toolBoxfactory.createToolbox(Scope.SESSION));
			} catch (Exception e) {
				logger.warn("velocity path:{} tool boox load error ", new String[] { getToolboxConfigLocation() }, e);
			}
		}
		return viewToolContext;
	}

}
