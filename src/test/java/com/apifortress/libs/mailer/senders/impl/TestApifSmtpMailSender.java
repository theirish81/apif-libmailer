package com.apifortress.libs.mailer.senders.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
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


    AbstractApplicationContext propertiesContext;
    @Before
    public void before(){
        propertiesContext = new ClassPathXmlApplicationContext("properties-smtp-beans.xml");
    }
    @Test
    public void testSmtpSenderConfigInjection(){
        ApifSmtpMailSender mailSender = propertiesContext.getBean(ApifSmtpMailSender.class);
        assertEquals("host",mailSender.mailSmtpAuthenticator.mailSmtpConfig.getHost());
    }
    @Test
    public void testSmtpSenderAuthenticator(){
        ApifSmtpMailSender mailSender = propertiesContext.getBean(ApifSmtpMailSender.class);
        assertEquals(mailSender.mailSmtpConfig.getUsername(),mailSender.mailSmtpAuthenticator.getPasswordAuthentication().getUserName());
        assertEquals(mailSender.mailSmtpConfig.getPassword(),mailSender.mailSmtpAuthenticator.getPasswordAuthentication().getPassword());
    }
}
