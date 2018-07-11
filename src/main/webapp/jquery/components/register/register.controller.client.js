(function () {
    $(main)

    var $emptyFields, $samePassword, $usernameTaken

    var $usernameFld, $passwordFld, $confirmPasswordFld
    var $createBtn
    var userService = new UserService()

    /**
     * Executes on document load, when the browser is done parsing the html page and the dom is ready. Retrieved
     * the dom elements needed later in the controller such as the form elements, action icons, and templates.
     * Binds action icons, such as create, update, select, and delete, to respective event handlers.
     */
    function main() {

        $emptyFields = $('#emptyFields'), $samePassword = $('#samePassword'), $usernameTaken = $('#usernameTaken')

        $usernameFld = $('#usernameFld'), $passwordFld = $('#passwordFld'), $confirmPasswordFld = $('#confirmPasswordFld')
        $createBtn = $('#createBtn')
        $createBtn.click(createAccount)
    }

    /**
     * Wrapper for creating a new account.  Checks to make sure fields are valid.
     */
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

    /**
     * Checks to see if the desired username is valid or not.
     */
    function validUsername() {

        userService.validUsername($usernameFld.val()).then(function(isValid) {
            if (!isValid) {
                $usernameTaken.modal('show')
            } else {
                register()
            }
        })
    }

    /**
     * Registers a new user.
     */
    function register() { 

        var user = new User($usernameFld.val(), $passwordFld.val(), null, null, null, null, null, null)

        userService.register(user).then(function() { window.location.href = '../profile/profile.template.client.html' })
    }

})();
