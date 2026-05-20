<script setup>
/*
    Teaching note:
    This example demonstrates event binding in Vue 3.

    Main points:
    1. Use v-on:click to bind a click event.
    2. Use @click as the shorthand form of v-on:click.
    3. Use event modifiers such as .once and .prevent.
    4. Pass the original DOM event object by using $event.
*/

/*
    Import ref from Vue.

    ref is used to create reactive data.
    When the value of count changes, the page will update automatically.
*/
import { ref } from 'vue'

/*
    Define a reactive variable count.

    Initial value: 0
*/
let count = ref(0)

/*
    Define a function named addCount.

    Because count is created by ref(),
    we need to use count.value in the JavaScript section.
*/
let addCount = () => {
    count.value++
}

/*
    Define a function named incrCount.

    This function receives the original click event object.
*/
let incrCount = (event) => {

    /*
        Increase the count value by 1.
    */
    count.value++

    /*
        event.preventDefault() prevents the default behavior of the element.

        For an <a> tag, the default behavior is jumping to another page.
        So this line prevents the link from opening.
    */
    event.preventDefault()
}
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        Display the value of count.

        In the template, Vue automatically unwraps ref variables,
        so we can write count directly instead of count.value.
    -->
    <h1>count: {{ count }}</h1>

    <!-- 
        v-on:click is used to bind a click event.

        When this button is clicked,
        the addCount() function will be executed.
    -->
    <button v-on:click="addCount()">addCount</button>
    <br>

    <!-- 
        @click is the shorthand form of v-on:click.

        Here we directly write count++ in the template.

        In the template, Vue allows us to use count directly,
        so we do not need to write count.value++.
    -->
    <button @click="count++">incrCount</button>
    <br>

    <!-- 
        .once is an event modifier.

        @click.once means this click event can only be triggered once.

        After the first click, this button will no longer increase count.
    -->
    <button @click.once="count++">addOnce</button>
    <br>

    <!-- 
        .prevent is an event modifier.

        The default behavior of <a> is jumping to the href address.
        @click.prevent prevents the default jump behavior.

        So when we click this link:
        1. count will increase by 1
        2. the page will NOT jump to http://www.atguigu.com
    -->
    <a 
      href="http://www.atguigu.com" 
      target="_blank" 
      @click.prevent="count++"
    >
      prevent
    </a>
    <br>

    <!-- 
        $event represents the original DOM event object.

        Here we pass $event to the incrCount function.

        Inside incrCount(event), we manually call:
        event.preventDefault()

        This also prevents the default jump behavior of the <a> tag.
    -->
    <a 
      href="http://www.atguigu.com" 
      target="_blank" 
      @click="incrCount($event)"
    >
      prevent by function
    </a>
    <br>

  </div>
</template>