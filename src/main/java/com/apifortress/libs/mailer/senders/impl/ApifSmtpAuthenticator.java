package com.apifortress.libs.mailer.senders.impl;

import com.apifortress.libs.mailer.config.AbstractApifMailSmtpConfig;
import com.apifortress.libs.mailer.config.impl.PropertiesApifMailSmtpConfig;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;

public class ApifSmtpAuthenticator extends Authenticator{

    private String user;
    private String password;
    private PropertiesApifMailSmtpConfig apiProperties;

    @PostConstruct
    public void init(){
        setUser(getApiProperties().getProperties().getProperty(AbstractApifMailSmtpConfig.SMTP_USERNAME));
        setPassword(getApiProperties().getProperties().getProperty(AbstractApifMailSmtpConfig.SMTP_PASSWORD));
    }


    public PropertiesApifMailSmtpConfig getApiProperties() {
        return apiProperties;
    }

    public void setApiProperties(PropertiesApifMailSmtpConfig apiProperties) {
        this.apiProperties = apiProperties;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
