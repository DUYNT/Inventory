var objInputProductManager = {
	callPopupInputProduct : function(){
		var url = CONTEXT_PATH + "Popup_init.do";
		var params = {
				'type' : 'ajax'
		};
		alert(1);
		$post(url, params, function(data){
			var jsonData = JSON.parse(convertNullToEmpty(data));
			$("#myModal").load(location.href + " #myModal");
		});
	},
};