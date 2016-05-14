<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="/Home_init.do" class="site_title"><i
							class="fa fa-paw"></i> <span><zz:write
									property="value.info.userInfo.donVi" name="BaseForm" /></span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile">
						<div class="profile_info"
							style="position: relative; top: -10px; float: right; width: 100%">
							<span>Chào mừng,</span>
							<h2>
								<zz:write property="value.info.userInfo.tenDayDu"
									name="BaseForm" />
							</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>Quản lý dữ liệu</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-recycle"></i> Tổng hợp <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/Total_init.do">Cân đối xuất
												nhập tồn</a></li>
										<li><a href="/Total_ioProductSave.do">Xem
												cân đối xuất nhập tồn</a></li>
										<li><a href="/Total_viewProduct.do">Xem thẻ
												kho</a></li>
										<li><a href="/Total_viewProductSave.do">Xem
												tồn kho</a></li>
										<li><a href="/Total_viewStartMonth.do">Đầu
												kỳ vật tư</a></li>
									</ul></li>
								<li><a><i class="fa fa-edit"></i> Dữ liệu <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/Store_init.do">Quản lý phiếu
												nhập</a></li>
										<li><a href="/Store_output.do">Quản lý
												phiếu xuất</a></li>
										<li><a href="/Store_outputLimitUnit.do">Quản
												lý hao hụt</a></li>
										<li><a href="/Store_advanceOLimitUnit.do">Tạo
												số lượng hao hụt</a></li>
									</ul></li>
								<li><a><i class="fa fa-folder-o"></i> Danh mục <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/Category_init.do">Danh mục
												vật tư</a></li>
										<li><a href="/Category_inventory.do">Danh
												mục kho</a></li>
										<li><a href="/Category_natureOutput.do">Danh
												mục tính chất xuất</a></li>
										<li><a href="/Category_natureInput.do">Danh
												mục tính chất nhập</a></li>
										<li><a href="/Category_custome.do">Danh mục
												khách hàng</a></li>
										<li><a href="/Category_supplier.do">Danh
												mục nhà cung cấp</a></li>
										<li><a href="/Category_mnOrderOffer.do">Danh
												mục VCF</a></li>
									</ul></li>
								<li><a><i class="fa fa-table"></i> Báo cáo <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li onclick="objReport.reportBieu1()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Báo cáo xuất, nhập, tồn">Biểu 1</a></li>
										<li onclick="objReport.reportBieu2()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total" data-placement="top"
											data-original-title="Tổng hợp nguồn nhập theo ngân sách">Biểu 2</a></li>
										<li onclick="objReport.reportBieu2A()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Phân tích nguồn nhập nhiên liệu theo ngân sách">Biểu
												2A</a></li>
										<li onclick="objReport.reportBieu2B()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Phân tích nguồn nhập dầu mỡ theo ngân sách">Biểu
												2B</a></li>
										<li onclick="objReport.reportBieu3()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Tổng hợp nguồn nhập ứng ngân sách">Biểu
												3</a></li>
										<li onclick="objReport.reportBieu3A()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Phân tích nguồn nhập nhiên liệu ứng ngân sách">Biểu
												3A</a></li>
										<li onclick="objReport.reportBieu3B()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Phân tích nguồn nhập dầu mỡ ứng ngân sách">Biểu
												3B</a></li>
										<li onclick="objReport.reportBieu4()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Báo cáo phân tích nguồn nhập khác">Biểu
												4</a></li>
										<li onclick="objReport.reportBieu5()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Báo cáo phân tích xuất khác">Biểu 5</a>
										</li>
										<li onclick="objReport.reportBieu6()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Tổng hợp xuất hạn mức cho các đơn vị">Biểu
												6</a></li>
										<li onclick="objReport.reportBieu6A()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Phân tích xuất nhiên liệu theo HM cho ĐV">Biểu
												6A</a></li>
										<li onclick="objReport.reportBieu6B()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Phân tích xuất dầu mỡ theo HM cho ĐV">Biểu
												6B</a></li>
										<li onclick="objReport.reportBieu7()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Tổng hợp xuất hạn mức cho các đơn vị">Biểu
												7</a></li>
										<li onclick="objReport.reportBieu7A()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Phân tích xuất nhiên liệu ứng hạn mức cho ĐV">Biểu
												7A</a></li>
										<li onclick="objReport.reportBieu7B()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top"
											data-original-title="Phân tích xuất dầu mỡ ứng hạn mức cho đơn vị">Biểu
												7B</a></li>
										<li onclick="objReport.reportBieu8()"><a href="#"
											data-toggle="modal" data-target="#modal-report-total"
											data-placement="top" data-original-title="Quản lý hao hụt">Biểu
												8</a></li>
										<li><a href="#"
											data-toggle="modal" data-target="#modal-report-phan-tich-ton-kho"
											data-placement="top"
											data-original-title="Báo cáo phân tích tồn kho">Biểu 9</a></li>
										<li><a href="#"
											data-toggle="modal" data-target="#modal-report-phan-tich-xuat-thanh-ly"
											data-placement="top"
											data-original-title="Phân tích xuất thanh lý, chuyển MĐSD">Biểu
												10</a></li>
										<li><a href="#"
											data-toggle="modal" data-target="#modal-report-hang-hoa-quy-dinh-sscd"
											data-placement="top"
											data-original-title="Báo cáo nhiên liệu, dầu mỡ quy định sẵn sàng chiến đấu">Biểu
												11</a></li>
										<li><a href="#"
											data-toggle="modal" data-target="#modal-xuat-nhap-ton-dtqg"
											data-placement="top"
											data-original-title="Báo cáo xuất, nhập, tồn DTQG">Biểu
												12</a></li>
										<li><a href="#"
											data-toggle="modal" data-target="#modal-tiep-nha-cap-phat-hang-hoa"
											data-placement="top"
											data-original-title="Báo cáo tiếp nhận, cấp phát xăng dầu">Biểu
												13</a></li>
										<li><a href="#"
											data-toggle="modal" data-target="#modal-report-so-phan-ho"
											data-placement="top" data-original-title="Sổ phân hộ xuất">Biểu
												14</a></li>
									</ul></li>
								<!-- <span class="glyphicon glyphicon-copy" aria-hidden="true"></span> -->
								<!-- <li><a><i class="fa fa-pie-chart"></i> Kiểm kê <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/Inventory_init.do">Tổng hợp
												dữ liệu kiểm kê</a></li>
										<li><a href="/Inventory_recordTruth.do">Ghi
												thực kiểm</a></li>
										<li><a href="/Inventory_report.do">Báo cáo
												kiểm kê</a></li>
									</ul></li> -->
							</ul>
						</div>

						<div class="menu_section">
							<h3>Danh mục quản trị viên</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i> Kết nối đến Cục <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/Station_init.do">Gửi báo cáo
												lên Cục</a></li>
										<li><a href="/Station_adding.do">Đồng bộ KH
												từ Cục</a></li>
										<li><a href="/Station_editing.do">Lịch sử
												kết nối với Cục</a></li>
									</ul></li>
								<li><a><i class="fa fa-user"></i> Thiết lập hệ thống <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="/User_init.do">Quản lý người dùng</a></li>
										<li><a href="/Authorities_init.do">Phân quyền sử dụng</a>
									</ul></li>
							</ul>
						</div>

					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Settings">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Logout"
							href="/Login_loguot.do"> <span
							class="glyphicon glyphicon-off" aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">

				<div class="nav_menu">
					<nav class="" role="navigation">
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>

						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;"
								class="user-profile dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"> <zz:write
										property="value.info.userInfo.username" name="BaseForm" /> <span
									class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="/User_control.do">Thông tin cá
											nhân</a></li>
									<li><a href="javascript:;"> <span>Thiết lập
												thông tin</span>
									</a></li>
									<li><a href="javascript:;">Cần sự trợ giúp</a></li>
									<li><a href="/Login_loguot.do"><i
											class="fa fa-sign-out pull-right"></i> Đăng xuất</a></li>
								</ul></li>

							<li role="presentation" class="dropdown"><a
								href="javascript:;" class="dropdown-toggle info-number"
								data-toggle="dropdown" aria-expanded="false"> <i
									class="fa fa-bell-o"></i> <span class="badge bg-green">6</span>
							</a>
								<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
									role="menu">
									<li><a> <span class="image"> <img
												src="images/img.jpg" alt="Profile Image" />
										</span> <span> <span>John Smith</span> <span class="time">3
													mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"> <img
												src="images/img.jpg" alt="Profile Image" />
										</span> <span> <span>John Smith</span> <span class="time">3
													mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"> <img
												src="images/img.jpg" alt="Profile Image" />
										</span> <span> <span>John Smith</span> <span class="time">3
													mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"> <img
												src="images/img.jpg" alt="Profile Image" />
										</span> <span> <span>John Smith</span> <span class="time">3
													mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li>
										<div class="text-center">
											<a href="inbox.html"> <strong>See All Alerts</strong> <i
												class="fa fa-angle-right"></i>
											</a>
										</div>
									</li>
								</ul></li>

						</ul>
					</nav>
				</div>
			</div>
