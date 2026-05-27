<script setup>
// Teaching note: Script section for 7.4 Programmatic Routing with useRouter.

import { useRouter } from 'vue-router'
import { ref } from 'vue'

// Define a variable to store the input path.
// For example: /home, /list, /add, /update
const myPath = ref('')

// Get the router object.
const router = useRouter()

// Define a function for programmatic routing.
const goMyPage = () => {
  // If the input is empty, do not jump.
  if (myPath.value === '') {
    alert('Please enter a path, such as /list')
    return
  }

  // Jump to the path entered by the user.
  router.push({ path: myPath.value })
}
</script>

<template>
  <div>
    <h2>Vue Router Example</h2>

    <router-link to="/home">Home</router-link> |
    <router-link to="/list">List</router-link> |
    <router-link to="/add">Add</router-link> |
    <router-link to="/update">Update</router-link> |
    <router-link to="/showAll">showAll</router-link> |
    <router-link to="/showDetail/1/java">Route Parameters</router-link> |

    <br><br>

    <!-- The user can enter a route path here, such as /list -->
    <input type="text" v-model="myPath" placeholder="Enter path, such as /list">

    <!-- Click the button to jump to the input path -->
    <button @click="goMyPage">Go</button>

    

    <hr>

    <!-- The matched component will be displayed here -->
    <router-view></router-view>
  </div>
</template>