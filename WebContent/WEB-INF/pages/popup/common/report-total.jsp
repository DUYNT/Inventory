<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<div id="modal-report-total" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" id="canbang">Chọn khoảng thời gian</h4>
			</div>
			<!-- content start -->
			<div class="x_content">
				<br>
				<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
					<input type="text" class="form-control has-feedback-left"
						id="inputSuccess4" placeholder="Từ ngày"> <span
						class="fa fa-calendar form-control-feedback left"
						aria-hidden="true"></span>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
					<input type="text" class="form-control" id="inputSuccess5"
						placeholder="Đến ngày"> <span
						class="fa fa-calendar form-control-feedback right"
						aria-hidden="true"></span>
				</div>
				<div class="checkbox">
					<label class="">
						<div class="icheckbox_flat-green "
							style="position: relative; left: -10px">
							<input type="checkbox" class="flat" =""
								style="position: absolute; opacity: 0;">
							<ins class="iCheck-helper"
								style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
						</div> Ký xác nhận
					</label>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
					<input type="text" class="form-control has-feedback-left"
						id="inputSuccess4" placeholder="Chủ nhiệm kho"> <span
						class="fa fa fa-user form-control-feedback left"
						aria-hidden="true"></span>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
					<input type="text" class="form-control has-feedback-left"
						id="inputSuccess4" placeholder="Trưởng ban TMKH"> <span
						class="fa fa fa-user form-control-feedback left"
						aria-hidden="true"></span>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
					<input type="text" class="form-control has-feedback-left"
						id="inputSuccess4" placeholder="Trưởng ban tài chính"> <span
						class="fa fa fa-user form-control-feedback left"
						aria-hidden="true"></span>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
					<input type="text" class="form-control has-feedback-left"
						id="inputSuccess4" placeholder="Trợ lý xăng dầu"> <span
						class="fa fa fa-user form-control-feedback left"
						aria-hidden="true"></span>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
					<input type="text" class="form-control has-feedback-left"
						id="inputSuccess4" placeholder="Người tổng hợp"> <span
						class="fa fa fa-user form-control-feedback left"
						aria-hidden="true"></span>
				</div>
			</div>
			<!-- content end -->
			<div class="clearfix"></div>
			<div class="modal-footer">
				<div class="row" style="text-align: center">
					<button type="button" class="btn btn-primary" id="report-total-export">
						<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
							<a href="#" style="color: white;"><i class="fa fa-inbox"></i>
								Xuất báo cáo</a>
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
