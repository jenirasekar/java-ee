<script setup>
/*
    Teaching note:
    This example demonstrates conditional rendering in Vue 3.

    Main points:
    1. v-if is used to render an element only when the condition is true.
    2. v-else is used to render another element when the v-if condition is false.
    3. ref is used to create reactive data.
*/

/*
    Import ref from Vue.

    ref is used to create a reactive variable.
    When the value changes, the page will update automatically.
*/
import { ref } from 'vue'

/*
    Define a reactive variable named awesome.

    Initial value: true

    Because awesome is true at the beginning,
    the element with v-if="awesome" will be displayed first.
*/
let awesome = ref(true)
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        v-if="awesome" means:
        If awesome is true, this h1 element will be rendered.

        Initial result:
        Vue is awesome!
    -->
    <h1 v-if="awesome">Vue is awesome!</h1>

    <!-- 
        v-else must be used immediately after v-if.

        If awesome is false, this h1 element will be rendered instead.
    -->
    <h1 v-else>Oh no 😢</h1>

    <!-- 
        @click is used to bind a click event.

        awesome = !awesome means reversing the current value.

        If awesome is true, it becomes false.
        If awesome is false, it becomes true.

        In the template, ref variables are automatically unwrapped,
        so we can write awesome directly instead of awesome.value.
    -->
    <h1 v-show="awesome">Vue is awesome!</h1>
    <button @click="awesome = !awesome">Toggle</button>

  </div>
</template>