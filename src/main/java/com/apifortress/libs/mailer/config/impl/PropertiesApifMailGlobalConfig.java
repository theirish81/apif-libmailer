package com.apifortress.libs.mailer.config.impl;

import com.apifortress.libs.mailer.exceptions.InvalidConfigException;
import com.apifortress.libs.mailer.config.AbstractApifMailGlobalConfig;
import com.apifortress.libs.mailer.util.LoadProperties;

import java.util.Properties;

public class PropertiesApifMailGlobalConfig extends AbstractApifMailGlobalConfig {

    public static final String FILENAME = "global.properties";

    private String filename = FILENAME;

    @Override
    public void init() throws InvalidConfigException {
        Properties properties = LoadProperties.getProperties(filename);

        put(GC_MODE_KEY, properties.getProperty(GC_MODE_KEY));
        put(GC_TEMPLATE_KEY, properties.getProperty(GC_TEMPLATE_KEY));
    }


    public void setFilename(String filename){
        this.filename = filename;
    }

}
