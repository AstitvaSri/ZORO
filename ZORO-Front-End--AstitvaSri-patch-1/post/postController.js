//Profile page working- tested ok :jun
(function () {
    'use strict';

    angular
        .module('app')
        .controller('profileController',profileController);

    profileController.$inject = ['UserService', '$location', '$rootScope', 'FlashService'];
    function profileController(UserService, $location, $rootScope, FlashService) {
       var vm = this;
        console.log("profile");
      //  console.log(vm);
        console.log("uuuuu");
    //  vm.editProfile=editProfile;


      //  vm.profile = profile;
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    var myurl=e.target.result;
                    $('#imagePreview').css('background-image', 'url('+e.target.result +')');
                    $('#imagePreview').hide();
                    $('#imagePreview').fadeIn(650);
                  //  console.log(myurl);
                    vm.user.img=myurl;
                    //console.log(reader);
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
        $("#imageUpload").change(function() {
            readURL(this);
        });
////////////////////////////////////////
var verified1=false;
document.querySelector("#pdf-upload").addEventListener("change", function(e){
  verified1=false;
	var canvasElement = document.querySelector("canvas")
	var file = e.target.files[0]
	if(file.type != "application/pdf"){
		console.error(file.name, "is not a pdf file.")
		return
	}

	var fileReader = new FileReader();

	fileReader.onload = function() {
		var typedarray = new Uint8Array(this.result);

		PDFJS.getDocument(typedarray).then(function(pdf) {
			// you can now use *pdf* here
			console.log("the pdf has ",pdf.numPages, "page(s).")

			pdf.getPage(pdf.numPages).then(function(page) {
        if(pdf.numPages==1){
          verified1=true;
          vm.user.verified=true;
        }
				// you can now use *page* here
				var viewport = page.getViewport(2.0);
				var canvas = document.querySelector("canvas")
				canvas.height = viewport.height;
				canvas.width = viewport.width;


				page.render({
					canvasContext: canvas.getContext('2d'),
					viewport: viewport
				});
			});

		});
	};

	fileReader.readAsArrayBuffer(file);
})





        ////////////////////////////////////////
$(".fsubmit").on("click",function(){
  console.log("fsubmit");
  if(vm.user.img&&vm.user.firstName&&vm.user.lastName&&vm.user.gender
  &&vm.user.age&&vm.user.city&&vm.user.state&&vm.user.phone&&vm.user.verified)
  {

  console.log("img is there");

    editProfile();
  }
  else
alert("Enter details and upload pic");
})


        function editProfile(){
          //vm.dataLoading = true;
          console.log("ANUJ");
          console.log(vm.user);
            UserService.Update(vm.user)
                .then(function (response) {
                  console.log(response);
                    if (response.found==false) {
                        FlashService.Success('Profile Updation successful', true);
                        $location.path('/dashboard');
                    } else {
                      console.log("values"+JSON.stringify(response));

                        FlashService.Error(response.message);
                      //  vm.dataLoading = false;
                    }
                });
        }

}



})();
