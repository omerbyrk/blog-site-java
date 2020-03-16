$(document).ready(function(){
	
	$("#delete-category").click(function() {
		
		if($("#category option").is(":selected")){
			if(confirm("Kategoriyi silmek istediğinden emin misin?")){
				ajax($(this).attr("href"), "POST" ,{ categoryId : $("#category option:selected").val()});
			}
		}else {alert("Lütfen önce bir kategori seçiniz.!");}
		return false;
	});
	
	$("#new-blog-form").submit(function(e){
		result = "";
		
		$("#title , #preview , #new-blog-form #content , #tags").each(function(){
			if($(this).val().trim() == "") {
				result += $(this).attr('name') + " field is empty , that must require to fill <br/>";
				e.preventDefault();
			}
		});
		
		
		if(!$("#category option").is(":selected")) {
			result += "category is not selected , that must require to selected at least one <br/>";
			e.preventDefault();
		}
		
		resultPrinter(result);
	});
	
	function resultPrinter(result) {
		$(".result-wrapper").addClass('push-xs-4 col-xs-6 alert alert-info');
		$(".result-wrapper").css("text-align","center");
		$(".result-wrapper").html(result);
	}
	
	
	if($("#hasBlog").html() == "true"){
		
		$(".blog-category").each(function() {
			var category = $(this).html().replace(" ", "");
			$('#category [category-name=' + category + ']').attr('selected',true);
		});
		$("#content").html($("#blog-content").html());
		$(".blog-tag").each(function() {
			$("#tags").val($("#tags").val() + $(this).html() + ", ");
		})
	}
	
	$("#new-category").click(function() {
		if($("#category option").is(":selected")){
			category = $("#category option:selected");
			$("#new-category-fw #id").val(category.attr("category-id"));
			$("#new-category-fw #name").val(category.attr("category-name"));
			$("#new-category-fw #order").val(category.attr("category-order"));
		}
		$("#new-category-fw").modal('show');
	});
});