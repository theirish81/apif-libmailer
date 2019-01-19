package com.apifortress.libs.mailer.senders.impl;

import com.apifortress.libs.mailer.config.impl.PropertiesApifMailSmtpConfig;
import javax.mail.*;
import java.util.Properties;

public class ApifSmtpSession{

    private ApifSmtpAuthenticator apifSmtpAuth;
    private PropertiesApifMailSmtpConfig apifProps;

    public Session init()
    {

        return Session.getDefaultInstance(apifProps.getProperties(),apifSmtpAuth);
    }

    public ApifSmtpAuthenticator getApifSmtpAuth() {

        return apifSmtpAuth;
    }

    public void setApifSmtpAuth(ApifSmtpAuthenticator apifSmtpAuth) {

        this.apifSmtpAuth = apifSmtpAuth;
    }

    public PropertiesApifMailSmtpConfig getApifProps()
    {
        return apifProps;
    }

    public void setApifProps(PropertiesApifMailSmtpConfig apifProps) {

        this.apifProps = apifProps;
    }

}

