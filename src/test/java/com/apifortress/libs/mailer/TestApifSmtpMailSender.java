package com.apifortress.libs.mailer;

import com.apifortress.libs.mailer.config.AbstractApifMailSmtpConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
public class TestApifSmtpMailSender {

    @Test
    public void testConfigInjection(){
        /*
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dummy-smtp-beans.xml");
        AbstractApifMailSmtpConfig config = applicationContext.getBean("mailSmtpConfig", AbstractApifMailSmtpConfig.class);
        assertEquals("DummyApifMailSmtpConfig",config.getClass().getSimpleName());
        assertEquals("foo.bar",config.get("smtpHost"));*/

        ApplicationContext propertiesContext = new ClassPathXmlApplicationContext("dummy-prop-beans.xml");
        AbstractApifMailSmtpConfig propCfg = propertiesContext.getBean("propertiesApifMailSmtpConfig", AbstractApifMailSmtpConfig.class);
        assertEquals("PropertiesApifMailSmtpConfig",propCfg.getClass().getSimpleName());
        assertEquals("host",propCfg.get(AbstractApifMailSmtpConfig.SMTP_HOST));
    }
}
