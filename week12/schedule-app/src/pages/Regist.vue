<script setup>
import { ref, reactive } from "vue";
import { useRouter } from "vue-router";

// Get the router object for page navigation
const router = useRouter();

// Create a reactive object to store registration form data
let registUser = reactive({
  username: "",
  userPwd: "",
});

// Message variables used to show validation results
let usernameMsg = ref("");
let userPwdMsg = ref("");
let reUserPwdMsg = ref("");

// Store the repeated password
let reUserPwd = ref("");

// Check whether the username is valid
function checkUsername() {
  // Username rule:
  // 5 to 10 characters, only letters and numbers are allowed
  let usernameReg = /^[a-zA-Z0-9]{5,10}$/;

  if (!usernameReg.test(registUser.username)) {
    usernameMsg.value = "Invalid format";
    return false;
  }

  // In this pure front-end version, there is no database.
  // So we do not check whether the username already exists.
  usernameMsg.value = "Available";
  return true;
}

// Check whether the password is valid
function checkUserPwd() {
  // Password rule:
  // Exactly 6 digits
  let userPwdReg = /^[0-9]{6}$/;

  if (!userPwdReg.test(registUser.userPwd)) {
    userPwdMsg.value = "Invalid format";
    return false;
  }

  userPwdMsg.value = "OK";
  return true;
}

// Check whether the repeated password is valid
function checkReUserPwd() {
  let userPwdReg = /^[0-9]{6}$/;

  if (!userPwdReg.test(reUserPwd.value)) {
    reUserPwdMsg.value = "Invalid format";
    return false;
  }

  // Check whether the two passwords are the same
  if (registUser.userPwd !== reUserPwd.value) {
    reUserPwdMsg.value = "Passwords do not match";
    return false;
  }

  reUserPwdMsg.value = "OK";
  return true;
}

// Registration function
function regist() {
  // Validate all form fields before registration
  let flag1 = checkUsername();
  let flag2 = checkUserPwd();
  let flag3 = checkReUserPwd();

  if (flag1 && flag2 && flag3) {
    // Pure front-end demonstration:
    // Save the username and password temporarily in localStorage.
    // This is only for classroom demonstration.
    localStorage.setItem("username", registUser.username);
    localStorage.setItem("userPwd", registUser.userPwd);

    alert("Registration successful. Please log in.");

    // Jump to the login page
    router.push("/login");
  } else {
    alert("Validation failed. Please check your input again.");
  }
}

// Clear all form data and messages
function clearForm() {
  registUser.username = "";
  registUser.userPwd = "";
  reUserPwd.value = "";

  usernameMsg.value = "";
  userPwdMsg.value = "";
  reUserPwdMsg.value = "";
}
</script>

<template>
  <div>
    <h3 class="ht">Register</h3>

    <table class="tab" cellspacing="0px">
      <tbody>
        <tr class="ltr">
          <td>Please enter username</td>
          <td>
            <input
              class="ipt"
              id="usernameInput"
              type="text"
              name="username"
              v-model="registUser.username"
              @blur="checkUsername()" />

            <span id="usernameMsg" class="msg" v-text="usernameMsg"></span>
          </td>
        </tr>
      </tbody>
      <tbody>
        <tr class="ltr">
          <td>Please enter password</td>
          <td>
            <input
              class="ipt"
              id="userPwdInput"
              type="password"
              name="userPwd"
              v-model="registUser.userPwd"
              @blur="checkUserPwd()" />

            <span id="userPwdMsg" class="msg" v-text="userPwdMsg"></span>
          </td>
        </tr>
      </tbody>
      <tbody>
        <tr class="ltr">
          <td>Confirm password</td>
          <td>
            <input class="ipt" id="reUserPwdInput" type="password" v-model="reUserPwd" @blur="checkReUserPwd()" />

            <span id="reUserPwdMsg" class="msg" v-text="reUserPwdMsg"></span>
          </td>
        </tr>
      </tbody>
      <tbody>
        <tr class="ltr">
          <td colspan="2" class="buttonContainer">
            <input class="btn1" type="button" @click="regist()" value="Register" />
            <input class="btn1" type="button" @click="clearForm()" value="Reset" />

            <router-link to="/login">
              <button class="btn1" type="button">Login</button>
            </router-link>
          </td>
        </tr>
      </tbody>
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
.msg {
  color: goldenrod;
}

/* Center the buttons */
.buttonContainer {
  text-align: center;
}
</style>
