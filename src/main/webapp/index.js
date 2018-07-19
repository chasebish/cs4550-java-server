(function () {

    $(main)

    var $registerBtn, $loginBtn, $profileBtn, $adminBtn, $courseBtn

    /**
     * Executes on document load, when the browser is done parsing the html page and the dom is ready. Retrieved
     * the dom elements needed later in the controller such as the form elements, action icons, and templates.
     * Binds action icons, such as create, update, select, and delete, to respective event handlers.
     */
    function main() {
        $registerBtn = $('#registerBtn')
        $loginBtn = $('#loginBtn')
        $profileBtn = $('#profileBtn')
        $adminBtn = $('#adminBtn')
        $courseBtn = $('#courseBtn')

        $registerBtn.click(function () { window.location.href = './jquery/components/register/register.template.client.html' })
        $loginBtn.click(function () { window.location.href = './jquery/components/login/login.template.client.html' })
        $profileBtn.click(function () { window.location.href = './jquery/components/profile/profile.template.client.html' })
        $adminBtn.click(function () { window.location.href = './jquery/components/admin/user-admin.template.client.html' })
        $courseBtn.click(function () { window.location.href = 'https://whiteboard-react-chasebish.herokuapp.com/' })
    }

})()