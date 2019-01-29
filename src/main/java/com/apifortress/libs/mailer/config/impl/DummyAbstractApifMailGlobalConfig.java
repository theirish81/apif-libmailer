package com.apifortress.libs.mailer.config.impl;

import com.apifortress.libs.mailer.exceptions.InvalidConfigException;
import com.apifortress.libs.mailer.config.AbstractApifMailGlobalConfig;

public class DummyAbstractApifMailGlobalConfig extends AbstractApifMailGlobalConfig {

    @Override
    public void init() throws InvalidConfigException {
        put(GC_MODE,"foo.bar");
    }
}
