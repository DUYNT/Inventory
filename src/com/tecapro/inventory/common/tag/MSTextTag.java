/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.taglib.nested.html.NestedTextTag;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tecapro.inventory.common.bean.ItemValidationInfoValue;
import com.tecapro.inventory.common.bean.TilesInfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.CheckUtil;
import com.tecapro.inventory.common.util.CommonUtil;
import com.tecapro.inventory.common.util.Constants;
import com.tecapro.inventory.common.util.ItemPropertyUtil;
import com.tecapro.inventory.common.util.StringUtil;

/**
 * Text custom tag
 */
public class MSTextTag extends NestedTextTag {
    
    private static final long serialVersionUID = -3697875212380461429L;

    private static final String BEAN_NAME_COMMON_UTIL = "CommonUtil";
    private static final String BEAN_NAME_CHECK_UTIL = "CheckUtil";
    private static final String BEAN_NAME_STRING_UTIL = "StringUtil";
    private static final String BEAN_NAME_ITEM_PROP_UTIL = "ItemPropertyUtil";
    private static final String UPPER_PROPERTIES_KEY = "UPPER_PROPERTIES";
    private static List<String> UPPER_PROPERTIES;
    private StringBuffer colorClass = new StringBuffer();
    private ItemValidationInfoValue itemValue = null;
    private boolean require = false;
    private String area = null;
    private String firstChar = "";

    public ItemValidationInfoValue getItemValue() {
        return itemValue;
    }

    public void setItemValue(ItemValidationInfoValue itemValue) {
        this.itemValue = itemValue;
    }

    public boolean isRequire() {
        return require;
    }

