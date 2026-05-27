<script setup>
// Teaching note: Home page example for route guard and logout.

// Import useRouter from vue-router.
// It is used to jump to another page by JavaScript code.
import { useRouter } from 'vue-router'

// Get router object.
const router = useRouter()

// Get username from sessionStorage.
// This username was saved when the user logged in successfully.
let username = window.sessionStorage.getItem('username')

// Define logout function.
function logout() {
    // Remove username from sessionStorage.
    // After removing it, the route guard will think the user is not logged in.
    window.sessionStorage.removeItem('username')

    // Jump to login page.
    router.push('/login')
}
</script>

<template>
  <div>
    <h1>Home Page</h1>

    <!-- Display the current login username -->
    <h3>Welcome {{ username }} login</h3>

    <!-- Click the button to log out -->
    <button @click="logout">Logout</button>
  </div>
</template>