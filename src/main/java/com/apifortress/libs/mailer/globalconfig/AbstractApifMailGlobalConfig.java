package com.apifortress.libs.mailer.globalconfig;


import com.apifortress.libs.mailer.exceptions.InvalidConfigException;
import com.apifortress.libs.mailer.util.HashtableExtended;

import javax.annotation.PostConstruct;

public abstract class AbstractApifMailGlobalConfig  extends HashtableExtended {

    @PostConstruct
    public abstract void init() throws InvalidConfigException;

    public static final String GC_MODE = "gcMode";
    public static final String GC_MODE_SMTP_VALUE = "smtp";
    public static final String GC_MODE_AMAZON_VALUE = "amazon";

    public String getGcMode() {
        return getString(GC_MODE);
    }
}
