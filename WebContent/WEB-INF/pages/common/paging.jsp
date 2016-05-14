<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tld/zz.tld" prefix="zz" %>

<table>
    <tr>
        <logic:equal name="BaseForm" property="value.info.page.showHyojiKensu" value="1">
        <td style="width: 120px; text-align:left;padding-left:2px;">Số bản ghi/trang：</td>
        <td style="width: 48px; text-align:left;">
        <select class="listNumRecord" onchange="setHyojiKensu(this);gotoPage('<bean:write name="BaseForm" property="value.info.page.actionPaging"/>', 1);">
        <logic:notEmpty name="BaseForm" property="value.info.page.listNumRecord">
        <logic:iterate id="element"  name="BaseForm" property="value.info.page.listNumRecord" indexId="idx">
        <logic:equal name="BaseForm" property="value.info.page.hyojiKensu" value="${element.getKey()}">
        <option value="<bean:write name="element" property="key"/>" selected="selected"><bean:write name="element" property="value"/></option>
        </logic:equal>
        <logic:notEqual name="BaseForm" property="value.info.page.hyojiKensu" value="${element.getKey()}">
        <option value="<bean:write name="element" property="key"/>"><bean:write name="element" property="value"/></option>
        </logic:notEqual>
        </logic:iterate>
        </logic:notEmpty>
        </select>
        </td>
        </logic:equal>
        
        <td class="listPaging" style="padding-left: 10px; text-align: center;">
        <logic:notEmpty name="BaseForm" property="value.info.page.listPaging">
            <table><tr><td>
                <logic:greaterThan name="BaseForm" property="value.info.page.currentPage" value="1">
                    <a onclick="gotoPage('<bean:write name="BaseForm" property="value.info.page.actionPaging"/>', 1);" href="javascript:void(0);">|<</a>&nbsp;
                </logic:greaterThan>
                <logic:lessEqual name="BaseForm" property="value.info.page.currentPage" value="1">
                    |<&nbsp;
                </logic:lessEqual>
                
                <logic:greaterThan name="BaseForm" property="value.info.page.currentPage" value="10">
                    <a onclick="gotoPage('<bean:write name="BaseForm" property="value.info.page.actionPaging"/>', ${BaseForm.value.info.page.currentPage - 10 - ((BaseForm.value.info.page.currentPage - 1) % 10)});" href="javascript:void(0);"><<</a>&nbsp;
                </logic:greaterThan>
                <logic:lessEqual name="BaseForm" property="value.info.page.currentPage" value="10">
                    <<&nbsp;
                </logic:lessEqual>
                
                <logic:iterate id="pIndex"  name="BaseForm" property="value.info.page.listPaging" indexId="idx">
                <logic:notEqual name="BaseForm" property="value.info.page.currentPage" value="${pIndex}">
                    <a onclick="gotoPage('<bean:write name="BaseForm" property="value.info.page.actionPaging"/>', ${pIndex});" href="javascript:void(0);"><bean:write name="pIndex" format="#,##0" /></a>&nbsp;
                </logic:notEqual>
                <logic:equal name="BaseForm" property="value.info.page.currentPage" value="${pIndex}">
                    <bean:write name="pIndex" format="#,##0" />&nbsp;
                </logic:equal>
                </logic:iterate>
                
                <logic:greaterThan name="BaseForm" property="value.info.page.lastPage" value="${BaseForm.value.info.page.listPaging[idx]}">
                    <a onclick="gotoPage('<bean:write name="BaseForm" property="value.info.page.actionPaging"/>', ${BaseForm.value.info.page.currentPage + (10 - ((BaseForm.value.info.page.currentPage - 1) % 10))});" href="javascript:void(0);">>></a>&nbsp;
                </logic:greaterThan>
                <logic:lessEqual name="BaseForm" property="value.info.page.lastPage" value="${BaseForm.value.info.page.listPaging[idx]}">
                    >>
                </logic:lessEqual>
                
                <logic:lessThan name="BaseForm" property="value.info.page.currentPage" value="${BaseForm.value.info.page.lastPage}">
                    <a onclick="gotoPage('<bean:write name="BaseForm" property="value.info.page.actionPaging"/>', ${BaseForm.value.info.page.lastPage});" href="javascript:void(0);">>|&nbsp;</a>
                </logic:lessThan>
                <logic:greaterEqual name="BaseForm" property="value.info.page.currentPage" value="${BaseForm.value.info.page.lastPage}">
                    >|&nbsp;
                </logic:greaterEqual>
            </td></tr></table>
        </logic:notEmpty>
        </td>
        <td class="countPage">
            <logic:greaterThan name="BaseForm" property="value.info.page.allKensu" value="0">
            <bean:write name="BaseForm" property="value.info.page.startKensu" format="#,##0" />&nbsp;-&nbsp;<bean:write name="BaseForm" property="value.info.page.currentKensu" format="#,##0" />&nbsp;/&nbsp;<bean:write name="BaseForm" property="value.info.page.allKensu" format="#,##0" />&nbsp;bản ghi
            </logic:greaterThan>
            <logic:lessEqual name="BaseForm" property="value.info.page.allKensu" value="0">
            <span class="display_hidden">
            <bean:write name="BaseForm" property="value.info.page.startKensu" format="000" />&nbsp;-&nbsp;<bean:write name="BaseForm" property="value.info.page.currentKensu" format="000" />&nbsp;/&nbsp;<bean:write name="BaseForm" property="value.info.page.allKensu" format="000" />&nbsp;bản ghi
            </span>
            </logic:lessEqual>
            <input id="usePaging" type="hidden" name="paging" value="" />
        </td>
    </tr>
</table>
