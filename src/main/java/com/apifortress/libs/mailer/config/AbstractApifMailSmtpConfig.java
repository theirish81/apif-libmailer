package com.apifortress.libs.mailer.config;

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
public abstract class AbstractApifMailSmtpConfig extends AbstractApifMailConfig {

    public static final String SMTP_HOST = "smtpHost";
    public static final String SMTP_USERNAME = "smtpUsername";
    public static final String SMTP_PASSWORD = "smtpPassword";
    public static final String SMTP_NO_AUTH = "smtpNoAuth";
    public static final String SMTP_PORT = "smtpPort";
    public static final String SMTP_START_TLS = "smtpStartTLS";
    public static final String SMTP_FROM = "smtpFrom";

    public String getHost(){
        return getString(SMTP_HOST);
    }
    public String getUsername(){
        return getString(SMTP_USERNAME);
    }
    public String getPassword(){
        return getString(SMTP_PASSWORD);
    }
    public boolean isNoAuth(){
        return getBoolean(SMTP_NO_AUTH);
    }
    public int getPort(){
        return getInt(SMTP_PORT);
    }
    public boolean isStartTls(){
        return getBoolean(SMTP_START_TLS);
    }
    public String getFrom() {
        return getString(SMTP_FROM);
    }
}
