$(document).ready(function(){
	
	{
		//Kategori ve tagların arasındaki ',' işaretini ayarlyoruz
		/*$(".wrapper-category a , .wrapper-tag a").each(function(){
			
			if($(".wrapper-category a").index($(this)) < $(".wrapper-category a").length -1 && $(".wrapper-tag a").index($(this)) < $(".wrapper-tag a").length - 1 ) {
				$(this).append(",");
			}
			
		});*/
	}
	
	$(".wrapper-category-and-tag-top").clone().appendTo(".wrapper-category-and-tag-bottom"); // Kategori ve tagların bulunduğu div ' i aşşağıya klonluyoruz
	
	{
		// Yoruma cevap vermek için 'answer butonuna ' tıklandığında , answer-formunu getiren event
		$(".answer").click(function(){
			commentField = $("#" + $(this).attr("commentId")).children(".media-body");
			$(".wrapper-answer-form").remove();
			commentField.append("<div class='wrapper-answer-form'></div>");
			$(".wrapper-hidden-answer-form").clone().appendTo(".wrapper-answer-form");
			$(document).trigger("newAnswerFormEvent");
			$(document).trigger("CloseAnswerFormEvent");
			$("#answer-form .comment-id").val($(this).attr("commentId"));
			recipientName = $(this).attr("receipt-name");
			$("#answer-form #answer").val("+ " + recipientName + ", ");
			$(".wrapper-answer-form .wrapper-hidden-answer-form").toggle(300, function() {
				$(".ScrollToAnswerForm")[0].click();
				$(".wrapper-answer-form .wrapper-hidden-answer-form #name").focus();
			});
		});
		
		
		$(document).on("CloseAnswerFormEvent", function() {
			$("#close-answer-form").click(function() {
				$(".wrapper-answer-form .wrapper-hidden-answer-form").fadeOut();
				return false;
			});
		})
		
		/**
		 * Delete Butonu , hem answer , hemde comment'e hizmet ediyor. gerekli bilgiler butonların kendisinden alındığı için.
		 * Comment'e hizmet eden butondan aldığımız $(this).attr('answerId') değeri , aslında içinde blogId barındırıyor ve
		 * Arka tarafta blogId gibi muamele görüyor
		 * */
		$(".delete").click(function(){
			if(confirm("Are you sure for delete the comment or answer?"))
				ajax($(this).attr('url') , $(this).attr('method') , {commentId : $(this).attr('commentId') , answerId : $(this).attr('answerId')});
		});
	}
	
	{ 	/**
			Comment ve Answer formunu burda submit eventini atarlıyoruz , submit edildiğinde , ajax üzerinden nesneleri gönderiyor.
			answer formu clonlandığı için , on methoduyla dinleniyor.
	 	*/
		$("#comment-form").submit(function(e){
			e.preventDefault();
			if($(this).valid() /*&& isCorrectCaptcha()*/){
				ajax($(this).attr('action') , $(this).attr('method') , $(this).serialize()).done(function() {
					$(".comment-form-reset").click();
				});
				
			}
		});
		$(document).on("newAnswerFormEvent",function(e,target){
			$("#answer-form").submit(function(e){
				e.preventDefault();
				if($(this).valid()){
					ajax($(this).attr('action') , $(this).attr('method') , $(this).serialize()).done(function() {
						$(".answer-form-reset").click();
					});
				}
			});
			setAnswerFormValidate(); // her yeni eklenen answer formu için , validate ayarlıyoruz.
		});
	}
	
	
	
	
	
	
	{
		// formları jquery-validate.js ile bu alanda validate ediyoruz.
		$("#comment-form").validate({
			rules : {
				name : {
					required : true,
					minlength : 3 ,
					maxlength : 50
				} ,
				email : {
					required : true ,
					email : true ,
					maxlength : 50
				},
				opinion : {
					required : true ,
					minlength : 10 ,
					maxlength : 254
				}
				
			}
		});	
		
		function setAnswerFormValidate() {
			$("#answer-form").validate({
				rules : {
					name : {
						required : true , 
						minlength : 3 ,
						maxlength : 50
					},
					answer : {
						required : true ,
						minlength : 10,
						maxlength : 254
					}
				}
			});
		}
		
		function isCorrectCaptcha() {
			/*var response = grecaptcha.getResponse();
			if(response.length == 0) {
				alert("please , accurately check the captcha...(Are you bot ?)");
				return false;
			}else {
				return true;
			}*/
			return true;
		}
	}
	
});