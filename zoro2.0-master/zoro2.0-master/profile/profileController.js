(function () {
    'use strict';

    angular
        .module('app')
        .controller('profileController',profileController);

    profileController.$inject = ['UserService', '$location', '$rootScope', 'FlashService'];
    function profileController(UserService, $location, $rootScope, FlashService) {
       var vm = this;
        console.log("profile");
        console.log(vm);
        console.log("uuuuu");
    //  vm.editProfile=editProfile;


      //  vm.profile = profile;

        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    $('#imagePreview').css('background-image', 'url('+e.target.result +')');
                    $('#imagePreview').hide();
                    $('#imagePreview').fadeIn(650);
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
        $("#imageUpload").change(function() {
            readURL(this);
        });

        function editProfile(){
          //vm.dataLoading = true;
          console.log("Called")
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
