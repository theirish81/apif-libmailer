package com.apifortress.libs.mailer.template.impl;

import com.apifortress.libs.mailer.template.AbstractApifTemplate;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

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
public class FsApifTemplate  extends AbstractApifTemplate {

    private File subpathFile = new File("templates");

    public void setSubpath(String subpath) throws FileNotFoundException {
        subpathFile = new File(subpath);
        if(!subpathFile.exists())
            throw new FileNotFoundException("Subpath does not exist");
    }

    @Override
    public void load(String identifier) throws Exception {
        File file = new File(subpathFile.getAbsolutePath()+File.separator+identifier);
        if(!file.exists())
            throw new FileNotFoundException("Template does not exist");
        text = new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset());
    }
}
