<%@ page session="false"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>

<div class="container body">
	<div class="main_container">
		<div class="right_col" role="main">
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="1">
				<tiles:insert definition="USER1" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="2">
				<tiles:insert definition="USER2" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="3">
				<tiles:insert definition="USER3" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="4">
				<tiles:insert definition="USERCONTROL" />
		</logic:equal>
		</div>
	</div>
</div>
		