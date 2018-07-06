(function () {
    $(main);
    var $usernameFld, $passwordFld;
    var $removeBtn, $updateBtn, $createBtn;
    var $firstNameFld, $lastNameFld;
    var $roleFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();

    function main() { 
        $usernameFld=$('#usernameFld');
        $passwordFld=$('#passwordFld');
        $firstNameFld=$('#firstNameFld');
        $lastNameFld=$('#lastNameFld');
        $roleFld=$('#roleFld');
        $tbody = $('.wbdv-tbody');
        $userRowTemplate = $('.wbdv-template.wbdv-user').clone().removeClass('wbdv-hidden');
        $createBtn = $('.wbdv-create');
        $createBtn.click(createUser);
        $updateBtn = $('.wbdv-update');
        $updateBtn.click(updateUser)
        userService.findAllUsers(renderUsers);
     }
    function createUser() {
        userService.createUser(JSON.stringify({
            username: $usernameFld.val,
            password: $passwordFld.val,
            firstName: $firstNameFld.val,
            lastName: $lastNameFld.val,
            role: $roleFld.val
        }))
    }
    function findAllUsers() {  }
    function findUserById() {  }
    function deleteUser() {  }
    function selectUser() {  }
    function updateUser() { console.log('hello world') }
    function renderUser(user) {  }
    function renderUsers(users) {
        $tbody.empty();
        for(var u in users) {
            var user = users[u];
            var $row = $userRowTemplate.clone();
            $row.find('.wbdv-username').html(user.username);
            $tbody.append($row);
        }}
})();
