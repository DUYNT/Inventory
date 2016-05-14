<!-- System_Error -->
<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.tecapro.inventory.common.util.Constants"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>Inventory Storage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<link rel="stylesheet" href="./css/common.css" />
<script language="Javascript" type="text/javascript">
<!--
var CONTEXT_PATH = '<%= request.getContextPath() %>';
var IS_TABLET = <%= request.getAttribute(Constants.Device.IS_TABLET) %>;
function init() {
	var btn = document.getElementById('idBtn');
	/* modal dialog  */
	if (typeof window.dialogArguments != 'undefined') {
		<% if (request.getSession().getAttribute(Constants.SESSION_INFO) == null) { %>
		window.returnValue = 2;
		<% } %>
		btn.setAttribute('value', 'Close');
		btn.addEventListener('click', function(){window.close();});
	} else if (typeof window.opener != 'undefined' && window.opener != null && window.name.indexOf(WINDOW_MAIN) != -1) {
        btn.setAttribute('value', 'Close');
        btn.addEventListener('click', function(){
            try {
                window.opener.location.replace('<%= request.getContextPath() %>/');
            } catch (e) {
                window.close();
            } finally {
                window.close();
            }
        });
	} else {
		btn.setAttribute('value', 'return to the login');
		btn.addEventListener('click', function(){window.location.replace('<%= request.getContextPath() %>/');});
	}
}
//-->
</script>
<script type="text/javascript" src="./js/jquery-1.9.1.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/main.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/conf.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/common.js" charset="UTF-8"></script>
</head>
<body onload="init();">
    <div id="main">
        <div id="header">
            <span>■ Error</span>
        </div>
        <div class="mainContent">
            <div id="topButton">
                <div class="div_button_right">
                    <input class="btnCommon" id="idBtn" type="button" />
                </div>
            </div>
            <div id="divForm">
                <div id="errorArea">
                    <logic:notEmpty name="BaseForm" property="error.errorMessage">
                        <span id="<bean:write name="BaseForm" property="error.errorId" />"> <bean:write name="BaseForm"
                                property="error.errorMessage" /></span>
                    </logic:notEmpty>
                    <logic:empty name="BaseForm" property="error.errorMessage">System error has occurred. Please contact your system administrator .</logic:empty>
                </div>
            </div>
        </div>
        <div style="height: 100px;"></div>
        <div id="footer"></div>
    </div>
</body>
</html>