package com.apifortress.libs.mailer.config.impl;

import com.apifortress.libs.mailer.config.AbstractApifMailSmtpConfig;

import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Properties;

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
public class PropertiesApifMailSmtpConfig extends AbstractApifMailSmtpConfig {

    public static final String FILENAME = "libmailer.properties";

    @Override
    public void init() throws Exception {
        Properties properties = new Properties();
        try {
                InputStream filePropertiesStream = this.getClass().getClassLoader().getResourceAsStream(FILENAME);
                //questo mi è servito per capire il path che usa IntelliJ.
                //String test = this.getClass().getResource("/").getPath();
                properties.load(filePropertiesStream);

                put(SMTP_HOST, properties.getProperty(SMTP_HOST));
                put(SMTP_USERNAME, properties.getProperty(SMTP_USERNAME));
                put(SMTP_PASSWORD, properties.getProperty(SMTP_PASSWORD));
                put(SMTP_NO_AUTH, properties.getProperty(SMTP_NO_AUTH));
                put(SMTP_PORT, properties.getProperty(SMTP_PORT));
                put(SMTP_START_TLS, properties.getProperty(SMTP_START_TLS));

        } catch (Exception ex)
        {
            //do something here.
        }

    }
}
