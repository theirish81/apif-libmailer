package com.apifortress.libs.mailer.config;


import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Hashtable;

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
public abstract class AbstractApifMailConfig extends Hashtable<String,Object> {

    @PostConstruct
    public abstract void init() throws Exception;

    public Boolean getBoolean(String key){
        Object item = get(key);
        if(item instanceof Boolean)
            return (Boolean) item;
        if(item instanceof String)
            return Boolean.valueOf((String) get(key));
        else
            throw new IllegalArgumentException("The configuration key "+key+" is not a valid type");
    }

    public Integer getInt(String key){
        Object item = get(key);
        if(item instanceof Integer)
            return (Integer) item;
        if(item instanceof String)
            return Integer.valueOf((String) get(key));
        else
            throw new IllegalArgumentException("The configuration key "+key+" is not a valid type");
    }
}
