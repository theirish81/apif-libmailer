package com.apifortress.libs.mailer;

import java.util.regex.Pattern;

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
public class ApifMail {

    private final String recipient;
    private final String subject;
    private final String mime;
    private final String text;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");

    public ApifMail(String recipient, String subject, String mime, String text) throws IllegalArgumentException {
        if(recipient == null || recipient.length() == 0)
            throw new IllegalArgumentException("Recipient cannot be null or empty");
        if(!EMAIL_PATTERN.matcher(recipient).matches())
            throw new IllegalArgumentException("Recipient must be a valid email address");
        this.recipient = recipient;
        if(subject == null || subject.length() == 0)
            throw new IllegalArgumentException("Subject cannot be null or empty");
        this.subject = subject;
        if(mime == null || mime.length() == 0)
            throw new IllegalArgumentException("Mime cannot be null or empty");
        this.mime = mime;
        if(text == null || text.length() == 0)
            throw new IllegalArgumentException("Text cannot be null or empty");
        this.text = text;
    }
}
