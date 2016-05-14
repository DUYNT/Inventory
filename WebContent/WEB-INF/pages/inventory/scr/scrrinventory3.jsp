<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/tld/zz.tld" prefix="zz"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<h3>Báo cáo kiểm kê</h3>


<div class="form-horizontal form-label-left input_mask">
	<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
		<div class="col-md-4 col-sm-4 col-xs-12">
			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="first-name" style="padding-top: 5px">Tháng kiểm kê </label>
				<div class="control-label col-md-9 col-sm-9 col-xs-12">
					<select class="form-control">

						<option>01</option>
						<option>002</option>
						<option>03</option>
						<option>04</option>
					</select>
				</div>
			</div>

		</div>

	</div>
</div>
<div class="form-horizontal form-label-left input_mask">


	<div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">

		<div class="form-group">


			<div class="col-md-6 col-sm-6 col-xs-12">

				<div class="checkbox">
					<label class="">
						<div class="icheckbox_flat-green" style="position: relative;">
							<input type="checkbox" class="flat" checked="checked"
								style="position: absolute; opacity: 0;">
							<ins class="iCheck-helper"
								style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
						</div> Biên bản kiểm kê phần nhiên liệu
					</label>
				</div>
			</div>

			<div class="col-md-6 col-sm-6 col-xs-12">

				<div class="form-group">
					<label class="control-label col-md-4 col-sm-4 col-xs-12">Tiêu
						đề biểu kiểm kê</label>
					<div class="col-md-8 col-sm-8 col-xs-12">
						<input type="text" name="country" id="autocomplete-custom-append"
							class="form-control col-md-10" style="float: left;"
							autocomplete="off">
						<div id="autocomplete-container"
							style="position: relative; float: left; width: 400px; margin: 10px;">
							<div class="autocomplete-suggestions"
								style="position: absolute; display: none; max-height: 300px; z-index: 9999;"></div>
						</div>
					</div>
				</div>
			</div>



		</div>
		<div class="form-group">


			<div class="col-md-6 col-sm-6 col-xs-12">

				<div class="checkbox">
					<label class="">
						<div class="icheckbox_flat-green" style="position: relative;">
							<input type="checkbox" class="flat" checked="checked"
								style="position: absolute; opacity: 0;">
							<ins class="iCheck-helper"
								style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; border: 0px; opacity: 0; background: rgb(255, 255, 255);"></ins>
						</div> Biên bản kiểm kê phần dầu mỡ
					</label>
				</div>
			</div>

			<div class="col-md-6 col-sm-6 col-xs-12">

				<div class="form-group">
					<label class="control-label col-md-4 col-sm-4 col-xs-12">Mẫu
						biểu kiểm kê</label>
					<div class="col-md-8 col-sm-8 col-xs-12">
						<input type="text" name="country" id="autocomplete-custom-append"
							class="form-control col-md-10" style="float: left;"
							autocomplete="off">
						<div id="autocomplete-container"
							style="position: relative; float: left; width: 400px; margin: 10px;">
							<div class="autocomplete-suggestions"
								style="position: absolute; display: none; max-height: 300px; z-index: 9999;"></div>
						</div>
					</div>
				</div>
			</div>



		</div>

	</div>

</div>
<label class="control-label col-md-4 col-sm-4 col-xs-12">Tổ kiểm
	kê</label>
<textarea id="message" required="required" class="form-control"
	name="message" data-parsley-trigger="keyup" data-parsley-minlength="20"
	data-parsley-maxlength="100"
	data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.."
	data-parsley-validation-threshold="10"></textarea>
<textarea id="message" required="required" class="form-control"
	style="margin-top: 10px" name="message" data-parsley-trigger="keyup"
	data-parsley-minlength="20" data-parsley-maxlength="100"
	data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.."
	data-parsley-validation-threshold="10"></textarea>

<label class="control-label col-md-4 col-sm-4 col-xs-12">Thuyết
	minh</label>
<textarea id="message" required="required" class="form-control"
	name="message" data-parsley-trigger="keyup" data-parsley-minlength="20"
	data-parsley-maxlength="100"
	data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.."
	data-parsley-validation-threshold="10"></textarea>
<textarea id="message" required="required" class="form-control"
	style="margin-top: 10px" name="message" data-parsley-trigger="keyup"
	data-parsley-minlength="20" data-parsley-maxlength="100"
	data-parsley-minlength-message="Come on! You need to enter at least a 20 caracters long comment.."
	data-parsley-validation-threshold="10"></textarea>


<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3" style="padding-top: 10px">
	<button type="button" class="btn btn-success">
		<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
			<a data-toggle="modal" data-target="#modal-confirm" href="#/print" style="color: white;"><i class="fa fa-plus"></i>
				Thực hiện</a>
		</div>
	</button>
	<button type="button" class="btn btn-success">
		<div class="fa-hover col-md-3 col-sm-4 col-xs-12">
			<a data-toggle="modal" data-target="#modal-confirm" href="#/print" style="color: white;"><i class="fa fa-trash-o"></i>
				Thoát</a>
		</div>
	</button>

</div>