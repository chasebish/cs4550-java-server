(function() {

    $(main)

    var $registerBtn, $loginBtn, $profileBtn, $adminBtn

    function main() {
        $registerBtn = $('#registerBtn')
        $loginBtn = $('#loginBtn')
        $profileBtn = $('#profileBtn')
        $adminBtn = $('#adminBtn')

        $registerBtn.click(function() { window.location.href = './jquery/components/register/register.template.client.html' })
        $loginBtn.click(function() { window.location.href = './jquery/components/login/login.template.client.html' })
        $profileBtn.click(function() { window.location.href = './jquery/components/profile/profile.template.client.html' })
        $adminBtn.click(function() { window.location.href = './jquery/components/admin/user-admin.template.client.html' })
    }

})()