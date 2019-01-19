package com.apifortress.libs.mailer.senders.impl;

import com.apifortress.libs.mailer.config.AbstractApifMailSmtpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

@Component
@Lazy
public class ApifSmtpAuthenticator extends Authenticator{

    @Autowired
    AbstractApifMailSmtpConfig mailSmtpConfig;

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(mailSmtpConfig.getUsername(), mailSmtpConfig.getPassword());
    }
}
