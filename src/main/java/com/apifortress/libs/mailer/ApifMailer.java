package com.apifortress.libs.mailer;

import com.apifortress.libs.mailer.senders.IApifMailSender;
import com.apifortress.libs.mailer.template.AbstractApifMailTemplate;
import com.apifortress.libs.mailer.template.ApifMailTemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

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
public class ApifMailer {

    private final Logger log = LoggerFactory.getLogger(ApifMailer.class);

    @Autowired
    IApifMailSender mailSender;

    @Autowired
    ApifMailTemplateEngine templateEngine;

    @Autowired
    ApplicationContext applicationContext;


    public void send(List<String> recipients, String subject, String templateName, Map<String,Object> variables, String mime) throws Exception {

    }

    private void sendMail(ApifMail mail){
        try {
            mailSender.send(mail);
        }catch(Exception e){ log.error("Error while sending email to "+mail.getRecipient(),e);}
    }
}
