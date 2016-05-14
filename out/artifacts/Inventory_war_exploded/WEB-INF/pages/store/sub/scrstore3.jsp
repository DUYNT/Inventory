<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Quản lý hao hụt</h3>


<div class="x_panel">
	<div class="x_title">
		<h2>
			Lựa chọn <small>vật tư hiện có</small>
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
					<div class="col-md-3 col-sm-3 col-xs-12">
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="first-name" style="padding-top: 5px">Kho </label>
							<div class="control-label col-md-9 col-sm-9 col-xs-12">
								<select class="form-control">

									<option>Bồn kho 1</option>
									<option>Bồn kho 2</option>
									<option>Bồn kho 3</option>
									<option>Bồn kho 4</option>
								</select>
							</div>
						</div>

					</div>

					<div class="col-md-3 col-sm-3 col-xs-12">

						<div class="form-group">
							<label class="control-label col-md-4 col-sm-4 col-xs-12"
								for="first-name" style="padding-top: 5px">Nguồn</label>
							<div class="control-label col-md-8 col-sm-8 col-xs-12">
								<select class="form-control">
									<option>Dự trữ thường xuyên</option>
									<option>Option one</option>
									<option>Option two</option>
									<option>Option three</option>
									<option>Option four</option>
								</select>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="ln_solid"></div>
					<button type="button" class="btn btn-primary">
						<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
							<a href="#/recycle" style="color: white;"><i
								class="fa fa-recycle"></i> Tồn kho</a>
						</div>
					</button>
					<button type="button" class="btn btn-default">
						<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
							<a href="#/recycle"><i class="fa fa-print"></i> In báo cáo</a>
						</div>
					</button>
				</div>


			</div>

		</div>
	</div>
</div>



<div class="x_panel">
	<div class="x_title">
		<h2>
			Danh sách <small>vật tư hiện có</small>
		</h2>
		<ul class="nav navbar-right panel_toolbox">
			<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
			</li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-expanded="false"><i
					class="fa fa-wrench"></i></a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">In báo cáo</a></li>
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
						<label>Show <select name="datatable_length"
							aria-controls="datatable" class="form-control input-sm"><option
									value="10">10</option>
								<option value="25">25</option>
								<option value="50">50</option>
								<option value="100">100</option></select> entries
						</label>
					</div>
				</div>
				<div class="input-group" style="float: right; margin-right: 5px">
					<input type="text" class="form-control" placeholder="Tìm kiếm" /><span
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
									style="width: 68px;">STT</th>
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
									style="width: 111px;">Đơn vị tính</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Start date: activate to sort column ascending"
									style="width: 195px;">Chất lượng</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">Đơn giá</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">Số lượng hao hụt</th>
							</tr>
						</thead>


						<tbody>


							<tr role="row" class="odd">
								<td class="sorting_1">1</td>
								<td>Accountant</td>
								<td>Tokyo</td>
								<td>33</td>
								<td>2008/11/28</td>
								<td>$162,700</td>
								<td>$162,700</td>
							</tr>
							<tr role="row" class="even">
								<td class="sorting_1">2</td>
								<td>Chief Executive Officer (CEO)</td>
								<td>London</td>
								<td>47</td>
								<td>2009/10/09</td>
								<td>$1,200,000</td>
								<td>$162,700</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">3</td>
								<td>Junior Technical Author</td>
								<td>San Francisco</td>
								<td>66</td>
								<td>2009/01/12</td>
								<td>$86,000</td>
								<td>$162,700</td>
							</tr>
							<tr role="row" class="even">
								<td class="sorting_1">4</td>
								<td>Software Engineer</td>
								<td>London</td>
								<td>41</td>
								<td>2012/10/13</td>
								<td>$132,000</td>
								<td>$162,700</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">5</td>
								<td>Software Engineer</td>
								<td>San Francisco</td>
								<td>28</td>
								<td>2011/06/07</td>
								<td>$206,850</td>
								<td>$162,700</td>
							</tr>
							<tr role="row" class="even">
								<td class="sorting_1">6</td>
								<td>Integration Specialist</td>
								<td>New York</td>
								<td>61</td>
								<td>2012/12/02</td>
								<td>$372,000</td>
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
								href="#" aria-controls="datatable" data-dt-idx="7" tabindex="0">Next</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="x_panel">
	<div class="x_title">
		<h2>
			Fixed Header Example <small>Users</small>
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
		<p class="text-muted font-13 m-b-30">
		<div class="form-horizontal form-label-left input_mask">
			<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">

				<div class="form-group">

					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-1 col-xs-12"
								for="first-name" style="padding-top: 15px; text-align: left">Khâu
								hao hụt </label>
							<div class="control-label col-md-9 col-sm-11 col-xs-12"
								style="padding-bottom: 5px">
								<select class="form-control">

									<option>Tất cả các khâu đã nhập số liệu</option>
									<option>Bồn kho 2</option>
									<option>Bồn kho 3</option>
									<option>Bồn kho 4</option>
								</select>
							</div>
						</div>

					</div>
					<div class="clearfix"></div>
		<div class="ln_solid"></div>
					<div style="width: 100%; vertical-align: middle; padding-top: 5px">
						<button type="button" class="btn btn-default">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a href="#/recycle"><i class="fa fa-print"></i> In gửi cục</a>
							</div>
						</button>
						<button type="button" class="btn btn-success">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm" href="#/check" style="color: white;"><i
									class="fa fa-check"></i> Xác nhận hao hụt</a>
							</div>
						</button>
						<button type="button" class="btn btn-warning">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm"  href="#/times" style="color: white;"><i
									class="fa fa-close"></i> Xóa</a>
							</div>
						</button>
						<button type="button" class="btn btn-danger">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm" href="#/plus" style="color: white;"><i class="fa fa-plus"></i>
									Ghi</a>
							</div>
						</button>
					</div>
				</div>
			</div>
		</div>

		</p>
		<div id="datatable-fixed-header_wrapper"
			class="dataTables_wrapper form-inline dt-bootstrap no-footer">
			<div class="row">
				<div class="col-sm-12">
					<table id="datatable-fixed-header"
						class="table table-striped table-bordered dataTable no-footer"
						role="grid" aria-describedby="datatable-fixed-header_info">
						<thead>
							<tr role="row">
								<th class="sorting_asc" tabindex="0"
									aria-controls="datatable-fixed-header" rowspan="1" colspan="1"
									aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 268px;">Nội dung</th>
								<th class="sorting" tabindex="0"
									aria-controls="datatable-fixed-header" rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 422px;">Giá trị</th>

							</tr>
						</thead>

						<tbody>
							<tr role="row" class="odd">

								<td>Bể trụ nằm trong hang dài hạn</td>
								<td>6.000.000</td>

							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

