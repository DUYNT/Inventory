<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Gửi báo cáo lên Cục</h3>
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
						<th class="column-title" style="display: table-cell;">Kiểu</th>
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
						<td class=" ">Xuất</td>
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
						<td class=" ">Nhập</td>
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
						<td class=" ">Xuất</td>
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
						<td class=" ">Nhập</td>
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
						<td class=" ">Xuất</td>
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
						<td class=" ">Nhập</td>
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
						<td class=" ">May 26, 2014 10:55:33 PM</td>
						<td class=" ">121000203</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>
						<td class=" ">Xuất</td>
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
						<td class=" ">May 26, 2014 10:52:44 PM</td>
						<td class=" ">121000204</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>
						<td class=" ">Nhập</td>
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
						<td class=" ">May 27, 2014 11:47:56 PM</td>
						<td class=" ">121000210</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class=" ">Xuất</td>
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
						<td class=" ">May 28, 2014 11:30:12 PM</td>
						<td class=" ">121000208</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class=" ">Xuất</td>
						<td class="a-right a-right ">$741.20</td>
						<td class=" last"><div
								class="fa-hover col-md-3 col-sm-4 col-xs-12" style="width: 100%">
								<a href="#/refresh" data-toggle="modal"
									data-target="#modal-chi-tiet-ke-hoach"><i
									class="glyphicon glyphicon-eye-open"></i> Xem</a> | <a
									href="#/refresh"><i class="fa fa-refresh"></i> Đồng bộ</a>
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
					<a data-toggle="modal" data-target="#modal-confirm"  href="#/pencil" style="color: white;"><i
						class="fa fa-cloud-upload"></i> Đồng bộ phiếu xuất, nhập đã chọn</a>
				</div>
			</button>
		</div>
	</div>
</div>


