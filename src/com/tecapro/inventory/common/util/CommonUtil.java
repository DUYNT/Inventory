/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;

/**
 * Common Util class
 *
 */
@Component("CommonUtil")
public class CommonUtil {

    /**
     * instance of PropertiesUtil
     */
    @Autowired
    private PropertiesUtil propUtil;

    /**
     * instance of DateUtil
     */
    @Autowired
    private DateUtil dateUtil;

    /**
     * Common properties
     */
    private static Properties commonProp;

    /**
     * init commonProp attribute
     */
    public void init() {
        if (commonProp == null) {
            commonProp = propUtil.getProperties(PropertiesUtil.COMMON_PROP);
        }
    }

    /**
     * init InputStreamReader object with InputStream
     * @param stream
     * @return
     */
    public InputStreamReader createInputStreamReader(InputStream stream) {
        return new InputStreamReader(stream);
    }

    /**
     * encodeBase64 InfoValue object
     *
     * @param value
     * @return
     * @throws Exception
     */
    public byte[] serialize(InfoValueIF value) throws Exception {
        return serialize((Object) value);
    }

    /**
     * encodeBase64 object
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public byte[] serialize(Object obj) throws Exception {
        ByteArrayOutputStream byteStream = null;
        ObjectOutputStream ostream = null;
        byte[] result = null;

        try {
            byteStream = new ByteArrayOutputStream();
            ostream = new ObjectOutputStream(new BufferedOutputStream(byteStream));
            ostream.writeObject(obj);
            ostream.flush();
            result = Base64.encodeBase64(byteStream.toByteArray());
        } finally {
            if (byteStream != null) {
                byteStream.close();
            }
            if (ostream != null) {
                ostream.close();
            }
        }
        return result;
    }

    /**
     * decodeBase64 serializeData into InfoValue object
     * @param serializeData
     * @param value
     * @return
     * @throws Exception
     */
    public Object deserialize(byte[] serializeData) throws Exception {
        byte[] decodebytes = Base64.decodeBase64(serializeData);

        ObjectInputStream istream = null;
        ByteArrayInputStream byteStream = null;
        Object result = null;

        try {
            byteStream = new ByteArrayInputStream(decodebytes);
            istream = new ObjectInputStream(byteStream);
            result = istream.readObject();
        } finally {
            if (byteStream != null) {
                byteStream.close();
            }
            if (istream != null) {
                istream.close();
            }
        }
        return result;
    }

    /**
     * get value property with key
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        return commonProp.getProperty(key);
    }

    /**
     * get value property with key and put params to result
     *
     * @param key
     * @param params
     * @return
     */
    public String getValue(String key, String[] params) {
        String messageFormat = commonProp.getProperty(key);
        return new StringBuffer().append(MessageFormat.format(messageFormat, (Object[]) params)).toString();
    }

    public byte[] convertFileToByte(String fileName) throws IOException, FileNotFoundException {

        FileInputStream fis = new FileInputStream(fileName);
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        OutputStream os = new BufferedOutputStream(b);
        byte[] data = null;
        int c;
        try {
            while ((c = fis.read()) != -1) {
                os.write(c);
            }
            os.flush();
            data = b.toByteArray();
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (os != null) {
                os.close();
            }
            if (b != null) {
                b.close();
            }
        }
        return data;
    }
}
