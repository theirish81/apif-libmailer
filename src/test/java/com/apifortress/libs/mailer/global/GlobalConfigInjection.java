package com.apifortress.libs.mailer.global;

import com.apifortress.libs.mailer.config.AbstractApifMailSmtpConfig;
import com.apifortress.libs.mailer.globalconfig.AbstractApifMailGlobalConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * @author 2019 Simone Pezzano
 *         ---
 *         Licensed to the Apache Software Foundation (ASF) under one
 *         or more contributor license agreements.  See the NOTICE file
 *         distributed with this work for additional information
 *         regarding copyright ownership.  The ASF licenses this file
 *         to you under the Apache License, Version 2.0 (the
 *         "License"); you may not use this file except in compliance
 *         with the License.  You may obtain a copy of the License at
 *         <p>
 *         http://www.apache.org/licenses/LICENSE-2.0
 *         <p>
 *         Unless required by applicable law or agreed to in writing,
 *         software distributed under the License is distributed on an
 *         "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *         KIND, either express or implied.  See the License for the
 *         specific language governing permissions and limitations
 *         under the License.
 */
public class GlobalConfigInjection {

    @Test
    public void testPropertiesConfigInjection() {
        ApplicationContext propertiesContext = new ClassPathXmlApplicationContext("global-configuration-beans.xml");
        AbstractApifMailGlobalConfig gcCfg = propertiesContext.getBean("globalConfig", AbstractApifMailGlobalConfig.class);
        assertEquals("PropertiesAbstractApifMailGlobalConfig", gcCfg.getClass().getSimpleName());
        assertEquals("smtp", gcCfg.get(AbstractApifMailGlobalConfig.GC_MODE));
    }
}
