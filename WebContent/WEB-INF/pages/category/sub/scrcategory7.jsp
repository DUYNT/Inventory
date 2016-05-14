<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Quản lý VCF</h3>

<div class="row">
	<!-- form input mask -->
	<div class="col-md-6 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					Danh sách phiếu nhập <small>Nhấn chuột vào để xem thông tin</small>
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
				<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
					<input type="text" class="form-control has-feedback-left"
						id="inputSuccess4" placeholder="D 15oC"> <span
						class="fa fa-flask form-control-feedback left" aria-hidden="true"></span>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
					<input type="text" class="form-control" id="inputSuccess5"
						placeholder="Nhiệt độ"> <span
						class="fa fa-flask form-control-feedback right" aria-hidden="true"></span>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Số TT</th>
							<th>D 15oC</th>
							<th>Nhiệt độ TT</th>
							<th>VCF</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>0.000000</td>
							<td>0.000007</td>
							<td>0.9985600</td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>0.0000000</td>
							<td>0.000007</td>
							<td>0.9985600</td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>0.0000000</td>
							<td>0.000007</td>
							<td>0.9985600</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<!-- /form input mask -->

	<!-- form color picker -->
	<div class="col-md-6 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>Nhập liệu <small> sử dụng thêm sửa xóa VCF</small></h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br>
				<div class="form-horizontal form-label-left input_mask">
					<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="Nhiệt độ thực tế"> <span
							class="fa fa-flask form-control-feedback left" aria-hidden="true"></span>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="D 15oC"> <span
							class="fa fa-flask form-control-feedback left"
							aria-hidden="true"></span>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
						<input type="text" class="form-control has-feedback-left"
							id="inputSuccess4" placeholder="VCF"> <span
							class="fa fa-flask form-control-feedback left"
							aria-hidden="true"></span>
					</div>
					<div class="clearfix"></div>
					<div class="ln_solid"></div>
					<div class="row" style="text-align: center;">
						<button type="button" class="btn btn-default">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a href="#/recycle"><i class="fa fa-print"></i> In</a>
							</div>
						</button>
						<button type="button" class="btn btn-success">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm" href="#/plus" style="color: white;"><i class="fa fa-plus"></i>
									Thêm</a>
							</div>
						</button>
						<button type="button" class="btn btn-warning">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm" href="#/pencil" style="color: white;"><i
									class="fa fa-pencil"></i> Sửa</a>
							</div>
						</button>
						<button type="button" class="btn btn-danger">
							<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
								<a data-toggle="modal" data-target="#modal-confirm" href="#/times" style="color: white;"><i
									class="fa fa-remove"></i> Xóa<span class="text-muted"></span></a>
							</div>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /form color picker -->
</div>
