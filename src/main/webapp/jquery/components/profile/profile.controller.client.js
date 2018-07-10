(function() {

    $(main)

    var $usernameFld
    var $phoneFld, $emailFld
    var $roleFld
    var $dobFld
    var $updateBtn
    var $logoutBtn

    var userService = new UserService()

    function main() {
        $usernameFld = $('#usernameFld')
        $phoneFld = $('#phoneFld'), $emailFld = $('#phoneFld')
        $roleFld = $('#roleFld')
        $dobFld = $('#dobFld')
        $updateBtn = $('#updateBtn')
        $updateBtn.click(updateUser)
        $logoutBtn = $('#logoutBtn')
        $logoutBtn.click(logoutUser)
    }

    function updateUser() {

    }

    function logoutUser() {

    }

})()