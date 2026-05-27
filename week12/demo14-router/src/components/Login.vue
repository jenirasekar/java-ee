<script setup>
// Teaching note: Login example for route guard.

import { ref } from 'vue'
import { useRouter } from 'vue-router'

// Define username and password.
let username = ref('')
let password = ref('')

// Get router object.
const router = useRouter()

// Define login function.
function login() {
    // Check username and password.
    if (username.value == 'root' && password.value == '123456') {

        // Save username into sessionStorage.
        // The route guard will use this value to check login status.
        window.sessionStorage.setItem("username", username.value)

        // Jump to home page after successful login.
        router.push("/home")

    } else {
        // Show error message if login fails.
        alert('用户名或者密码错误')
    }
}
</script>

<template>
  <div>
    account:
    <input type="text" v-model="username">
    <br>

    password:
    <input type="password" v-model="password">
    <br>

    <button @click="login">login</button>
  </div>
</template>