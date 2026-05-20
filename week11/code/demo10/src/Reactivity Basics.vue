<!-- <script setup type="module">
// Teaching note: Script section for 6.2.1 A Non-Reactive Example.
let counter = 0;
function show(){
    alert(counter);
}
</script>

<template>
  <div>
    <button @click="counter--">-</button>
    {{ counter }}
    <button @click="counter++">+</button>
    <hr>
    <button @click="show()">Show counter</button>
  </div>
</template> -->


<!-- <script setup type="module">
// Teaching note: Script section for 6.2.2 ref.
import {ref} from 'vue'

let counter = ref(0);

function show(){
    alert(counter.value);
}

let decr = () => {
  counter.value--;
}

let incr = () => {
  counter.value++;
}
</script>

<template>
  <div>
    <button @click="decr()">-</button>
    {{ counter }}
    <button @click="incr()">+</button>
    <hr>
    <button @click="show()">Show counter</button>
  </div>
</template> -->


<script setup>
/*
    Teaching note:
    This example demonstrates reactive in Vue 3.

    Main points:
    1. reactive is used to create a reactive object.
    2. When a property inside the reactive object changes,
       the page will update automatically.
    3. reactive is usually used for objects or arrays.
*/

/*
    Import reactive from Vue.

    reactive is used to create a reactive object.
*/
import { reactive } from 'vue'

/*
    Create a reactive object named data.

    The object has one property:
    counter: 0

    Because data is reactive, when data.counter changes,
    the template will update automatically.
*/
let data = reactive({
  counter: 0
})

/*
    Define a function named show.

    This function displays the current value of data.counter
    in an alert box.
*/
function show() {
    alert(data.counter)
}

/*
    Define a function named decr.

    This function decreases data.counter by 1.
*/
let decr = () => {
  data.counter--
}

/*
    Define a function named incr.

    This function increases data.counter by 1.
*/
let incr = () => {
  data.counter++
}
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        When this button is clicked,
        the decr() function will be executed.

        data.counter will decrease by 1.
    -->
    <button @click="decr()">-</button>

    <!-- 
        Display the value of data.counter.

        Because data is reactive,
        the displayed value will update automatically
        when data.counter changes.
    -->
    {{ data.counter }}

    <!-- 
        When this button is clicked,
        the incr() function will be executed.

        data.counter will increase by 1.
    -->
    <button @click="incr()">+</button>

    <hr>

    <!-- 
        When this button is clicked,
        the show() function will be executed.

        It will show the current counter value in an alert box.
    -->
    <button @click="show()">Show counter</button>

  </div>
</template>