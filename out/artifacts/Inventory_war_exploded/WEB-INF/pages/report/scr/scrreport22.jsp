<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>FORM 14</h3>
<div class="x_panel">
	<div class="x_title">
		<h2>
		SỔ PHÂN HỘ
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
								<th class="sorting_desc" tabindex="0" aria-controls="datatable"
									rowspan="2"
									aria-label="Name: activate to sort column ascending"
									style="width: 68px;" aria-sort="descending">STT</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2"
									aria-label="Position: activate to sort column ascending"
									style="width: 422px;">NGÀY</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2"
									aria-label="Office: activate to sort column ascending"
									style="width: 202px;">DIỄN GIẢI</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2" aria-label="Age: activate to sort column ascending"
									style="width: 111px;">ĐVT</th>
								<th class="sorting_desc" tabindex="0" aria-controls="datatable"
									rowspan="2"
									aria-label="Name: activate to sort column ascending"
									style="width: 268px;" aria-sort="descending">NGƯỜI NHẬN LỆNH</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2"
									aria-label="Position: activate to sort column ascending"
									style="width: 422px;">KẾ HOẠCH</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="2"
									aria-label="Office: activate to sort column ascending"
									style="width: 202px;">THỰC HIỆN</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="2" aria-label="Age: activate to sort column ascending"
									style="width: 511px;">CO GÁNH</th>

							</tr>



							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 268px;">XĂNG ÔTÔ</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									rowspan="1" colspan="1"
									aria-label="Position: activate to sort column ascending"
									style="width: 222px;">CÒN</th>



							</tr>
						</thead>


						<tbody>
							<tr role="row" class="even">
								<td class="sorting_1"></td>
								<td></td>
								<td>PC</td>
								<td>Kg</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr role="row" class="even">
								<td class="sorting_1"></td>
								<td></td>
								<td>140</td>
								<td>Kg</td>
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
<div class="col-md-12 col-sm-12 col-xs-12">
	<div class="x_panel">
		<div class="x_title">
			<h2>
				Default Example <small>Users</small>
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

									<th class="sorting_desc" tabindex="0" aria-controls="datatable"
										rowspan="2"
										aria-label="Name: activate to sort column ascending"
										style="width: 268px;" aria-sort="descending">STT</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="2"
										aria-label="Position: activate to sort column ascending"
										style="width: 422px;">DIỄN GIẢI</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="2"
										aria-label="Office: activate to sort column ascending"
										style="width: 202px;">THỜI GIAN BÁO CÁO</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										colspan="2"
										aria-label="Age: activate to sort column ascending"
										style="width: 311px;">LŨY TIẾN</th>

								</tr>



								<tr role="row">
									<th class="sorting_asc" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" aria-sort="ascending"
										aria-label="Name: activate to sort column descending"
										style="width: 168px;">XĂNG ÔTÔ</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Position: activate to sort column ascending"
										style="width: 102px;">XĂNG MÁY BAY</th>



								</tr>
							</thead>


							<tbody>
								<tr role="row" class="even">
									<td class="sorting_1">Xăng ô tô</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>

								</tr>
								<tr role="row" class="even">
									<td class="sorting_1">Xăng máy bay</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>

								</tr>
								<tr role="row" class="even">
									<td class="sorting_1">Xăng máy bay</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>

								</tr>
								<tr role="row" class="even">
									<td class="sorting_1">Dầu mỡ</td>
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