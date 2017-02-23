package com.mercury.component;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

	private static final ThreadLocal<String> contextHolder = new InheritableThreadLocal<String>();

	@Override
	protected Object determineCurrentLookupKey() {
		String currentDataSource = contextHolder.get();
		System.out.println("[" + Thread.currentThread().getName() + "] :" + currentDataSource);
		return currentDataSource;
	}

	public static void setDateSource(String dateSource) {
		contextHolder.set(dateSource);
	}
}
