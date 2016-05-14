/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

/**
 * Properties utill class
 *
 */
@Component("PropertiesUtil")
public class PropertiesUtil {
    
    public static final String MESSAGE_PROP = "message.properties.xml";
    public static final String ITEMS_PROP = "items";
    public static final String COMMON_PROP = "common.properties.xml";
    public static final String FILEPATH_PROP = "filepath.properties.xml";
    
    private Properties messageProp;
    private Properties itemsProp;
    private Properties pathProp;
    
    /**
     * load message
     */
    public void init() {
        if (messageProp == null) {
            messageProp = this.getProperties(PropertiesUtil.MESSAGE_PROP);
        }
        if (itemsProp == null) {
            itemsProp = this.getItemsProperties();
        }
        if (pathProp == null) {
            pathProp = this.getProperties(PropertiesUtil.FILEPATH_PROP);
        }
    }
    
    /**
     * get item property
     */
    public String getItemProperty(String key) {
        return itemsProp.getProperty(key);
    }
    
    /**
     * get message property
     */
    public String getMsgProperty(String key) {
        return messageProp.getProperty(key);
    }
    
    /**
     * get path property
     */
    public String getPathProperty(String key) {
        return pathProp.getProperty(key);
    }
    
    /**
     * get xml properties
     * @param propertiesFileName
     * @return
     *      Properties object
     */
    public Properties getProperties(String propertiesFileName) {

        Properties prop = new Properties();

        InputStream istream = null;

        try {
            istream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFileName);
            prop.loadFromXML(istream);

            return prop;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            if (istream != null) {
                try {
                    istream.close();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    /**
     * get multi file xml properties
     * @return
     *      Properties object
     */
    public Properties getItemsProperties() {

        Properties prop = new Properties();
        String f = null;
        ClassLoader cl = this.getClass().getClassLoader();
        String path = cl.getResource(ITEMS_PROP).getPath();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

//        for (File file : listOfFiles) {
//            if (file.isFile()) {
//                f = file.getPath();
//                if (f.endsWith(".xml") || f.endsWith(".XML")) {
//                    Properties iProp = new Properties();
//                    InputStream istream = null;
//                    try {
//                        istream = new FileInputStream(f);
//                        iProp.loadFromXML(istream);
//                        for (Entry<Object, Object> e : iProp.entrySet()) {
//                            if (prop.containsKey(e.getKey())) {
//                                throw new Exception("Propertie key [" + e.getKey() + "] in file [" + f + "] existed!");
//                            }
//                        }
//                        prop.putAll(iProp);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    } finally {
//                        if (istream != null) {
//                            try {
//                                istream.close();
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }
//            }
//        }
        return prop;
    }

    /**
     * @return the messageProp
     */
    public Properties getMessageProp() {
        return messageProp;
    }

    /**
     * @param messageProp the messageProp to set
     */
    public void setMessageProp(Properties messageProp) {
        this.messageProp = messageProp;
    }
}