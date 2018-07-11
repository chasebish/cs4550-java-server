(function () {
    $(main)

    var $emptyFields, $samePassword, $usernameTaken

    var $usernameFld, $passwordFld, $confirmPasswordFld
    var $createBtn
    var userService = new UserService()

    function main() {

        $emptyFields = $('#emptyFields'), $samePassword = $('#samePassword'), $usernameTaken = $('#usernameTaken')

        $usernameFld = $('#usernameFld'), $passwordFld = $('#passwordFld'), $confirmPasswordFld = $('#confirmPasswordFld')
        $createBtn = $('#createBtn')
        $createBtn.click(createAccount)
    }

    function createAccount() {
        if ($usernameFld.val() === '' || $passwordFld.val() === '' || $confirmPasswordFld.val() === '') {
            $emptyFields.modal('show')
        }
        else if ($passwordFld.val() !== $confirmPasswordFld.val()) {
            $samePassword.modal('show')
        } else {
            validUsername()
        }
    }

    function validUsername() {

        userService.validUsername($usernameFld.val()).then(function(isValid) {
            if (!isValid) {
                $usernameTaken.modal('show')
            } else {
                register()
            }
        })
    }

    function register() { 

        var userObj = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
        }

        userService.register(userObj).then(function() { window.location.href = '../profile/profile.template.client.html' })
    }

})();
