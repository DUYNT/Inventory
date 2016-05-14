<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Đồng bộ kế hoạch từ CỤC</h3>

<div class="x_panel">
	<div class="x_title">
		<h2>
			Danh sách kế hoạch <small>chưa được đồng bộ lên Cục</small>
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

		<p>
			Dữ phím
			<code>Ctrl</code>
			để chọn từng dòng, và dữ
			<code> Shift</code>
			để chọn nhiều dòng cùng 1 lúc
		</p>

		<div class="table-responsive">
			<table class="table table-striped jambo_table bulk_action">
				<thead>
					<tr class="headings">
						<th class="column-title" style="display: table-cell;">Sô
							phiếu</th>
						<th class="column-title" style="display: table-cell;">Ngày
							tạo phiếu</th>
						<th class="column-title" style="display: table-cell;">Theo
							lệnh</th>
						<th class="column-title" style="display: table-cell;">DV Vận
							chuyển</th>
						<th class="column-title" style="display: table-cell;">Giấy
							giới thiệu</th>
						<th class="column-title" style="display: table-cell;">Tính
							chất</th>
						<th class="column-title" style="display: table-cell;">Đơn vị</th>
						<th class="column-title no-link last" style="display: table-cell;"><span
							class="nobr">Đồng bộ</span></th>
					</tr>
				</thead>

				<tbody>
					<tr class="even pointer">
						<td class=" ">121000040</td>
						<td class=" ">May 23, 2014 11:47:56 PM</td>
						<td class=" ">121000210 <i
							class="success fa fa-long-arrow-up"></i></td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$7.45</td>
						<td class=" last"><div
								class="fa-hover col-md-3 col-sm-4 col-xs-12" style="width: 100%">
								<a href="#/refresh" data-toggle="modal"
									data-target="#modal-chi-tiet-ke-hoach"><i
									class="glyphicon glyphicon-eye-open"></i> Xem</a> | <a
									href="#/refresh"><i class="fa fa-refresh"></i> Đồng bộ</a>
							</div></td>
					</tr>
					<tr class="odd pointer">
						<td class=" ">121000039</td>
						<td class=" ">May 23, 2014 11:30:12 PM</td>
						<td class=" ">121000208 <i
							class="success fa fa-long-arrow-up"></i>
						</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$741.20</td>
						<td class=" last"><div
								class="fa-hover col-md-3 col-sm-4 col-xs-12" style="width: 100%">
								<a href="#/refresh" data-toggle="modal"
									data-target="#modal-chi-tiet-ke-hoach"><i
									class="glyphicon glyphicon-eye-open"></i> Xem</a> | <a
									href="#/refresh"><i class="fa fa-refresh"></i> Đồng bộ</a>
							</div></td>
					</tr>
					<tr class="even pointer">
						<td class=" ">121000038</td>
						<td class=" ">May 24, 2014 10:55:33 PM</td>
						<td class=" ">121000203 <i
							class="success fa fa-long-arrow-up"></i>
						</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$432.26</td>
						<td class=" last"><div
								class="fa-hover col-md-3 col-sm-4 col-xs-12" style="width: 100%">
								<a href="#/refresh" data-toggle="modal"
									data-target="#modal-chi-tiet-ke-hoach"><i
									class="glyphicon glyphicon-eye-open"></i> Xem</a> | <a
									href="#/refresh"><i class="fa fa-refresh"></i> Đồng bộ</a>
							</div></td>
					</tr>
					<tr class="odd pointer">
						<td class=" ">121000037</td>
						<td class=" ">May 24, 2014 10:52:44 PM</td>
						<td class=" ">121000204</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$333.21</td>
						<td class=" last"><div
								class="fa-hover col-md-3 col-sm-4 col-xs-12" style="width: 100%">
								<a href="#/refresh" data-toggle="modal"
									data-target="#modal-chi-tiet-ke-hoach"><i
									class="glyphicon glyphicon-eye-open"></i> Xem</a> | <a
									href="#/refresh"><i class="fa fa-refresh"></i> Đồng bộ</a>
							</div></td>
					</tr>
					<tr class="even pointer">
						<td class=" ">121000040</td>
						<td class=" ">May 24, 2014 11:47:56 PM</td>
						<td class=" ">121000210</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$7.45</td>
						<td class=" last"><div
								class="fa-hover col-md-3 col-sm-4 col-xs-12" style="width: 100%">
								<a href="#/refresh" data-toggle="modal"
									data-target="#modal-chi-tiet-ke-hoach"><i
									class="glyphicon glyphicon-eye-open"></i> Xem</a> | <a
									href="#/refresh"><i class="fa fa-refresh"></i> Đồng bộ</a>
							</div></td>
					</tr>
					<tr class="odd pointer">
						<td class=" ">121000039</td>
						<td class=" ">May 26, 2014 11:30:12 PM</td>
						<td class=" ">121000208 <i
							class="error fa fa-long-arrow-down"></i>
						</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$741.20</td>
						<td class=" last"><div
								class="fa-hover col-md-3 col-sm-4 col-xs-12" style="width: 100%">

							</div></td>
					</tr>
					<tr class="even pointer">
						<td class=" ">121000038</td>
						<td class=" ">May 26, 2014 10:55:33 PM</td>
						<td class=" ">121000203</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$432.26</td>
						<td class=" last"><div
								class="fa-hover col-md-3 col-sm-4 col-xs-12" style="width: 100%">

							</div></td>
					</tr>
					<tr class="odd pointer">
						<td class=" ">121000037</td>
						<td class=" ">May 26, 2014 10:52:44 PM</td>
						<td class=" ">121000204</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$333.21</td>
						<td class=" last"><div
								class="fa-hover col-md-3 col-sm-4 col-xs-12" style="width: 100%">

							</div></td>
					</tr>

					<tr class="even pointer">
						<td class=" ">121000040</td>
						<td class=" ">May 27, 2014 11:47:56 PM</td>
						<td class=" ">121000210</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$7.45</td>
						<td class=" last"><div
								class="fa-hover col-md-3 col-sm-4 col-xs-12" style="width: 100%">

							</div></td>
					</tr>
					<tr class="odd pointer">
						<td class=" ">121000039</td>
						<td class=" ">May 28, 2014 11:30:12 PM</td>
						<td class=" ">121000208</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$741.20</td>
						<td class=" last"><div
								class="fa-hover col-md-3 col-sm-4 col-xs-12" style="width: 100%">

							</div></td>
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
<div class="x_panel">
	<div class="x_title">
		<h2>Thiết lập tự động đồng bộ</h2>
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
		<p>Nếu chọn tự động đồng bộ thì hệ thống sẽ tự động trong 1 khoảng
			thời gian nhất định tải dữ liệu kế hoạch xuất nhập từ các CỤC về đơn
			vị</p>
		<div class="radio">
			<label class="">
				<div onclick="objStation.checkAutoSymStation()"
					id="checkAutoSymStation" class="iradio_flat-green"
					style="position: relative;">
					<input type="radio" class="flat" checked="" name="iCheck"
						style="position: absolute; opacity: 0;">
					<ins class="iCheck-helper"
						style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
				</div> Tự động đồng bộ
			</label>
		</div>
		<div class="radio">
			<label class="">
				<div onclick="objStation.checkAutoSymStation()"
					class="iradio_flat-green" style="position: relative;">
					<input type="radio" class="flat" checked="" name="iCheck"
						style="position: absolute; opacity: 0;">
					<ins class="iCheck-helper"
						style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
				</div> Đông bộ bằng tay
			</label>
		</div>
		<div class="row" id="settingFormAutoSymStation" style="display: none">
			Heelelel</div>
	</div>
</div>
