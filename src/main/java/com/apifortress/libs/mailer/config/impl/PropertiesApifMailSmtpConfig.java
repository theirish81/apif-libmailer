package com.apifortress.libs.mailer.config.impl;

import com.apifortress.libs.mailer.config.AbstractApifMailSmtpConfig;
import com.apifortress.libs.mailer.exceptions.InvalidConfigException;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
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

    private String filename = FILENAME;
    private Properties properties;

    @Override
    public void init() throws InvalidConfigException {
        properties = new Properties();
        InputStream filePropertiesStream = null;
        try {
                filePropertiesStream = new FileInputStream(new File(filename));

                getProperties().load(filePropertiesStream);

                put(SMTP_HOST, getProperties().getProperty(SMTP_HOST));
                put(SMTP_USERNAME, getProperties().getProperty(SMTP_USERNAME));
                put(SMTP_PASSWORD, getProperties().getProperty(SMTP_PASSWORD));
                put(SMTP_NO_AUTH, getProperties().getProperty(SMTP_NO_AUTH));
                put(SMTP_PORT, Integer.valueOf(getProperties().getProperty(SMTP_PORT)));
                put(SMTP_START_TLS, Boolean.valueOf(getProperties().getProperty(SMTP_START_TLS)));

        } catch (Exception ex) {
            throw new InvalidConfigException(ex.getMessage());
        } finally{
            try {
                filePropertiesStream.close();
            }catch(IOException e){e.printStackTrace();}
        }

    }

    public void setFilename(String filename){
        this.filename = filename;
    }

    public Properties getProperties() {
        return properties;
    }
}
