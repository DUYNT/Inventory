<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<tiles:insert attribute="meta" />
<tiles:insert attribute="style" />
<tiles:insert attribute="script" />
</head>
<body class="bg_login">
	<zz:form action="/Login_login.do" method="post" style="margin:0px;" styleId="BaseForm" >
	<tiles:insert attribute="body" />
	
	</zz:form>
</body>
</html>