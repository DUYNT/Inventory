/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

/**
 * RemoreAddressUtil class
 *
 */
@Component("RemoreAddressUtil")
public class RemoteAddressUtil {
    
    private static final String[] HEADERS_TO_TRY = { 
        "X-Forwarded-For",
        "Proxy-Client-IP",
        "WL-Proxy-Client-IP",
        "HTTP_X_FORWARDED_FOR",
        "HTTP_X_FORWARDED",
        "HTTP_X_CLUSTER_CLIENT_IP",
        "HTTP_CLIENT_IP",
        "HTTP_FORWARDED_FOR",
        "HTTP_FORWARDED",
        "HTTP_VIA",
        "REMOTE_ADDR"
    };

    public String getIpddress(HttpServletRequest request) {
        String ip = null;
        
        ip = request.getRemoteAddr();
        
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            for (String header : HEADERS_TO_TRY) {
                ip = request.getHeader(header);
                if (!(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))) {
                    break;
                }
            }
        }
        
        return ip;
    }

}
