<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<div id="modal-quan-ly-phieu-xuat-3" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Các vật tư hiện có</h4>
			</div>

			<!-- content start -->
			<div class="x_content">
				<br>
				<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
					<input type="text" class="form-control has-feedback-left"
						id="inputSuccess2" placeholder="D15oC"> <span
						class="fa fa-flask form-control-feedback left" aria-hidden="true"></span>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
					<input type="text" class="form-control" id="inputSuccess3"
						placeholder="Nhiệt độ"> <span
						class="fa fa-flask form-control-feedback right" aria-hidden="true"></span>
				</div>
			</div>
			<table class="table table-striped jambo_table bulk_action">
				<thead>
					<tr class="headings">
						<th class="column-title">Số TT</th>
						<th class="column-title">D 15oC</th>
						<th class="column-title">Nhiêt độ TT</th>
						<th class="column-title">VCF</th>
					</tr>
				</thead>

				<tbody>
					<tr class="even pointer">
						<td class=" ">001</td>
						<td class=" ">15 o c</td>
						<td class=" ">15oC <i class="success fa fa-long-arrow-up"></i></td>
						<td class=" ">100</td>
					</tr>
					<tr class="odd pointer">
						<td class=" ">002</td>
						<td class=" ">15 o c</td>
						<td class=" ">15oC <i class="success fa fa-long-arrow-up"></i>
						</td>
						<td class=" ">200</td>
					</tr>
					<tr class="even pointer">
						<td class=" ">003</td>
						<td class=" ">15 o c</td>
						<td class=" ">15oC <i class="success fa fa-long-arrow-up"></i>
						</td>
						<td class=" ">200</td>
					</tr>
					<tr class="odd pointer">
						<td class=" ">004</td>
						<td class=" ">15 o c</td>
						<td class=" ">15oC</td>
						<td class=" ">300</td>
					</tr>
				</tbody>
			</table>
			<!-- content end -->
			<div class="clearfix"></div>
			<div class="modal-footer">
				<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3"
					style="margin-left: 26%;">
					<div class="fa-hover col-md-3 col-sm-4 col-xs-12"
						style="text-align: right;">
						<a href="#/plus"><i class="fa fa-plus"></i> Ghi</a>
					</div>
					<div class="fa-hover col-md-3 col-sm-4 col-xs-12 "
						style="text-align: right;">
						<a href="#/pencil"><i class="fa fa-pencil"></i> Đóng</a>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
