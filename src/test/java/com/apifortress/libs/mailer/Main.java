package com.apifortress.libs.mailer;

import com.apifortress.libs.mailer.senders.IApifMailSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class Main {

    public static void main(String[] args) throws Exception {
        ApifMailer apifMailer = ApifMailer.getInstance();
       // apifMailer.send(new ApifMail("dbrach77@gmail.com","prova","text/html","prova"));

        Map<String,Object> map = new HashMap<>();
        map.put("foo","bar");
        apifMailer.send("dbrach77@gmail.com","foo","foobar.txt",map,"text/html");

        map.clear();
        map.put("foo","bar2");
        apifMailer.send("dbrach77@gmail.com","foo2","foobar.txt",map,"text/html");

        map.clear();
        map.put("foo","bar3");
        apifMailer.send("dbrach77@gmail.com","foo3","foobar.txt",map,"text/html");



    }
}
