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
        $phoneFld = $('#phoneFld'), $emailFld = $('#emailFld')
        $roleFld = $('#roleFld')
        $dobFld = $('#dobFld')
        $updateBtn = $('#updateBtn')
        $updateBtn.click(updateUser)
        $logoutBtn = $('#logoutBtn')
        $logoutBtn.click(logoutUser)

        getProfile()
    }

    function getProfile() {
        userService.profile().then(function(user) {
            $usernameFld.val(user.username)
            $phoneFld.val(user.phone)
            $emailFld.val(user.email)
            $roleFld.val(user.role)
            $dobFld.val(user.dateOfBirth)
        })
    }

    function updateUser() {

    }

    function logoutUser() {
        userService.logout().then(function() {
            window.location.href = '../login/login.template.client.html'
        }).catch(function() {
            alert('There was an error logging you out.')
        })
    }

})()