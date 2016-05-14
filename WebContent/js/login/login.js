var objLogin = {
	confirmPassword : function() {
		var newpass = $("#passwordNew").val();
		var confirm = $("#confirmPassword").val();
		var pass = $('input[name="value.user.matKhau"]').val();
		if(convertNullToEmpty($('input[name="value.user.matKhau"]').val()) == ''){
			new ShowNotification({
				title: 'Ô nhập mật khẩu hiện tại',
				text: 'Không thể để trống rỗng ô dữ liệu này nếu muốn thay đổi mật khẩu hiện tại',
				type: 'error',
				sound: false
			});
			return;
		}
		if(convertNullToEmpty($('input[name="value.user.matKhauMoi"]').val()) == ''){
			new ShowNotification({
				title: 'Ô nhập mật khẩu mới',
				text: 'Không thể để trống rỗng ô dữ liệu này nếu muốn thay đổi mật khẩu hiện tại',
				type: 'error',
				sound: false
			});
			return;
		}
		if (newpass != confirm) {
			new ShowNotification({
				title: 'Mật khẩu không khớp',
				text: 'Ô nhập mật khẩu mới và ô xác nhận mật khẩu không khớp nhau, vì vậy không thể thay đổi mật khẩu hiện tại',
				type: 'error',
				sound: false
			});
			return;
		}else{
			var url = CONTEXT_PATH + "/User_changePassword.do";
			var params = {
					"type" : "ajax",
					"value.user.matKhauMoi" : newpass,
					"value.user.matKhau" : pass
			}
			$.post(url, params, function(data) {
				var jsonData = JSON.parse(convertNullToEmpty(data));
				if (jsonData != '') {
					var msg = convertNullToEmpty(jsonData['msg']);
					if(msg != ''){
						new ShowNotification({
							title: 'Thông báo',
							text: msg,
							type: 'info',
							sound: false
						});
					}
				}
			});
		}
	},
	
	updateUserInfomation : function(){
		var tenDayDu = $('input[name="value.user.tenDayDu"]').val();
		var soDienThoai = $('input[name="value.user.soDienThoai"]').val();
		var chungMinhThu = $('input[name="value.user.chungMinhThu"]').val();
		var ngayCap = $('input[name="value.user.ngayCap"]').val();
		var noiCap = $('input[name="value.user.noiCap"]').val();
		var donVi = $('input[name="value.user.donVi"]').val();
		var ngayTaoSuDung = $('input[name="value.user.ngayTaoSuDung"]').val();
		var matKhau = $("#matKhauConfirm").val();
		var url = CONTEXT_PATH + '/User_changeInfomation.do';
		
		if(convertNullToEmpty($('input[name="value.user.tenDayDu"]').val()) == ''){
			new ShowNotification({
				title: 'Không để trống rỗng',
				text: 'Ô nhập dữ liệu tên đầy đủ không được để trống rỗng.',
				type: 'error',
				sound: false
			});
			return;
		}
		if(convertNullToEmpty($("#matKhauConfirm").val()) == ''){
			new ShowNotification({
				title: 'Không để trống rỗng',
				text: 'Ô nhập dữ liệu mật khẩu không được để trống rỗng',
				type: 'error',
				sound: false
			});
			return;
		}
		var params = {
				"type" : "ajax",
				"value.user.tenDayDu" : convertNullToEmpty(tenDayDu),
				"value.user.soDienThoai" : convertNullToEmpty(soDienThoai),
				"value.user.ngayCap" : convertNullToEmpty(ngayCap),
				"value.user.noiCap" : convertNullToEmpty(noiCap),
				"value.user.donVi" : convertNullToEmpty(donVi),
				"value.user.ngayTaoSuDung" : convertNullToEmpty(ngayTaoSuDung),
				"value.user.matKhau" : convertNullToEmpty(matKhau)
		}
		$.post(url, params, function(data) {
			var jsonData = JSON.parse(convertNullToEmpty(data));
			if (jsonData != '') {
				var msg = convertNullToEmpty(jsonData['msg']);
				if(msg != ''){
					new ShowNotification({
						title: 'Thông báo',
						text: msg,
						type: 'info',
						sound: false
					});
				}
			}
		});
	}
}

$(document).ready(function() {
	$("#updateChangerPassword").click(function() {
		objLogin.confirmPassword();
	});
	$("#updateUserInfomation").click(function() {
		objLogin.updateUserInfomation();
	});
});