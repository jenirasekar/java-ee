<script setup>
/*
    Teaching note:
    This example demonstrates text rendering in Vue 3.

    Main points:
    1. v-text renders content as plain text.
    2. v-html renders content as real HTML.
*/

/*
    Define a normal string variable.
*/
let msg = 'hello vue3'

/*
    Define a string that looks like an HTML tag.

    Although this string contains <font>,
    it is still just a normal string in JavaScript.
*/
let redMsg = "<font color='red'>msg</font>"

/*
    Define an HTML string by using template literals.

    ${msg} means inserting the value of the msg variable into the string.

    Final value:
    <font color='green'>hello vue3</font>
*/
let greenMsg = `<font color='green'>${msg}</font>`
</script>

<template>
  <!-- 
      Template section:
      This part defines the page structure displayed in the browser.
  -->
  <div>

    <!-- 
        v-text renders plain text.

        It will display:
        hello vue3
    -->
    <span v-text="msg"></span>
    <br>

    <!-- 
        v-text treats redMsg as normal text.

        It will display the HTML tag itself:
        <font color='red'>msg</font>

        The text will NOT become red.
    -->
    <span v-text="redMsg"></span>
    <br>

    <!-- 
        v-html renders redMsg as real HTML.

        It will display:
        msg

        The displayed text will become red.
    -->
    <span v-html="redMsg"></span>
    <br>

    <!-- 
        v-html renders greenMsg as real HTML.

        It will display:
        hello vue3

        The displayed text will become green.
    -->
    <span v-html="greenMsg"></span>
    <br>

  </div>
</template>