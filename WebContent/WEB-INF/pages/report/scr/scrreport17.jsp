<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>FORM 9</h3>
<div class="x_panel">
	<div class="x_title">
		<h2>BÁO CÁO PHÂN TÍCH TỒN KHO</h2>
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
									style="width: 68px;">STT</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 222px;">MÃ VẬT TƯ</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Start date: activate to sort column ascending"
									style="width: 395px;">TÊN VẬT TƯ</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 202px;">ĐƠN VỊ TÍNH</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Age: activate to sort column ascending"
									style="width: 311px;">SỐ LƯỢNG</th>

								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">ĐƠN GIÁ</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 154px;">THÀNH TIỀN</th>
							</tr>
						</thead>


						<tbody>

							<tr role="row" class="odd">
								<td colspan="7">Kho</td>

							</tr>
							<tr role="row" class="odd">
								<td colspan="7">Hàng chính phẩm</td>

							</tr>
							<tr role="row" class="odd">
								<td colspan="7">Nhiên liệu</td>

							</tr>
							<tr role="row" class="odd">
								<td colspan="7">Xăng ôtô</td>

							</tr>
							<tr role="row" class="odd">
								<td></td>
								<td>MOGAS 97</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>

							</tr>
							<tr role="row" class="odd">
								<td></td>
								<td>MOGAS 92</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>

							</tr>
							<tr role="row" class="odd">
								<td></td>
								<td>Dầu D0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>

							</tr>
							<tr role="row" class="odd">
								<td></td>
								<td>Xăng máy bay</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>

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