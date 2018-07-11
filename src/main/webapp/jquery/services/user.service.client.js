/**
 * The service client for the user-admin page.
 */
function AdminUserServiceClient() {
    this.createUser = createUser;
    this.validUsername = validUsername;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = '/api/user';
    var self = this;

    /**
     * Creates a new user in the database.
     * 
     * @param {User} user the user to be created
     * @param {Function} callback called on success
     */
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

    /**
     * Checks to see if a username is valid.
     * 
     * @param {string} username the username to be checked
     */
    function validUsername(username) {
        return fetch(this.url + '/username', {
            method: 'POST',
            body: username
        }).then(function (response) {
            return response.json()
        })
    }

    /**
     * Gets all current users in the database.
     * 
     * @param {Function} callback called on success
     */
    function findAllUsers(callback) {
        return $.ajax({
            url: self.url,
            success: callback
        })
    }

    /**
     * Finds a user by their ID.
     * 
     * @param {number} userId the ID being searched for in the database.
     */
    function findUserById(userId) {
        return fetch(self.url + '/' + userId)
            .then(function (response) {
                return response.json();
            })
    }

    /**
     * Updates a user based on their ID.
     * 
     * @param {number} userId the ID of the user to be updated
     * @param {User} user the user fields being sent to the database
     */
    function updateUser(userId, user) {
        return fetch(self.url + '/' + userId, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'Content-Type': 'application/json'
            }
        })
    }

    /**
     * Deletes a user from the database.
     * 
     * @param {number} userId the ID of the user to be deleted
     * @param {Function} callback called on success
     */
    function deleteUser(userId, callback) {
        return fetch(self.url + '/' + userId, {
            method: 'DELETE',
            success: callback
        })
    }

}

/**
 * The service client for users
 */
function UserService() {
    this.register = register
    this.validUsername = validUsername
    this.login = login
    this.profile = profile
    this.updateProfile = updateProfile
    this.logout = logout

    this.url = '/api/user'

    /**
     * Registers a new user and adds them to the database.
     * 
     * @param {User} user the new user to be added
     */
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

    /**
     * Checks to see if a username is valid.
     * 
     * @param {string} username 
     */
    function validUsername(username) {
        return fetch(this.url + '/username', {
            method: 'POST',
            body: username
        }).then(function (response) {
            return response.json()
        })
    }

    /**
     * Logs a current user in.
     * 
     * @param {User} user 
     */
    function login(user) {
        return fetch(this.url + '/login', {
            method: 'POST',
            body: JSON.stringify(user),
            credentials: 'include',
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function (response) {
            return response.json()
        })
    }

    /**
     * Logs the current user out.
     */
    function logout() {
        return fetch(this.url + '/logout', {
            method: 'POST',
            credentials: 'include'
        })
    }

    /**
     * Fetches the profile of the user that is currently logged in
     */
    function profile() {
        return fetch(this.url + '/profile', {
            method: 'GET',
            credentials: 'include'
        }).then(function (response) {
            return response.json()
        })
    }

    /**
     * Updates the profile of the user that is currently logged in
     * 
     * @param {User} user 
     */
    function updateProfile(user) {
        return fetch(this.url + '/profile', {
            method: 'PUT',
            body: JSON.stringify(user),
            credentials: 'include',
            headers: {
                'Content-Type': 'application/json'
            }
        })
    }
}

