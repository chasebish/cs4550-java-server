(function() {

    $(main)

    var currentUser, currentUserId
    
    var $editSuccess

    var $usernameFld
    var $phoneFld, $emailFld
    var $roleFld
    var $dobFld
    var $updateBtn
    var $logoutBtn

    var userService = new UserService()

    function main() {

        $editSuccess = $('#editSuccess')

        $usernameFld = $('#usernameFld')
        $phoneFld = $('#phoneFld'), $emailFld = $('#emailFld')
        $roleFld = $('#roleFld')
        $dobFld = $('#dobFld')
        $updateBtn = $('#updateBtn')
        $updateBtn.click(updateUser)
        $logoutBtn = $('#logoutBtn')
        $logoutBtn.click(logoutUser)

        $editSuccess.hide()

        getProfile()
    }

    function getProfile() {
        userService.profile().then(function(user) {
            if (user.id) {
                currentUser = user
                currentUserId = user.id

                $usernameFld.val(user.username)
                $phoneFld.val(user.phone)
                $emailFld.val(user.email)
                $roleFld.val(user.role)
                $dobFld.val(user.dateOfBirth)
            } else {
                alert('You aren\'t logged in')
                window.location.href = '../login/login.template.client.html'
            }
        })
    }

    function updateUser() {
        userService.updateUser(currentUserId, {
            phone: $phoneFld.val(),
            email: $emailFld.val(),
            role: $roleFld.val(),
            dateOfBirth: $dobFld.val()
        }).then(function() {
            getProfile()
            $editSuccess.show()
        })
    }

    function logoutUser() {
        userService.logout().then(function() {
            window.location.href = '../login/login.template.client.html'
        }).catch(function() {
            alert('There was an error logging you out.')
        })
        // var logout = userService.logout()
    }

})()