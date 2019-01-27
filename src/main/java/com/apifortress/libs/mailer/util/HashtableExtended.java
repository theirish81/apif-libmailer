package com.apifortress.libs.mailer.util;

import java.util.Hashtable;

public class HashtableExtended extends Hashtable<String,Object> {

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

    public String getString(String key){
        return (String) get(key);
    }
}
