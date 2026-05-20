<script setup>
/*
    Teaching note:
    This example demonstrates watchEffect in Vue 3.

    Main points:
    1. watchEffect() is used to automatically track reactive dependencies.
    2. It runs immediately when the page is loaded.
    3. When the reactive data used inside watchEffect changes,
       watchEffect will run again automatically.
*/

import { ref, reactive, watchEffect } from 'vue'

/*
    Define a ref variable named firstname.

    firstname is used to store the first name entered by the user.
*/
let firstname = ref('')

/*
    Define a reactive object named lastname.

    lastname.name is used to store the last name entered by the user.
*/
let lastname = reactive({
  name: ''
})

/*
    Define a ref variable named fullname.

    fullname is used to store the complete name.
*/
let fullname = ref('')

/*
    watchEffect() will run immediately.

    Vue will automatically track the reactive data used inside it.

    In this function, we use:
    - firstname.value
    - lastname.name

    So when firstname or lastname.name changes,
    this function will run again automatically.
*/
watchEffect(() => {

  /*
      Combine firstname and lastname.name,
      then assign the result to fullname.value.

      Because fullname is created by ref(),
      we need to use fullname.value in JavaScript.
  */
  fullname.value = `${firstname.value} ${lastname.name}`
})
</script>
<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        Display fullname.

        fullname is a ref variable.
        In the template, Vue automatically unwraps ref variables,
        so we can write fullname directly instead of fullname.value.
    -->
    Full name: {{ fullname }}
    <br>

    <!-- 
        v-model creates two-way binding.

        When the user types in this input box,
        firstname will change automatically.

        Then the watcher of firstname will be triggered.
    -->
    First name:
    <input type="text" v-model="firstname">
    <br>

    <!-- 
        This input is bound to lastname.name.

        When the user types in this input box,
        lastname.name will change automatically.

        Then the watcher of lastname.name will be triggered.
    -->
    Last name:
    <input type="text" v-model="lastname.name">
    <br>

  </div>
</template>