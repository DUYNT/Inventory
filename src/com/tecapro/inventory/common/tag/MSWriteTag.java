/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.taglib.nested.bean.NestedWriteTag;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tecapro.inventory.common.bean.ItemValidationInfoValue;
import com.tecapro.inventory.common.bean.TilesInfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.Constants;
import com.tecapro.inventory.common.util.ItemPropertyUtil;
import com.tecapro.inventory.common.util.StringUtil;

/**
 * Write custom tag
 * 
 */
public class MSWriteTag extends NestedWriteTag {

    private static final long serialVersionUID = -966023535185274958L;
    private static final String BEAN_NAME_STRING_UTIL = "StringUtil";
    private static final String BEAN_NAME_ITEM_PROP_UTIL = "ItemPropertyUtil";
    private static final String RESOURCES_BUNDLE = "ms";

    private Integer truncate = null;
    private String firstChar = "";

    private String nameSpace = null;

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    /**
     * Setter for truncate
     * 
     * @param truncate
     *            the truncate to set
     */
    public void setTruncate(Integer truncate) {
        this.truncate = truncate;
    }

    /**
     * Getter for truncate
     * 
     * @return the truncate
     */
    public Integer getTruncate() {
        return truncate;
    }

    /**
     * @return the firstChar
     */
    public String getFirstChar() {
        return firstChar;
    }

    /**
     * @param firstChar
     *            the firstChar to set
     */
    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            return super.doEndTag();
        } finally {
            this.formatStr = null;
            this.truncate = null;
        }
    }

    @Override
    public int doStartTag() throws JspException {

        this.bundle = RESOURCES_BUNDLE;

        String nameSpace = "";

        if (this.nameSpace != null) {
            nameSpace = this.nameSpace;
        }

        TilesInfoValue tilesValue = (TilesInfoValue) pageContext.getAttribute(nameSpace + TilesInfoValue.class.getSimpleName(), PageContext.REQUEST_SCOPE);
        BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());

        tilesValue.setInfo(form.getValue().getInfo());

        return super.doStartTag();
    }

    @Override
    protected String formatValue(Object valueToFormat) throws JspException {

        Object value = valueToFormat;

        StringUtil strUtil = (StringUtil) WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext()).getBean(BEAN_NAME_STRING_UTIL);
        ItemPropertyUtil itemPropUtil = (ItemPropertyUtil) WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext()).getBean(BEAN_NAME_ITEM_PROP_UTIL);
        ItemValidationInfoValue itemValue = itemPropUtil.getItemInfo(getProperty());

        if (valueToFormat == null
                        || ((valueToFormat instanceof Integer || valueToFormat instanceof Float || valueToFormat instanceof Double || valueToFormat instanceof Long) && (new BigDecimal(
                                        valueToFormat.toString())).doubleValue() == 0)) {

            Integer numSeisu = (itemValue != null) ? itemValue.getNumSeisuLength() : null;
            value = MSTagUtil.getOrgValue(numSeisu, pageContext, getProperty(), getProperty());
            valueToFormat = value;

            if (value == null) {
                return "";
            } else if ("".equals(value.toString()) || (new BigDecimal(value.toString())).doubleValue() == 0) {
                if (formatStr != null && !"".equals(formatStr) && formatStr.indexOf("#") != -1) {
                    return getFirstChar() + "0";
                } else {
                    return "0";
                }
            }
        }

        if (valueToFormat instanceof String && valueToFormat != null) {

            String stringValue = (String) value;

            SimpleDateFormat formatter = null;
            java.util.Date strDate = null;
            String format = null;
            if (itemValue != null) {
                format = itemValue.getFormat();
                format = (format == null) ? "" : format;
            }
            if (formatStr == null || "".equals(formatStr)) {
                formatStr = format;
            }
            format = formatStr;

            if (!"".equals(stringValue) && formatStr != null && !"".equals(formatStr)) {
                if (Constants.DateFormat.YYYY_MM.equals(format)) {
                    value = stringValue.replace("-", "/");
                } else if (Constants.DateFormat.YYYYMM.equals(format) && stringValue.length() == 6) {
                    value = new StringBuffer(stringValue.substring(0, 4)).append("/").append(stringValue.substring(4)).toString();
                } else if (Constants.DateFormat.YYYY_MM_DD.equals(format)) {
                    formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_ST);
                } else if (Constants.DateFormat.YYYY_MM_DD_ST.equals(format)) {
                    formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_ST);
                } else if (Constants.DateFormat.YYYYMMDD.equals(format)) {
                    formatter = new SimpleDateFormat(Constants.DateFormat.YYYYMMDD);
                } else if (Constants.DateFormat.YYYY_MM_DD_HH_II_SS_1.equals(format)) {
                    formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_ST);
                } else if (Constants.DateFormat.YYYY_MM_DD_HH_II_SS_2.equals(format)) {
                    formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_2_ST);
                } else if (Constants.DateFormat.YYYY_MM_DD_HH_II_SS_3.equals(format)) {
                    formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_3);
                } else if (Constants.DateFormat.YYYY_MM_DD_HH_II_SS_4.equals(format)) {
                    formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_4);
                } else if (formatStr != null && !"".equals(formatStr) && formatStr.indexOf("#") != -1 && ((String) valueToFormat).matches("[0-9.-]*")) {
                    DecimalFormat df = new DecimalFormat(formatStr);
                    value = getFirstChar() + df.format(Double.parseDouble((String) valueToFormat));
                }

                if (formatter != null) {
                    try {
                        if (stringValue.indexOf(".") != -1) {
                            stringValue = stringValue.substring(0, stringValue.indexOf("."));
                        }
                        strDate = formatter.parse(stringValue);
                    } catch (ParseException e1) {
                        if (stringValue.indexOf(" ", 15) != -1) {
                            stringValue = stringValue.substring(15 + stringValue.indexOf(" ", 15));
                        }
                        try {
                            strDate = formatter.parse(stringValue);
                        } catch (ParseException e2) {
                            formatter = null;
                        }
                    }
                }

                if (formatter != null && strDate != null) {
                    formatter.applyPattern(formatStr);
                    value = formatter.format(strDate);
                } else if (value != null && !"".equals(value)) {
                    return (String) value;
                } else {
                    return (String) valueToFormat;
                }
            } else {
                if (this.truncate != null && this.truncate > 0) {
                    return strUtil.cutStringWithByte((String) valueToFormat, this.truncate);
                } else {
                    return (String) valueToFormat;
                }
            }
        }

        if (formatStr != null && !"".equals(formatStr) && formatStr.indexOf("#") != -1 && (value.toString()).matches("[0-9.-]*")) {
            value = getFirstChar() + super.formatValue(value);
        } else {
            value = super.formatValue(value);
        }

        return (String) value;
    }
}