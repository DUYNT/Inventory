<%@ page session="false"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<script src="./js/store/store.js"></script>
<div class="container body">
	<div class="main_container">
		<div class="right_col" role="main">
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="1">
				<tiles:insert definition="STORE1" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="2">
				<tiles:insert definition="STORE2" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="3">
				<tiles:insert definition="STORE3" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="4">
				<tiles:insert definition="STORE4" />
		</logic:equal>
		</div>
	</div>
</div>
		