<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<div class="x_panel">
	<div class="x_title">
		<h2>Danh sách tính chất nhập</h2>
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
				<div class="col-sm-12">
					<table id="datatable"
						class="table table-striped table-bordered dataTable no-footer"
						role="grid" aria-describedby="datatable_info">
						<thead>
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 68px;">Mã tính chất</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 426px;">Tính chất nhập</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 204px;">Ghi chú</th>

							</tr>
						</thead>


						<tbody>

							<tr role="row" class="odd">

								<td>3301</td>
								<td>Điều chuyển kho chiến lược</td>
								<td>Điều chuyển kho chiến lược</td>
							</tr>
							<tr role="row" class="odd">

								<td>3301</td>
								<td>Điều chuyển kho chiến lược</td>
								<td>Điều chuyển kho chiến lược</td>
							</tr>
							<tr role="row" class="odd">

								<td>3301</td>
								<td>Điều chuyển kho chiến lược</td>
								<td>Điều chuyển kho chiến lược</td>
							</tr>
							<tr role="row" class="odd">

								<td>3301</td>
								<td>Điều chuyển kho chiến lược</td>
								<td>Điều chuyển kho chiến lược</td>
							</tr>
							<tr role="row" class="odd">

								<td>3301</td>
								<td>Điều chuyển kho chiến lược</td>
								<td>Điều chuyển kho chiến lược</td>
							</tr>
							<tr role="row" class="odd">

								<td>3301</td>
								<td>Điều chuyển kho chiến lược</td>
								<td>Điều chuyển kho chiến lược</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="x_panel">
	<div class="x_title">
		<h2>
			Nhập liệu <small>dùng cho sửa hoặc xóa</small>
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
			<div class="col-md-12 col-sm-12 col-xs-12 "
				style="padding-bottom: 15px;">
				<label class="control-lable col-md-2 col-sm-2 col-xs-2"
					for="first-name" style="padding-top: 5px">Mã tính chất</label>
				<div class="control-label col-md-10 col-sm-10 col-xs-10">
					<input type="text" class="form-control" id="inputSuccess3">
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12 "
				style="padding-bottom: 15px;">
				<label class="control-lable col-md-2 col-sm-2 col-xs-2"
					for="first-name" style="padding-top: 5px">Tính chất nhập</label>
				<div class="control-label col-md-10 col-sm-10 col-xs-10">
					<input type="text" class="form-control" id="inputSuccess3">
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12 "
				style="padding-bottom: 15px;">
				<label class="control-lable col-md-2 col-sm-2 col-xs-2"
					for="first-name" style="padding-top: 5px">Ghi chú</label>
				<div class="control-label col-md-10 col-sm-10 col-xs-10">
					<input type="text" class="form-control" id="inputSuccess3">
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="ln_solid"></div>
		<div class="row" style="text-align: right;">
			<button type="button" class="btn btn-default">
				<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
					<a href="#/recycle"><i class="fa fa-print"></i> In</a>
				</div>
			</button>
			<button type="button" class="btn btn-success">
				<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
					<a data-toggle="modal" data-target="#modal-confirm" href="#/plus" style="color: white;"><i class="fa fa-plus"></i>
						Thêm</a>
				</div>
			</button>
			<button type="button" class="btn btn-warning">
				<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
					<a data-toggle="modal" data-target="#modal-confirm" href="#/pencil" style="color: white;"><i
						class="fa fa-pencil"></i> Sửa</a>
				</div>
			</button>
			<button type="button" class="btn btn-danger">
				<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
					<a data-toggle="modal" data-target="#modal-confirm" href="#/times" style="color: white;"><i class="fa fa-remove"></i>
						Xóa<span class="text-muted"></span></a>
				</div>
			</button>
		</div>