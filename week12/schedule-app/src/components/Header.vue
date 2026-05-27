<script setup>
/*
  Import Pinia stores.

  defineUser is used to store the current logged-in user.
  defindSchedule is used to store the schedule list.
*/
import { defineUser } from '../store/userStore.js'
import { defindSchedule } from '../store/scheduleStore.js'

import { useRouter } from 'vue-router'
import { onMounted } from 'vue'

// Get Pinia store objects
let sysUser = defineUser()
let schedule = defindSchedule()

// Get the router object for page navigation
let router = useRouter()

/*
  When the component is mounted, try to restore the login status.

  In a pure front-end project, Pinia data may be lost after refreshing the page.
  So we read the username from sessionStorage and put it back into Pinia.
*/
onMounted(() => {
  let loginUser = sessionStorage.getItem('loginUser')

  if (loginUser) {
    sysUser.username = loginUser
    sysUser.uid = 1
  }
})

/*
  Logout function.

  In the pure front-end version, logout means:
  1. Clear user information in Pinia.
  2. Clear schedule information in Pinia.
  3. Remove login status from sessionStorage.
  4. Jump back to the login page.
*/
function logout() {
  // Clear all Pinia user data
  sysUser.$reset()

  // Clear all Pinia schedule data
  schedule.$reset()

  // Clear login status saved in sessionStorage
  sessionStorage.removeItem('loginUser')

  // Jump to the login page
  router.push('/login')
}
</script>

<template>
  <div>
    <h1 class="ht">Welcome to Schedule Management System</h1>

    <div>
      <!--
        If the username is empty, it means the user has not logged in.
        Show Login and Register buttons.
      -->
      <div class="optionDiv" v-if="sysUser.username === ''">
        <router-link to="/login">
          <button class="b1s" type="button">Login</button>
        </router-link>

        <router-link to="/regist">
          <button class="b1s" type="button">Register</button>
        </router-link>
      </div>

      <!--
        If the username is not empty, it means the user has logged in.
        Show welcome message, logout button, and schedule button.
      -->
      <div class="optionDiv" v-else>
        Welcome {{ sysUser.username }}

        <button class="b1b" type="button" @click="logout()">
          Logout
        </button>

        <router-link to="/showSchedule">
          <button class="b1b" type="button">
            My Schedule
          </button>
        </router-link>
      </div>

      <br />
    </div>
  </div>
</template>

<style scoped>
/* Title style */
.ht {
  text-align: center;
  color: cadetblue;
  font-family: Arial, sans-serif;
}

/* Small button style */
.b1s {
  border: 2px solid powderblue;
  border-radius: 4px;
  width: 80px;
  background-color: antiquewhite;
}

/* Big button style */
.b1b {
  border: 2px solid powderblue;
  border-radius: 4px;
  width: 120px;
  background-color: antiquewhite;
}

/* Option area style */
.optionDiv {
  width: 450px;
  float: right;
}
</style>