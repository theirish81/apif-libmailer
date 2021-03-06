package com.apifortress.libs.mailer.senders.impl;

import com.apifortress.libs.mailer.ApifMail;
import com.apifortress.libs.mailer.config.AbstractApifMailAmazonConfig;
import com.apifortress.libs.mailer.config.AbstractApifMailConfig;
import com.apifortress.libs.mailer.senders.IApifMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

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
public class ApifAmazonMailSender implements IApifMailSender {

    @Autowired
    AbstractApifMailAmazonConfig mailConfig;

    public void send(ApifMail mail) throws Exception{

    }
}
