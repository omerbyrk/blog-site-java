$(document).ready(function(){
    $("#sidebar-button-left").click(function(){
        $("#main").toggleClass("offset-7 offset-0");
        $("#sidebar-left").toggleClass("custom-hidden-sm-down sidebar-left-active col-7");
        $("#sidebar-button-right").toggleClass("custom-hidden-sm-down");
    });

    $("#sidebar-button-right").click(function(){
        $("#main").toggleClass("pull-7 pull-md-0");
        $("#sidebar-right").toggleClass("custom-hidden-sm-down sidebar-right-active col-7");
        $("#sidebar-button-left").toggleClass("custom-hidden-sm-down");
    });

    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    });
    
	$(".blog-categories, .blog-tags").each(function() {
		$(this).find(".comma:last-child").remove(0);
	});
    
});

function ajax(url,type,data) {
	return $.ajax({
		type : type,
		url : url,
		data : data,
		success : function(response) {
			alert(response.operationResult.detail);
		},
		error : function(){
			alert("an error occurred , when executing the operation");
		}
	});
}