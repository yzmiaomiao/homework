package com.mercury.web.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.Log4jWebConfigurer;

import com.mercury.component.PropertiesComponent;

public class MercuryContextListener extends ContextLoaderListener {


    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out
                .println("----------------------------------------加载资源START-------------------------------------------");
        super.contextInitialized(event);
        ApplicationContext applicationContext =
                WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        PropertiesComponent propertiesComponent =
                (PropertiesComponent) applicationContext.getBean("propertiesComponent");
        event.getServletContext().setInitParameter(Log4jWebConfigurer.CONFIG_LOCATION_PARAM,
                "classpath:log4j-" + propertiesComponent.getLogEnv() + ".xml");
        Log4jWebConfigurer.initLogging(event.getServletContext());
        System.out
                .println("----------------------------------------加载资源END----------------------------------------------");
    }
}
