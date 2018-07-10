function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = '/api/user';
    var self = this;

    function createUser(user, callback) {
        return fetch(self.url, {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'Content-Type': 'application/json'
            },
            success: callback
        })
    }

    function findAllUsers(callback) {
        return $.ajax({
            url: self.url,
            success: callback
        })
    }

    function findUserById(userId) {
        return fetch(self.url + '/' + userId)
            .then(function(response) {
                return response.json();
            })
    }

    function updateUser(userId, user) {
        return fetch(self.url + '/' + userId, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'Content-Type': 'application/json'
            }
        })
    }

    function deleteUser(userId, callback) {
        return fetch(self.url + '/' + userId,{
            method: 'DELETE',
            success: callback
        })
    }
     
}

function UserService() {
    this.register = register
    this.validUsername = validUsername
    this.login = login
    this.profile = profile
    this.updateUser = updateUser
    this.logout = logout
    
    this.url = '/api/user'
    
    function register(user) {
        return fetch(this.url + '/register', {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                "Content-Type": "application/json"
            },
            credentials: 'include'
        })
    }

    function validUsername(username) {
        return fetch(this.url + '/username', {
            method: 'POST',
            body: username
        }).then(function(response) {
            return response.json()
        })
    }

    function login(user) {
        return fetch(this.url + '/login', {
            method: 'POST',
            body: JSON.stringify(user),
            credentials: 'include',
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(response) {
            return response.json()
        })
    }

    function logout() {
        return fetch(this.url + '/logout', {
            method: 'POST',
            credentials: 'include'
        })
    }

    function profile() {
        return fetch(this.url + '/profile', {
            method: 'GET',
            credentials: 'include'
        }).then(function(response) {
            return response.json()
        })
    }

    function updateUser(userId, user) {
        return fetch(this.url + '/' + userId, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'Content-Type': 'application/json'
            }
        })
    }
  }
  
