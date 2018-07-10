(function () {

   $(main)

    var $usernameFld, $passwordFld
    var $loginBtn
    var userService = new UserService()

    function main() {

        $usernameFld = $('#usernameFld'), $passwordFld = $('#passwordFld')
        $loginBtn = $('#loginBtn')
        $loginBtn.click(login)

    }
    function login() {

        var userObj = {
            username: $usernameFld.val(),
            password: $passwordFld.val()
        }

        userService.login(userObj).then(function(out) {
            console.log(out)
        })

    }
})();
