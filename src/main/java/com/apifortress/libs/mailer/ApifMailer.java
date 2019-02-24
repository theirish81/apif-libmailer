package com.apifortress.libs.mailer;

import com.apifortress.libs.mailer.config.AbstractApifMailGlobalConfig;
import com.apifortress.libs.mailer.senders.IApifMailSender;
import com.apifortress.libs.mailer.template.AbstractApifMailTemplate;
import com.apifortress.libs.mailer.template.ApifMailTemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

    public static String BEANS_FILE = "real-properties-smtp-beans.xml";
    ApifMailTemplateEngine apifMailTemplateEngine;
    ApplicationContext applicationContext;
    AbstractApifMailGlobalConfig mailGlobalConfig;
    IApifMailSender mailSender;
    AbstractApifMailTemplate mailTemplate;
    String parsedMailTemplate;

    public static ApifMailer instance;

    public static ApifMailer getInstance(){
        if (instance == null)
            instance = new ApifMailer();
        return instance;
    }

    private ApifMailer(){
        applicationContext = new ClassPathXmlApplicationContext(BEANS_FILE);
        apifMailTemplateEngine = (ApifMailTemplateEngine)applicationContext.getBean("apifMailTemplateEngine");
        mailGlobalConfig = (AbstractApifMailGlobalConfig)applicationContext.getBean("globalConfig");
    }

    public void send(List<String> recipients, String subject, String templateName, Map<String,Object> variables, String mime) throws Exception {
        for (String recipient : recipients){
            send(recipient, subject , templateName,variables,mime);
        }
    }

    public void send(String recipient, String subject, String templateName, Map<String,Object> variables, String mime) throws Exception{
        send(new ApifMail(recipient, subject, mime, apifMailTemplateEngine.parse(getApiTemplate(templateName),variables)));
    }

    public void send(String recipient, String subject, String template, String mime) throws Exception{
        send(new ApifMail(recipient, subject, mime, template));
    }

    public void send(ApifMail mail){
        try {
            getApifSender().send(mail);
        }catch(Exception e){ log.error("Error while sending email to "+mail.getRecipient(),e);}
    }

    private IApifMailSender getApifSender(){
        if (mailSender == null) {
            if (isSmtpMode())
                mailSender = (IApifMailSender) applicationContext.getBean("apifSmtpMailSender");
        }

        return mailSender;
    }

    private AbstractApifMailTemplate getApiTemplate(String templateName) throws Exception {
        if (mailTemplate == null) {
            mailTemplate = applicationContext.getBean("apifMailTemplate",AbstractApifMailTemplate.class);
            mailTemplate.load(templateName);
        }

        return mailTemplate;
    }

    public String getParsedTemplate (String templateName,Map<String,Object> variables) throws Exception {
        AbstractApifMailTemplate mailTemplate = getApiTemplate(templateName);
        mailTemplate.load(templateName);
        parsedMailTemplate = apifMailTemplateEngine.parse(mailTemplate,variables);
        return parsedMailTemplate;
    }

    private Boolean isSmtpMode(){
        return   AbstractApifMailGlobalConfig.GC_MODE_SMTP_VALUE.equals(mailGlobalConfig.getGcMode()) ? true : false;
    }

}
