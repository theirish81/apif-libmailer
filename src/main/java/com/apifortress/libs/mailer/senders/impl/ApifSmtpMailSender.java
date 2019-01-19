package com.apifortress.libs.mailer.senders.impl;

import com.apifortress.libs.mailer.ApifMail;
import com.apifortress.libs.mailer.config.AbstractApifMailSmtpConfig;
import com.apifortress.libs.mailer.senders.IApifMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
@Component
@Lazy
public class ApifSmtpMailSender implements IApifMailSender {

    @Autowired
    AbstractApifMailSmtpConfig mailSmtpConfig;

    @Autowired
    ApifSmtpAuthenticator mailSmtpAuthenticator;

    private Properties javamailProperties;
    private static String JM_KEY_DO_AUTH = "mail.smtp.auth";
    private static String JM_KEY_TRANSPORT = "mail.transport.protocol";
    private static String JM_VALUE_TRANSPORT = "smtp";
    private static String JM_KEY_SOCKERFACTORY = "mail.smtp.socketFactory.class";
    private static String JM_VALUE_SOCKERFACTORY = "javax.net.ssl.SSLSocketFactory";
    private static String JM_KEY_HOST = "mail.smtp.host";
    private static String JM_KEY_PORT = "mail.smtp.port";

    /**
     * AbstractApifMailSmtpConfig is config independent, therefore we need to convert
     * the properties into a Javamail compatible properties object
     */
    @PostConstruct
    public void init(){
        javamailProperties = new Properties();
        javamailProperties.put(JM_KEY_DO_AUTH,!mailSmtpConfig.isNoAuth());
        javamailProperties.put(JM_KEY_TRANSPORT,JM_VALUE_TRANSPORT);
        javamailProperties.put(JM_KEY_SOCKERFACTORY,JM_VALUE_SOCKERFACTORY);
        javamailProperties.put(JM_KEY_HOST,mailSmtpConfig.getHost());
        javamailProperties.put(JM_KEY_PORT,mailSmtpConfig.getPort());
    }

    public void send(ApifMail mail) throws Exception {
        Session session;
        if(mailSmtpConfig.isNoAuth())
            session = Session.getInstance(javamailProperties);
        else
            session = Session.getInstance(javamailProperties,mailSmtpAuthenticator);

        Transport transport = session.getTransport();

        transport.connect();

        transport.close();
    }
}

