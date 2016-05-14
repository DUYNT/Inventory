<%@ page session="false"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>
<footer>
	<div class="pull-right">Quản lý kho hàng .Tổng cục hậu cần</div>
	<div class="clearfix"></div>
	<div id="custom_notifications" class="custom-notifications dsp_none">
		<ul class="list-unstyled notifications clearfix"
			data-tabbed_notifications="notif-group">
		</ul>
		<div class="clearfix"></div>
		<div id="notif-group" class="tabbed_notifications"></div>
	</div>
</footer>
			<tiles:insert definition="CONFIRM" />
			<tiles:insert definition="REPORTTOTAL" />
			<tiles:insert definition="REPORTQUYDINHSSCD" />
			<tiles:insert definition="REPORTPHANTICHTONKHO" />
			<tiles:insert definition="REPORTSOPHANHO" />
			<tiles:insert definition="REPORTTIEPNHANCAPPHATHH" />
			<tiles:insert definition="REPORTXUATNHAPTONDTQG" />
			<tiles:insert definition="REPORTXUATTHANHLY" />
</div>
</div>
</body>

<!-- Tạo tree cho danh mục hàng hóa -->
<script type="text/javascript">
	$.fn
			.extend({
				treed : function(o) {
					var openedClass = 'glyphicon-minus-sign';
					var closedClass = 'glyphicon-plus-sign';
					if (typeof o != 'undefined') {
						if (typeof o.openedClass != 'undefined') {
							openedClass = o.openedClass;
						}

						if (typeof o.closedClass != 'undefined') {
							closedClass = o.closedClass;
						}
					}
					;

					//initialize each of the top levels        
					var tree = $(this);
					tree.addClass("tree");
					tree
							.find('li')
							.has("ul")
							.each(
									function() {
										var branch = $(this); //li with children ul            
										branch
												.prepend("<i class='indicator glyphicon " + closedClass + "'></i>");
										branch.addClass('branch');
										branch.on('click', function(e) {
											if (this == e.target) {
												var icon = $(this).children(
														'i:first');
												icon.toggleClass(openedClass
														+ " " + closedClass);
												$(this).children().children()
														.toggle();
											}
										})
										branch.children().children().toggle();
									});

					//fire event from the dynamically added icon      
					tree.find('.branch .indicator').each(function() {

						$(this).on('click', function() {
							$(this).closest('li').click();
						});
					});
					//fire event to open branch if the li contains an anchor instead of text        

					tree.find('.branch>a').each(function() {
						$(this).on('click', function(e) {
							$(this).closest('li').click();
							e.preventDefault();
						});
					});

					//fire event to open branch if the li contains a button instead of text        
					tree.find('.branch>button').each(function() {
						$(this).on('click', function(e) {
							$(this).closest('li').click();
							e.preventDefault();
						});
					});
				}
			});

	$('#tree1').treed();
	
	$.fn
	.extend({
		treed : function(o) {
			var openedClass = 'glyphicon-minus-sign';
			var closedClass = 'glyphicon-plus-sign';
			if (typeof o != 'undefined') {
				if (typeof o.openedClass != 'undefined') {
					openedClass = o.openedClass;
				}

				if (typeof o.closedClass != 'undefined') {
					closedClass = o.closedClass;
				}
			}
			;

			//initialize each of the top levels        
			var tree = $(this);
			tree.addClass("tree");
			tree
					.find('li')
					.has("ul")
					.each(
							function() {
								var branch = $(this); //li with children ul            
								branch
										.prepend("<i class='indicator glyphicon " + closedClass + "'></i>");
								branch.addClass('branch');
								branch.on('click', function(e) {
									if (this == e.target) {
										var icon = $(this).children(
												'i:first');
										icon.toggleClass(openedClass
												+ " " + closedClass);
										$(this).children().children()
												.toggle();
									}
								})
								branch.children().children().toggle();
							});

			//fire event from the dynamically added icon      
			tree.find('.branch .indicator').each(function() {

				$(this).on('click', function() {
					$(this).closest('li').click();
				});
			});
			//fire event to open branch if the li contains an anchor instead of text        

			tree.find('.branch>a').each(function() {
				$(this).on('click', function(e) {
					$(this).closest('li').click();
					e.preventDefault();
				});
			});

			//fire event to open branch if the li contains a button instead of text        
			tree.find('.branch>button').each(function() {
				$(this).on('click', function(e) {
					$(this).closest('li').click();
					e.preventDefault();
				});
			});
		}
	});

$('#tree2').treed();
</script>