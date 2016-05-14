/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * SessionFilter class
 *
 */
public class SessionFilter implements Filter {
    private FilterConfig filterConfig;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws ServletException, IOException {
        
        chain.doFilter(request, response);
    }

    public FilterConfig getFilterConfig() {
        return this.filterConfig;
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

    public void destroy() {
    }

}