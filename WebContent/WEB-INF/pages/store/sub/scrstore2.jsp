<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Quản lý phiếu xuất</h3>
<div class="row">
	<!-- form input mask -->
	<div class="col-md-6 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					Danh sách phiếu xuât <small>Nhấn chuột vào để xem thông tin</small>
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
							<th>Số phiếu</th>
							<th>Ngày viết</th>
							<th>Theo lệnh</th>
							<th>Số xe</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">100</th>
							<td>11/12/2001</td>
							<td>Thông tư 23</td>
							<td>33-H3 9956</td>
						</tr>
						<tr>
							<th scope="row">101</th>
							<td>11/02/2001</td>
							<td>Thông tư 24</td>
							<td>33-H3 3876</td>
						</tr>
						<tr>
							<th scope="row">102</th>
							<td>11/11/2001</td>
							<td>Thông tư 25</td>
							<td>33-H3 3556</td>
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

	<!-- form color picker -->
	<div class="col-md-6 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>Mục đích</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br>
				<div class="form-horizontal form-label-left input_mask">
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<select class="form-control">
							<option>Đơn vị nhận</option>
							<option>Quân khu 1</option>
							<option>Quân khu 2</option>
							<option>Quân khu 3</option>
							<option>Quân khu 4</option>
						</select>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<select class="form-control">
							<option>Tính chất nhập</option>
							<option>Kế hoạch tổng cục</option>
							<option>Kế hoạch lẻ</option>
							<option>Kế hoạch dự phòng</option>
							<option>Kế hoạch sẵn sàng</option>
						</select>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="Người nhận"> <span
							class="fa fa-child form-control-feedback left" aria-hidden="true"></span>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control" id="inputSuccess5"
							placeholder="Giấy giới thiệu số"> <span
							class="fa fa-inbox form-control-feedback right"
							aria-hidden="true"></span>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="Ngày hết hạn"> <span
							class="fa fa-calendar form-control-feedback left"
							aria-hidden="true"></span>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control" id="inputSuccess5"
							placeholder="Theo lệnh"> <span
							class="fa fa-phone form-control-feedback right"
							aria-hidden="true"></span>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="ĐV Vận chuyển"> <span
							class="fa fa-truck form-control-feedback left" aria-hidden="true"></span>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control" id="inputSuccess5"
							placeholder="Biển số xe"> <span
							class="fa fa-sort-numeric-asc form-control-feedback right"
							aria-hidden="true"></span>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="Dung tích"> <span
							class="fa fa-hdd-o form-control-feedback left" aria-hidden="true"></span>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control" id="inputSuccess5"
							placeholder="Ngày tạo phiếu"> <span
							class="fa fa-calendar form-control-feedback right"
							aria-hidden="true"></span>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
						<textarea class="form-control" rows="3" placeholder="Ghi chú"></textarea>
					</div>
					<div class="clearfix"></div>
					<div class="ln_solid"></div>
					<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3"
						style="margin-left: 0%">
						<button type="button" class="btn btn-primary">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm" href="#/plus" style="color: white;"><i class="fa fa-plus"></i>
									Tạo phiếu mới</a>
							</div>
						</button>
						<button type="button" class="btn btn-primary">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm" href="#/pencil" style="color: white;"><i
									class="fa fa-pencil"></i> Sửa phiếu</a>
							</div>
						</button>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- /form color picker -->
</div>

<div class="x_panel">
	<div class="x_title">
		<h2>
			Danh sách <small>hàng hóa của phiếu nhập</small>
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
				<button type="button" class="btn btn-success" data-toggle="modal"
					data-target="#modal-quan-ly-phieu-xuat-1" style="float: right;">
					<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
						<i class="fa fa-plus-square-o"></i> Thêm hàng hóa
					</div>
				</button>
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
									style="width: 20px;">STT</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 422px;">Mã vật tư</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 202px;">Tên vật tư</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Age: activate to sort column ascending"
									style="width: 111px;">ĐVT</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Start date: activate to sort column ascending"
									style="width: 195px;">CL</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">SL KH</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">ND TT</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">D 15oC</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">VCF</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">SLTT</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">Đơn giá</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">Thành tiền</th>
							</tr>
						</thead>


						<tbody>


							<tr role="row" class="odd">
								<td class="sorting_1">001</td>
								<td>X00.00.01.01.01.004</td>
								<td>X¨ng RON 83</td>
								<td>Lít</td>
								<td>2127</td>
								<td>28oC</td>
								<td>18oC</td>
								<td>100</td>
								<td>2015</td>
								<td>10054</td>
								<td>162,700 đ</td>
								<td>162,700 đ</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">001</td>
								<td>X00.00.01.01.01.004</td>
								<td>X¨ng RON 83</td>
								<td>Lít</td>
								<td>2127</td>
								<td>28oC</td>
								<td>18oC</td>
								<td>100</td>
								<td>2015</td>
								<td>10054</td>
								<td>162,700 đ</td>
								<td>162,700 đ</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">001</td>
								<td>X00.00.01.01.01.004</td>
								<td>X¨ng RON 83</td>
								<td>Lít</td>
								<td>2127</td>
								<td>28oC</td>
								<td>18oC</td>
								<td>100</td>
								<td>2015</td>
								<td>10054</td>
								<td>162,700 đ</td>
								<td>162,700 đ</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<tiles:insert definition="PHIEUXUAT1" />
<tiles:insert definition="PHIEUXUAT2" />
<tiles:insert definition="PHIEUXUAT3" />
