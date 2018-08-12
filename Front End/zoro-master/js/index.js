$(document).ready(function() {
	setTimeout(function() {
		$("#main").removeClass("is-loading");
	}, 300)
});
//https://s3-us-west-2.amazonaws.com/s.cdpn.io/336999/shinokubo_test.jpg

function switchVisible() {
            if (document.getElementById('Div1')) {

                if (document.getElementById('Div1').style.display == 'none') {
                    document.getElementById('Div1').style.display = 'block';
                    document.getElementById('Div2').style.display = 'none';
                }
                else {
                    document.getElementById('Div1').style.display = 'none';
                    document.getElementById('Div2').style.display = 'block';
                }
            }
}


var regex = new RegExp(
        '^(([^<>()[\\]\\\\.,;:\\s@\\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\\"]+)*)|' +
        '(\\".+\\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])' +
        '|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$'
    );
var regex_otp = new RegExp('[a-zA-Z0-9]{6}');

    $('.email input').on('keyup', function(e) {
			if($("#text").text()=="Verify"){
	     $(this).parent().toggleClass('success', regex_otp.test($(this).val()));
   			
			}else{
		 $(this).parent().toggleClass('success', regex.test($(this).val()));
			}
		});

$("#text").on("click",function(){
	if($("#text").text()=="Verify")
	{
		console.log("Verifed");
		$.getJSON("otp-verify-url", function(result){
		
		//HOW TO SEND JSON OBJECT VIA POST REQUEST TO API?
		
			window.location="index-1.html/register";
		});
	}
	else{
	
	if($(".email").hasClass("success")){
		//call the api with email
		var user_email=$('.email input').val();
		console.log(user_email);
//Here call the api with email->		 
		$.getJSON("http://localhost:7070/spring-rest-demo/zoroapi/checkexistence/"+user_email+"/", function(result){	
			if(result.found){
				console.log("email exists");
				$("#display-text").text("Email already exists. You might want to login, otherwise try a different one.");
			}
			else{
			 console.log("data:");
			 console.log(JSON.stringify(result));
			console.log("Send otp now");
			
				$("#display-text").text("Please Enter OTP to continue:");
			
			
				 $('.email input').val('');
				$(".email").removeClass("success");
				 $(".email-input").attr("placeholder","e.g. X1234X")
					$("#text").text("Verify");
				 $(".email-input").attr("type","text")
			}
			
		 });
	}
	
}
});



$(".start").on("click",function(){
	$(".desc-div").addClass("removed");
	$("#text").html('<i class="fa fa-spinner fa-spin" style="font-size:24px"></i>');
	setTimeout(function(){
$(".form-div").addClass("shown");
		
		$("#text").text("SEND OTP").fadeIn("slow");
	}, 2000)
});

/*
$(".start").on("click",function(){
	if($(".form-div").hasClass("shown"))
		{
	console.log("SEnd otp now");
	$("#display-text").text("Please Enter OTP to continue:");
	$("#emal-svg").addClass("hidden");
}});*/


$(".login-btn").on("click",function(){
	 window.location="index-1.html";
});