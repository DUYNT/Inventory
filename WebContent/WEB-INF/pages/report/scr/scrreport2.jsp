<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>FORM 2</h3>
<div class="x_panel">
	<div class="x_title">
		<h2>Tổng hợp nguồn nhập xăng dầu theo ngân sách</h2>
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
						<tr>
							<th rowspan="3">STT</th>
							<th rowspan="3">DIỄN GIẢI</th>
							<th colspan="5">NHIÊN LIỆU</th>
							<th rowspan="3">DẦU MỠ</th>
							<th rowspan="3">TỔNG TIỀN</th>
						</tr>
						<tr>
							<th rowspan="2">Xăng Ôtô</th>
							<th rowspan="2">Xăng Máy Bay</th>
							<th rowspan="2">Nhiên liệu phản lực</th>
							<th rowspan="2">DIEZEL</th>
							<th rowspan="2">+</th>


						</tr>

						<tbody>

							<tr>
								<td colspan="2">Tổng số lượng</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>


							</tr>

							<tr>

								<td rowspan="3">1</td>
								<td colspan="1">TỔNG CỘNG</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>

							</tr>
							<tr>

								<td>số lượng</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>

							</tr>
							<tr>


								<td>thành tiền</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>

							</tr>


							<tr>
								<td rowspan="3">2</td>
								<td>ỨNG NGÂN SÁCH NĂM SAU</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>

							</tr>
							<tr>


								<td>số lượng</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>

							</tr>
							<tr>


								<td>thành tiền</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>

							</tr>
							<tr>
								<td colspan="2">Tổng tiền</td>
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