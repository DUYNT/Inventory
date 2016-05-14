/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.action.BaseAction;
import com.tecapro.inventory.common.bean.InfoValue;
import com.tecapro.inventory.common.exception.UniqueKeyException;
import com.tecapro.inventory.common.form.BaseForm;

/**
 * LogUtil class
 *
 */
@Component("LogUtil")
public class LogUtil {

    @Autowired
    private BeanUtil<?> beanUtil;
    
    private static final Map<Thread, Integer> LOG_LEVEL = Collections.synchronizedMap(new LinkedHashMap<Thread, Integer>() {

        private static final long serialVersionUID = 1725853344614134562L;
        
        private static final int MAX_ENTRIES = 100;

        protected boolean removeEldestEntry(Map.Entry<Thread, Integer> eldest) {
            return size() > MAX_ENTRIES;
        }
    });

    /**
     * log Prefix
     */
    public enum LogPrefix {
        START("START"), END("E N D"), OTHER("OTHER");

        private String prefix;

        private LogPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String toString() {
            return prefix;
        }
    }

    /**
     * 
     * Start log output
     * 
     * @param log
     * @param clazz
     * @param method
     * @return
     */
    public long startLog(Log log, String clazz, String method, InfoValue info) {

        long time = System.nanoTime();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();

        log.info(returnLogString(clazz, method, info, LogPrefix.START, new StringBuffer().append(totalMemory - freeMemory).append(",").append(totalMemory)
                .toString()));

        Integer level = LOG_LEVEL.get(Thread.currentThread());

        if (level == null) {
            level = Integer.valueOf(1);
        } else {
            level += 1;
        }
        LOG_LEVEL.put(Thread.currentThread(), level);

        return time;

    }

    /**
     * 
     * End log output
     * 
     * @param log
     * @param clazz
     * @param method
     * @param time
     */
    @SuppressWarnings("resource")
	public void endLog(Log log, String clazz, String method, InfoValue info, long time) {

        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();

        Integer level = LOG_LEVEL.get(Thread.currentThread());

        if (level != null) {
            level -= 1;
        } else {
            level = 0;
        }

        if (level == 0) {
            LOG_LEVEL.remove(Thread.currentThread());
        } else {
            LOG_LEVEL.put(Thread.currentThread(), level);
        }

        Formatter formatter = new Formatter(new StringBuffer());
        log.info(returnLogString(clazz, method, info, LogPrefix.END, new StringBuffer().append(totalMemory - freeMemory).append(",").append(totalMemory)
                .append(",").append(formatter.format("%.3f", (System.nanoTime() - time) / 1000000.0D)).append("ms").toString()));

    }

    /**
     * 
     * Debug log output
     * 
     * @param log
     * @param clazz
     * @param method
     * @param time
     */
    public void debugLog(Log log, String clazz, String method, InfoValue info, String message) {
        if (log.isDebugEnabled()) {
            log.debug(returnLogString(clazz, method, info, LogPrefix.OTHER, message));
        }
    }

    /**
     * 
     * Info log output
     * 
     * @param log
     * @param clazz
     * @param method
     * @param time
     */
    public void infoLog(Log log, String clazz, String method, InfoValue info, String message) {
        log.info(returnLogString(clazz, method, info, LogPrefix.OTHER, message));
    }

    /**
     * 
     * Info log output
     * 
     * @param log
     * @param clazz
     * @param method
     * @param time
     */
    public void infoLog(Log log, String clazz, String method, InfoValue info, Throwable e) {
        log.info(returnLogString(clazz, method, info, LogPrefix.OTHER, e));
        if (e instanceof UniqueKeyException) {
            log.info(e.getMessage(), e);
        }

    }

    /**
     * 
     * Warn log output
     * 
     * @param log
     * @param clazz
     * @param method
     * @param time
     */
    public void warnLog(Log log, String clazz, String method, InfoValue info, String message) {
        log.warn(returnLogString(clazz, method, info, LogPrefix.OTHER, message));
    }

