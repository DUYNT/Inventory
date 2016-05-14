<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>FORM 11</h3>
<div class="x_panel">
	<div class="x_title">
		<h2>
		BÁO CÁO NHIÊN LIỆU, DẦU MỠ QUY ĐỊNH, DỰ TRỮ SẴN SÀNG CHIẾN ĐẤU KHO HẬU PHƯƠNG THEO QUYẾT ĐỊNH
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
				<div class="col-sm-12">
					<table id="datatable"
						class="table table-striped table-bordered dataTable no-footer"
						role="grid" aria-describedby="datatable_info">
						<thead>
							<tr role="row">

								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2"
									aria-label="Position: activate to sort column ascending"
									style="width: 222px;">TẠI THỜI ĐIỂM</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="5"
									aria-label="Start date: activate to sort column ascending"
									style="width: 395px;">NHIÊN LIỆU</th>

								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 108px;">DẦU MỠ</th>

							</tr>
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 68px;">XĂNG ÔTÔ</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 222px;">XĂNG MÁY BAY</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Start date: activate to sort column ascending"
									style="width: 395px;">N.LIỆU P.LỰC</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 202px;">ĐIÊZEL</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Age: activate to sort column ascending"
									style="width: 311px;">+</th>


							</tr>
						</thead>


						<tbody>




							<tr role="row" class="odd">
								<td>Quy định phải có</td>

								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="odd">
								<td>Hiện có</td>

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