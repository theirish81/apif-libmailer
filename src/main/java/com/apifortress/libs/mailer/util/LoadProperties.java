package com.apifortress.libs.mailer.util;

import com.apifortress.libs.mailer.exceptions.InvalidConfigException;

import java.io.*;
import java.util.Properties;

public class LoadProperties {

    public static Properties getProperties(String filename) throws InvalidConfigException{
        InputStream filePropertiesStream = null;
        try {
            File file = new File(filename);
            if(!file.exists())
                throw new FileNotFoundException("Configuration file "+filename+" does not exist");
            filePropertiesStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(filePropertiesStream);

            return properties;
        } catch (Exception ex) {
            throw new InvalidConfigException(ex.getMessage());
        } finally{
            try {
                if(filePropertiesStream!=null)
                    filePropertiesStream.close();
            }catch(IOException e){e.printStackTrace();}
        }
    }
}
