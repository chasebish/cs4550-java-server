(function () {
    $(main)
    var $usernameFld, $passwordFld
    var $updateBtn, $createBtn, $searchBtn
    var $firstNameFld, $lastNameFld
    var $emailFld, $phoneFld, $dobFld
    var $roleFld
    var $userRowTemplate, $tbody
    var userService = new AdminUserServiceClient()


    /**
     * Executes on document load, when the browser is done parsing the html page and the dom is ready. Retrieved
     * the dom elements needed later in the controller such as the form elements, action icons, and templates.
     * Binds action icons, such as create, update, select, and delete, to respective event handlers.
     */
    function main() {

        $usernameFld = $('#usernameFld'), $passwordFld=$('#passwordFld')
        $firstNameFld = $('#firstNameFld'), $lastNameFld=$('#lastNameFld')
        $emailFld = $('#emailFld'), $phoneFld=$('#phoneFld'), $dobFld=$('#dobFld')
        $roleFld =$ ('#roleFld')
        $tbody = $('.wbdv-tbody')
        $userRowTemplate = $('.wbdv-template.wbdv-user').clone().removeClass('wbdv-hidden')
        $createBtn = $('.wbdv-create')
        $createBtn.click(createUser)
        $updateBtn = $('.wbdv-update')
        $updateBtn.click(updateUser)

        // Renders all current users
        findAllUsers()
    }

    /**
     * Handles create user event when user clicks on plus icon. Reads from the form elements and creates a user
     * object. Uses the user service createUser() function to create the new user. Updates the list of users on
     * server response.
     */
    function createUser() {
        userService.createUser({
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            email: $emailFld.val(),
            phone: $phoneFld.val(),
            dateOfBirth: $dobFld.val(),
            role: $roleFld.val()
        }, resetFields()).then(findAllUsers)
    }

    /**
     * Resets the fields to default
     */
    function resetFields() {
        $usernameFld.val('')
        $firstNameFld.val('')
        $lastNameFld.val('')
        $emailFld.val('')
        $phoneFld.val('')
        $dobFld.val('')
        $roleFld.val('')
    }

    /**
     * Called whenever the list of users needs to be refreshed. Uses user service findAllUsers() to retrieve all
     * the users and passes response to renderUsers.
     */
    function findAllUsers() { 
        userService.findAllUsers().then(renderUsers)
    }

    /**
     * Called whenever a particular user needs to be retrieved by their id, as in when a user is selected for editing.
     * Reads the user is from the icon id attribute. Uses user service findUserById() to retrieve user and then
     * updates the form on server response.
     */
    function findUserById() {  }

    /**
     * Handles delete user event when user clicks the cross icon. Reads the user is from the icon id attribute. Uses
     * user service deleteUser() to send a delete request to the server. Updates user list on server response.
     */
    function deleteUser() { 
        var deleteBtn = $(event.currentTarget);
        var userId = deleteBtn
            .parent().parent().parent().attr('id');

        userService.deleteUser(userId).then(findAllUsers)
    }

    /**
     * handles update user event when user clicks on check mark icon. Reads the user is from the icon id attribute.
     * Reads new user values form the form, creates a user object and then uses user service updateUser() to send
     * the new user data to server. Updates user list on server response
     */
    function updateUser() { 
        userService.updateUser(id, {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            email: $emailFld.val(),
            phone: $phoneFld.val(),
            dateOfBirth: $dobFld.val(),
            role: $roleFld.val()
        }) 
    }

    /**
     * Accepts a user object as parameter and updates the form with the user properties
     * @param {*} user 
     */
    function renderUser(user) {  }

    /**
     * Accepts an array of user instances, clears the current content of the table body, iterates over the array of users,
     * clones a table row template for each user instance, populates the table row with the user object properties, adds
     * the table row to the table body.
     * @param {*} users 
     */
    function renderUsers(users) {

        $tbody.empty()
        
        for(var u in users) {
            var user = users[u]
            var $row = $userRowTemplate.clone()

            $row.attr('id', user.id)

            $row.find('.wbdv-remove').click(deleteUser)
            $row.find('.wbdv-edit').click(deleteUser)

            $row.find('.wbdv-username').html(user.username)
            $row.find('.wbdv-password').html('********')
            $row.find('.wbdv-first-name').html(user.firstName)
            $row.find('.wbdv-last-name').html(user.lastName)
            $row.find('.wbdv-email').html(user.email)
            $row.find('.wbdv-phone').html(user.phone)
            $row.find('.wbdv-dob').html(user.dateOfBirth)
            $row.find('.wbdv-role').html(user.role)

            $tbody.append($row)
        }
    }
})()
