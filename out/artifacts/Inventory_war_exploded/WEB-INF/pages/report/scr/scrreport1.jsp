<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>FORM 1</h3>

<div class="x_panel">
	<div class="x_title">
		<h2>
		BÁO CÁO TỔNG HỢP NHẬP XUẤT TỒN XĂNG DẦU
			
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
						<tr>
							<th rowspan="3">STT</th>
							<th rowspan="3">Diễn Giải</th>
							<th rowspan="3">Tồn</th>
							<th colspan="5">Nhập Trong kỳ</th>
							<th rowspan="3">Tổng có</th>
							<th colspan="6">Xuất trong kỳ</th>
							<th rowspan="3">Tồn</th>
						</tr>
						<tr>
							<th colspan="3">Ngân sách thường xuyên</th>
							<th rowspan="2">Nhập khác</th>
							<th rowspan="2">Cộng khác</th>
							<th colspan="3">Xuất cho đơn vị</th>
							<th rowspan="2">Xuất khác</th>
							<th rowspan="2">Hao hụt</th>
							<th rowspan="2">Cộng xuất</th>
						</tr>
						<tr>
							<th>Năm 2016</th>
							<th>Ứng năm sau</th>
							<th>Cộng</th>
							<th>Hạn mức</th>
							<th>Ứng HM năm</th>
							<th>Cộng</th>
						</tr>
						<tbody>
							<tr>

								<td colspan="2">Hàng chính phẩm</td>

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
							<tr>

								<td colspan="2">Nhiên liệu</td>
								<td>20,000</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>20,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>14,871.0</td>
								<td>14,871.0</td>
								<td>5,129.0</td>
							</tr>
							<tr>
								<td colspan="2">Xăng ôtô</td>
								<td>10,000</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>20,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>14,941.0</td>
							</tr>
							<tr>
								<td>1</td>
								<td>Magas-97</td>
								<td>40,000</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>30,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>14,941.0</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Xăng-92</td>
								<td>90,000</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>40,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>14,941.0</td>
							</tr>
							<tr>
								<td>3</td>
								<td>Xăng RON 83</td>
								<td>0.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>20,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>14,941.0</td>
							</tr>
							<tr>
								<td>4</td>
								<td>Xăng RON 83</td>
								<td>0.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>50,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>14,941.0</td>
							</tr>
							<tr>
								<td>5</td>
								<td>Xăng RON 83</td>
								<td>0.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>20,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>14,941.0</td>
							</tr>
							<tr>
								<td colspan="2">Xăng máy bay</td>

								<td>0.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>70,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>14,941.0</td>
							</tr>
							<tr>
								<td>6</td>
								<td>B-91/115</td>
								<td>0.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>20,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>14,941.0</td>
							</tr>
							<tr>
								<td colspan="2">Nhiên liệu phản lực</td>

								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>80,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>14,941.0</td>
							</tr>
							<tr>
								<td>7</td>
								<td>TC-1</td>
								<td>0.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>20,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>0.0</td>
							</tr>
							<tr>
								<td>8</td>
								<td>TC-2</td>
								<td>0.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>10,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>0.0</td>
							</tr>
							<tr>
								<td colspan="2">Nhiên liệu Điêdel</td>

								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>20,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>14,941.0</td>
							</tr>
							<tr>
								<td>9</td>
								<td>D0 0,5S</td>
								<td>0.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>60,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>0.0</td>
							</tr>
							<tr>
								<td colspan="17">Dầu nhờn</td>

							</tr>
							<tr>
								<td colspan="17">Dầu nhờn động cơ</td>

							</tr>

							<tr>
								<td>10</td>
								<td>AVG-100LL</td>
								<td>0.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>20,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>6,059.0</td>
								<td>5,059.0</td>
								<td>14,941.0</td>
							</tr>
							<tr>
								<td>11</td>
								<td>AVG-100LL</td>
								<td>0.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>20,000.0</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>5,059.0</td>
								<td>5,059.0</td>
								<td>11,941.0</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>