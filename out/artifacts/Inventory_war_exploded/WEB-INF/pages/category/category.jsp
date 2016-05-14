<%@ page session="false"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>

<div id="modal-danh-muc" class="container body">
	<div class="main_container">
		<div class="right_col" role="main">
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="1">
				<tiles:insert definition="CATEGORY1" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="2">
				<tiles:insert definition="CATEGORY2" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="3">
				<tiles:insert definition="CATEGORY3" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="4">
				<tiles:insert definition="CATEGORY4" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="5">
				<tiles:insert definition="CATEGORY5" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="6">
				<tiles:insert definition="CATEGORY6" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="7">
				<tiles:insert definition="CATEGORY7" />
		</logic:equal>
		</div>
	</div>
</div>
		