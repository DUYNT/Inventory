<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Cân đối xuất nhập tồn</h3>

<div class="x_panel">
	<div class="x_title">
		<h2>
			Xem tình trạng <small>hiện tại của các vật tư khi chưa cân
				bằng</small>
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
			<table class="table table-striped jambo_table bulk_action">
				<thead>
					<tr class="headings">
						<th>
							<div class="icheckbox_flat-green" style="position: relative;">
								<input type="checkbox" id="check-all" class="flat"
									style="position: absolute; opacity: 0;">
								<ins class="iCheck-helper"
									style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
							</div>
						</th>
						<th class="column-title">Mã vật tư</th>
						<th class="column-title">Tên vật tư</th>
						<th class="column-title">ĐVT</th>
						<th class="column-title">SL chưa cân bằng</th>
						<th class="column-title">SL đã xuất</th>
						<th class="column-title">Đơn giá</th>
						<th class="bulk-actions" colspan="7"><a class="antoo"
							style="color: #fff; font-weight: 500;">Bulk Actions ( <span
								class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
						</th>
					</tr>
				</thead>

				<tbody>
					<tr class="even pointer">
						<td class="a-center ">
							<div class="icheckbox_flat-green" style="position: relative;">
								<input type="checkbox" class="flat" name="table_records"
									style="position: absolute; opacity: 0;">
								<ins class="iCheck-helper"
									style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
							</div>
						</td>
						<td class=" ">121000040</td>
						<td class=" ">May 23, 2014 11:47:56 PM</td>
						<td class=" ">121000210 <i
							class="success fa fa-long-arrow-up"></i></td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$7.45</td>
					</tr>
					<tr class="odd pointer">
						<td class="a-center ">
							<div class="icheckbox_flat-green" style="position: relative;">
								<input type="checkbox" class="flat" name="table_records"
									style="position: absolute; opacity: 0;">
								<ins class="iCheck-helper"
									style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
							</div>
						</td>
						<td class=" ">121000039</td>
						<td class=" ">May 23, 2014 11:30:12 PM</td>
						<td class=" ">121000208 <i
							class="success fa fa-long-arrow-up"></i>
						</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$741.20</td>
					</tr>
					<tr class="even pointer">
						<td class="a-center ">
							<div class="icheckbox_flat-green" style="position: relative;">
								<input type="checkbox" class="flat" name="table_records"
									style="position: absolute; opacity: 0;">
								<ins class="iCheck-helper"
									style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
							</div>
						</td>
						<td class=" ">121000038</td>
						<td class=" ">May 24, 2014 10:55:33 PM</td>
						<td class=" ">121000203 <i
							class="success fa fa-long-arrow-up"></i>
						</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$432.26</td>
					</tr>
					<tr class="odd pointer">
						<td class="a-center ">
							<div class="icheckbox_flat-green" style="position: relative;">
								<input type="checkbox" class="flat" name="table_records"
									style="position: absolute; opacity: 0;">
								<ins class="iCheck-helper"
									style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
							</div>
						</td>
						<td class=" ">121000037</td>
						<td class=" ">May 24, 2014 10:52:44 PM</td>
						<td class=" ">121000204</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$333.21</td>
					</tr>
					<tr class="even pointer">
						<td class="a-center ">
							<div class="icheckbox_flat-green" style="position: relative;">
								<input type="checkbox" class="flat" name="table_records"
									style="position: absolute; opacity: 0;">
								<ins class="iCheck-helper"
									style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
							</div>
						</td>
						<td class=" ">121000040</td>
						<td class=" ">May 24, 2014 11:47:56 PM</td>
						<td class=" ">121000210</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$7.45</td>
					</tr>
					<tr class="odd pointer">
						<td class="a-center ">
							<div class="icheckbox_flat-green" style="position: relative;">
								<input type="checkbox" class="flat" name="table_records"
									style="position: absolute; opacity: 0;">
								<ins class="iCheck-helper"
									style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
							</div>
						</td>
						<td class=" ">121000039</td>
						<td class=" ">May 26, 2014 11:30:12 PM</td>
						<td class=" ">121000208 <i
							class="error fa fa-long-arrow-down"></i>
						</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$741.20</td>
					</tr>
					<tr class="even pointer">
						<td class="a-center ">
							<div class="icheckbox_flat-green" style="position: relative;">
								<input type="checkbox" class="flat" name="table_records"
									style="position: absolute; opacity: 0;">
								<ins class="iCheck-helper"
									style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
							</div>
						</td>
						<td class=" ">121000038</td>
						<td class=" ">May 26, 2014 10:55:33 PM</td>
						<td class=" ">121000203</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$432.26</td>
					</tr>
					<tr class="odd pointer">
						<td class="a-center ">
							<div class="icheckbox_flat-green" style="position: relative;">
								<input type="checkbox" class="flat" name="table_records"
									style="position: absolute; opacity: 0;">
								<ins class="iCheck-helper"
									style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
							</div>
						</td>
						<td class=" ">121000037</td>
						<td class=" ">May 26, 2014 10:52:44 PM</td>
						<td class=" ">121000204</td>
						<td class=" ">Mike Smith</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$333.21</td>
					</tr>

					<tr class="even pointer">
						<td class="a-center ">
							<div class="icheckbox_flat-green" style="position: relative;">
								<input type="checkbox" class="flat" name="table_records"
									style="position: absolute; opacity: 0;">
								<ins class="iCheck-helper"
									style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
							</div>
						</td>
						<td class=" ">121000040</td>
						<td class=" ">May 27, 2014 11:47:56 PM</td>
						<td class=" ">121000210</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$7.45</td>
					</tr>
					<tr class="odd pointer">
						<td class="a-center ">
							<div class="icheckbox_flat-green" style="position: relative;">
								<input type="checkbox" class="flat" name="table_records"
									style="position: absolute; opacity: 0;">
								<ins class="iCheck-helper"
									style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
							</div>
						</td>
						<td class=" ">121000039</td>
						<td class=" ">May 28, 2014 11:30:12 PM</td>
						<td class=" ">121000208</td>
						<td class=" ">John Blank L</td>
						<td class=" ">Paid</td>
						<td class="a-right a-right ">$741.20</td>
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
		<div class="ln_solid"></div>
		<div class="form-group" style="text-align: center;">
			<button id="send" type="button" class="btn btn-success">
				<a data-toggle="modal" data-target="#modal-confirm" href="#/search" style="color: white;"><i
					class="fa fa-check-circle"></i> Cân đối xuất nhập tồn</a>
			</button>
		</div>
	</div>
</div>
<div class="x_panel">
	<div class="x_title">
		<h2>
			Danh sách báo cáo <small> khi vật tư đã được thực hiện cân
				băng kho</small>
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
			<table id="datatable"
				class="table table-striped table-bordered dataTable no-footer"
				role="grid" aria-describedby="datatable_info">
				<thead>
					<tr role="row">
				.		<th class="sorting_asc" tabindex="0" aria-controls="datatable"
							rowspan="1" colspan="1" aria-sort="ascending"
							aria-label="Name: activate to sort column descending"
							style="width: 160px;">STT</th>
						<th class="sorting" tabindex="0" aria-controls="datatable"
							rowspan="1" colspan="1"
							aria-label="Position: activate to sort column ascending"
							style="width: 261px;">Mã vật tư</th>
						<th class="sorting" tabindex="0" aria-controls="datatable"
							rowspan="1" colspan="1"
							aria-label="Office: activate to sort column ascending"
							style="width: 118px;">Tên vật tư</th>
						<th class="sorting" tabindex="0" aria-controls="datatable"
							rowspan="1" colspan="1"
							aria-label="Age: activate to sort column ascending"
							style="width: 59px;">ĐVT</th>
						<th class="sorting" tabindex="0" aria-controls="datatable"
							rowspan="1" colspan="1"
							aria-label="Start date: activate to sort column ascending"
							style="width: 113px;">SL Đầu</th>
						<th class="sorting" tabindex="0" aria-controls="datatable"
							rowspan="1" colspan="1"
							aria-label="Salary: activate to sort column ascending"
							style="width: 87px;">SL Nhập</th>
						<th class="sorting" tabindex="0" aria-controls="datatable"
							rowspan="1" colspan="1"
							aria-label="Start date: activate to sort column ascending"
							style="width: 113px;">SL xuất</th>
						<th class="sorting" tabindex="0" aria-controls="datatable"
							rowspan="1" colspan="1"
							aria-label="Salary: activate to sort column ascending"
							style="width: 87px;">SL Tồn</th>
					</tr>
				</thead>
				<tbody>
					<tr role="row" class="odd">
						<td class="sorting_1" colspan="8">Kho BỒN SỐ 1</td>
					</tr>
					<tr role="row" class="even">
						<td class="sorting_1" colspan="8">NHÓM VẬT TƯ XĂNG Ô TÔ</td>
					</tr>
					<tr role="row" class="odd">
						<td class="sorting_1">Ashton Cox</td>
						<td>Junior Technical Author</td>
						<td>San Francisco</td>
						<td>66</td>
						<td>2009/01/12</td>
						<td>$86,000</td>
						<td>2008/11/28</td>
						<td>$162,700</td>
					</tr>
					<tr role="row" class="even">
						<td class="sorting_1">Bradley Greer</td>
						<td>Software Engineer</td>
						<td>London</td>
						<td>41</td>
						<td>2012/10/13</td>
						<td>$132,000</td>
						<td>2008/11/28</td>
						<td>$162,700</td>
					</tr>
					<tr role="row" class="odd">
						<td class="sorting_1" colspan="8">NHÓM VẬT TƯ XĂNG MÁY BAY</td>
					</tr>
					<tr role="row" class="even">
						<td class="sorting_1">Brielle Williamson</td>
						<td>Integration Specialist</td>
						<td>New York</td>
						<td>61</td>
						<td>2012/12/02</td>
						<td>$372,000</td>
						<td>2008/11/28</td>
						<td>$162,700</td>
					</tr>
					<tr role="row" class="odd">
						<td class="sorting_1">Bruno Nash</td>
						<td>Software Engineer</td>
						<td>London</td>
						<td>38</td>
						<td>2011/05/03</td>
						<td>$163,500</td>
						<td>2008/11/28</td>
						<td>$162,700</td>
					</tr>
					<tr role="row" class="even">
						<td class="sorting_1">Caesar Vance</td>
						<td>Pre-Sales Support</td>
						<td>New York</td>
						<td>21</td>
						<td>2011/12/12</td>
						<td>$106,450</td>
						<td>2008/11/28</td>
						<td>$162,700</td>
					</tr>
					<tr role="row" class="odd">
						<td class="sorting_1" colspan="8">NHÓM VẬT TƯ NHIÊN LIỆU PHẢN LỰC</td>
					</tr>
					<tr role="row" class="even">
						<td class="sorting_1">Cedric Kelly</td>
						<td>Senior Javascript Developer</td>
						<td>Edinburgh</td>
						<td>22</td>
						<td>2012/03/29</td>
						<td>$433,060</td>
						<td>2008/11/28</td>
						<td>$162,700</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="ln_solid"></div>
		<div class="row" style="text-align: center;">
			<button type="button" class="btn btn-default">
				<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
					<a href="#/recycle"><i class="fa fa-print"></i> In báo cáo</a>
				</div>
			</button>
		</div>
	</div>
</div>