package com.apifortress.libs.mailer.config;


import com.apifortress.libs.mailer.exceptions.InvalidConfigException;
import com.apifortress.libs.mailer.util.HashtableExtended;

import javax.annotation.PostConstruct;

public abstract class AbstractApifMailGlobalConfig  extends HashtableExtended {

    @PostConstruct
    public abstract void init() throws InvalidConfigException;

    public static final String GC_MODE_KEY = "gcMode";
    public static final String GC_MODE_SMTP_VALUE = "smtp";
    public static final String GC_MODE_AMAZON_VALUE = "amazon";

    public static final String GC_TEMPLATE_KEY = "gcTemplate";
    public static final String GC_TEMPLATE_VALUE = "fs";


    public String getGcMode() {
        return getString(GC_MODE_KEY);
    }
    public String getGcTemplate(){ return getString(GC_TEMPLATE_KEY);}
}
