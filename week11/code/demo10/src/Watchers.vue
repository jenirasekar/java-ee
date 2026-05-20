<script setup>
/*
    Teaching note:
    This example demonstrates watchers in Vue 3.

    Main points:
    1. watch() is used to observe data changes.
    2. When the watched data changes, the callback function will run.
    3. watch() can watch ref data directly.
    4. To watch a property inside a reactive object, we usually use a function.
    5. deep: true is used for deeply watching an object.
*/

import { ref, reactive, watch } from 'vue'

/*
    Define a ref variable.

    firstname is a simple reactive value.
    Because it is created by ref(),
    we need to use firstname.value in JavaScript.
*/
let firstname = ref('')

/*
    Define a reactive object.

    lastname is an object.
    It has one property: name.
*/
let lastname = reactive({
  name: ''
})

/*
    Define a ref variable to store the full name.

    fullname will be updated when firstname or lastname.name changes.
*/
let fullname = ref('')

/*
    Watch firstname.

    Because firstname is created by ref(),
    we can watch it directly.

    newValue -> the new value after change
    oldValue -> the previous value before change
*/
watch(firstname, (newValue, oldValue) => {
  /*
      Print the value change in the browser console.
  */
  console.log(`${oldValue} changed to ${newValue}`)

  /*
      Update fullname.

      firstname.value is used because firstname is a ref variable.
      lastname.name is used because lastname is a reactive object.
  */
  fullname.value = firstname.value + lastname.name
})

/*
    Watch lastname.name.

    Since lastname is a reactive object,
    we use a function to return lastname.name.

    This means:
    only watch the name property inside lastname.
*/
watch(() => lastname.name, (newValue, oldValue) => {
  /*
      Print the value change in the browser console.
  */
  console.log(`${oldValue} changed to ${newValue}`)

  /*
      Update fullname when lastname.name changes.
  */
  fullname.value = firstname.value + lastname.name
})

/*
    Watch the whole lastname object.

    deep: true means deeply watching the object.
    If any property inside lastname changes, this watcher can be triggered.

    immediate: false means this watcher will not run immediately
    when the page is loaded. It only runs after the data changes.

    Note:
    In this example, this watcher and the watcher above both watch lastname.name.
    So when lastname.name changes, fullname may be updated more than once.
    This is mainly for demonstrating different watch usages.
*/
watch(() => lastname, (newValue, oldValue) => {
  fullname.value = firstname.value + lastname.name
}, {
  deep: true,
  immediate: false
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