<script setup>
/*
    Teaching note:
    This example demonstrates two-way binding in Vue 3.

    Main points:
    1. v-model is used for two-way binding.
    2. When the input value changes, the JavaScript data changes automatically.
    3. When the JavaScript data changes, the page value also updates automatically.
    4. v-model can be used with input, checkbox, textarea, and select.
*/

import { reactive, ref } from 'vue'

/*
    Define a reactive array for hobbies.

    Because multiple checkboxes may be selected,
    we use an array to store the selected values.

    Example:
    If the user selects Eat and Play,
    hbs.value will become:
    ['eat', 'play']
*/
let hbs = ref([])

/*
    Define a reactive object to store user information.

    username  -> account name
    password  -> password
    introduce -> self-introduction
    pro       -> selected province
*/
let user = reactive({
  username: null,
  password: null,
  introduce: null,
  pro: null
})

/*
    Define the login function.

    This function is executed when the Login button is clicked.
*/
function login() {
  /*
      Show the selected hobbies.

      Because hbs is created by ref(),
      we need to use hbs.value in JavaScript.
  */
  alert(hbs.value)

  /*
      Convert the user object into a JSON string
      and show it in an alert box.
  */
  alert(JSON.stringify(user))
}

/*
    Define the reset function.

    This function clears all form data.
*/
function clearx() {
  /*
      Clear the values in the user object.

      Because user is created by reactive(),
      we can directly modify its properties.
  */
  user.username = ''
  user.password = ''
  user.introduce = ''
  user.pro = ''

  /*
      Clear the hobbies array.

      splice(0, hbs.value.length) means:
      starting from index 0,
      delete all elements in the array.
  */
  hbs.value.splice(0, hbs.value.length)
}
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        v-model="user.username" creates two-way binding.

        When the user types in this input box,
        user.username will update automatically.
    -->
    Account:
    <input type="text" v-model="user.username">
    <br>

    <!-- 
        v-model="user.password" binds the input value
        to user.password.

        In real projects, type="password" is usually better
        because it hides the password text.
    -->
    Password:
    <input type="text" v-model="user.password">
    <br>

    <!-- 
        Checkbox two-way binding.

        Because hbs is an array,
        selected checkbox values will be added into hbs.

        If a checkbox is unchecked,
        its value will be removed from hbs.
    -->
    Hobbies:

    Eat
    <input type="checkbox" v-model="hbs" value="eat">

    Drink
    <input type="checkbox" v-model="hbs" value="drink">

    Play
    <input type="checkbox" v-model="hbs" value="play">

    <br>

    <!-- 
        textarea can also use v-model.

        The text entered by the user will be stored in user.introduce.
    -->
    Introduction:
    <textarea v-model="user.introduce"></textarea>

    <br>

    <!-- 
        select can also use v-model.

        The selected option value will be stored in user.pro.
    -->
    Province:
    <select v-model="user.pro">

      <!-- 
          If this option is selected,
          user.pro will become '1'.
      -->
      <option value="1">Heilongjiang</option>

      <!-- 
          If this option is selected,
          user.pro will become '2'.
      -->
      <option value="2">Jilin</option>

      <!-- 
          If this option is selected,
          user.pro will become '3'.
      -->
      <option value="3">Liaoning</option>

      <!-- 
          If this option is selected,
          user.pro will become '4'.
      -->
      <option value="4">Beijing</option>
    </select>

    <br>

    <!-- 
        When this button is clicked,
        the login() function will be executed.
    -->
    <button @click="login()">Login</button>

    <!-- 
        When this button is clicked,
        the clearx() function will be executed.

        It will reset all form data.
    -->
    <button @click="clearx()">Reset</button>

    <hr>

    <!-- 
        Display the selected hobbies.

        In the template, Vue automatically unwraps ref variables,
        so we can write hbs directly instead of hbs.value.
    -->
    Hobbies: {{ hbs }}

    <hr>

    <!-- 
        Display the user object.

        When the form input changes,
        this displayed object will also update automatically.
    -->
    User information: {{ user }}

  </div>
</template>