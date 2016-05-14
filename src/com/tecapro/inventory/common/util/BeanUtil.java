/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.bean.ItemValidationInfoValue;

/**
 * BeanUtil class
 *
 * @param <T>
 */
@Component("BeanUtil")
public class BeanUtil<T> {

    /**
     * instance of ConvertUtil
     */
    @Autowired
    private ConvertUtil convertUtil;
    
    /**
     * instance of ItemPropertyUtil
     */
    @Autowired
    private ItemPropertyUtil itemPropUtil;

    /**
     * instance of BeanUtilsBean
     */
    private CSSBeanUtilsBean beanUtil = new CSSBeanUtilsBean();

    /**
     * BeanUtilsBean class
     * @see org.apache.commons.beanutils.BeanUtilsBean
     *
     */
    public class CSSBeanUtilsBean extends BeanUtilsBean {

        /**
         * instance of ConvertUtil
         */
        private ConvertUtil convertUtil;
        
        /**
         * instance of ItemPropertyUtil
         */
        private ItemPropertyUtil itemPropUtil;
        
        /**
         * Setter for convertUtil
         * @param convertUtil the convertUtil to set
         */
        public void setConvertUtil(ConvertUtil convertUtil) {
            this.convertUtil = convertUtil;
        }

        /**
         * @param itemPropUtil the itemPropUtil to set
         */
        public void setItemPropUtil(ItemPropertyUtil itemPropUtil) {
            this.itemPropUtil = itemPropUtil;
        }

        /**
         * (non-Javadoc)
         * @see org.apache.commons.beanutils.BeanUtilsBean.setProperty(Object bean, String name, Object value) 
         *          throws IllegalAccessException, InvocationTargetException
         */
        @Override
        public void setProperty(Object bean, String name, Object value) throws IllegalAccessException, InvocationTargetException {

            try {
                Object convValue = value;

                if (value instanceof String) {
                    convValue = convertUtil.convert((String) value);
                }
                
                ItemValidationInfoValue itemValue = itemPropUtil.getItemInfo(name);
                
                if (itemValue != null && itemValue.getFormat() != null && itemValue.getFormat().trim().length() > 0) {
                    DateConverter dConverter = new DateConverter(null);
                    dConverter.setPattern(itemValue.getFormat().replace("/", "-"));
                    this.getConvertUtils().register(dConverter, java.util.Date.class);
                }

                super.setProperty(bean, name, convValue);
            } catch (Exception e) {
                try {
                    if (value.toString().equals(Constants.BLANK)) {
                        super.setProperty(bean, name, Constants.ZERO);
                    }
                } catch (Exception ex) {

                }
            }
        }
    }


    /**
     * (non-Javadoc)
     * @see org.apache.commons.beanutils.BeanUtilsBean.populate(Object bean, Map properties) 
     *              throws IllegalAccessException, InvocationTargetException
     *
     * @param input
     * @param bean
     */
    @SuppressWarnings("unchecked")
    public void populate(Object input, Object bean) {
        try {
            beanUtil.setConvertUtil(convertUtil);
            beanUtil.setItemPropUtil(itemPropUtil);
            
            DoubleConverter dConverter = new DoubleConverter(null);
            ShortConverter sConverter = new ShortConverter(null);
            FloatConverter fConverter = new FloatConverter(null);
            LongConverter lConverter = new LongConverter(null);
            IntegerConverter iConverter = new IntegerConverter(null);
            
            beanUtil.getConvertUtils().register(dConverter, Double.class);
            beanUtil.getConvertUtils().register(sConverter, Short.class);
            beanUtil.getConvertUtils().register(fConverter, Float.class);
            beanUtil.getConvertUtils().register(lConverter, Long.class);
            beanUtil.getConvertUtils().register(iConverter, Integer.class);
            
            beanUtil.populate(bean, (Map<String, Object>) input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Call com.viettel.common.util.BeanUtil.describe(String, Object, boolean)
     *      with parameter three is true
     * @param name
     * @param value
     *      Map Object
     * @return
     */
    public Map<String, Object> describe(String name, Object value) {
        return describe(name, value, true);
    }

    /**
     * (non-Javadoc)
     * @see com.viettel.common.util.BeanUtil.describe(String, Map<String,Object>, Object, boolean)
     * 
     * @param name
     * @param value
     * @param info
     * @return
     */
    public Map<String, Object> describe(String name, Object value, boolean info) {
        try {
            Map<String, Object> result = new HashMap<String, Object>();
            describe(name, result, value, info);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Create object Map of Object bean
     * 
     * @param name
     * @param target
     * @param bean
     * @param info
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unchecked")
    private void describe(String name, Map<String, Object> target, Object bean, boolean info) throws InvocationTargetException, IllegalAccessException {

        if (bean == null) {
            return;
        }

        Method[] methods = bean.getClass().getMethods();

        Object[] param = new Object[] {};

        for (int i = 0, j = methods.length; i < j; i++) {

            String methodName = methods[i].getName();

            if (!methodName.startsWith("get")) {
                continue;
            }

            if (!info && methodName.equals("getInfo")) {
                continue;
            }

            if (methods[i].getParameterTypes().length != 0) {
                continue;
            }

            Object value = methods[i].invoke(bean, param);

            if (value == null || value == bean) {
                continue;
            }

            String propName = String.valueOf(Character.toLowerCase(methodName.charAt(3)));

            if (methodName.length() > 4) {
                propName += methodName.substring(4);
            }

            if (value instanceof List) {

                Iterator<Object> itr = (Iterator<Object>) ((List<Object>) value).iterator();
                for (int k = 0; itr.hasNext(); k++) {
                    describeObject(name, target, itr.next(), new StringBuffer().append(propName).append("[").append(k).append("]").toString(), info);
                }
            } else {
                describeObject(name, target, value, propName, info);
            }
        }
    }

    /**
     * Put object bean to Map with key propName 
     * 
     * @param name
     * @param target
     * @param value
     * @param propName
     * @param info
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private void describeObject(String name, Map<String, Object> target, Object value, String propName, boolean info) throws InvocationTargetException,
            IllegalAccessException {
        if (info && name != null && name.contains("info") && propName.equals("info")) {
            return;
        }

        String prop = null;
        if (name != null) {
            prop = new StringBuffer(name).append(".").append(propName).toString();
        } else {
            prop = propName;
        }

        if ((value instanceof String) || (value instanceof BigDecimal) || (value instanceof Integer) || (value instanceof Long) || (value instanceof Timestamp)) {
            target.put(prop, value);
            return;
        }

        if (value != null && !value.getClass().getSimpleName().endsWith("Value")) {
            return;
        }

        describe(prop, target, value, info);
    }

    /**
     * Perform setter method (java reflection) on bean object with parameter is Value
     * 
     * @param bean
     * @param propertyName
     * @param value
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void setBean(Object bean, String propertyName, Object value) throws IllegalAccessException, InvocationTargetException {

        String setMethodName = new StringBuffer().append("set").append(Character.toUpperCase(propertyName.charAt(0)))
                .append(propertyName.length() > 1 ? propertyName.substring(1) : "").toString();
        Object[] args = new Object[] { value };

        for (Method method : bean.getClass().getMethods()) {
            if (method.getName().equals(setMethodName) && method.getParameterTypes().length == 1) {
                method.invoke(bean, args);
            }
        }
    }
}
