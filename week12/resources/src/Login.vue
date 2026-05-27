<script setup>
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'

// Import the Pinia user store
// It is used to save the current logged-in user information on the front end
import { defineUser } from '../store/userStore.js'

// Get the router object for page navigation
const router = useRouter()

// Get the user store object
let sysUser = defineUser()

// Create a reactive object to store login form data
let loginUser = reactive({
  username: '',
  userPwd: ''
})

// Message variables used to show validation results
let usernameMsg = ref('')
let userPwdMsg = ref('')

// Check whether the username is valid
function checkUsername() {
  // Username rule:
  // 5 to 10 characters, only letters and numbers are allowed
  let usernameReg = /^[a-zA-Z0-9]{5,10}$/

  if (!usernameReg.test(loginUser.username)) {
    usernameMsg.value = 'Invalid format'
    return false
  }

  usernameMsg.value = 'OK'
  return true
}

// Check whether the password is valid
function checkUserPwd() {
  // Password rule:
  // Exactly 6 digits
  let userPwdReg = /^[0-9]{6}$/

  if (!userPwdReg.test(loginUser.userPwd)) {
    userPwdMsg.value = 'Invalid format'
    return false
  }

  userPwdMsg.value = 'OK'
  return true
}

// Login function
function login() {
  // Validate all form fields before login
  let flag1 = checkUsername()
  let flag2 = checkUserPwd()

  if (!(flag1 && flag2)) {
    alert('Validation failed. Please check your input again.')
    return
  }

  // Pure front-end demonstration:
  // Read the registered username and password from localStorage.
  // These values are saved by the registration page.
  let savedUsername = localStorage.getItem('username')
  let savedUserPwd = localStorage.getItem('userPwd')

  // If there is no user information in localStorage,
  // it means the user has not registered yet.
  if (!savedUsername || !savedUserPwd) {
    alert('No registered user found. Please register first.')
    return
  }

  // Check whether the username is correct
  if (loginUser.username !== savedUsername) {
    alert('Username is incorrect.')
    return
  }

  // Check whether the password is correct
  if (loginUser.userPwd !== savedUserPwd) {
    alert('Password is incorrect.')
    return
  }

  // Login successful
  alert('Login successful.')

  // Save the logged-in user information into Pinia
  // In this pure front-end version, uid is only a simulated value.
  sysUser.uid = 1
  sysUser.username = loginUser.username

  // Save login status in sessionStorage
  // This can be used to check whether the user has logged in.
  sessionStorage.setItem('loginUser', loginUser.username)

  // Jump to the schedule management page
  router.push('/showSchedule')
}

// Clear all form data and messages
function clearForm() {
  loginUser.username = ''
  loginUser.userPwd = ''

  usernameMsg.value = ''
  userPwdMsg.value = ''
}
</script>

<template>
  <div>
    <h3 class="ht">Login</h3>

    <table class="tab" cellspacing="0px">
      <tr class="ltr">
        <td>Please enter username</td>
        <td>
          <input
            class="ipt"
            type="text"
            v-model="loginUser.username"
            @blur="checkUsername()"
          />

          <span id="usernameMsg" v-text="usernameMsg"></span>
        </td>
      </tr>

      <tr class="ltr">
        <td>Please enter password</td>
        <td>
          <input
            class="ipt"
            type="password"
            v-model="loginUser.userPwd"
            @blur="checkUserPwd()"
          />

          <span id="userPwdMsg" v-text="userPwdMsg"></span>
        </td>
      </tr>

      <tr class="ltr">
        <td colspan="2" class="buttonContainer">
          <input class="btn1" type="button" @click="login()" value="Login" />
          <input class="btn1" type="button" @click="clearForm()" value="Reset" />

          <router-link to="/regist">
            <button class="btn1" type="button">Register</button>
          </router-link>
        </td>
      </tr>
    </table>
  </div>
</template>

<style scoped>
/* Title style */
.ht {
  text-align: center;
  color: cadetblue;
  font-family: Arial, sans-serif;
}

/* Table container style */
.tab {
  width: 500px;
  border: 5px solid cadetblue;
  margin: 0px auto;
  border-radius: 5px;
  font-family: Arial, sans-serif;
}

/* Table cell border style */
.ltr td {
  border: 1px solid powderblue;
}

/* Input box style */
.ipt {
  border: 0px;
  width: 50%;
}

/* Button style */
.btn1 {
  border: 2px solid powderblue;
  border-radius: 4px;
  width: 80px;
  background-color: antiquewhite;
}

/* Validation message style */
#usernameMsg,
#userPwdMsg {
  color: goldenrod;
}

/* Center the buttons */
.buttonContainer {
  text-align: center;
}
</style>