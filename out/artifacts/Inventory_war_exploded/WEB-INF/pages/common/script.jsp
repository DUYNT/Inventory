<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ page import="com.tecapro.inventory.common.util.Constants"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<script language="Javascript" type="text/javascript">
<!--
var CONTEXT_PATH = '<%= request.getContextPath() %>';
var IS_TABLET = <%= request.getAttribute(Constants.Device.IS_TABLET) %>;
<% if (request.getAttribute(Constants.DOWNLOAD_KEY) != null 
        && !"".equals(request.getAttribute(Constants.DOWNLOAD_KEY))) {%>
var DOWNLOAD_VAL = "<%= request.getAttribute(Constants.DOWNLOAD_KEY) %>";
var DOWNLOAD_KEY = "<%= Constants.DOWNLOAD_KEY %>";
<% } %>
	<logic:notEmpty  name="BaseForm" property="error.errorMessage">
	var ERROR_ID = "<bean:write name="BaseForm" property="error.errorId" />";
	var ERROR_MSG = "<bean:write name="BaseForm" property="error.errorMessage" />";
	</logic:notEmpty>
	<logic:empty name="BaseForm" property="error.errorMessage">
	<logic:notEmpty name="BaseForm" property="infoMsg">
	var MSGS = [];
	<logic:iterate id="msg" name="BaseForm" property="infoMsg" offset="0" indexId="i">
	<logic:notEmpty name="msg">
	MSGS[MSGS.length] = "<bean:write name="msg" />";
	</logic:notEmpty>
	var INFO_MSG = MSGS.join("\n");
	</logic:iterate>
	</logic:notEmpty>
	</logic:empty>
//-->
</script>

<script type="text/javascript" src="./js/jquery-1.9.1.min.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="./js/conf.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/common.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/jquery-ui.min.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="./js/jquery.fn.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/script.loader.js"
	charset="UTF-8"></script>
<script type="text/javascript" src="./js/script.js" charset="UTF-8"></script>

<script type="text/javascript" src="./js/jquery-1.9.1.min.js"></script>
<!-- jQuery -->
<script src="./css/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="./css/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="./css/vendors/fastclick/lib/fastclick.js"></script>
<!-- gauge.js -->
<script src="./css/vendors/bernii/gauge.js/dist/gauge.min.js"></script>
<!-- iCheck -->
<script src="./css/vendors/iCheck/icheck.min.js"></script>
<!-- Skycons -->
<script src="./css/vendors/skycons/skycons.js"></script>
<!-- Flot -->
<!-- Custom Theme Scripts -->
<script src="./js/custom.js"></script>

<script src="./js/login/login.js"></script>
<script src="./js/pop/input-product-manager.js"></script>
<script src="./js/report/report.js"></script>
<script src="./js/station/station.js"></script>
