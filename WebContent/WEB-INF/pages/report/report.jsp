<%@ page session="false"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>

<div class="container body">
	<div class="main_container">
		<div class="right_col" role="main">
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="1">
				<tiles:insert definition="REPORT1" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="2">
				<tiles:insert definition="REPORT2" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="3">
				<tiles:insert definition="REPORT3" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="4">
				<tiles:insert definition="REPORT4" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="5">
				<tiles:insert definition="REPORT5" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="6">
				<tiles:insert definition="REPORT6" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="7">
				<tiles:insert definition="REPORT7" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="8">
				<tiles:insert definition="REPORT8" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="9">
				<tiles:insert definition="REPORT9" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="10">
				<tiles:insert definition="REPORT10" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="11">
				<tiles:insert definition="REPORT11" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="12">
				<tiles:insert definition="REPORT12" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="13">
				<tiles:insert definition="REPORT13" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="14">
				<tiles:insert definition="REPORT14" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="15">
				<tiles:insert definition="REPORT15" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="16">
				<tiles:insert definition="REPORT16" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="17">
				<tiles:insert definition="REPORT17" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="18">
				<tiles:insert definition="REPORT18" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="19">
				<tiles:insert definition="REPORT19" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="20">
				<tiles:insert definition="REPORT20" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="21">
				<tiles:insert definition="REPORT21" />
		</logic:equal>
		<logic:equal name="BaseForm" property="value.resultValue.typeLayout" value="22">
				<tiles:insert definition="REPORT22" />
		</logic:equal>
		</div>
	</div>
</div>
		