    /**
     * 
     * Warn log output
     * 
     * @param log
     * @param clazz
     * @param method
     * @param time
     */
    public void warnLog(Log log, String clazz, String method, InfoValue info, Throwable e) {
        log.warn(returnLogString(clazz, method, info, LogPrefix.OTHER, e));
        log.warn(e.getMessage(), e);
    }

    /**
     * 
     * Error log output
     * 
     * @param log
     * @param clazz
     * @param method
     * @param time
     */
    public void errorLog(Log log, String clazz, String method, InfoValue pinfo, String message) {
        LOG_LEVEL.remove(Thread.currentThread());
        log.error(returnLogString(clazz, method, pinfo, LogPrefix.OTHER, message));
    }

    /**
     * 
     * Error log output
     * 
     * @param log
     * @param clazz
     * @param method
     * @param time
     */
    public void errorLog(Log log, String clazz, String method, InfoValue info, Throwable e) {
        LOG_LEVEL.remove(Thread.currentThread());
        log.error(returnLogString(clazz, method, info, LogPrefix.OTHER, e));
        log.error(e.getMessage(), e);
    }

    /**
     * Error log output
     * 
     * @param zform
     * @param request
     * @param e
     * @param method
     */
    public void errorLog(Log log, BaseForm zform, HttpServletRequest request, Throwable e, String method) {

        errorLog(log, BaseAction.class.getSimpleName(), method, zform.getValue().getInfo(),
                "------ Error Information ------");
        errorLog(log, BaseAction.class.getSimpleName(), method, zform.getValue().getInfo(), e);

        errorLog(log, BaseAction.class.getSimpleName(), method, zform.getValue().getInfo(),
                "------ Input Information ------");
        errorLog(log, BaseAction.class.getSimpleName(), method, zform.getValue().getInfo(), 
                dump(request.getParameterMap()));

        errorLog(log, BaseAction.class.getSimpleName(), method, zform.getValue().getInfo(),
                "------ Output Information ------");
        errorLog(log, BaseAction.class.getSimpleName(), method, zform.getValue().getInfo(), 
                dump(zform));

    }

    /**
     * 
     * @param value
     * @return
     */
    public String dump(Object bean) {

        StringBuffer buf = new StringBuffer();

        Map<String, Object> map = beanUtil.describe(null, bean);

        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            String key = entry.getKey();
            Object entryValue = entry.getValue();
            
            if ("valueBase64".equals(key)) {
                continue;
            }

            buf.append(key).append("=");

            if (entryValue == null) {
                buf.append("<null>");
            } else {
                buf.append(entryValue);
            }

            if (it.hasNext()) {
                buf.append(", ");
            }
        }

        return buf.toString();
    }

    /**
     * 
     * @param clazz
     * @param method
     * @param info
     * @param e
     * @return
     */
    protected String returnLogString(String clazz, String method, InfoValue info, LogPrefix prefix, Throwable e) {
        return returnLogString(clazz, method, info, prefix, e.getMessage());
    }

    /**
     * 
     * @param clazz
     * @param method
     * @param pinfo
     * @param message
     * @return
     */
    protected String returnLogString(String clazz, String method, InfoValue pinfo, LogPrefix prefix, String message) {

    	InfoValue info = pinfo;
        String user = null;

        if (info == null) {
            info = new InfoValue();
        } else if (info.getUserInfo() != null) {
            //user = info.getUserInfo().getPersonCode();
        }

        String threadId = "T" + String.format("%08d", Thread.currentThread().getId() % 100000000L);
        StringBuffer space = new StringBuffer(prefix.toString());
        Integer level = LOG_LEVEL.get(Thread.currentThread());

        if (level != null) {
            int n = level.intValue();
            for (int i = 0; i < n; i++) {
                space.append(Constants.SPACE);
            }
        }

        if (user == null || Constants.BLANK.equals(user)) {
            user = "########";
        }

        return new StringBuffer(threadId).append(",").append(user).append(",").append(space).append(",")
                .append(clazz).append(".").append(method).append(",")
                .append(message).toString();

    }

}
