<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>FORM 6B</h3>
<div class="x_panel">
	<div class="x_title">
		<h2>PHÂN TÍCH XUẤT DẦU MỠ THEO HẠN MỨC CHO ĐƠN VỊ</h2>
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
									rowspan="2" aria-sort="ascending"
									aria-label=": activate to sort column descending"
									style="width: 268px;">DIỄN GIẢI</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="2" aria-label=": activate to sort column ascending"
									style="width: 422px;">LỆNH</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-label=": activate to sort column ascending"
									style="width: 202px;">NỘI DUNG</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-label=": activate to sort column ascending"
									style="width: 202px;">NỘI DUNG</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-label=": activate to sort column ascending"
									style="width: 202px;">NỘI DUNG</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-label=": activate to sort column ascending"
									style="width: 202px;">NỘI DUNG</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-label=": activate to sort column ascending"
									style="width: 202px;">NỘI DUNG</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-label=": activate to sort column ascending"
									style="width: 202px;">NỘI DUNG</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-label=": activate to sort column ascending"
									style="width: 202px;">NỘI DUNG</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-label=": activate to sort column ascending"
									style="width: 202px;">NỘI DUNG</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-label=": activate to sort column ascending"
									style="width: 202px;">NỘI DUNG</th>
							</tr>
							<tr role="row">

								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 422px;">CÓ</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 202px;">NGÀY</th>




							</tr>
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="2" colspan="3" aria-sort="ascending"
									aria-label=": activate to sort column descending"
									style="width: 268px;">Tổng cộng</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 422px;">TM</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 202px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 111px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 195px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 154px;"></th>
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label=": activate to sort column descending"
									style="width: 268px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 422px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 202px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 111px;"></th>
							</tr>
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label=": activate to sort column descending"
									style="width: 268px;">KH</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 422px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 202px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 111px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 195px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 154px;"></th>
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label=": activate to sort column descending"
									style="width: 268px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 422px;"></th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label=": activate to sort column ascending"
									style="width: 202px;"></th>

							</tr>
						</thead>
						<tbody>
							<tr role="row" class="even">
								<td rowspan="2" class="sorting_1">QUÂN KHU I</td>
								<td rowspan="2"></td>
								<td rowspan="2"></td>
								<td>TM</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="even">
								<td>KH</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="even">
								<td rowspan="2" class="sorting_1"></td>
								<td rowspan="2"></td>
								<td rowspan="2"></td>
								<td>TM</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="even">
								<td>KH</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="even">
								<td rowspan="2" class="sorting_1">QUÂN KHU 3</td>
								<td rowspan="2"></td>
								<td rowspan="2"></td>
								<td>TM</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="even">
								<td>KH</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="even">
								<td rowspan="2" class="sorting_1"></td>
								<td rowspan="2"></td>
								<td rowspan="2"></td>
								<td>TM</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="even">
								<td>KH</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="even">
								<td rowspan="2" class="sorting_1">QK THỦ ĐÔ</td>
								<td rowspan="2"></td>
								<td rowspan="2"></td>
								<td>TM</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="even">
								<td>KH</td>
								<td></td>
								<td></td>
								<td></td>
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
		</div>
	</div>
</div>
