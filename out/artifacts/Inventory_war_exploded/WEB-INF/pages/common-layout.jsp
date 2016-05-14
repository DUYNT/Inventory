<%@ page session="false" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ page import="com.tecapro.inventory.common.util.Constants"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html class="js flexbox rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent"
	lang="en">
<head>
<title><tiles:getAsString name="title"/></title>
<tiles:insert attribute="meta"/>
<tiles:insert attribute="style"/>
</head>
<body>

<tiles:insert attribute="header"/>
<zz:form action="/Tiles_init.do" method="post" style="margin:0px;" styleId="BaseForm">
    <tiles:insert attribute="body"/>
    <div id="commonHidden" style="display:none;">
        <zz:hidden property="changeflag" value="0" />
        <div id="update_gamen"><tiles:getAsString name="update_gamen" /></div>
        <zz:hidden styleId="currentPageId" name="BaseForm" property="value.info.page.currentPage" />
        <zz:hidden styleId="hyojiKensuId" name="BaseForm" property="value.info.page.hyojiKensu" />
        <zz:hidden styleId="currentPageId1" name="BaseForm" property="value.info.page1.currentPage" />
        <zz:hidden styleId="hyojiKensuId1" name="BaseForm" property="value.info.page1.hyojiKensu" />
        <zz:hidden styleId="currentPageId2" name="BaseForm" property="value.info.page2.currentPage" />
        <zz:hidden styleId="hyojiKensuId2" name="BaseForm" property="value.info.page2.hyojiKensu" />
        <zz:hidden styleId="currentPageId3" name="BaseForm" property="value.info.page3.currentPage" />
        <zz:hidden styleId="hyojiKensuId3" name="BaseForm" property="value.info.page3.hyojiKensu" />
        <zz:base64 />
    </div>
</zz:form>
<tiles:insert attribute="script"/>
<tiles:insert attribute="footer"/>
</body>
</html>