    public void setRequire(boolean require) {
        this.require = require;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the firstChar
     */
    public String getFirstChar() {
        return firstChar;
    }

    /**
     * @param firstChar the firstChar to set
     */
    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    /**
     * Reader input
     */
    protected String renderInputElement() throws JspException {
        StringBuffer results = new StringBuffer("<input");

        prepareAttribute(results, "type", this.type);

        String name = null;

        name = prepareName();
        prepareAttribute(results, "name", name);

        BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());

        HashMap<String, Boolean> keyMap = new HashMap<String, Boolean>();
        keyMap.put(name, isRequire());
        area = (area == null || "".equals(area)) ? Constants.COMMON_AREA : area;
        form.getValue().getInfo().getItem().getAreaList(area).add(keyMap);

        colorClass = new StringBuffer();

        if (isRequire()) {
            colorClass.append(Constants.StyleClass.REQUIRE);
            colorClass.append(Constants.SPACE);
        }

        if (getReadonly()) {
            colorClass.append(Constants.StyleClass.READONLY);
            colorClass.append(Constants.SPACE);
        }

        if (getStyleClass() != null) {
            if (getStyleClass().indexOf(Constants.StyleClass.TRANSPARENT) >= 0) {
                colorClass.append(Constants.StyleClass.TRANSPARENT);
                colorClass.append(Constants.SPACE);
                setStyleClass(getStyleClass().replaceAll(Constants.StyleClass.TRANSPARENT, ""));
            }
        }

        List<String> idList = form.getError().getIdList();

        for (String id : idList) {
            if (id.equals(name)) {
                colorClass.append(Constants.StyleClass.ERROR);
                colorClass.append(Constants.SPACE);
                break;
            }
        }

        if (colorClass.length() > 0) {
            MSTagUtil.addStyleClass(this, colorClass.toString());
        }

        prepareAttribute(results, "accesskey", getAccesskey());
        prepareAttribute(results, "accept", getAccept());
        prepareAttribute(results, "maxlength", getMaxlength());
        prepareAttribute(results, "size", getCols());
        prepareAttribute(results, "tabindex", getTabindex());
        prepareValue(results);
        results.append(this.prepareEventHandlers());
        results.append(this.prepareStyles());
        prepareOtherAttributes(results);
        results.append(this.getElementClose());

        return results.toString();
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            return super.doEndTag();
        } finally {
            require = false;
            this.setStyleClass(null);
            this.setReadonly(false);
            this.setDisabled(false);
            this.setOnblur(null);
            this.setOnfocus(null);
            this.setOnchange(null);
            itemValue = null;
            colorClass = null;
            this.area = null;
        }
    }

    public void init() {
        CommonUtil commonUtil = (CommonUtil) WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext()).getBean(BEAN_NAME_COMMON_UTIL);
        String[] props = commonUtil.getValue(UPPER_PROPERTIES_KEY).split(",");

        UPPER_PROPERTIES = new ArrayList<String>(props.length);
        for (int i = 0; i < props.length; i++) {
            UPPER_PROPERTIES.add(props[i].trim());
        }
    }

    @Override
    public int doStartTag() throws JspException {
        
        init();

        ItemPropertyUtil itemPropUtil = (ItemPropertyUtil) WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext())
                        .getBean(BEAN_NAME_ITEM_PROP_UTIL);
        TilesInfoValue tilesValue = (TilesInfoValue) pageContext.getAttribute(TilesInfoValue.class.getSimpleName(), PageContext.REQUEST_SCOPE);

        BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());
        
        tilesValue.setInfo(form.getValue().getInfo());

        if (getDisabled()) {
            setReadonly(true);
            setDisabled(false);
        }

        itemValue = itemPropUtil.getItemInfo(getProperty());

        if (itemValue != null) {
            StringBuffer onFocus = new StringBuffer();
            StringBuffer onBlur = new StringBuffer();
            StringBuffer onChange = new StringBuffer();

            if (getOnfocus() != null) {
                onFocus.append(getOnfocus() + ";");
            }

            if (getOnchange() != null) {
                onChange.append(getOnchange() + ";");
            }

            if (itemValue.getNumSeisuLength() != null) {
                onFocus.append("removeComma(this);");
                onBlur.append("trim(this);formatDecimal(this," + itemValue.getNumShosuLength() + ");addComma(this);");
            } else if (Constants.DateFormat.YYYY_MM_DD.equals(itemValue.getFormat())) { 
                onFocus.append("removeSlash(this);");
                onBlur.append("trim(this);formatYMD(this);");
            } else if (Constants.DateFormat.YYYY_MM.equals(itemValue.getFormat())) {
                onFocus.append("removeSlash(this);");
                onBlur.append("trim(this);formatYM(this);");
            } else if (Constants.DateFormat.HH_MM.equals(itemValue.getFormat())) {
                onFocus.append("removeColon(this);");
                onBlur.append("trim(this);formatHH_MM(this);");
            } else if (Constants.DateFormat.HH_MM_SS.equals(itemValue.getFormat())) {
                onFocus.append("removeColon(this);");
                onBlur.append("trim(this);formatHH_MM_SS(this);");
            } else if ("mail".equals(itemValue.getFormat())) {
                onBlur.append("trim(this);toHalfSize(this.value);");
            } else {
                onBlur.append("trim(this);");
            }

            if (getOnblur() != null) {
                onBlur.append(getOnblur() + ";");
            }

            if (itemValue.isKana() || itemValue.isFullwidth() 
                    || (!itemValue.isAlph() && !itemValue.isNum() && !itemValue.isCode() && !itemValue.isKana() && !itemValue.isFullwidth())) {
                MSTagUtil.addStyleClass(this, "imeonoff");
            } else {
                MSTagUtil.addStyleClass(this, "imeoff");
            }

            onFocus.append("textSelect(this);");

            if (UPPER_PROPERTIES.contains(itemValue.getProperty())) {
                onBlur.insert(0, "toUpperText(this);");
                onChange.insert(0, "toUpperText(this);");
            }

            setOnfocus(onFocus.toString());
            setOnblur(onBlur.toString());
            setOnchange(onChange.toString());
        }

        if (tilesValue.isReadonly()) {
            setReadonly(true);
        }

        MSTagUtil.setChangeFlag(this);

        return super.doStartTag();
    }

    /**
     * 
     * text append
     * 
     * @param results
     *            The StringBuffer that output will be appended to.
     */
    protected void prepareValue(StringBuffer results) throws JspException {
        results.append(" value=\"");
        
        CheckUtil checkUtil = (CheckUtil) WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext()).getBean(BEAN_NAME_CHECK_UTIL);
        StringUtil strUtil = (StringUtil) WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext()).getBean(BEAN_NAME_STRING_UTIL);
        
        if (value != null) {
            value = MSTagUtil.replaceInvalidCharcter(value.toString(), Constants.REPLACE_CHARACTER);
            results.append(this.formatValue(value));
        } else if (redisplay || !"password".equals(type)) {

            Object value = null;

            //value = TagUtils.getInstance().lookup(pageContext, name, property, null);
            Integer numSeisu = (itemValue != null) ? itemValue.getNumSeisuLength() : null;
            value = MSTagUtil.getOrgValue(numSeisu, pageContext, prepareName(), property);

            if (value == null || Constants.BLANK.equals(value.toString().trim())) {
                value = Constants.BLANK;
            }

            if (itemValue != null && !"".equals(value)) {

                String stringValue = value.toString();

                if (!Constants.BLANK.equals(itemValue.getFormat())) {
                    
                    SimpleDateFormat formatter = null;
                    java.util.Date strDate = null;
                    String format = itemValue.getFormat();
                    String apllyFormat = null;
                    
                    if (!"".equals(stringValue) && (value instanceof String || value instanceof Date || value instanceof Timestamp)) {
                        
                        
                        if (Constants.DateFormat.YYYY_MM.equals(format)) {
                            value = stringValue.replace("-", "/");
                        } else if (Constants.DateFormat.YYYYMM.equals(format) && stringValue.length() == 6) {
                            value = new StringBuffer(stringValue.substring(0, 4)).append("/").append(stringValue.substring(4)).toString();
                        } else if (Constants.DateFormat.YYYY_MM_DD.equals(format)) {
                            formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_ST);
                            apllyFormat = Constants.DateFormat.YYYY_MM_DD;
                        } else if (Constants.DateFormat.YYYY_MM_DD_ST.equals(format)) {
                            formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_ST);
                            apllyFormat = Constants.DateFormat.YYYY_MM_DD_ST;
                        } else if (Constants.DateFormat.YYYYMMDD.equals(format)) {
                            formatter = new SimpleDateFormat(Constants.DateFormat.YYYYMMDD);
                        } else if (Constants.DateFormat.YYYY_MM_DD_HH_II_SS_1.equals(format)) {
                            formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_ST);
                            apllyFormat = Constants.DateFormat.YYYY_MM_DD_HH_II_SS_1;
                        } else if (Constants.DateFormat.YYYY_MM_DD_HH_II_SS_2.equals(format)) {
                            formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_2_ST);
                            apllyFormat = Constants.DateFormat.YYYY_MM_DD_HH_II_SS_2;
                        } else if (Constants.DateFormat.YYYY_MM_DD_HH_II_SS_3.equals(format)) {
                            formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_3);
                        } else if (Constants.DateFormat.YYYY_MM_DD_HH_II_SS_4.equals(format)) {
                            formatter = new SimpleDateFormat(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_4);
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
                            if (formatter != null && !checkUtil.isDateFormat(stringValue, formatter)) {
                                formatter = null;
                                value = strUtil.replace(stringValue, "-", "/");
                            }
                        }
                    } else if (value instanceof java.util.Date && format != null) {
                        formatter = new SimpleDateFormat(format);
                        strDate = (java.util.Date) value;
                    }
                    
                    if (formatter != null && strDate != null) {
                        if (apllyFormat != null) {
                            formatter.applyPattern(apllyFormat);
                        }
                        value = formatter.format(strDate);
                    } else if (format.contains(Constants.DateFormat.YYYY_MM_DD)
                                || format.contains(Constants.DateFormat.YYYY_MM)
                                || format.contains(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_1)
                                || format.contains(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_2)
                                || format.contains(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_3)
                                || format.contains(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_4)) {
                        value = strUtil.replace(stringValue, "-", "/");
                    }
                } else {

                    Integer numShosu = (itemValue != null) ? itemValue.getNumShosuLength() : null;
                    if (numSeisu != null && numSeisu > 0 && stringValue.matches("[0-9.-]*")) {
                        String format = "#,##0";
                        if (numShosu != null && numShosu > 0) {
                            format = String.format(format + ".%0" + numShosu + "d", 0);
                        }
                        Locale.setDefault(Locale.JAPAN);
                        DecimalFormat df = new DecimalFormat(format);
                        value = df.format(Double.parseDouble(stringValue));
                        if (getFirstChar() != null) {
                            value = getFirstChar() + value;
                        }
                    }
                }
            } else if (value instanceof Timestamp) {
                String stringValue = (String) value.toString();
                if (stringValue.indexOf(".") != -1) {
                    value = new StringBuffer(stringValue.substring(0, stringValue.indexOf("."))).toString();
                }
            }

            value = MSTagUtil.replaceInvalidCharcter(value.toString().trim(), Constants.REPLACE_CHARACTER);

            results.append(this.formatValue(value));
        }

        results.append('"');
    }

    /**
     * Replace character
     * 
     * @param input
     * @param replace
     * @return
     */
    protected String replaceInvalidCharcter(String input, String replace) {

        String result = input.toString().replaceAll("&#*[a-zA-Z0-9]*;", replace);

        for (int i = 0; i < CheckUtil.NOTPERMIT_CHAR.length(); i++) {

            char kinshiChar = CheckUtil.NOTPERMIT_CHAR.charAt(i);

            if (result.indexOf(kinshiChar) >= 0) {
                result = result.replaceAll(String.valueOf(kinshiChar), replace);
            }
        }

        return result;
    }

}