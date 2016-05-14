<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<script type="text/javascript" src="./js/scr/SCR0010.js" charset="UTF-8"></script>
<zz:hidden property="value.user.checkFail" name="BaseForm"
	styleId="checkFail" value="0"/>
<div class="layoutLogin" style="height: 310px">
	<h4>Đăng nhập đến hệ thống</h4>
	<zz:text styleClass="name" name="BaseForm"
		property="value.user.tenDangNhap" require="true" />
	<zz:password styleClass="pw" name="BaseForm"
		property="value.user.matKhau" require="true" />
	<div id="capcharLogin" class="name hieght48" style="width: 343px; float: left;  display: none;">
		<zz:text styleClass="pw" name="BaseForm" property="value.user.capchar"
			require="true" style="width: 48%" />
		<div style="background: #FFF; width: 40%; height: 48px; border-radius: 6px; position: relative; left: 60%; top: -60px;">
			<img src="ic.jpg" style="position: relative; top: 5px" />
		</div>
	</div>
	<zz:button index="1" styleId="button" styleClass="button"
		onclick="login()" />
	<span style="color: red; font-size: small; float: left; width: 100%">
		<logic:notEmpty name="BaseForm" property="value.errorMsg">
			<zz:write property="value.errorMsg" />
		</logic:notEmpty>
	</span>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		var count = $("#checkFail").val();
		count++;
		$("#checkFail").val(count);
		if($("#checkFail").val() >= 4){
			$("#capcharLogin").show();
		}else{
			$("#capcharLogin").hide();
		}
	});
</script>
</html>
