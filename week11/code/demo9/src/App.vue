下面是**适合上课讲解的注释版代码**：

<script type="module">
/*
    Teaching note:
    This example demonstrates reactivity in Vue 3
    and how to use the setup() function.
*/

// Import ref from Vue.
// ref is used to create reactive data.
import { ref } from 'vue'

export default {
    /*
        setup() is an important function in Vue 3 Composition API.

        Code written inside setup() is used to define:
        1. reactive data
        2. functions
        3. variables that can be used in the template
    */
    setup() {

        /*
            Create a reactive variable named counter.

            ref(1) means:
            - the initial value of counter is 1
            - counter is reactive

            When counter changes, the page will update automatically.
        */
        let counter = ref(1)

        /*
            Define the increase function.

            Because counter is created by ref(),
            we need to use counter.value to access or modify its value
            in the JavaScript section.
        */
        function increase() {
            counter.value++
        }

        /*
            Define the decrease function.

            This function decreases the value of counter by 1.
        */
        function decrease() {
            counter.value--
        }

        /*
            Return data and functions.

            Only the variables and functions returned here
            can be used in the template section.
        */
        return {
            counter,
            increase,
            decrease
        }
    }
}
</script>

<template>
    <!-- 
        Template section:
        This part defines the page structure displayed in the browser.
    -->

    <div>
        <!-- 
            @click is the shorthand form of v-on:click.

            When the user clicks this button,
            the decrease() function will be executed.
        -->
        <button @click="decrease()">-</button>

        <!-- 
            Display the value of counter.

            In the template, Vue automatically unwraps ref data,
            so we can write counter directly instead of counter.value.
        -->
        {{ counter }}

        <!-- 
            When the user clicks this button,
            the increase() function will be executed.
        -->
        <button @click="increase()">+</button>
    </div>
</template>


<!-- 
<script setup type="module">
// Teaching note: Script section for 5.2.4 Reactivity and the setup Function.
import {ref} from 'vue'

let counter = ref(1)

function increase(){
    counter.value++
}

function decrease(){
    counter.value--
}
</script>

<template>
  
    <div>
      <button @click="decrease()">-</button>
      {{ counter }}
      <button @click="increase()">+</button>
    </div>
</template>
 -->
