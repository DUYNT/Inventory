var objStation = {
	checkAutoSymStation : function () {
		alert(10);
		if($("#checkAutoSymStation").hasClass('checked')){
			$("#settingFormAutoSymStation").show();
		}else{
			alert(11);
			$("#settingFormAutoSymStation").hide();
		}
	}
}