<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>

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
				<label class="control-label col-md-3 col-sm-3 col-xs-12">Tại kho</label>
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
				<label class="control-label col-md-3 col-sm-3 col-xs-12">Thẻ kho</label>
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
				<label class="control-label col-md-3 col-sm-3 col-xs-12">Chất lượng</label>
				<div class="control-label col-md-9 col-sm-9 col-xs-12">
					<select class="form-control">
						<option>Loại 1</option>
						<option>Loại 2</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12">Tìm theo vật tư</label>
				<div class="col-md-9 col-sm-9 col-xs-12">
					<input type="text" class="form-control" placeholder="Ghi chú">
				</div>
			</div>
			<div class="ln_solid"></div>
			<div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <button id="send" type="button" class="btn btn-success"><div class="fa-hover col-md-3 col-sm-4 col-xs-12"><a href="#/search" style="color: white;"><i class="fa fa-search"></i> Tìm kiếm</a>
                        </div></button>
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
                    <h2>Mục đích <small>tính chất sử dụng</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br>
                    <div class="jumbotron">
                      <p style="text-align: center;">Chức năng này cho phép xem vật tư tồn đầu kỳ xuất nhập</p>
                    </div>
                    </div>
                </div>
              </div>
              <!-- /form color picker -->
            </div>

<div class="x_panel">
	<div class="x_title">
		<h2>Danh sách vật tư</h2>
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
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Name: activate to sort column ascending"
									style="width: 58px;">Mã VT</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 422px;">Tên vật tư</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 202px;">Đơn vị tính</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">Chất lượng</th>
								<th class="sorting_desc" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Age: activate to sort column ascending"
									aria-sort="descending" style="width: 111px;">Số lượng</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Start date: activate to sort column ascending"
									style="width: 195px;">Đơn giá</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">Thành tiền</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">Tên kho</th>


							</tr>
						</thead>


						<tbody>

							<tr role="row" class="odd">
								<td class="">001</td>
								<td>Xăng A92</td>
								<td class="">lít</td>
								<td class="sorting_1">tốt</td>
								<td>4 thùng</td>
								<td>$300</td>
								<td>$900000</td>
								<td>Kho 01</td>
							</tr>
							<tr role="row" class="even">
								<td class="">002</td>
								<td>Xăng A95</td>
								<td class="">lít</td>
								<td class="sorting_1">đạt</td>
								<td>1 thùng</td>
								<td>$320</td>
								<td>$102234</td>
								<td>Kho 02</td>
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
