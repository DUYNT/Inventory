<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Lịch sử đồng bộ lên Cục</h3>

<div class="x_panel">
	<div class="x_title">
		<h2>Lịch sử hoạt động</h2>
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
		<div class="dataTables_wrapper form-inline dt-bootstrap no-footer">
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
			<div class="input-group" style="float: right; margin-right: 12px">
				<input type="text" class="form-control" placeholder="Tìm kiếm"><span
					class="input-group-btn">
					<button type="button" class="btn btn-primary">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</div>
		<div class="row">
			<table class="table table-striped jambo_table bulk_action">
				<thead>
					<tr class="headings">
						<th class="column-title" style="display: table-cell;">Ngày
							kết nối</th>
						<th class="column-title" style="display: table-cell;">Mục
							đích kết nối</th>
						<th class="column-title" style="display: table-cell;">Nhân
							viên kết nối</th>
						<th class="column-title" style="display: table-cell;">Chức vụ</th>
						<th class="column-title" style="display: table-cell;">Số điện
							thoại</th>
						<th class="column-title" style="display: table-cell;"></th>
					</tr>
				</thead>

				<tbody>
					<tr class="even pointer">
						<td class=" ">May 23, 2014 11:47:56 PM</td>
						<td class=" ">Nộp phiếu xuất</td>
						<td class=" ">Nguyễn Ah tuán <i
							class="success fa fa-long-arrow-up"></i></td>
						<td class=" ">Nhân viên thống kê</td>
						<td class=" ">0915966288</td>
					</tr>
					<tr class="odd pointer">
						<td class=" ">May 23, 2014 11:47:56 PM</td>
						<td class=" ">Nộp phiếu xuất</td>
						<td class=" ">Nguyễn Ah tuán <i
							class="success fa fa-long-arrow-up"></i></td>
						<td class=" ">Nhân viên thống kê</td>
						<td class=" ">0915966288</td>
					</tr>
					<tr class="even pointer">
						<td class=" ">May 24, 2014 10:55:33 PM</td>
						<td class=" ">121000038</td>
						<td class=" ">121000203 <i
							class="success fa fa-long-arrow-up"></i>
						</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>

					</tr>
					<tr class="odd pointer">
						<td class=" ">May 23, 2014 11:47:56 PM</td>
						<td class=" ">Nộp phiếu xuất</td>
						<td class=" ">Nguyễn Ah tuán <i
							class="success fa fa-long-arrow-up"></i></td>
						<td class=" ">Nhân viên thống kê</td>
						<td class=" ">0915966288</td>
					</tr>
					<tr class="even pointer">
						<td class=" ">May 24, 2014 11:47:56 PM</td>
						<td class=" ">121000040</td>
						<td class=" ">121000210</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>

					</tr>
					<tr class="odd pointer">
						<td class=" ">May 23, 2014 11:47:56 PM</td>
						<td class=" ">Nộp phiếu xuất</td>
						<td class=" ">Nguyễn Ah tuán <i
							class="success fa fa-long-arrow-up"></i></td>
						<td class=" ">Nhân viên thống kê</td>
						<td class=" ">0915966288</td>

					</tr>
					<tr class="even pointer">
						<td class=" ">May 26, 2014 10:55:33 PM</td>
						<td class=" ">121000038</td>
						<td class=" ">121000203</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>

					</tr>
					<tr class="odd pointer">
						<td class=" ">May 23, 2014 11:47:56 PM</td>
						<td class=" ">Nộp phiếu xuất</td>
						<td class=" ">Nguyễn Ah tuán <i
							class="success fa fa-long-arrow-up"></i></td>
						<td class=" ">Nhân viên thống kê</td>
						<td class=" ">0915966288</td>
					</tr>

					<tr class="even pointer">
						<td class=" ">May 27, 2014 11:47:56 PM</td>
						<td class=" ">121000040</td>
						<td class=" ">121000210</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>

					</tr>
					<tr class="odd pointer">
						<td class=" ">May 23, 2014 11:47:56 PM</td>
						<td class=" ">Nộp phiếu xuất</td>
						<td class=" ">Nguyễn Ah tuán <i
							class="success fa fa-long-arrow-up"></i></td>
						<td class=" ">Nhân viên thống kê</td>
						<td class=" ">0915966288</td>
					</tr>
				</tbody>
			</table>
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
		<div class="clearfix"></div>
		<div class="ln_solid"></div>
		<div class="row" style="text-align: center;">
			<button type="button" class="btn btn-success btn-lg">
				<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
					<a data-toggle="modal" data-target="#modal-confirm" href="#/pencil"
						style="color: white;"><i class="fa fa-cloud-download"></i>
						Đồng bộ KH đã chọn về đơn vị</a>
				</div>
			</button>
		</div>
	</div>
</div>
