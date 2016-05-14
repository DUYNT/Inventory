<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<!-- jquery.inputmask -->
<div class="page-title">
	<div class="title_left">
		<h3>Hồ sơ cá nhân</h3>
	</div>
	<div class="title_right">
		<div
			class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for...">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">Go!</button>
				</span>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-6 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>Thay đổi thông tin đăng nhập</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="fa fa-wrench"></i></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Settings 1</a></li>
							<li><a href="#">Settings 2</a></li>
						</ul></li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br>
				<div class="form-horizontal form-label-left input_mask">

					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess2"
							placeholder="<zz:write property="value.info.userInfo.username" name="BaseForm"/>"
							disabled="disabled"> <span
							class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="password" class="form-control"
							name="value.user.matKhau" placeholder="Mật khẩu hiện tại">
						<span class="fa fa-lock form-control-feedback right"
							aria-hidden="true"></span>
					</div>
					<!-- chuyen vao Object User mật khẩu cần thay đổi -->
					<div id="user-control-password-new"
						class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="password" class="form-control has-feedback-left"
							name="value.user.matKhauMoi" id="passwordNew"
							placeholder="Mật khẩu mới"> <span
							class="fa fa-lock form-control-feedback left" aria-hidden="true"></span>
					</div>

					<div id="user-control-password-confirm"
						class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="password" class="form-control" id="confirmPassword"
							placeholder="Nhập lại mật khẩu"> <span
							class="fa fa-lock form-control-feedback right" aria-hidden="true"></span>
					</div>

					<div class="ln_solid"></div>
					<div class="form-group">
						<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
							<button type="button" class="btn btn-success" id="updateChangerPassword">Cập nhật mật
								khẩu</button>
						</div>
						<span
							style="color: red; font-size: small; float: left; width: 100%;" id="errMsg">
							<logic:notEmpty name="BaseForm" property="value.errMsg">
								<zz:write property="value.errMsg" />
							</logic:notEmpty>
						</span>
					</div>

				</div>
			</div>
		</div>

	</div>

	<div class="col-md-6 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>Thay đổi thông tin cá nhân</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="fa fa-wrench"></i></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Settings 1</a></li>
							<li><a href="#">Settings 2</a></li>
						</ul></li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br>
				<div class="form-horizontal form-label-left">

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Tên
							đầy đủ</label>
						<div class="col-md-9 col-sm-9 col-xs-9">
							<input type="text" class="form-control has-feedback-left"
								id="single_cal3"
								name="value.user.tenDayDu"
								placeholder="<zz:write property="value.info.userInfo.tenDayDu" name="BaseForm"/>"
								aria-describedby="inputSuccess2Status3"
								value="<zz:write property="value.info.userInfo.tenDayDu" name="BaseForm"/>">
							<span class="fa fa-user form-control-feedback left"
								aria-hidden="true"></span> <span id="inputSuccess2Status3"
								class="sr-only">(success)</span>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Số
							điện thoại</label>
						<div class="col-md-9 col-sm-9 col-xs-9">
							<input type="text" class="form-control has-feedback-left"
								name="value.user.soDienThoai"
								placeholder="<zz:write property="value.info.userInfo.soDienThoai" name="BaseForm"/>"
								aria-describedby="inputSuccess2Status3"
								value="<zz:write property="value.info.userInfo.soDienThoai" name="BaseForm"/>">
							<span class="fa fa-phone-square form-control-feedback left"
								aria-hidden="true"></span> <span id="inputSuccess2Status3"
								class="sr-only">(success)</span>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Số
							CMND</label>
						<div class="col-md-9 col-sm-9 col-xs-9">
							<input disabled="disabled" type="text"
								name="value.user.chungMinhThu"
								class="form-control has-feedback-left" id="single_cal3"
								placeholder="<zz:write property="value.info.userInfo.chungMinhThu" name="BaseForm"/>"
								aria-describedby="inputSuccess2Status3"> <span
								class="fa fa-credit-card form-control-feedback left"
								aria-hidden="true"></span> <span id="inputSuccess2Status3"
								class="sr-only">(success)</span>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Ngày
							cấp CMND</label>
						<div class="col-md-9 col-sm-9 col-xs-9">
							<input disabled="disabled" type="text"
								name="value.user.ngayCap"
								class="form-control has-feedback-left" id="single_cal3"
								placeholder="<zz:write property="value.info.userInfo.ngayCap" name="BaseForm"/>"
								aria-describedby="inputSuccess2Status3"> <span
								class="fa fa-calendar-o form-control-feedback left"
								aria-hidden="true"></span> <span id="inputSuccess2Status3"
								class="sr-only">(success)</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Nơp
							cấp</label>
						<div class="col-md-9 col-sm-9 col-xs-9">
							<input disabled="disabled" type="text"
								name="value.user.noiCap"
								class="form-control has-feedback-left" id="single_cal3"
								placeholder="<zz:write property="value.info.userInfo.noiCap" name="BaseForm"/>"
								aria-describedby="inputSuccess2Status3"> <span
								class="fa fa-check-circle form-control-feedback left"
								aria-hidden="true"></span> <span id="inputSuccess2Status3"
								class="sr-only">(success)</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Đơn
							vị làm việc</label>
						<div class="col-md-9 col-sm-9 col-xs-9">
							<input disabled="disabled" type="text"
								class="form-control has-feedback-left" id="single_cal3"
								name="value.user.donVi"
								placeholder="<zz:write property="value.info.userInfo.donVi" name="BaseForm"/>"
								aria-describedby="inputSuccess2Status3"> <span
								class="fa fa fa-tree form-control-feedback left"
								aria-hidden="true"></span> <span id="inputSuccess2Status3"
								class="sr-only">(success)</span>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Ngày
							tạo sử dụng</label>
						<div class="col-md-9 col-sm-9 col-xs-9">
							<input disabled="disabled" type="text"
								class="form-control has-feedback-left" id="single_cal3"
								name="value.user.ngayTaoSuDung"
								placeholder="<zz:write property="value.info.userInfo.ngayTaoSuDung" name="BaseForm"/>"
								aria-describedby="inputSuccess2Status3"> <span
								class="fa fa-calendar-o form-control-feedback left"
								aria-hidden="true"></span> <span id="inputSuccess2Status3"
								class="sr-only">(success)</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Mật
							khẩu hiện tại</label>
						<div class="col-md-9 col-sm-9 col-xs-9">
							<input type="password" class="form-control has-feedback-left"
								name="value.user.matKhau"
								id="matKhauConfirm" aria-describedby="inputSuccess2Status3">
							<span class="fa fa-lock form-control-feedback left"
								aria-hidden="true"></span> <span id="inputSuccess2Status3"
								class="sr-only">(success)</span>
						</div>
					</div>
					<div class="ln_solid"></div>
					<div class="form-group">
						<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
							<button type="button" id="updateUserInfomation" class="btn btn-success">Cập nhật
								thông tin</button>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#single_cal1').daterangepicker({
			singleDatePicker : true,
			calender_style : "picker_1"
		}, function(start, end, label) {
			console.log(start.toISOString(), end.toISOString(), label);
		});
		$('#single_cal2').daterangepicker({
			singleDatePicker : true,
			calender_style : "picker_2"
		}, function(start, end, label) {
			console.log(start.toISOString(), end.toISOString(), label);
		});
		$('#single_cal3').daterangepicker({
			singleDatePicker : true,
			calender_style : "picker_3"
		}, function(start, end, label) {
			console.log(start.toISOString(), end.toISOString(), label);
		});
		$('#single_cal4').daterangepicker({
			singleDatePicker : true,
			calender_style : "picker_4"
		}, function(start, end, label) {
			console.log(start.toISOString(), end.toISOString(), label);
		});
	});
</script>
