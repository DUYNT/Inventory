<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<div class="checkbox">
	<label class="">
		<div class="icheckbox_flat-green checked" style="position: relative;">
			<input type="checkbox" class="flat" checked="checked"
				style="position: absolute; opacity: 0;">
			<ins class="iCheck-helper"
				style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
		</div> Kho gửi đơn vị
	</label>
</div>

<div class="row">
	<div class="col-md-6 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					Danh sách <small>các phân kho của đơn vị</small>
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
				<div class="col-sm-12">
					<table id="datatable"
						class="table table-striped table-bordered dataTable no-footer"
						role="grid" aria-describedby="datatable_info">
						<thead>
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 68px;">Mã kho</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 422px;">Tên kho</th>
							</tr>
						</thead>
						<tbody>

							<tr role="row" class="odd">
								<td>001</td>
								<td>Bồn số 1</td>
							</tr>
							<tr role="row" class="even">
								<td>002</td>
								<td>Bồn số 2</td>
							</tr>
							<tr role="row" class="odd">
								<td>003</td>
								<td>Bể số 5</td>
							</tr>
							<tr role="row" class="even">
								<td>004</td>
								<td>Bể số 8</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="col-md-6 col-xs-12">
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
				<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
					<input name="value.params.thukho" type="text" class="form-control has-feedback-left"
						id="inputSuccess2" placeholder="Số thứ tự"> <span
						class="fa fa-sort-numeric-asc form-control-feedback left"
						aria-hidden="true"></span>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
					<input name="value.params.tenPhanKho" type="text" class="form-control has-feedback-left"
						id="inputSuccess2" placeholder="Tên kho"> <span
						class="fa fa-adn form-control-feedback left" aria-hidden="true"></span>
				</div>
				<div class="clearfix"></div>
				<div class="ln_solid"></div>
				<div class="row" style="text-align: right;">
					<button type="button" class="btn btn-default">
						<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
							<a href="#/recycle"><i class="fa fa-print"></i> In</a>
						</div>
					</button>
					<!-- data-toggle="modal" data-target="#modal-confirm"  -->
					<button onclick="send('/Category_addPhanKho')" type="button" class="btn btn-success">
						<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
							<a href="#/plus" style="color: white;"><i class="fa fa-plus"></i>
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
							<a data-toggle="modal" data-target="#modal-confirm" href="#/times" style="color: white;"><i
								class="fa fa-remove"></i> Xóa<span class="text-muted"></span></a>
						</div>
					</button>
				</div>
			</div>
		</div>
	</div>
</div>