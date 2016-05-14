<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<div class="container body">
	<div class="main_container">
		<div class="right_col" role="main">
			<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="1">
					<tiles:insert definition="INVENTORY1" />
			</logic:equal>
			<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="2">
					<tiles:insert definition="INVENTORY2" />
			</logic:equal>
			<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="3">
					<tiles:insert definition="INVENTORY3" />
			</logic:equal>
		</div>
	</div>
</div>