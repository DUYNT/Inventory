<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Danh sách người dùng</h3>
<div class="row">
	<!-- form input mask -->
	<div class="col-md-6 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					Danh sách người dùng<small>Nhấn chuột vào để xem thông tin</small>
				</h2>
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
				<div class="row">
					<div class="col-sm-6">
						<div class="dataTables_length" id="datatable_length">
							<label><select name="datatable_length"
								aria-controls="datatable" class="form-control input-sm"><option
										value="10">10</option>
									<option value="25">25</option>
									<option value="50">50</option>
									<option value="100">100</option></select> </label>
						</div>
					</div>
					<div class="col-sm-6">
						<div id="datatable_filter" class="dataTables_filter">
							<label><input type="search" class="form-control input-sm"
								placeholder="Tìm kiếm" aria-controls="datatable"></label>
						</div>
					</div>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Mã người dùng</th>
							<th>Tên đầy đủ</th>
							<th>Số điện thoại</th>
							<th>Chức vụ</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">100</th>
							<td>Nguyễn Văn A</td>
							<td>01234567889</td>
							<td>Kho 186</td>
						</tr>
						<tr>
							<th scope="row">100</th>
							<td>Nguyễn Văn A</td>
							<td>01234567889</td>
							<td>Kho 186</td>
						</tr>
						<tr>
							<th scope="row">100</th>
							<td>Nguyễn Văn A</td>
							<td>01234567889</td>
							<td>Kho 186</td>
						</tr>
					</tbody>
				</table>
				<div class="row">
					<div class="col-sm-7" style="float: right;">
						<div class="dataTables_paginate paging_simple_numbers"
							id="datatable_paginate">
							<ul class="pagination">
								<li class="paginate_button previous disabled"
									id="datatable_previous"><a href="#"
									aria-controls="datatable" data-dt-idx="0" tabindex="0">Previous</a></li>
								<li class="paginate_button active"><a href="#"
									aria-controls="datatable" data-dt-idx="1" tabindex="0">1</a></li>
								<li class="paginate_button "><a href="#"
									aria-controls="datatable" data-dt-idx="2" tabindex="0">2</a></li>
								<li class="paginate_button "><a href="#"
									aria-controls="datatable" data-dt-idx="3" tabindex="0">3</a></li>
								<li class="paginate_button "><a href="#"
									aria-controls="datatable" data-dt-idx="4" tabindex="0">4</a></li>
								<li class="paginate_button "><a href="#"
									aria-controls="datatable" data-dt-idx="5" tabindex="0">5</a></li>
								<li class="paginate_button "><a href="#"
									aria-controls="datatable" data-dt-idx="6" tabindex="0">6</a></li>
								<li class="paginate_button next" id="datatable_next"><a
									href="#" aria-controls="datatable" data-dt-idx="7" tabindex="0">Next</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- /form input mask -->
	<div class="col-md-6 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>Chức vụ nhân viên</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>

			</div>
			<div class="x_content">
				<div class="col-md-12 col-sm-12 col-xs-12">
                          <select class="select2_single form-control select2-hidden-accessible" tabindex="-1" aria-hidden="true">
                            <option></option>
                            <option value="KH">NV Thống kê, kế hoạch</option>
                            <option value="TC">NV Tài chính</option>
                            <option value="TK">NV Thủ kho</option>
                            <option value="QT">NV Quản trị</option>
                            <option value="HT">NV Hỗ trợ</option>
                          </select>
                        </div>
			</div>
		</div>
	</div>
	<!-- form color picker -->
	<div class="col-md-6 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>Nhập liệu</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br>
				<form class="form-horizontal form-label-left input_mask">
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="Tên đầy đủ"> <span
							class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control" id="inputSuccess5"
							placeholder="Số điện thoại"> <span
							class="fa fa-phone-square form-control-feedback right"
							aria-hidden="true"></span>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="Số CMND"> <span
							class="fa fa-credit-card form-control-feedback left"
							aria-hidden="true"></span>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control" id="inputSuccess5"
							placeholder="Ngày cấp CMND"> <span
							class="fa fa-calendar-o form-control-feedback right"
							aria-hidden="true"></span>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="Nơi cấp"> <span
							class="fa fa-check-circle form-control-feedback left"
							aria-hidden="true"></span>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control" id="inputSuccess5"
							placeholder="Đơn vị làm việc"> <span
							class="fa fa fa-tree form-control-feedback right"
							aria-hidden="true"></span>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="Ngày tạo sử dụng"> <span
							class="fa fa-calendar-o form-control-feedback left"
							aria-hidden="true"></span>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control" id="inputSuccess5"
							placeholder="Mật khẩu mới"> <span
							class="fa fa-lock form-control-feedback right" aria-hidden="true"></span>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="Mật khẩu"> <span
							class="fa fa-lock form-control-feedback left" aria-hidden="true"></span>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control" id="inputSuccess5"
							placeholder="Nhập lại mật khẩu mới"> <span
							class="fa fa-lock form-control-feedback right" aria-hidden="true"></span>
					</div>


					<div class="clearfix"></div>
					<div class="ln_solid"></div>
					<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3"
						style="margin-left: 0%">
						<button type="submit" class="btn btn-primary">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm"
									href="#/plus" style="color: white;"><i class="fa fa-plus"></i>
									Tạo người dùng mới</a>
							</div>
						</button>
						<button type="submit" class="btn btn-primary">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm"
									href="#/pencil" style="color: white;"><i
									class="fa fa-pencil"></i> Sửa người dùng</a>
							</div>
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>
	<!-- /form color picker -->
</div>

