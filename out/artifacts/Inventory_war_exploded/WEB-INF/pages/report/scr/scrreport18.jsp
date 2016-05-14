<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>FORM 10</h3>
<div class="x_panel">
	<div class="x_title">
		<h2>PHÂN TÍCH XUẤT HÀNG THANH LÝ, HÀNG CHUYỂN MỤC ĐÍCH SỬ DỤNG</h2>
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
									aria-label="Name: activate to sort column descending"
									style="width: 68px;">STT</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2"
									aria-label="Position: activate to sort column ascending"
									style="width: 222px;">NỘI DUNG XUẤT</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="5"
									aria-label="Start date: activate to sort column ascending"
									style="width: 395px;">NHIÊN LIỆU</th>

								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 108px;">DẦU MỠ</th>
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 448px;">GHI CHÚ</th>
							</tr>
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 168px;">Xăng Ôtô</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 162px;">Xăng máy bay</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Start date: activate to sort column ascending"
									style="width: 165px;">NL phản lực</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Office: activate to sort column ascending"
									style="width: 102px;">Dầu</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Age: activate to sort column ascending"
									style="width: 111px;">+</th>


							</tr>
						</thead>


						<tbody>
s
							<tr role="row" class="odd">
								<td colspan="2">Dầu nhờn</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="odd">
								<td>1</td>
								<td>Mỡ MO</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="odd">
								<td>2</td>
								<td>GA</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
								<tr role="row" class="odd">
								<td>3</td>
								<td>Dầu D0</td>
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