<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Ghi thực kiểm</h3>


<div class="x_panel">
	<div class="x_title">
		<h2>
			Form Design <small>different form elements</small>
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


		<div class="form-horizontal form-label-left input_mask">





			<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">

				<div class="form-group">



					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="first-name" style="padding-top: 5px">Tháng kiểm kê
							</label>
							<div class="control-label col-md-9 col-sm-9 col-xs-12">
								<select class="form-control">

									<option>01</option>
									<option>002</option>
									<option>03</option>
									<option>04</option>
								</select>
							</div>
						</div>

					</div>

					<div class="col-md-3 col-sm-3 col-xs-12">

						<div class="radio">
							<label> <input type="radio" checked="" value="option1"
								id="optionsRadios1" name="optionsRadios"> Nhiên liệu
							</label>
						</div>
					</div>

					<div class="col-md-3 col-sm-3 col-xs-12">
						<div class="radio">
							<label> <input type="radio" checked="" value="option1"
								id="optionsRadios1" name="optionsRadios"> Dầu mỡ
							</label>
						</div>
					</div>



					<div class="col-md-2 col-sm-2 col-xs-12">
						<button type="button" class="btn btn-primary">Thực lực
							kiểm kê hàng hóa</button>
					</div>
				</div>


			</div>

		</div>



		<div class="x_panel">
			<div class="x_title">
				<h2>Bảng vật tư</h2>
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




				<div class="form-horizontal form-label-left input_mask">

					<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">

						<div class="form-group">

							<div class="col-md-5 col-sm-5 col-xs-12">
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="first-name" style="padding-top: 15px">Vật tư xăng
										dầu </label>
									<div class="control-label col-md-9 col-sm-9 col-xs-12">
										<select class="form-control">


										</select>
									</div>
								</div>

							</div>
							<div class="col-md-3 col-sm-3 col-xs-12" style="padding-top: 7px">
								<button type="button" class="btn btn-primary">..</button>
							</div>

						</div>

					</div>

				</div>



				<div id="datatable_wrapper"
					class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					<div class="row">
						<div class="col-sm-6">
							<div class="dataTables_length" id="datatable_length">
								<label>Show <select name="datatable_length"
									aria-controls="datatable" class="form-control input-sm"><option
											value="10">10</option>
										<option value="25">25</option>
										<option value="50">50</option>
										<option value="100">100</option></select> entries
								</label>
							</div>
						</div>
						<div class="col-sm-6">
							<div id="datatable_filter" class="dataTables_filter">
								<label>Search:<input type="search"
									class="form-control input-sm" placeholder=""
									aria-controls="datatable"></label>
							</div>
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
											style="width: 68px;">Mã bồn</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Position: activate to sort column ascending"
											style="width: 68px;">Tên bồn chứa</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Office: activate to sort column ascending"
											style="width: 68px;">Đơn vị tính</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Age: activate to sort column ascending"
											style="width: 68px;">Đơn giá</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Start date: activate to sort column ascending"
											style="width: 68px;">Tồn đầu kỳ</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Salary: activate to sort column ascending"
											style="width: 68px;">Tăng TK</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Salary: activate to sort column ascending"
											style="width: 68px;">Giảm TK</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Salary: activate to sort column ascending"
											style="width: 68px;">SL sổ sách</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Salary: activate to sort column ascending"
											style="width: 68px;">T.Tế KK</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Salary: activate to sort column ascending"
											style="width: 68px;">H chung</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Salary: activate to sort column ascending"
											style="width: 68px;">H nước</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Salary: activate to sort column ascending"
											style="width: 68px;">V dầu TT</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Salary: activate to sort column ascending"
											style="width: 68px;">V 15</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Salary: activate to sort column ascending"
											style="width: 68px;">Ghi chú</th>
									</tr>
								</thead>


								<tbody>


									<tr role="row" class="odd">
										<td>001</td>
										<td>Bồn chứa xăng</td>
										<td>lít</td>
										<td>20,00.0</td>
										<td>200</td>
										<td>100</td>
										<td>12</td>
										<td>1</td>
										<td>30</td>
										<td>Tokyo</td>
										<td>33</td>
										<td>2008/11/28</td>
										<td>$162,700</td>
										<td>$162,700</td>


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
										href="#" aria-controls="datatable" data-dt-idx="7"
										tabindex="0">Next</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>


<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">

	<div class="form-group" style="padding-top: 10px">

		<div class="col-md-4 col-sm-4 col-xs-12" > 
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="first-name" style="padding-top: 5px">Bồn chứa </label>
				<div class="control-label col-md-9 col-sm-9 col-xs-12">
					<select class="form-control">

						<option>01</option>
						<option>002</option>
						<option>03</option>
						<option>04</option>
					</select>
				</div>
			</div>

		</div>

		<div class="col-md-4 col-sm-4 col-xs-12" >
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">H chung </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">V chung </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
	</div>
	<div class="form-group" style="margin-top: 5px">

		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">Tồn đầu kỳ </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">H Nước</label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">V Nước </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
	</div>
	<div class="form-group" style="margin-top: 5px">

		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">Tăng TK </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">T Thực tế</label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">V Dầu TT </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
	</div>
	<div class="form-group" style="margin-top: 5px">

		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">Giảm TK </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">D15</label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">V15 </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
	</div>
	<div class="form-group" style="margin-top: 5px">

		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">SL sổ sách </label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					style="padding-top: 5px">CVF</label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>

	</div>

	<div class="form-group" style="margin-top: 5px">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-1 col-sm-1 col-xs-12"
					style="padding-top: 5px">Ghi chú</label>
				<div class="col-md-7 col-sm-7 col-xs-12">
					<input class="date-picker form-control col-md-7 col-xs-12"
						required="required" type="text">
				</div>
			</div>

		</div>
	</div>
</div>
<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
		<button type="button" class="btn btn-success">
			<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
				<a data-toggle="modal" data-target="#modal-confirm" href="#/print" style="color: white;"><i class="fa fa-plus"></i>
					Thêm mới</a>
			</div>
		</button>
	<button type="button" class="btn btn-success">
			<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
				<a data-toggle="modal" data-target="#modal-confirm" href="#/print" style="color: white;"><i class="fa fa-trash-o"></i>
					Xóa</a>
			</div>
		</button>
		<button type="button" class="btn btn-success">
			<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
				<a data-toggle="modal" data-target="#modal-confirm" href="#/print" style="color: white;"><i class="fa fa-filter"></i>
					Ghi</a>
			</div>
		</button>
</div>