<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Tạo số lượng hao hụt</h3>
<div class="x_panel">
	<div class="x_title">
		<h2>Nhập dữ liệu tìm kiếm</h2>
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
		<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">

			<div class="form-group">
				<label class="control-label col-md-2 col-sm-2 col-xs-12"
					for="first-name" style="padding-top: 5px">Kho hàng</label>
				<div class="control-label col-md-10 col-sm-10 col-xs-12">
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
		<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">

			<div class="form-group">
				<label class="control-label col-md-2 col-sm-2 col-xs-12"
					for="first-name" style="padding-top: 5px">Nguồn</label>
				<div class="control-label col-md-10 col-sm-10 col-xs-12">
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
		<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
			<label class="control-lable col-md-2 col-sm-2 col-xs-12"
				for="first-name" style="padding-top: 5px">Từ ngày</label>
			<div class="control-label col-md-10 col-sm-10 col-xs-12">
				<input type="text" class="form-control has-feedback-left"
					id="inputSuccess2"> <span
					class="fa fa-calendar form-control-feedback left"
					aria-hidden="true"></span>
			</div>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
			<label class="control-lable col-md-2 col-sm-2 col-xs-12"
				for="first-name" style="padding-top: 5px">Đến ngày</label>
			<div class="control-label col-md-10 col-sm-10 col-xs-12">
				<input type="text" class="form-control has-feedback-left"
					id="inputSuccess2"> <span
					class="fa fa-calendar form-control-feedback left"
					aria-hidden="true"></span>
			</div>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
			<div class="form-group">
				<label class="control-label col-md-2 col-sm-2 col-xs-12"
					for="first-name" style="padding-top: 5px">Nhóm VT </label>
				<div class="control-label col-md-10 col-sm-10 col-xs-12">
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
		<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
			<label class="control-lable col-md-2 col-sm-2 col-xs-12"
				for="first-name" style="padding-top: 5px">Tên VT</label>
			<div class="control-label col-md-10 col-sm-10 col-xs-12">
				<input type="text" class="form-control has-feedback-left"
					id="inputSuccess2"> <span
					class="fa fa-adn form-control-feedback left" aria-hidden="true"></span>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="ln_solid"></div>
	<div class="row">
		<button id="send" type="button" class="btn btn-success"
			style="margin-left: 50%">
			<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
				<a href="#/search" style="color: white;"><i class="fa fa-search"></i>
					Tìm kiếm</a>
			</div>
		</button>
	</div>
</div>
<div class="x_panel">
	<div class="x_title">
		<h2>Danh sách</h2>
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
									style="width: 68px;">Mã vật tư</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 622px;">Tên vật tư</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 202px;">ĐVT</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Age: activate to sort column ascending"
									style="width: 111px;">CL</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Start date: activate to sort column ascending"
									style="width: 195px;">Đơn giá</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">SLTT</th>
							</tr>
						</thead>


						<tbody>

							<tr role="row" class="odd">
								<td class="sorting_1">X00.00.00.33.00.21.001</td>
								<td>Nhiên liệu diêdel</td>
								<td>Lít</td>
								<td>Loại 1</td>
								<td>16,022đ</td>
								<td>25,000</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">X00.00.00.33.00.21.001</td>
								<td>Nhiên liệu diêdel</td>
								<td>Lít</td>
								<td>Loại 1</td>
								<td>16,022đ</td>
								<td>25,000</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">X00.00.00.33.00.21.001</td>
								<td>Nhiên liệu diêdel</td>
								<td>Lít</td>
								<td>Loại 1</td>
								<td>16,022đ</td>
								<td>25,000</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">X00.00.00.33.00.21.001</td>
								<td>Nhiên liệu diêdel</td>
								<td>Lít</td>
								<td>Loại 1</td>
								<td>16,022đ</td>
								<td>25,000</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">X00.00.00.33.00.21.001</td>
								<td>Nhiên liệu diêdel</td>
								<td>Lít</td>
								<td>Loại 1</td>
								<td>16,022đ</td>
								<td>25,000</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">X00.00.00.33.00.21.001</td>
								<td>Nhiên liệu diêdel</td>
								<td>Lít</td>
								<td>Loại 1</td>
								<td>16,022đ</td>
								<td>25,000</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">X00.00.00.33.00.21.001</td>
								<td>Nhiên liệu diêdel</td>
								<td>Lít</td>
								<td>Loại 1</td>
								<td>16,022đ</td>
								<td>25,000</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">X00.00.00.33.00.21.001</td>
								<td>Nhiên liệu diêdel</td>
								<td>Lít</td>
								<td>Loại 1</td>
								<td>16,022đ</td>
								<td>25,000</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">X00.00.00.33.00.21.001</td>
								<td>Nhiên liệu diêdel</td>
								<td>Lít</td>
								<td>Loại 1</td>
								<td>16,022đ</td>
								<td>25,000</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="ln_solid"></div>
			<div class="row" style="text-align: right;">
				<button type="button" class="btn btn-success">
					<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
						<a data-toggle="modal" data-target="#modal-confirm" href="#/plus"
							style="color: white;"><i class="fa fa-plus"></i> Thêm</a>
					</div>
				</button>
				<button type="button" class="btn btn-warning">
					<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
						<a data-toggle="modal" data-target="#modal-confirm"
							href="#/pencil" style="color: white;"><i class="fa fa-pencil"></i>
							Sửa</a>
					</div>
				</button>
				<button type="button" class="btn btn-danger">
					<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
						<a data-toggle="modal" data-target="#modal-confirm" href="#/times"
							style="color: white;"><i class="fa fa-remove"></i> Xóa<span
							class="text-muted"></span></a>
					</div>
				</button>
			</div>
		</div>