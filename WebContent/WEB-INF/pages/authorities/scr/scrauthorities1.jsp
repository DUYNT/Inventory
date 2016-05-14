<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Level 1</h3>



<div class="col-md-6 col-sm-6 col-xs-12">


	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>Nhóm người dùng</h2>
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
										<th class="sorting_desc" tabindex="0"
											aria-controls="datatable" rowspan="1" colspan="1"
											aria-label="Name: activate to sort column ascending"
											style="width: 68px;" aria-sort="descending">STT</th>
										<th class="sorting" tabindex="0" aria-controls="datatable"
											rowspan="1" colspan="1"
											aria-label="Position: activate to sort column ascending"
											style="width: 222px;">Tên nhóm người dùng</th>

									</tr>
								</thead>


								<tbody>

									</tr>
									<tr role="row" class="odd">
										<td class="sorting_1">1</td>
										<td>Phiếu xuất nhập</td>
									</tr>

									<tr role="row" class="odd">
										<td class="sorting_1">2</td>
										<td>Quản trị</td>
									<tr role="row" class="odd">
										<td class="sorting_1">3</td>
										<td>Đổi mã vật tư</td>
									<tr role="row" class="odd">
										<td class="sorting_1">4</td>
										<td>Ban tài chính</td>
								</tbody>
							</table>
						</div>
					</div>

				</div>
			</div>


			<div class="x_content">

				<form class="form-horizontal form-label-left">


					<div class="divider-dashed"></div>

					<div class="form-group">
						<label class="col-sm-3 control-label">Quyền đăc biệt</label>

					</div>
					<h4>ĐƯỢC PHÉP CẬP NHẬT TẤT CẢ CÁC DANH MỤC</h4>
				</form>

			</div>
			<div class="col-md-12 col-sm-12 col-xs-12" style="padding-top: 10px">
				<div class="form-group">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">


						<button type="button" class="btn btn-success">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm"
									href="#/plus" style="color: white;"><i class="fa fa-plus"></i>
									Thêm</a>
							</div>
						</button>

						<button type="button" class="btn btn-warning">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm"
									href="#/pencil" style="color: white;"><i
									class="fa fa-pencil"></i> Sửa</a>
							</div>
						</button>
						<button type="button" class="btn btn-danger">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm"
									href="#/plus" style="color: white;"><i class="fa fa-close"></i>
									Xóa</a>
							</div>
						</button>
					</div>
				</div>

			</div>

		</div>

	</div>








	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>Danh sách người dùng</h2>
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
				<div class="col-md-4 col-sm-4 col-xs-12">
					<div id="datatable_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap no-footer">

						<div class="row">
							<div class="col-sm-12">
								<table id="datatable"
									class="table table-striped table-bordered dataTable no-footer"
									role="grid" aria-describedby="datatable_info">
									<thead>
										<tr role="row">
											<th class="sorting_desc" tabindex="0"
												aria-controls="datatable" rowspan="1" colspan="1"
												aria-label="Name: activate to sort column ascending"
												style="width: 68px;" aria-sort="descending">STT</th>
											<th class="sorting" tabindex="0" aria-controls="datatable"
												rowspan="1" colspan="1"
												aria-label="Position: activate to sort column ascending"
												style="width: 222px;">Họ tên</th>


										</tr>
									</thead>


									<tbody>

										</tr>
										<tr role="row" class="odd">
											<td class="sorting_1">1</td>
											<td>Phiếu xuất nhập</td>


										</tr>

										<tr role="row" class="odd">
											<td class="sorting_1">2</td>
											<td>Quản trị</td>
										<tr role="row" class="odd">
											<td class="sorting_1">3</td>
											<td>Đổi mã vật tư</td>
										<tr role="row" class="odd">
											<td class="sorting_1">4</td>
											<td>Ban tài chính</td>
									</tbody>
								</table>
							</div>
						</div>

					</div>
				</div>
				<div class="col-md-8 col-sm-8 col-xs-12">
					<div class="x_content">
						<br>
						<form id="demo-form2" data-parsley-validate=""
							class="form-horizontal form-label-left" novalidate="">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4 col-xs-12"
										for="first-name">Tên người dùng </label>
									<div class="col-md-8 col-sm-8 col-xs-12">
										<input type="text" id="first-name" required="required"
											class="form-control col-md-7 col-xs-12">
									</div>
								</div>

							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4 col-xs-12"
										for="first-name">Mật khẩu</label>
									<div class="col-md-8 col-sm-8 col-xs-12">
										<input type="text" id="first-name" required="required"
											class="form-control col-md-7 col-xs-12">
									</div>
								</div>

							</div>


							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<label class="control-label col-md-4 col-sm-4 col-xs-12"
										for="first-name">Mô tả </label>
									<div class="col-md-8 col-sm-8 col-xs-12">
										<input type="text" id="first-name" required="required"
											class="form-control col-md-7 col-xs-12">
									</div>
								</div>

							</div>




						</form>
					</div>
				</div>

				<div class="col-md-12 col-sm-12 col-xs-12" style="padding-top: 10px">
					<div class="form-group">
						<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-3">

							<button type="button" class="btn btn-success">
								<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
									<a data-toggle="modal" data-target="#modal-confirm"
										href="#/plus" style="color: white;"><i class="fa fa-plus"></i>
										Thêm</a>
								</div>
							</button>


							<button type="button" class="btn btn-warning">
								<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
									<a data-toggle="modal" data-target="#modal-confirm"
										href="#/pencil" style="color: white;"><i
										class="fa fa-pencil"></i> Sửa</a>
								</div>
							</button>



							<button type="button" class="btn btn-danger">
								<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
									<a data-toggle="modal" data-target="#modal-confirm"
										href="#/plus" style="color: white;"><i class="fa fa-close"></i>
										Xóa</a>
								</div>
							</button>

						</div>
					</div>

				</div>
			</div>




		</div>

	</div>


