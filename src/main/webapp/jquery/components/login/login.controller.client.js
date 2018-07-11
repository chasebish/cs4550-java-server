(function() {

    $(main)

    var $invalidUser

    var $usernameFld, $passwordFld
    var $loginBtn
    var userService = new UserService()

    /**
     * Executes on document load, when the browser is done parsing the html page and the dom is ready. Retrieved
     * the dom elements needed later in the controller such as the form elements, action icons, and templates.
     * Binds action icons, such as create, update, select, and delete, to respective event handlers.
     */
    function main() {

        $invalidUser = $('#invalidUser')

        $usernameFld = $('#usernameFld'), $passwordFld = $('#passwordFld')
        $loginBtn = $('#loginBtn')
        $loginBtn.click(login)

    }

    /**
     * Logs a user in
     */
    function login() {

        var userObj = {
            username: $usernameFld.val(),
            password: $passwordFld.val()
        }

        userService.login(userObj)
            .then(function(out) {
                window.location.href = '../profile/profile.template.client.html'
            }, function() {
                $invalidUser.modal('show')
            })
    }

})();
