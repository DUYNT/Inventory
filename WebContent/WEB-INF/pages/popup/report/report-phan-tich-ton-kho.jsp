<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<div id="modal-report-phan-tich-ton-kho" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Phân tích tồn kho các phân kho</h4>
			</div>

			<!-- content start -->
			<div class="x_content">

				<div class="col-md-12 col-sm-12 col-xs-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Chọn</th>
							<th>Phân loại</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">
								<div class="icheckbox_flat-green "
									style="position: relative;">
									<input type="checkbox" class="flat" =""
										style="position: absolute; opacity: 0;">
									<ins class="iCheck-helper"
										style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
								</div>
							</th>
							<td>Sẵn sàng chiến đấu</td>
						</tr>
						<tr>
							<th scope="row"><div class="icheckbox_flat-green "
									style="position: relative;">
									<input type="checkbox" class="flat" =""
										style="position: absolute; opacity: 0;">
									<ins class="iCheck-helper"
										style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
								</div></th>
							<td>Dự chữ thường xuyên</td>
						</tr>
						<tr>
							<th scope="row"><div class="icheckbox_flat-green "
									style="position: relative;">
									<input type="checkbox" class="flat" =""
										style="position: absolute; opacity: 0;">
									<ins class="iCheck-helper"
										style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
								</div></th>
							<td>Dự trữ quốc gia</td>
						</tr>
					</tbody>
				</table>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<select
						class="select2_single form-control select2-hidden-accessible"
						tabindex="-1" aria-hidden="true">
						<option>Kho chứa hàng</option>
						<option value="KH">Phân kho 1</option>
						<option value="TC">Phân kho 2</option>
						<option value="TK">Phân kho 3</option>
						<option value="QT">Phân kho 4</option>
						<option value="HT">Phân kho 5</option>
					</select>
				</div>
			</div>
			<!-- content end -->
			<div class="clearfix"></div>
			<div class="modal-footer">
				<div class="row" style="text-align: center">
					<button type="button" id="exportReportBieu9" class="btn btn-primary">
						<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
							<a href="#" style="color: white;"><i class="fa fa-inbox"></i> Xuất báo cáo</a>
						</div>
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
							<a href="#"><i class="fa fa-close"></i> Đóng</a>
						</div>
					</button>
				</div>
			</div>
		</div>

	</div>
</div>
