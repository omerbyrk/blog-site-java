$(document).ready(function(){
	
	
	{
		// category sayfasındaki pagination ayarları
		var url = $(".url").text();
		var totalMovie = $(".totalBlog").text();
		var totalPage = Math.round(totalMovie / 5) + 1 ;
	
		/*$('#pagination').twbsPagination({
	        totalPages: totalPage,
	        visiblePages: 6,
	        href: url + '?currentPage={{number}}'
		});*/
		
		setPagination({
	        totalPage : totalPage, // You will calculate total page with your total data
	        paginationSize : 7 , 
	        url : url , // Your request mapper
	        parameter : "currentPage" // The query parameter like ?'pageNo'=10 , ?'page'=10
	    });
	}
	
	{
		//Pagination ' in dizaynını bootstrapda ayarlamak için , gerekli classları atıyoruz
		$("#pagination li").addClass("page-item");
		$("#pagination a").addClass("page-link");
	}
});