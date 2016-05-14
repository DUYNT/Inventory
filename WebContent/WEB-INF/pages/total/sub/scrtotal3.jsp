<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Xem thẻ kho</h3>
<div class="row">
	<!-- form input mask -->
	<div class="col-md-6 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					Tìm kiếm <small>nhập thông tin tìm kiếm</small>
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
				<br>
				<div class="form-horizontal form-label-left input_mask">

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Tại
							kho</label>
						<div class="control-label col-md-9 col-sm-9 col-xs-12">
							<select class="form-control">

								<option>Kho số 1</option>
								<option>Kho số 2</option>
								<option>Kho số 3</option>
								<option>Kho số 4</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Thẻ
							kho</label>
						<div class="control-label col-md-9 col-sm-9 col-xs-12">
							<select class="form-control">
								<option>Xăng xe máy</option>
								<option>Xăng xe oto</option>
								<option>Xăng tầu bay</option>
								<option>Xăng xe lửa</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Từ
							ngày</label>
						<div class="col-md-9 col-sm-9 col-xs-12">
							<input type="text" class="form-control" placeholder="Ghi chú">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">Đến
							ngày</label>
						<div class="col-md-9 col-sm-9 col-xs-12">
							<input type="text" class="form-control" placeholder="Ghi chú">
						</div>
					</div>
					<div class="ln_solid"></div>
					<div class="form-group">
						<div class="col-md-6 col-md-offset-3">
							<button id="send" type="button" class="btn btn-success">
								<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
									<a href="#/search" style="color: white;"><i
										class="fa fa-search"></i> Tìm kiếm</a>
								</div>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /form input mask -->

	<!-- form color picker -->
	<div class="col-md-6 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					Mục đích <small>tính chất sử dụng</small>
				</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br>
				<div class="jumbotron">
					<p style="text-align: center;">Chức năng này cho phép xem tình
						hình xuất nhập của từng khoản hàng</p>
				</div>
			</div>
		</div>
	</div>
	<!-- /form color picker -->
</div>

<div class="x_panel">
	<div class="x_title">
		<h2>
			Thông tin <small>chi tiết của từng khoản hàng</small>
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
		<div class="table-responsive">
			<table class="table">
				<tbody>
					<tr>
						<th style="width: 25%">Mã vật tư:</th>
						<td style="width: 25%">00.25.33.44.65</td>
						<th style="width: 25%">SL đầu kỳ:</th>
						<td style="width: 25%">102,100</td>
					</tr>
					<tr>
						<th>Tên vật tư:</th>
						<td style="text-align: left;">Xăng dầu hỏa</td>
						<th>SL cuối kỳ</th>
						<td style="text-align: left;">102,100</td>
					</tr>
					<tr>
						<th>Đơn vị tính:</th>
						<td style="text-align: left;">lít</td>
						<th>Đơn giá</th>
						<td style="text-align: left;">50,224đ</td>
					</tr>
					<tr>
						<th>Chất lượng</th>
						<td style="text-align: left;">Loại 1</td>
						<th></th>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<br>
	</div>
</div>


<div class="x_panel">
	<div class="x_title">
		<h2>
			Danh sách <small>đã tìm kiếm được</small>
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

		<div id="datatable_wrapper"
			class="dataTables_wrapper form-inline dt-bootstrap no-footer">
			<div class="row">
				<div class="col-sm-6">
					<div class="dataTables_length" id="datatable_length">
						<label>Hiển thị <select name="datatable_length"
							aria-controls="datatable" class="form-control input-sm"><option
									value="10">10</option>
								<option value="25">25</option>
								<option value="50">50</option>
								<option value="100">100</option></select> đối tượng
						</label>
					</div>
				</div>
				<div class="input-group" style="float:right; margin-right: 5px">
					<input type="text" class="form-control" placeholder="Tìm kiếm"/><span
						class="input-group-btn">
						<button type="button" class="btn btn-primary">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<table id="datatable"
						class="table table-striped table-bordered dataTable no-footer"
						role="grid" aria-describedby="datatable_info">
						<thead>
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 68px;">Ngày X/N</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 150px;">Số X/N lệnh</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 380px;">Đơn vị Nhập/Xuất</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Age: activate to sort column ascending"
									style="width: 111px;">SL Nhập</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Start date: activate to sort column ascending"
									style="width: 195px;">Số lượng Xuất</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">Số lượng tồn</th>
							</tr>
						</thead>


						<tbody>

							<tr role="row" class="odd">
								<td class="sorting_1">Airi Satou</td>
								<td>Accountant</td>
								<td>Tokyo</td>
								<td>330,235</td>
								<td>235</td>
								<td>162,700</td>
							</tr>
							<tr role="row" class="even">
								<td class="sorting_1">Angelica Ramos</td>
								<td>Chief Executive Officer (CEO)</td>
								<td>London</td>
								<td>475,457</td>
								<td>457</td>
								<td>1,200,000</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">Ashton Cox</td>
								<td>Junior Technical Author</td>
								<td>San Francisco</td>
								<td>66,457</td>
								<td>457</td>
								<td>86,000</td>
							</tr>
							<tr role="row" class="even">
								<td class="sorting_1">Bradley Greer</td>
								<td>Software Engineer</td>
								<td>London</td>
								<td>41,457</td>
								<td>457</td>
								<td>132,000</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">Brenden Wagner</td>
								<td>Software Engineer</td>
								<td>San Francisco</td>
								<td>28,457</td>
								<td>457</td>
								<td>206,850</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<div class="dataTables_info" id="datatable_info" role="status"
						aria-live="polite">Showing 1 to 10 of 57 entries</div>
				</div>
				<div class="col-sm-7">
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
