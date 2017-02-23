package com.mercury.web.velocity;

import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

public class ExVelocityLayoutViewResolver extends VelocityLayoutViewResolver {

	/**
	 * 使用拓展的view
	 */
	@Override
	protected Class<?> requiredViewClass() {
		return ExVelocityLayoutView.class;
	}

}