</div>


<div class="col-md-6 col-sm-6 col-xs-12">
	<div class="x_panel">
		<div class="x_title">
			<h2>Các chức năng cấm sử dụng</h2>
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
										rowspan="1" colspan="1"
										aria-label="Name: activate to sort column ascending"
										style="width: 68px;" aria-sort="descending">STT</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Position: activate to sort column ascending"
										style="width: 422px;">Tên chức năng</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1"
										aria-label="Office: activate to sort column ascending"
										style="width: 22px;">Chọn</th>


								</tr>
							</thead>


							<tbody>



								<tr role="row" class="odd">
									<td class="sorting_1">1</td>
									<td>Viết, xem, sửa, xóa phiếu nhập</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>



								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">2</td>
									<td>Viết, xem ,sửa phiếu nhập đã thực hiện</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>



								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">3</td>
									<td>Viết mới, xem, sửa phiếu xuất</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>



								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">4</td>
									<td>Xem, sửa, xóa phiếu xuất đã thực hiện</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>



								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">5</td>
									<td>Cân đối xuất nhập tồn</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>



								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">6</td>
									<td>Xem cân đối</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>

								</tr>

								<tr role="row" class="odd">
									<td class="sorting_1">7</td>
									<td>Xem thẻ kho</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">8</td>
									<td>Xem tồn kho</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">9</td>
									<td>Đầu kỳ vật tư</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">10</td>
									<td>Tìm kiếm tổng hợp</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">11</td>
									<td>Báo cáo xuất nhập tồn</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">12</td>
									<td>Tổng hợp nguồn nhập theo ngân sách</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">13</td>
									<td>Phân tích nguồn nhập nhiên liệu theo ngân sách</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">14</td>
									<td>Phân tích nguồn nhập dầu mỡ theo ngân sách</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">15</td>
									<td>Tổng hợp nguồn nhập ứng ngân sách</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">16</td>
									<td>Phân tích nguồn nhập nhiên liệu ứng ngân sách</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">17</td>
									<td>Phân tích nguồn nhập dầu mỡ ứng ngân sách</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>
								<tr role="row" class="odd">
									<td class="sorting_1">18</td>
									<td>Báo cáo phân tích nguồn nhập khác</td>
									<td><label>
											<div class="icheckbox_flat-green" style="position: relative;">
												<input type="checkbox" class="flat"
													style="position: absolute; opacity: 0;">
												<ins class="iCheck-helper"
													style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
											</div>
									</label></td>
								</tr>


							</tbody>
						</table>


					</div>
				</div>

			</div>
		</div>
	</div>
</div>