(function() {

    $(main)
    
    var $editSuccess, $dismissNoLogin

    var $xNoLogin, $noLogin

    var $usernameFld
    var $firstNameFld, $lastNameFld
    var $phoneFld, $emailFld
    var $roleFld
    var $dobFld
    var $updateBtn
    var $logoutBtn

    var userService = new UserService()

    /**
     * Executes on document load, when the browser is done parsing the html page and the dom is ready. Retrieved
     * the dom elements needed later in the controller such as the form elements, action icons, and templates.
     * Binds action icons, such as create, update, select, and delete, to respective event handlers.
     */
    function main() {

        $editSuccess = $('#editSuccess'), $xNoLogin = $('#xNoLogin'), $dismissNoLogin = $('#dismissNoLogin')
        $xNoLogin.click(function() {
            window.location.href = '../login/login.template.client.html'
        })
        $dismissNoLogin.click(function() {
            window.location.href = '../login/login.template.client.html'
        })

        $noLogin = $('#noLogin')

        $usernameFld = $('#usernameFld')
        $firstNameFld = $('#firstNameFld'), $lastNameFld = $('#lastNameFld')
        $phoneFld = $('#phoneFld'), $emailFld = $('#emailFld')
        $roleFld = $('#roleFld')
        $dobFld = $('#dobFld')
        $updateBtn = $('#updateBtn')
        $updateBtn.click(updateProfile)
        $logoutBtn = $('#logoutBtn')
        $logoutBtn.click(logoutUser)

        $editSuccess.hide()

        getProfile()
    }

    /**
     * Gets the profile of the currently stored user.  If it successfully gets a user, it renders their profile
     * with the values filled in.
     */
    function getProfile() {
        userService.profile().then(function(user) {
            if (user === null) {
                $noLogin.modal('show')
            } else if (user.id) {
                $usernameFld.val(user.username)
                $firstNameFld.val(user.firstName)
                $lastNameFld.val(user.lastName)
                $phoneFld.val(user.phone)
                $emailFld.val(user.email)
                $roleFld.val(user.role)
                $dobFld.val(user.dateOfBirth)
            } else {
                $noLogin.modal('show')
            }
        })
    }

    /**
     * Updates a user's profile based on new attributes passed in
     */
    function updateProfile() {

        var user = new User(
            null,
            null,
            $firstNameFld.val(),
            $lastNameFld.val(),
            $emailFld.val(),
            $phoneFld.val(),
            $dobFld.val(),
            $roleFld.val()
        )

        userService.updateProfile(user).then(function() {
            getProfile()
            $editSuccess.show()
            hideAlert($editSuccess)
        })
    }

    /**
     * Logs a user out
     */
    function logoutUser() {
        userService.logout().then(function() {
            window.location.href = '../login/login.template.client.html'
        }).catch(function() {
            alert('There was an error logging you out.')
        })
    }

    /**
     * Hides an alert after 5 seconds
     * 
     * @param {alert} alert 
     */
    function hideAlert(alert) {
        setTimeout(function() {
            alert.hide()}, 5000)
    }

})()