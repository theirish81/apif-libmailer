package com.apifortress.libs.mailer.senders.impl;

import javax.mail.Authenticator;

public class ApifSmtpAuthenticator extends Authenticator{

    private String user;
    private String password;

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
