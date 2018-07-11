function User(username, password, firstName, lastName, email, phone, dateOfBirth, role) {

    // Sets user variables
    this.username = username
    this.password = password
    this.firstName = firstName
    this.lastName = lastName
    this.email = email
    this.phone = phone
    if (dateOfBirth === '') {
        this.dateOfBirth = null
        console.log('empty')
    } else {
        this.dateOfBirth = dateOfBirth
        console.log('oops')
    }
    this.role = role
  
    // Setters and getters
    this.setUsername = setUsername
    this.getUsername = getUsername

    this.setPassword = setPassword
    this.getPassword = getPassword

    this.setFirstName = setFirstName
    this.getFirstName = getFirstName
    
    this.setLastName = setLastName
    this.getLastName = getLastName

    this.setEmail = setEmail
    this.getEmail = getEmail

    this.setPhone = setPhone
    this.getPhone = getPhone

    this.setDateOfBirth = setDateOfBirth
    this.getDateOfBirth = getDateOfBirth

    this.setRole = setRole
    this.getRole = getRole

    function setUsername(username) {
      this.username = username
    }
    function getUsername() {
      return this.username
    }
    
    function setPassword(password) {
        this.password = password
    }
    function getPassword() {
        return this.password
    }

    function setFirstName(firstName) {
        this.firstName = firstName
    }
    function getFirstName() {
        return this.firstName
    }

    function setLastName(lastName) {
        this.lastName = lastName
    }
    function getLastName() {
        return this.lastName
    }

    function setEmail(email) {
        this.email = email
    }
    function getEmail() {
        return this.email
    }

    function setPhone(phone) {
        this.phone = phone
    }
    function getPhone() {
        return this.phone
    }

    function setDateOfBirth(dateOfBirth) {
        this.dateOfBirth = dateOfBirth
    }
    function getDateOfBirth() {
        return this.dateOfBirth
    }

    function setRole(role) {
        this.role = role
    }
    function getRole() {
        return this.role
    }
}
  