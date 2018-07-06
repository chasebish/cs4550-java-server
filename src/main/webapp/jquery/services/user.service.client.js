function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'http://localhost:8080/api/user';
    var self = this;

    function createUser(user, callback) {
        return fetch(self.url, {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'Content-Type': 'application/json'
            },
            success: callback
        });
    }

    function findAllUsers(callback) {
        return $.ajax({
            url: self.url,
            success: callback
        })
    }

    function findUserById(userId) {
        return fetch(
            self.url + '/' + userId);
    }

    function updateUser(userId, user) {
        return fetch(self.url + '/' + userId, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'Content-Type': 'application/json'
            }
        });
    }

    function deleteUser(userId) {
        // return fetch(self.url + '/' + userId,
        //     { method: 'DELETE' }
        // );
    }
     
}

function UserService() {
    this.register = register;
    
    function register() {  }
  }
  