<div class="x_panel">
	<div class="x_title">
		<h2>
			Danh sách quản lý hao hụt <small>chưa được đồng bộ lên Cục</small>
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
								style="width: 422px;">Mã vật tư</th>
							<th class="sorting" tabindex="0" aria-controls="datatable"
								rowspan="1" colspan="1"
								aria-label="Office: activate to sort column ascending"
								style="width: 202px;">Tên vật tư</th>
							<th class="sorting" tabindex="0" aria-controls="datatable"
								rowspan="1" colspan="1"
								aria-label="Age: activate to sort column ascending"
								style="width: 111px;">Đơn vị tính</th>
							<th class="sorting" tabindex="0" aria-controls="datatable"
								rowspan="1" colspan="1"
								aria-label="Start date: activate to sort column ascending"
								style="width: 195px;">Chất lượng</th>
							<th class="sorting" tabindex="0" aria-controls="datatable"
								rowspan="1" colspan="1"
								aria-label="Salary: activate to sort column ascending"
								style="width: 154px;">Đơn giá</th>
							<th class="sorting" tabindex="0" aria-controls="datatable"
								rowspan="1" colspan="1"
								aria-label="Salary: activate to sort column ascending"
								style="width: 154px;">Số lượng hao hụt</th>
						</tr>
					</thead>


					<tbody>


						<tr role="row" class="odd">
							<td class="sorting_1">1</td>
							<td>Accountant</td>
							<td>Tokyo</td>
							<td>33</td>
							<td>2008/11/28</td>
							<td>$162,700</td>
							<td>$162,700</td>
						</tr>
						<tr role="row" class="even">
							<td class="sorting_1">2</td>
							<td>Chief Executive Officer (CEO)</td>
							<td>London</td>
							<td>47</td>
							<td>2009/10/09</td>
							<td>$1,200,000</td>
							<td>$162,700</td>
						</tr>
						<tr role="row" class="odd">
							<td class="sorting_1">3</td>
							<td>Junior Technical Author</td>
							<td>San Francisco</td>
							<td>66</td>
							<td>2009/01/12</td>
							<td>$86,000</td>
							<td>$162,700</td>
						</tr>
						<tr role="row" class="even">
							<td class="sorting_1">4</td>
							<td>Software Engineer</td>
							<td>London</td>
							<td>41</td>
							<td>2012/10/13</td>
							<td>$132,000</td>
							<td>$162,700</td>
						</tr>
						<tr role="row" class="odd">
							<td class="sorting_1">5</td>
							<td>Software Engineer</td>
							<td>San Francisco</td>
							<td>28</td>
							<td>2011/06/07</td>
							<td>$206,850</td>
							<td>$162,700</td>
						</tr>
						<tr role="row" class="even">
							<td class="sorting_1">6</td>
							<td>Integration Specialist</td>
							<td>New York</td>
							<td>61</td>
							<td>2012/12/02</td>
							<td>$372,000</td>
							<td>$162,700</td>
						</tr>

					</tbody>
				</table>
				
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
						<a data-toggle="modal" data-target="#modal-confirm" href="#/pencil" style="color: white;"><i
							class="fa fa-cloud-upload"></i> Đồng bộ quản lý hao hụt</a>
					</div>
				</button>
			</div>
		</div>
		<tiles:insert definition="DETAILKH" />
	</div>

	<div class="x_panel">
		<div class="x_title">
			<h2>
				Danh sách hàng hóa <small> thực tế đang tồn tại</small>
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
										rowspan="1" colspan="1"
										aria-label="Name: activate to sort column ascending"
										style="width: 58px;">STT</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Position: activate to sort column ascending"
										style="width: 422px;">Tên bồn, phi, thùng chứa</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Office: activate to sort column ascending"
										style="width: 202px;">ĐVT</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Salary: activate to sort column ascending"
										style="width: 154px;">Chất lượng</th>
									<th class="sorting_desc" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Age: activate to sort column ascending"
										aria-sort="descending" style="width: 111px;">Số lượng</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Start date: activate to sort column ascending"
										style="width: 195px;">Đơn giá</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Salary: activate to sort column ascending"
										style="width: 154px;">Thành tiền</th>


								</tr>
							</thead>


							<tbody>

								<tr role="row" class="odd">
									<td class="">1</td>
									<td>Marketing Designer</td>
									<td class="">London</td>
									<td class="sorting_1">66</td>
									<td>2012/11/27</td>
									<td>$198,500</td>
									<td>2012/11/27</td>

								</tr>
								<tr role="row" class="even">
									<td class="">2</td>
									<td>System Architect</td>
									<td class="">Edinburgh</td>
									<td class="sorting_1">61</td>
									<td>2011/04/25</td>
									<td>$320,800</td>
									<td>2012/11/27</td>

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
			<div class="clearfix"></div>
			<div class="ln_solid"></div>
			<div class="row" style="text-align: center;">
				<button type="button" class="btn btn-success btn-lg">
					<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
						<a data-toggle="modal" data-target="#modal-confirm" href="#/pencil" style="color: white;"><i
							class="fa fa-cloud-upload"></i> Đồng bộ hàng hóa</a>
					</div>
				</button>
			</div>
		</div>
		
		
	<div class="x_panel">
		<div class="x_title">
			<h2>
				Yêu cấu thanh xử lý <small> các mặt hàng từ các kế hoạch tồn đọng đã lâu</small>
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
										rowspan="1" colspan="1"
										aria-label="Name: activate to sort column ascending"
										style="width: 58px;">STT</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Position: activate to sort column ascending"
										style="width: 422px;">Mã hàng hóa</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Office: activate to sort column ascending"
										style="width: 202px;">ĐVT</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Salary: activate to sort column ascending"
										style="width: 154px;">Kế hoạch xuất</th>
									<th class="sorting_desc" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Age: activate to sort column ascending"
										aria-sort="descending" style="width: 111px;">Số lượng</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Start date: activate to sort column ascending"
										style="width: 195px;">Đơn giá</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Start date: activate to sort column ascending"
										style="width: 195px;">Nhập từ</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Salary: activate to sort column ascending"
										style="width: 154px;">Thành tiền</th>
								</tr>
							</thead>


							<tbody>

								<tr role="row" class="odd">
									<td class="">1</td>
									<td>x0.012.0232</td>
									<td class="">Cái</td>
									<td class="sorting_1">Năm 2005</td>
									<td>1254</td>
									<td>198,500đ</td>
									<td>2012/11/27</td>
									<td>100,000,100đ</td>

								</tr>
								<tr role="row" class="even">
									<td class="">2</td>
									<td>x0.012.0232</td>
									<td class="">cái</td>
									<td class="sorting_1">Năm 2005</td>
									<td>1022</td>
									<td>198,500đ</td>
									<td>2012/11/27</td>
									<td>100,000,100đ</td>

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
			<div class="clearfix"></div>
			<div class="ln_solid"></div>
			<div class="row" style="text-align: center;">
				<button type="button" class="btn btn-success btn-lg">
					<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
						<a data-toggle="modal" data-target="#modal-confirm" href="#/pencil" style="color: white;"><i
							class="fa fa-cloud-upload"></i> Đồng bộ hàng hóa</a>
					</div>
				</button>
			</div>
		</div>
	</div>