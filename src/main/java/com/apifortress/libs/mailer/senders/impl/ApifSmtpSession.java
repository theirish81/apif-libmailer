package com.apifortress.libs.mailer.senders.impl;

import com.apifortress.libs.mailer.config.impl.PropertiesApifMailSmtpConfig;
import javax.mail.*;
import java.util.Properties;

public class ApifSmtpSession{

    private ApifSmtpAuthenticator apifSmtpAuth;

    public Session init()
    {
        return Session.getDefaultInstance(apifSmtpAuth.getApiProperties().getProperties(),apifSmtpAuth);
    }

    public ApifSmtpAuthenticator getApifSmtpAuth() {

        return apifSmtpAuth;
    }

    public void setApifSmtpAuth(ApifSmtpAuthenticator apifSmtpAuth) {

        this.apifSmtpAuth = apifSmtpAuth;
    }

}

