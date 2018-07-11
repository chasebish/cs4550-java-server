(function() {

    $(main)

    var $invalidUser

    var $usernameFld, $passwordFld
    var $loginBtn
    var userService = new UserService()

    function main() {

        $invalidUser = $('#invalidUser')

        $usernameFld = $('#usernameFld'), $passwordFld = $('#passwordFld')
        $loginBtn = $('#loginBtn')
        $loginBtn.click(login)

    }

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
