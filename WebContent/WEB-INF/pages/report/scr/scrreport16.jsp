<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>FORM 8</h3>
<div class="x_panel">
	<div class="x_title">
		<h2>QUẢN LÝ HAO HỤT</h2>
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
									rowspan="3" aria-sort="ascending"
									aria-label=": activate to sort column descending"
									style="width: 368px;">NỘI DUNG HAO HỤT</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="15" aria-label=": activate to sort column ascending"
									style="width: 422px;">SỐ LƯỢNG VÀ CHỦNG LOẠI XĂNG DẦU</th>

							</tr>
							<tr role="row">

								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="5" aria-label=": activate to sort column ascending"
									style="width: 422px;">XĂNG DẦU CHÍNH PHẨM</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="5" aria-label=": activate to sort column ascending"
									style="width: 202px;">XĂNG DẦU HẠ CẤP ĐỂ XỬ LÝ</th>

								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="5" aria-label=": activate to sort column ascending"
									style="width: 195px;">XĂNG DẦU HẠ CẤP</th>

							</tr>
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									colspan="1" aria-sort="ascending"
									aria-label=": activate to sort column descending"
									style="width: 268px;">XĂNG ÔTÔ</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 222px;">XĂNG</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 202px;">CÒN</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 111px;">WLPL</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 195px;">VN</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 200px;">XĂNG ÔTÔ</th>
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									colspan="1" aria-sort="ascending"
									aria-label=": activate to sort column descending"
									style="width: 268px;">XĂNG</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 222px;">CÒN</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 202px;">WLPL</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 111px;">VN</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 200px;">XĂNG ÔTÔ</th>
								<th class="sorting_asc" tabindex="0" aria-controls="datatable"
									colspan="1" aria-sort="ascending"
									aria-label=": activate to sort column descending"
									style="width: 268px;">XĂNG</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 222px;">CÒN</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 202px;">WLPL</th>
								<th class="sorting" tabindex="0" aria-controls="datatable"
									colspan="1" aria-label=": activate to sort column ascending"
									style="width: 211px;">VN</th>
							</tr>

						</thead>
						<tbody>
							<tr role="row" class="even">

								<td>Bảo quản</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>1. BQ dài hạn</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>Tu dưỡng ngoài trời</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>Số lượng</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>Tỷ lệ hao hụt</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>SL HH định mức</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>SL HH thực tế</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>So sánh</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>Tu dưỡng LH</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>Số lượng</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>TL hao hụt</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>SL HH định mức</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>SL HH thực tế </td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>Tỷ lệ Hao hụt</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>So sánh</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>BD ngoài trời</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>Số lượng</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>Tỷ lệ HH</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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

								<td>SL HH định mức</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
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